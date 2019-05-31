alter table PETCLINIC_VISIT alter column HOURLY_RATE_ID rename to HOURLY_RATE_ID__U44950 ^
alter table PETCLINIC_VISIT alter column HOURLY_RATE_ID__U44950 set null ;
drop index IDX_PETCLINIC_VISIT_ON_HOURLY_RATE ;
alter table PETCLINIC_VISIT drop constraint FK_PETCLINIC_VISIT_ON_HOURLY_RATE ;
-- alter table PETCLINIC_VISIT add column VET_ID varchar(36) ^
-- update PETCLINIC_VISIT set VET_ID = <default_value> ;
-- alter table PETCLINIC_VISIT alter column VET_ID set not null ;
alter table PETCLINIC_VISIT add column VET_ID varchar(36) not null ;
