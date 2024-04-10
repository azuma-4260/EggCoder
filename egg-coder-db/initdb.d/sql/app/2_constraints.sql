use egg_coder;

alter table TAGS add constraint fk1_tag_user foreign key (id_user) references USERS(id_user);
alter table TAG_RECORDS add constraint fk1_tag_record_record foreign key (id_record) references RECORDS(id_record);
alter table LOGIN_AUTHORITIES add constraint fk1_authority_user foreign key (id_user) references USERS(id_user);
