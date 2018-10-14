CREATE TABLE CM_PRICEITEM_EXT_STG(
PRICEITEM_ID      VARCHAR(10),
PRICEITEM_CD      VARCHAR(10),
DESCRIPTION_TEXT  VARCHAR(100),
PI_STATUS_FLAG    VARCHAR(10), 
RECORD_STATUS     VARCHAR(10), 
CREATION_DT       DATETIME, 
CONSTRAINT PK_PRICEITEMID PRIMARY KEY(PRICEITEM_ID));

CREATE TABLE CM_PRICEITEM_PARM_EXT_STG(	
PRICEITEM_ID     VARCHAR(10),
PRICE_PARM_CD    VARCHAR(10),
REQUIRED_SW      VARCHAR(10),
PRIORITY_NUM     VARCHAR(10),
START_DT         DATETIME,
END_DT           DATETIME,
DISP_ORD         VARCHAR(10),
RECORD_STATUS    VARCHAR(10),
CREATION_DT      DATETIME,
CONSTRAINT PK_PRICEITEMPARAMID PRIMARY KEY(PRICEITEM_ID));

CREATE TABLE CM_PRICELIST_EXT_STG(	
PRICELIST_ID       VARCHAR(10),
PRICELIST_EXT_ID   VARCHAR(10),
PRICELIST_NAME     VARCHAR(10),
PL_STATUS_FLG      VARCHAR(10),
PL_START_DT        DATETIME,
PL_END_DT          DATETIME,
PL_TYPE            VARCHAR(10),
RECORD_STATUS      VARCHAR(10),
CREATION_DT        DATETIME,
CONSTRAINT PK_PRICELISTID PRIMARY KEY(PRICELIST_ID));


CREATE TABLE CM_PRICEASGN_RS_RC_EXT_STG(	
PRICE_ASGN_ID       VARCHAR(10),
PRICELIST_EXT_ID    VARCHAR(10),
PRICEITEM_CD        VARCHAR(10),
PRICECOMP_ID        VARCHAR(10),
RS_CD               VARCHAR(10),
EFFDT               VARCHAR(10),
RC_SEQ              VARCHAR(10),
RC_NAME             VARCHAR(10),
VALUE_AMT           VARCHAR(10),
TIERED_FLAG         VARCHAR(10),
CREATION_DT         DATETIME,
CONSTRAINT PK_PRICEASGNID PRIMARY KEY(PRICE_ASGN_ID));


CREATE TABLE CM_RS_RC_EXT_STG(	
RS_CD                VARCHAR(10),
RS_DESCR             VARCHAR(10),
PRICE_CURRENCY_CD    VARCHAR(10),
EFFTDT               VARCHAR(10),
RC_SEQ               VARCHAR(10),
RC_NAME              VARCHAR(10),
STEP_RC_SEQ          VARCHAR(10),
STEP_LOW_VAL         VARCHAR(10),
STEP_HIGH_VAL        VARCHAR(10),
CREATION_DT          DATETIME,
CONSTRAINT PK_RSCD PRIMARY KEY(RS_CD));