alter table PETCLINIC_VISIT add constraint FK_PETCLINIC_VISIT_ON_VET foreign key (VET_ID) references PETCLINIC_VETERINARIAN(ID);
create index IDX_PETCLINIC_VISIT_ON_VET on PETCLINIC_VISIT (VET_ID);
