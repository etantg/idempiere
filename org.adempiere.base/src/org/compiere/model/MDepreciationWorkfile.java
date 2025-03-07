package org.compiere.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.Properties;
import java.util.logging.Level;

import org.adempiere.base.Core;
import org.compiere.util.CLogMgt;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.TimeUtil;
import org.compiere.util.Util;
import org.idempiere.fa.feature.UseLife;
import org.idempiere.fa.feature.UseLifeImpl;
import org.idempiere.fa.service.api.DepreciationDTO;
import org.idempiere.fa.service.api.DepreciationFactoryLookupDTO;
import org.idempiere.fa.service.api.IDepreciationMethod;


/**
 *  Depreciation Workfile Model
 *	@author	Teo Sarca, SC ARHIPAC SERVICE SRL
 */
public class MDepreciationWorkfile extends X_A_Depreciation_Workfile
	implements UseLife
{
	/**
	 * generated serial id
	 */
	private static final long serialVersionUID = -3814417671427820714L;

    /**
     * UUID based Constructor
     * @param ctx  Context
     * @param A_Depreciation_Workfile_UU  UUID key
     * @param trxName Transaction
     */
    public MDepreciationWorkfile(Properties ctx, String A_Depreciation_Workfile_UU, String trxName) {
        super(ctx, A_Depreciation_Workfile_UU, trxName);
		if (Util.isEmpty(A_Depreciation_Workfile_UU))
			setInitialDefaults();
    }

	/**
	 * 	Default Constructor
	 *	@param ctx context
	 *	@param A_Depreciation_Workfile_ID line
	 *  @param trxName
	 */
	public MDepreciationWorkfile (Properties ctx, int A_Depreciation_Workfile_ID, String trxName)
	{
		super (ctx,A_Depreciation_Workfile_ID, trxName);
		if (A_Depreciation_Workfile_ID == 0)
			setInitialDefaults();
	}	//	MDepreciationWorkfile
	
	/**
	 * Set the initial defaults for a new record
	 */
	private void setInitialDefaults() {
		setPostingType(POSTINGTYPE_Actual);
		setA_QTY_Current(Env.ZERO);
		setA_Asset_Cost(Env.ZERO);
		setA_Accumulated_Depr(Env.ZERO);
		setA_Period_Posted(0);
		setA_Current_Period(0);
	}

	/**
	 * 	Load Constructor
	 *	@param ctx context
	 *	@param rs result set
	 */
	public MDepreciationWorkfile (Properties ctx, ResultSet rs, String trxName)
	{
		super (ctx, rs, trxName);
	}	//	MDepreciationWorkfile
	
	/**	Asset (parent)			*/
	private MAsset m_asset = null;
	
	/**	Get Asset					*/
	public MAsset getAsset() {
		return getAsset(false);
	}
	
	/**	
	 *  Get asset using this trxName
	 *	@param	requery	true to re-query from DB
	 *	@return parent asset
	 */
	public MAsset getAsset(boolean requery)
	{
		if (m_asset == null || requery) {
			m_asset = MAsset.get(getCtx(), getA_Asset_ID(), get_TrxName());
		}
		if (m_asset.get_ID() <= 0) {
			m_asset = null;
		}
		return m_asset;
	}
	
	/**	
	 *  Set asset
	 *	@param asset
	 */
	public void setAsset(MAsset asset)
	{
		setA_Asset_ID(asset.get_ID());
		m_asset = asset;
	}
	
	/**	
	 *  Gets asset's service date (commissioning)
	 *	@return asset service date
	 */	
	public Timestamp getAssetServiceDate()
	{
		MAsset asset = getAsset();
		if (asset == null) {
			return null;
		}
		return asset.getAssetServiceDate();
	}
	
	@Override
	protected boolean afterSave (boolean newRecord, boolean success)
	{
		if(m_buildDepreciation)
		{
			buildDepreciation();
		}
		return true;
	}
	
	@Override
	protected boolean beforeSave (boolean newRecord)
	{
		if (log.isLoggable(Level.INFO)) log.info ("Entering: trxName=" + get_TrxName());
		
		// Copy UseLife to A_Life
		if (newRecord) { 
			setA_Life_Period(getUseLifeMonths());
			setA_Asset_Life_Years(getUseLifeYears());
			setA_Life_Period_F(getUseLifeMonths_F());
			setA_Asset_Life_Years_F(getUseLifeYears_F());
		}
		
		// If it is fully amortized, change asset status to deprecated
		MAsset asset = getAsset(true);
		if (MAsset.A_ASSET_STATUS_Activated.equals(asset.getA_Asset_Status())
			&& isFullyDepreciated())
		{
			asset.changeStatus(MAsset.A_ASSET_STATUS_Depreciated, null);
			asset.saveEx();
		}
		
		// Fix DateAcct
		if(is_ValueChanged(COLUMNNAME_DateAcct))
		{
			setDateAcct(TimeUtil.getMonthLastDay(getDateAcct()));
		}
		
		//
		BigDecimal cost = getA_Asset_Cost();
		BigDecimal accumDep_C = getA_Accumulated_Depr();
		setA_Asset_Remaining(cost.subtract(accumDep_C));
		BigDecimal accumDep_F = getA_Accumulated_Depr_F();
		setA_Asset_Remaining_F(cost.subtract(accumDep_F));
		
		// Financing
		{
			String mainColumnName = null;
			if (newRecord || is_ValueChanged(COLUMNNAME_A_Asset_Cost))
			{
				mainColumnName = COLUMNNAME_A_Asset_Cost;
			}
			else if (is_ValueChanged(COLUMNNAME_A_Valoare_Cofinantare))
			{
				mainColumnName = COLUMNNAME_A_Valoare_Cofinantare;
			}
			else if (is_ValueChanged(COLUMNNAME_A_Valoare_Tert))
			{
				mainColumnName = COLUMNNAME_A_Valoare_Tert;
			}
			updateFinantare(this, mainColumnName);
		}
		
		
		if (log.isLoggable(Level.INFO)) log.info("Leaving: trxName=" + get_TrxName() + " [RETURN TRUE]");
		return true;
	}	//	beforeSave
	
	/**	
	 * Asset is fully depreciated
	 * <ul>
	 * <li>If PostingType != ACTUAL then return false
	 * <li>Do not check your current asset
	 * </ul>
	 * @return true if the asset is fully depreciated, false otherwise
	 */
	public boolean isFullyDepreciated()
	{
		if(!getPostingType().equals(POSTINGTYPE_Actual))
		{
			return false;
		}
		
		Collection<MDepreciationWorkfile> workFiles = MDepreciationWorkfile.forA_Asset_ID(getCtx(), getA_Asset_ID(), get_TrxName());
		for(MDepreciationWorkfile assetwk : workFiles) {	
		// check if is fully depreciated
			BigDecimal remainingAmt_C = assetwk.getA_Depreciation_Workfile_ID() == getA_Depreciation_Workfile_ID() 
					? getRemainingCost(null, false) : assetwk.getRemainingCost(null, false);
			BigDecimal remainingAmt_F = assetwk.getA_Depreciation_Workfile_ID() == getA_Depreciation_Workfile_ID()
					? getRemainingCost(null, true) : assetwk.getRemainingCost(null, true);
		if(remainingAmt_C.signum() == 0 && remainingAmt_F.signum() == 0)
		{
			//if A_Asset_Cost is 0 have a voided addition, in this case asset is not full depreciated 
			if (getA_Asset_Cost().signum() == 0)
			{
			 return false;	
			}
		}
			else
			{
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * @param asset
	 * @param postingType
	 * @param assetgrpacct
	 */
	public MDepreciationWorkfile(MAsset asset, String postingType, MAssetGroupAcct assetgrpacct)
	{
		this(asset.getCtx(), 0, asset.get_TrxName());
		setC_AcctSchema_ID(assetgrpacct.getC_AcctSchema_ID());
		setA_Asset_ID(asset.getA_Asset_ID());
		setAD_Org_ID(asset.getAD_Org_ID()); //@win added
		setA_Asset_Cost(asset.getA_Asset_Cost());
		setA_Accumulated_Depr(asset.getA_Accumulated_Depr());
		setA_Accumulated_Depr_F(asset.getA_Accumulated_Depr_F());
		setA_Current_Period(asset.getA_Current_Period());
		
		setIsDepreciated(asset.isDepreciated());
		setPostingType(postingType);
		//
		// Copy UseLife values from asset group to workfile
		UseLifeImpl.copyValues(this, assetgrpacct);
		
		//
		// Set Date Acct from Asset
		Timestamp dateAcct = asset.getDateAcct();
		if (dateAcct != null)
		{
			dateAcct = TimeUtil.addMonths(dateAcct, 1);
			setDateAcct(dateAcct);
		}		
		//
		// Set UseLife values from asset (if any)
		if (asset.getUseLifeMonths() > 0)
		{
			UseLifeImpl.get(this, false).setUseLifeMonths(asset.getUseLifeMonths());
		}
		if (asset.getUseLifeMonths_F() > 0)
		{
			UseLifeImpl.get(this, true).setUseLifeMonths(asset.getUseLifeMonths_F());
		}
		//
		dump();
	}
	
	/**
	 * Copy constructor
	 * @param copy
	 */
	public MDepreciationWorkfile(MDepreciationWorkfile copy) 
	{
		this(Env.getCtx(), copy);
	}

	/**
	 * Copy constructor
	 * @param ctx
	 * @param copy
	 */
	public MDepreciationWorkfile(Properties ctx, MDepreciationWorkfile copy) 
	{
		this(ctx, copy, (String) null);
	}

	/**
	 * Copy constructor
	 * @param ctx
	 * @param copy
	 * @param trxName
	 */
	public MDepreciationWorkfile(Properties ctx, MDepreciationWorkfile copy, String trxName) 
	{
		this(ctx, 0, trxName);
		copyPO(copy);
		this.m_asset = copy.m_asset != null ? new MAsset(ctx, copy.m_asset, trxName) : null;
	}

	/** Logger										*/
	private CLogger log = CLogger.getCLogger(getClass());

	/**
	 * @param ctx
	 * @param asset_id
	 * @param trxName
	 * @return collection of MDepreciationWorkfile
	 */
	public static Collection<MDepreciationWorkfile> forA_Asset_ID(Properties ctx, int asset_id, String trxName)
	{
		return new Query(ctx, Table_Name, MDepreciationWorkfile.COLUMNNAME_A_Asset_ID+"=?", trxName)
					.setParameters(new Object[]{asset_id})
					.list();
	}
	
	/**
	 * @param ctx
	 * @param A_Asset_ID
	 * @param postingType
	 * @return workfile
	 * @see #get(Properties, int, String, String)
	 */
	public static MDepreciationWorkfile get (Properties ctx, int A_Asset_ID, String postingType)
	{
		return get(ctx, A_Asset_ID, postingType, null);
	}
	
	/**
	 * @param ctx
	 * @param A_Asset_ID
	 * @param postingType
	 * @param trxName
	 * @param C_AcctSchema_ID Account Schema
	 * @return workfile
	 * @see #get(Properties, int, String, String)
	 */
	public static MDepreciationWorkfile get (Properties ctx, int A_Asset_ID, String postingType,  String trxName, int C_AcctSchema_ID)
	{
		if (A_Asset_ID <= 0 || postingType == null)
		{
			return null;
		}
		
		final String whereClause = COLUMNNAME_A_Asset_ID+"=?"
									+" AND "+COLUMNNAME_PostingType+"=? AND " +  COLUMNNAME_C_AcctSchema_ID + "=?" ;

		int acctSchemaId =  C_AcctSchema_ID==0 ? MClient.get(ctx).getAcctSchema().get_ID() : C_AcctSchema_ID;
		MDepreciationWorkfile wk = new Query(ctx, MDepreciationWorkfile.Table_Name, whereClause, trxName)
				.setParameters(new Object[]{A_Asset_ID, postingType,acctSchemaId})
				.firstOnly();
				
		return wk;
	}
	
	/**
	 * Get/load workfile from cache (if trxName is null)
	 * @param ctx
	 * @param A_Asset_ID
	 * @param postingType
	 * @param trxName
	 * @return workfile
	 */
	public static MDepreciationWorkfile get (Properties ctx, int A_Asset_ID, String postingType, String trxName)
	{
		return get(ctx, A_Asset_ID, postingType, trxName, 0);		
	}
	
	/**	
	 * @return last day of previous month of DateAcct
	 */
	public Timestamp getLastActionDate()
	{
		return TimeUtil.getMonthLastDay(TimeUtil.addMonths(getDateAcct(), -1));
	}
	
	/**	
	 *  Check if the asset is depreciated at the specified date
	 *	@param date
	 *	@return true if you amortized until the specified date, otherwise false
	 */
	public boolean isDepreciated(Timestamp date)
	{
		Timestamp lastActionDate = getLastActionDate();
		boolean isDepr = !date.after(lastActionDate);		// date <= lastActionDate
		
		if (log.isLoggable(Level.FINE)) log.fine("LastActionDate=" + lastActionDate + ", GivenDate=" + date + " => isDepreciated=" + isDepr);
		return isDepr;
	}
	
	/**
	 * Get Asset Accounting for this workfile
	 * @param dateAcct
	 * @param trxName
	 * @return asset accounting model
	 */
	public MAssetAcct getA_AssetAcct(Timestamp dateAcct, String trxName)
	{
		return MAssetAcct.forA_Asset_ID(getCtx(), getC_AcctSchema_ID(), getA_Asset_ID(), getPostingType(), dateAcct, trxName);
	}

	/**	
	 * Returns the current cost of FAs. It is calculated as the difference between acquisition value and salvage value (A_Salvage_Value).
	 * @return the current cost of FAs
	 */
	public BigDecimal getActualCost()
	{
		return getActualCost(getA_Asset_Cost());
	}
	
	/**
	 * @param assetCost
	 * @return assetCost - A_Salvage_Value
	 */
	public BigDecimal getActualCost(BigDecimal assetCost)
	{
		return assetCost.subtract(getA_Salvage_Value());
	}
	
	/**
	 * Adjust asset cost and qty with deltaAmt and deltaQty
	 * @param deltaAmt
	 * @param deltaQty
	 * @param reset true to use deltaAmt and deltaQty as current asset cost and qty
	 */
	public void adjustCost(BigDecimal deltaAmt, BigDecimal deltaQty, boolean reset)
	{
		BigDecimal newCost = Env.ZERO;
		BigDecimal newQty = Env.ZERO;
		if (!reset)
		{
			newCost = getA_Asset_Cost();
			newQty = getA_QTY_Current();
		}
		newCost = newCost.add(deltaAmt);
		newQty = newQty.add(deltaQty);
		
		setA_Asset_Cost(newCost);
		setA_QTY_Current(newQty);
		
		if (log.isLoggable(Level.FINE)) log.fine("adjustCost(" + deltaAmt + ", " + deltaQty + ", reset=" + reset + ") => amt=" + getA_Asset_Cost() + ", qty=" + getA_QTY_Current());
	}
	
	/**
	 * Adjust Accumulated depreciation
	 * @param amt
	 * @param amt_F
	 * @param reset true to use amt and amt_F as new value
	 * @return true
	 */
	public boolean adjustAccumulatedDepr(BigDecimal amt, BigDecimal amt_F, boolean reset)
	{
		if (amt == null)
		{
			amt = Env.ZERO;
		}
		if (amt_F == null)
		{
			amt_F = Env.ZERO;
		}
		setA_Accumulated_Depr(amt.add(reset ? Env.ZERO : getA_Accumulated_Depr()));
		setA_Accumulated_Depr_F(amt_F.add(reset ? Env.ZERO : getA_Accumulated_Depr_F()));
		return true;
	}

	/**
	 * Adjust use life years
	 * @param deltaUseLifeYears
	 * @param deltaUseLifeYears_F
	 * @param reset true to use deltaUseLifeYears and deltaUseLifeYears_F as new value
	 */
	public void adjustUseLife(int deltaUseLifeYears, int deltaUseLifeYears_F, boolean reset)
	{
		if (log.isLoggable(Level.FINE)) log.fine("Entering: deltaUseLifeYears=" + deltaUseLifeYears + ", deltaUseLifeYears_F=" + deltaUseLifeYears_F);
		//
		UseLifeImpl.get(this, false).adjustUseLifeYears(deltaUseLifeYears, reset);
		UseLifeImpl.get(this, true).adjustUseLifeYears(deltaUseLifeYears_F, reset);
		//
		if (log.isLoggable(Level.FINE)) log.fine("Leaving");
	}
	
	/**
	 * @param fiscal true for UseLifeMonths_F, false for getUseLifeMonths
	 * @return use life in months
	 */
	public int getUseLifeMonths(boolean fiscal)
	{
		return fiscal ? getUseLifeMonths_F() : getUseLifeMonths();
	}
	
	/**
	 * @param fiscal true for A_Accumulated_Depr_F, false for A_Accumulated_Depr
	 * @return accumulated depreciation
	 */
	public BigDecimal getA_Accumulated_Depr(boolean fiscal)
	{
		return fiscal ? getA_Accumulated_Depr_F() : getA_Accumulated_Depr();
	}
	
	/**
	 * @return accumulated cost
	 */
	public BigDecimal getAccumulatedCost()
	{
		return getA_Accumulated_Depr(isFiscal());
	}
	
	/**
	 * @return re-evaluation cost
	 */
	public BigDecimal getReevaluationCost()
	{
		return Env.ZERO;
	}
	
	/**
	 * @param accumAmt null to use current A_Accumulated_Depr/A_Accumulated_Depr_F value
	 * @param fiscal true for A_Accumulated_Depr_F, false for A_Accumulated_Depr
	 * @return residual (remaining) value (actual cost - accumulated depreciation)
	 */
	public BigDecimal getRemainingCost(BigDecimal accumAmt, boolean fiscal)
	{
		BigDecimal cost = getActualCost();
		if (accumAmt == null) {
			accumAmt = getA_Accumulated_Depr(fiscal);
		}
		return cost.subtract(accumAmt);
	}
	
	/**
	 * @param accumAmt
	 * @return residual (remaining) value (actual cost - accumulated depreciation)
	 */
	public BigDecimal getRemainingCost(BigDecimal accumAmt)
	{
		return getRemainingCost(accumAmt, isFiscal());
	}
	
	/**
	 * @param A_Current_Period
	 * @param method
	 * @return remaining periods
	 */
	public int getRemainingPeriods(int A_Current_Period, MDepreciation method)
	{
		int useLifePeriods = getUseLifeMonths(isFiscal());
		if (method != null) {
			useLifePeriods += method.getFixMonthOffset();
		}
		int currentPeriod = (A_Current_Period >= 0 ? A_Current_Period : getA_Current_Period());
		return useLifePeriods - currentPeriod;
	}
	
	/**
	 * @param A_Current_Period
	 * @return remaining periods
	 */
	public int getRemainingPeriods(int A_Current_Period)
	{
		return getRemainingPeriods(A_Current_Period, null);
	}
	
	/**	*/
	private boolean m_isFiscal = false;
	
	/**
	 * @return true for fiscal, false otherwise
	 */
	public boolean isFiscal()
	{
		return m_isFiscal;
	}
	
	/**
	 * Set fiscal flag (in memory only - this is not modifying the work file)
	 * @param fiscal
	 */
	public void setFiscal(boolean fiscal)
	{
		m_isFiscal = fiscal;
	}
	
	/**	
	 * Increment the current period (A_Current_Period) 1, and a month DateAcct. 
	 */
	public void incA_Current_Period()
	{
		int old_period = getA_Current_Period();
		Timestamp old_date = getDateAcct();
		int new_period = old_period + 1;
		Timestamp new_date = TimeUtil.addMonths(getDateAcct(), 1);
		setA_Current_Period(new_period);
		setDateAcct(new_date);
		//
		if (log.isLoggable(Level.FINE)) log.fine("(A_Current_Period, DateAcct)=(" + old_period + ", " + old_date + ")->(" + new_period + ", " + new_date + ")");
	}
	
	/**
	 * Set A Current Period (and Data Act) to period after the latest expense (MDepreciationExp) record. 
	 * This method do not save to DB.
	 */
	public void setA_Current_Period()
	{
		String whereClause = MDepreciationExp.COLUMNNAME_A_Asset_ID+"=?"
					+" AND "+MDepreciationExp.COLUMNNAME_PostingType+"=?"
					+" AND "+MDepreciationExp.COLUMNNAME_Processed+"=? AND IsActive=?"
					+" AND "+MDepreciationExp.COLUMNNAME_C_AcctSchema_ID+"=?"
		;
		//
		MDepreciationExp depexp = new Query(getCtx(), MDepreciationExp.Table_Name, whereClause, get_TrxName())
									.setParameters(new Object[]{getA_Asset_ID(), getPostingType(), true, true, getC_AcctSchema_ID()})
									.setOrderBy(MDepreciationExp.COLUMNNAME_A_Period+" DESC"
												+","+MDepreciationExp.COLUMNNAME_DateAcct+" DESC")
									.first();
		if (depexp != null)
		{
			setA_Current_Period(depexp.getA_Period());
			setDateAcct(depexp.getDateAcct());
			incA_Current_Period();
		}
		else
		{
			log.info("There are no MDepreciationExp records from which to set current period and accounting date");
		}

	}
	
	/** Build depreciation flag - if true, the depreciation should be built after save */ 
	private boolean m_buildDepreciation = false;
	
	/**
	 * Build depreciation (A_Depreciation_Exp) entries.<br/>
	 * More exactly, is deleting not Processed entries and create new ones again.<br/>
	 * WARNING: IS NOT modifying workfile (this).
	 */
	public void buildDepreciation()
	{
		if (!isDepreciated())
		{
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		load(get_TrxName()); // reload workfile
		MAssetAcct assetacct = getA_AssetAcct(null, get_TrxName()); 
		// TODO: teo_sarca: need to evaluate what happens when we change Depreciation method !!!
		MDepreciation depreciation_C = MDepreciation.get(getCtx(), assetacct.getA_Depreciation_ID());
		MDepreciation depreciation_F = MDepreciation.get(getCtx(), assetacct.getA_Depreciation_F_ID());
		int offset_C = 0, offset_F = 0;
		
		BigDecimal assetCost = getActualCost();
		BigDecimal accumDep_C = getA_Accumulated_Depr(false);
		BigDecimal accumDep_F = getA_Accumulated_Depr(true);
		int lifePeriods_C = getUseLifeMonths(false) + offset_C;
		int lifePeriods_F = getUseLifeMonths(true) + offset_F;
		int lifePeriods = (lifePeriods_C > lifePeriods_F ? lifePeriods_C : lifePeriods_F);
		BigDecimal exp_C = Env.ZERO;
		BigDecimal exp_F = Env.ZERO;
		
		//logging
		if(CLogMgt.isLevelFine())
		{
			sb.append("currentPeriod=" + getA_Current_Period() + ", AssetServiceDate=" + getAssetServiceDate() + "\n");
			sb.append("offset: C|F=" + offset_C + "|" + offset_F + "\n");
			sb.append("life: C|F=" + lifePeriods_C + "|" + lifePeriods_F + " + offset =" + lifePeriods + "\n");
		}
		
		truncDepreciation();
		int A_Current_Period = getA_Current_Period();
		
		// lookup for implement of IDepreciationMethod
		DepreciationFactoryLookupDTO depreciationFactoryLookupDTO = new DepreciationFactoryLookupDTO();
		depreciationFactoryLookupDTO.depreciationType = depreciation_C.getDepreciationType();
		IDepreciationMethod depreciationMethod = Core.getDepreciationMethod (depreciationFactoryLookupDTO);
		
		if(depreciationMethod != null) {
			DepreciationDTO depreciationDTO = new DepreciationDTO();
			depreciationDTO.useFullLife = new BigDecimal(this.getA_Life_Period());// at the moment, int is ok for Thai, but for other country BigDecima is suitable, need to change AD
			depreciationDTO.useFullLifeUnit = Calendar.MONTH;
			depreciationDTO.depreciationId = this.get_ID();
			depreciationDTO.inServiceDate = this.getA_Asset().getAssetServiceDate();
			depreciationDTO.accountDate = this.getDateAcct();
			depreciationDTO.startPeriodDepreciation = this.getA_Current_Period();
			lifePeriods = (int)depreciationMethod.getCountPeriod(depreciationDTO);
			
			// it's safe, at the moment, core disable setting of lifePeriods_F
			lifePeriods_C = lifePeriods;
			lifePeriods_F = lifePeriods;
		}
		
		Timestamp startDateAcct = getDateAcct();
		if (getAssetDepreciationDate() != null)
		{
			if (getAssetDepreciationDate().compareTo(getDateAcct()) >= 0)
			{
				if (TimeUtil.getMonthLastDay(startDateAcct).compareTo(getAssetDepreciationDate()) == 0)
				{
					startDateAcct = TimeUtil.addMonths(getAssetDepreciationDate(), 1);
					++A_Current_Period;
				}
				else
					startDateAcct = getAssetDepreciationDate();					
			}
		}
		
		for (int currentPeriod = A_Current_Period, cnt = 1; currentPeriod <= lifePeriods; currentPeriod++, cnt++)
		{
			final String whereClause = MDepreciationExp.COLUMNNAME_A_Asset_ID+"=?"
					+" AND A_Period=?"
					+" AND "+MDepreciationExp.COLUMNNAME_PostingType+"=?"
					+" AND "+MDepreciationExp.COLUMNNAME_Processed+"=?";
			boolean match = new Query(getCtx(), MDepreciationExp.Table_Name, whereClause, get_TrxName())
					.setParameters(new Object[]{getA_Asset_ID(), currentPeriod, getPostingType(), true})
					.match();
			if (match) {
				continue;
			}
			
			exp_C = Env.ZERO;
			exp_F = Env.ZERO;
			
			String help = "" + accumDep_C + "|" + accumDep_F + " + ";
			
			if (lifePeriods_C > currentPeriod ||  !depreciation_C.requireLastPeriodAdjustment())
			{
				setFiscal(false);
				exp_C = depreciation_C.invoke(this, assetacct, currentPeriod, accumDep_C, depreciationMethod);
				accumDep_C = accumDep_C.add(exp_C);
			}
			else if (lifePeriods_C == currentPeriod)
			{	// last period
				if (depreciationMethod != null && depreciationMethod.isPeriodAdjustment()) {
					exp_C = depreciation_C.invoke(this, assetacct, currentPeriod, accumDep_C, depreciationMethod);
				}else {
					exp_C = assetCost.subtract(accumDep_C);
				}
				accumDep_C = assetCost;
			}
			
			if (lifePeriods_F > currentPeriod || !depreciation_F.requireLastPeriodAdjustment())
			{
				setFiscal(true);
				exp_F = depreciation_F.invoke(this, assetacct, currentPeriod, accumDep_F, depreciationMethod);
				accumDep_F = accumDep_F.add(exp_F);
			}
			else if (lifePeriods_F == currentPeriod)
			{	// last period (fiscal)
				if (depreciationMethod != null && depreciationMethod.isPeriodAdjustment()) {
					exp_C = depreciation_C.invoke(this, assetacct, currentPeriod, accumDep_C, depreciationMethod);
				}else {
					exp_F = assetCost.subtract(accumDep_F);
				}
				accumDep_F = assetCost;
			}
			
			help += "" + exp_C + "|" + exp_F + " = " + accumDep_C + "|" + accumDep_F;
			
			// added by zuhri
			int months = 0; 
			
			months = months + (currentPeriod - A_Current_Period);
			Timestamp dateAcct = TimeUtil.getMonthLastDay(TimeUtil.addMonths(startDateAcct, months));
			
			MDepreciationExp.createDepreciation (this, currentPeriod, dateAcct,
													exp_C, exp_F,
													accumDep_C, accumDep_F,
													help, get_TrxName());
			if (log.isLoggable(Level.FINE)) 
			{
				String info = "" + cnt + ": period=" + currentPeriod + "/" + lifePeriods_C + "|" + lifePeriods_F
					+ ", exp=" + exp_C + "|" + exp_F + ", accumDep=" + accumDep_C + "|" + accumDep_F
					+ ", DateAcct=" + dateAcct;
				log.fine("=> " + info + Env.NL + Env.NL);
				sb.append(info + Env.NL);
			}
		} // for
		if (log.isLoggable(Level.FINE)) log.fine(sb.toString());
		
		m_buildDepreciation = false;
	}	//	buildDepreciation
	

	
	/**
	 * Truncate not processed depreciation entries.
	 * IS NOT modifying workfile.
	 */
	public void truncDepreciation()
	{
		String trxName = get_TrxName();
		
		int A_Current_Period = getA_Current_Period();
		final String sql = "DELETE FROM "+MDepreciationExp.Table_Name
						+" WHERE "
							+MDepreciationExp.COLUMNNAME_Processed+"=?"
							+" AND "+MDepreciationExp.COLUMNNAME_A_Period+">=?"
							+" AND "+MDepreciationExp.COLUMNNAME_A_Asset_ID+"=?"
							+" AND "+MDepreciationExp.COLUMNNAME_PostingType+"=?"
							+" AND "+MDepreciationExp.COLUMNNAME_C_AcctSchema_ID+"=?"
		;
		Object[] params = new Object[]{false, A_Current_Period, getA_Asset_ID(), getPostingType(), getC_AcctSchema_ID()};
		int no = DB.executeUpdateEx(sql, params, trxName);
		if (log.isLoggable(Level.FINE)) log.fine("sql=" + sql + "\nDeleted #" + no);
	}	//	truncDepreciation
	
	/**
	 * Update Funding Mode related fields
	 * @param m model
	 * @param changedColumnName column name that has been changed
	 */
	public static void updateFinantare(SetGetModel m, String changedColumnName)
	{
		//Own contribution:
		BigDecimal valCofinantare = SetGetUtil.get_AttrValueAsBigDecimal(m, COLUMNNAME_A_Valoare_Cofinantare);
		// Asset Value:
		BigDecimal assetCost = SetGetUtil.get_AttrValueAsBigDecimal(m, COLUMNNAME_A_Asset_Cost);
		// Third value:
		BigDecimal valTert = SetGetUtil.get_AttrValueAsBigDecimal(m, COLUMNNAME_A_Valoare_Tert);
		
		// Calculate values
		if (valCofinantare.signum() == 0 && valTert.signum() == 0)
		{
			// Values ​​have never been set, so put everything on their own financing
			valCofinantare = assetCost;
			valTert = Env.ZERO;
		}
		else if (COLUMNNAME_A_Asset_Cost.equals(changedColumnName))
		{
			valCofinantare = assetCost.subtract(valTert);
		}
		else if (COLUMNNAME_A_Valoare_Cofinantare.equals(changedColumnName))
		{
			valTert = assetCost.subtract(valCofinantare);
		}
		else if (COLUMNNAME_A_Valoare_Tert.equals(changedColumnName))
		{
			valCofinantare = assetCost.subtract(valTert);
		}
		else
		{
			valTert = assetCost.subtract(valCofinantare);
		}
		
		// Financing Type
		String tipFinantare = A_TIP_FINANTARE_Cofinantare;
		if (valTert.signum() == 0)
		{
			tipFinantare = A_TIP_FINANTARE_Proprie;
		}
		else if (valCofinantare.signum() == 0)
		{
			tipFinantare = A_TIP_FINANTARE_Terti;
		}
		//
		// Set values
		m.set_AttrValue(COLUMNNAME_A_Tip_Finantare, tipFinantare);
		m.set_AttrValue(COLUMNNAME_A_Valoare_Cofinantare, valCofinantare);
		m.set_AttrValue(COLUMNNAME_A_Valoare_Tert, valTert);
		//
		// If the method is invoked for a persistent object when reset mode of financing
		if (A_TIP_FINANTARE_Proprie.equals(tipFinantare) && SetGetUtil.isPersistent(m))
		{
			m.set_AttrValue(COLUMNNAME_A_FundingMode_ID, null);
		}
	}
	
	@Override
	public boolean set_AttrValue(String ColumnName, Object value) {
		int index = get_ColumnIndex(ColumnName);
		if (index < 0)
			return false;
		return set_ValueNoCheck(ColumnName, value);
	}
	
	@Override
	public Object get_AttrValue(String ColumnName) {
		int index = get_ColumnIndex(ColumnName);
		if (index < 0)
			return null;
		return get_Value(index);
	}
	
	@Override
	public boolean is_AttrValueChanged(String ColumnName) {
		int index = get_ColumnIndex(ColumnName);
		if (index < 0)
			return false;
		return is_ValueChanged(index);
	}
}	//	MDepreciationWorkfile
