/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : PostgreSQL
 Source Server Version : 90602
 Source Host           : localhost:5432
 Source Catalog        : vendor
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 90602
 File Encoding         : 65001

 Date: 23/11/2017 14:27:28
*/


-- ----------------------------
-- Table structure for T_VENDOR_ALIPAY
-- ----------------------------
DROP TABLE IF EXISTS "T_VENDOR_ALIPAY";
CREATE TABLE "T_VENDOR_ALIPAY" (
  "FCREATED_ON" varchar(20) COLLATE "pg_catalog"."default",
  "FBILL_NO" varchar(50) COLLATE "pg_catalog"."default",
  "FNO" varchar(8) COLLATE "pg_catalog"."default",
  "FAVM_GOODS_CHN" varchar(8) COLLATE "pg_catalog"."default",
  "FBARCODE" varchar(50) COLLATE "pg_catalog"."default",
  "FBILL_AMOUNT" int4,
  "FPAY_CHANNEL_ID" varchar(1) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "T_VENDOR_ALIPAY" OWNER TO "postgres";

-- ----------------------------
-- Records of T_VENDOR_ALIPAY
-- ----------------------------
BEGIN;
INSERT INTO "T_VENDOR_ALIPAY" VALUES ('2017-11-16 10:00:00', '9300000201707011111', '93000000', '13', '6925303781262', 5, '1');
INSERT INTO "T_VENDOR_ALIPAY" VALUES ('2017-11-18 10:00:00', '9300000201707011112', '94000000', '15', '6925303781263', 6, '2');
INSERT INTO "T_VENDOR_ALIPAY" VALUES ('2017-11-20 20:00:00', '9300000201707011113', '95000000', '16', '6925303781264', 7, '3');
COMMIT;

-- ----------------------------
-- Table structure for T_VENDOR_PRODUCT
-- ----------------------------
DROP TABLE IF EXISTS "T_VENDOR_PRODUCT";
CREATE TABLE "T_VENDOR_PRODUCT" (
  "FBARCODE" varchar(50) COLLATE "pg_catalog"."default",
  "FNAME" varchar(50) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "T_VENDOR_PRODUCT" OWNER TO "postgres";

-- ----------------------------
-- Records of T_VENDOR_PRODUCT
-- ----------------------------
BEGIN;
INSERT INTO "T_VENDOR_PRODUCT" VALUES ('6925303781262', '雅哈[意式经典](PET280ml)');
INSERT INTO "T_VENDOR_PRODUCT" VALUES ('6925303781263', '测试2');
INSERT INTO "T_VENDOR_PRODUCT" VALUES ('6925303781264', '测试333');
COMMIT;

-- ----------------------------
-- Table structure for T_VENDOR_REPLEN
-- ----------------------------
DROP TABLE IF EXISTS "T_VENDOR_REPLEN";
CREATE TABLE "T_VENDOR_REPLEN" (
  "FNO" varchar(8) COLLATE "pg_catalog"."default",
  "FAVM_GOODS_CHN" varchar(8) COLLATE "pg_catalog"."default",
  "FBARCODE" varchar(50) COLLATE "pg_catalog"."default",
  "FSKU_NAME" varchar(50) COLLATE "pg_catalog"."default",
  "FQTY" int4,
  "FADD_TIME" varchar(20) COLLATE "pg_catalog"."default",
  "FIO" varchar(1) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "T_VENDOR_REPLEN" OWNER TO "postgres";

-- ----------------------------
-- Records of T_VENDOR_REPLEN
-- ----------------------------
BEGIN;
INSERT INTO "T_VENDOR_REPLEN" VALUES ('93000000', '13', '6925303781262', '雅哈[意式经典](PET280ml)', 5, '2017-11-16 11:00:08', '1');
INSERT INTO "T_VENDOR_REPLEN" VALUES ('94000000', '24', '6925303781263', '测试2', 9, '2017-11-18 11:00:08', '0');
COMMIT;
