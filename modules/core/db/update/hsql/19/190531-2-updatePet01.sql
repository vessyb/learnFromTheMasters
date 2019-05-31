alter table PETCLINIC_PET add constraint FK_PETCLINIC_PET_ON_PHOTO foreign key (PHOTO_ID) references SYS_FILE(ID);
create index IDX_PETCLINIC_PET_ON_PHOTO on PETCLINIC_PET (PHOTO_ID);
