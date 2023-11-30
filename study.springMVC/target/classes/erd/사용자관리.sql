SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS TB_USER;




/* Create Tables */

CREATE TABLE TB_USER
(
	USER_ID varchar(128) NOT NULL,
	USER_PW varchar(64),
	USER_NM varchar(5),
	USER_AUTH varchar(9) DEFAULT 'AUTH_USER',
	RGST_DT timestamp DEFAULT NOW() NOT NULL,
	RGST_ID varchar(128),
	UPDT_DT timestamp DEFAULT NOW() NOT NULL,
	UPDT_ID varchar(128),
	DEL_YN char(1) DEFAULT 'N' NOT NULL,
	PRIMARY KEY (USER_ID)
);



