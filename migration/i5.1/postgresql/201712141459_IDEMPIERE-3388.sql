-- IDEMPIERE-3388
-- Dec 14, 2017 2:58:05 PM CET
UPDATE C_AcctSchema SET CostingMethod='A',Updated=TO_TIMESTAMP('2017-12-14 14:58:05','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE C_AcctSchema_ID=101
;

-- Dec 14, 2017 2:58:14 PM CET
UPDATE M_CostElement SET IsActive='N',Updated=TO_TIMESTAMP('2017-12-14 14:58:14','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE M_CostElement_ID=104
;

SELECT register_migration_script('201712141459_IDEMPIERE-3388.sql') FROM dual
;

