-- begin PETCLINIC_PET_TYPE
create table PETCLINIC_PET_TYPE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end PETCLINIC_PET_TYPE
-- begin PETCLINIC_OWNER
create table PETCLINIC_OWNER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    EMAIL varchar(255) not null,
    PHONE_NUMBER varchar(255),
    --
    primary key (ID)
)^
-- end PETCLINIC_OWNER
-- begin PETCLINIC_PET
create table PETCLINIC_PET (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    PET_TYPE_ID varchar(36) not null,
    OWNER_ID varchar(36) not null,
    PHOTO_ID varchar(36),
    --
    primary key (ID)
)^
-- end PETCLINIC_PET
-- begin PETCLINIC_VETERINARIAN
create table PETCLINIC_VETERINARIAN (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    USER_ID varchar(36) not null,
    HOURLY_RATE decimal(19, 2) not null,
    --
    primary key (ID)
)^
-- end PETCLINIC_VETERINARIAN
-- begin PETCLINIC_CONSUMABLE
create table PETCLINIC_CONSUMABLE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TITLE varchar(255) not null,
    DESCRIPTION varchar(255) not null,
    PRICE decimal(19, 2) not null,
    --
    primary key (ID)
)^
-- end PETCLINIC_CONSUMABLE
-- begin PETCLINIC_VISIT
create table PETCLINIC_VISIT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DATE_ timestamp not null,
    DESCRIPTION varchar(255) not null,
    AMOUNT decimal(19, 2) not null,
    VET_ID varchar(36) not null,
    HOURS integer not null,
    PET_ID varchar(36) not null,
    NUMBER_ varchar(255),
    --
    primary key (ID)
)^
-- end PETCLINIC_VISIT
-- begin PETCLINIC_VISIT_CONSUMABLE_LINK
create table PETCLINIC_VISIT_CONSUMABLE_LINK (
    VISIT_ID varchar(36) not null,
    CONSUMABLE_ID varchar(36) not null,
    primary key (VISIT_ID, CONSUMABLE_ID)
)^
-- end PETCLINIC_VISIT_CONSUMABLE_LINK
