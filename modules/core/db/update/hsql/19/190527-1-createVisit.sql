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
    HOURLY_RATE_ID varchar(36) not null,
    HOURS integer not null,
    PET_ID varchar(36) not null,
    --
    primary key (ID)
);