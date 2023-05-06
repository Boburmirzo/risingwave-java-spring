create table campaigns (id bigint not null, statut_courant integer, name varchar(255), user_bo_id bigint, primary key (id)) ;
create table comments (id bigint not null, contenu varchar(255), id_auteur bigint not null, campaign_bo_id bigint, primary key (id)) ;
create table users (id bigint not null, name varchar(255), primary key (id));


alter table campaigns add constraint FK4b426jrng2p6s9orv5suqfcaq foreign key (user_bo_id) references users (id);
alter table comments add constraint FKpj8nxor41yn0xs1h48crag0fb foreign key (campaign_bo_id) references campaigns (id);
alter table comments add constraint FKwl85ien2gui9q6739c7g5vnt foreign key (id_auteur) references users (id);
