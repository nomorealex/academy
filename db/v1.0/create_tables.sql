SET search_path TO application_db;

DROP TABLE IF EXISTS T_TEAM CASCADE;
DROP TABLE IF EXISTS T_TEAM_MEMBER CASCADE;
DROP TABLE IF EXISTS T_RACK CASCADE;
DROP TABLE IF EXISTS T_RACK_ASSET CASCADE;
DROP TABLE IF EXISTS T_BOOKING CASCADE;

CREATE TABLE T_TEAM
(
    ID                  UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    NAME                varchar(50),
    PRODUCT             varchar(100),
    CREATED_AT          TIMESTAMP DEFAULT now(),
    MODIFIED_AT         TIMESTAMP DEFAULT now(),
    DEFAULT_LOCATION    varchar(10) NOT NULL
);

CREATE TABLE T_TEAM_MEMBER
(
    ID                  UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    TEAM_ID             UUID NOT NULL,
    CTW_ID              varchar(8) NOT NULL UNIQUE,
    NAME                varchar(50) NOT NULL,
    CREATED_AT          TIMESTAMP DEFAULT now(),
    MODIFIED_AT         TIMESTAMP DEFAULT now()
);

CREATE TABLE T_RACK
(
    ID                  UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    SERIAL_NUMBER       varchar(50) NOT NULL UNIQUE,
    STATUS              varchar(8) NOT NULL,
    TEAM_ID             UUID,
    DEFAULT_LOCATION    varchar(10) NOT NULL,
    CREATED_AT          TIMESTAMP DEFAULT now(),
    MODIFIED_AT         TIMESTAMP DEFAULT now()
);

CREATE TABLE T_RACK_ASSET
(
    ID                  UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    ASSET_TAG           varchar(50) NOT NULL,
    RACK_ID             UUID NOT NULL
);

CREATE TABLE T_BOOKING
(
    ID                  UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    RACK_ID             UUID NOT NULL,
    REQUESTER_ID        UUID NOT NULL,
    BOOK_FROM           varchar(50) NOT NULL,
    BOOK_TO             varchar(50) NOT NULL,
    CREATED_AT          TIMESTAMP DEFAULT now(),
    MODIFIED_AT         TIMESTAMP DEFAULT now()
);