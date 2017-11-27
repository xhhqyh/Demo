create sequence se_user
increment by 1
start with 0
minvalue 0
maxvalue 9999
nocycle
nocache

create table UserInfo(
       userid int primary key, --����
       uName varchar(20) not null, -- ����
       uAge number(3) not null -- ����
);

insert into UserInfo values(se_user.nextval, '���ǻ�', 3);
insert into UserInfo values(se_user.nextval, '���ǻ�2', 4);
insert into UserInfo values(se_user.nextval, '������', 5);
insert into UserInfo values(se_user.nextval, '��־��', 6);
insert into UserInfo values(se_user.nextval, '�����', 7);
insert into UserInfo values(se_user.nextval, 'Ь��', 8);
insert into UserInfo values(se_user.nextval, '�����', 20);

select * from UserInfo order by userid desc;

select rownum rn, u.* from UserInfo u order by userid desc;

select * from (select rownum rn, u.* from UserInfo u) t where t.rn>2 and t.rn<5 order by userid desc; 

select count(*) num from UserInfo