-- begin PETCLINIC_PET_TYPE
create unique index IDX_PETCLINIC_PET_TYPE_UNIQ_NAME on PETCLINIC_PET_TYPE (NAME) ^
-- end PETCLINIC_PET_TYPE
-- begin PETCLINIC_OWNER
create unique index IDX_PETCLINIC_OWNER_UNIQ_EMAIL on PETCLINIC_OWNER (EMAIL) ^
create unique index IDX_PETCLINIC_OWNER_UNIQ_PHONE_NUMBER on PETCLINIC_OWNER (PHONE_NUMBER) ^
-- end PETCLINIC_OWNER
-- begin PETCLINIC_PET
alter table PETCLINIC_PET add constraint FK_PETCLINIC_PET_ON_PET_TYPE foreign key (PET_TYPE_ID) references PETCLINIC_PET_TYPE(ID)^
alter table PETCLINIC_PET add constraint FK_PETCLINIC_PET_ON_OWNER foreign key (OWNER_ID) references PETCLINIC_OWNER(ID)^
create index IDX_PETCLINIC_PET_ON_PET_TYPE on PETCLINIC_PET (PET_TYPE_ID)^
create index IDX_PETCLINIC_PET_ON_OWNER on PETCLINIC_PET (OWNER_ID)^
-- end PETCLINIC_PET
-- begin PETCLINIC_VETERINARIAN
alter table PETCLINIC_VETERINARIAN add constraint FK_PETCLINIC_VETERINARIAN_ON_USER foreign key (USER_ID) references SEC_USER(ID)^
create unique index IDX_PETCLINIC_VETERINARIAN_UNIQ_USER_ID on PETCLINIC_VETERINARIAN (USER_ID) ^
create index IDX_PETCLINIC_VETERINARIAN_ON_USER on PETCLINIC_VETERINARIAN (USER_ID)^
-- end PETCLINIC_VETERINARIAN
-- begin PETCLINIC_VISIT
alter table PETCLINIC_VISIT add constraint FK_PETCLINIC_VISIT_ON_VET foreign key (VET_ID) references PETCLINIC_VETERINARIAN(ID)^
alter table PETCLINIC_VISIT add constraint FK_PETCLINIC_VISIT_ON_PET foreign key (PET_ID) references PETCLINIC_PET(ID)^
create index IDX_PETCLINIC_VISIT_ON_VET on PETCLINIC_VISIT (VET_ID)^
create index IDX_PETCLINIC_VISIT_ON_PET on PETCLINIC_VISIT (PET_ID)^
-- end PETCLINIC_VISIT
-- begin PETCLINIC_VISIT_CONSUMABLE_LINK
alter table PETCLINIC_VISIT_CONSUMABLE_LINK add constraint FK_VISCON_ON_VISIT foreign key (VISIT_ID) references PETCLINIC_VISIT(ID)^
alter table PETCLINIC_VISIT_CONSUMABLE_LINK add constraint FK_VISCON_ON_CONSUMABLE foreign key (CONSUMABLE_ID) references PETCLINIC_CONSUMABLE(ID)^
-- end PETCLINIC_VISIT_CONSUMABLE_LINK
