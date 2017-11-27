create sequence se_user
increment by 1
start with 0
minvalue 0
maxvalue 9999
nocycle
nocache

create table UserInfo(
       userid int primary key, --Ö÷¼ü
       uName varchar(20) not null, -- ĞÕÃû
       uAge number(3) not null -- ÄêÁä
);

insert into UserInfo values(se_user.nextval, 'ÍõÑÇ»Ô', 3);
insert into UserInfo values(se_user.nextval, 'ÍõÑÇ»Ô2', 4);
insert into UserInfo values(se_user.nextval, '¹ş¹ş¹ş', 5);
insert into UserInfo values(se_user.nextval, '³ÂÖ¾ºÀ', 6);
insert into UserInfo values(se_user.nextval, 'ÀîÌì½Ü', 7);
insert into UserInfo values(se_user.nextval, 'Ğ¬½³', 8);
insert into UserInfo values(se_user.nextval, 'ÆîÑà»Ô', 20);

select * from UserInfo order by userid desc;

select rownum rn, u.* from UserInfo u order by userid desc;

select * from (select rownum rn, u.* from UserInfo u) t where t.rn>2 and t.rn<5 order by userid desc; 

select count(*) num from UserInfo