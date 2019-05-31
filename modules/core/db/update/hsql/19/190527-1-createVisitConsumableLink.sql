create table PETCLINIC_VISIT_CONSUMABLE_LINK (
    VISIT_ID varchar(36) not null,
    CONSUMABLE_ID varchar(36) not null,
    primary key (VISIT_ID, CONSUMABLE_ID)
);
