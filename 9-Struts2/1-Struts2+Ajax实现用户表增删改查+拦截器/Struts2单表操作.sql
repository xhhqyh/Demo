create table stuInfo(
       tid int primary key, --����
       stuNo number not null, --ѧ��
       stuSex varchar2(5) check(stuSex in('Ů','��')),--�Ա�
       stuName varchar2(10) not null -- ����
);

update stuInfo set stuNo='111', stuSex='��', stuName='��'  where tid = 15

create sequence sequence_stu
increment by 1
start with 0
minvalue 0
maxvalue 99999
nocycle
nocache

select * from stuInfo;

delete from StuInfo where tid = 1;