create table stuInfo(
       tid int primary key, --主键
       stuNo number not null, --学号
       stuSex varchar2(5) check(stuSex in('女','男')),--性别
       stuName varchar2(10) not null -- 姓名
);

update stuInfo set stuNo='111', stuSex='男', stuName='大'  where tid = 15

create sequence sequence_stu
increment by 1
start with 0
minvalue 0
maxvalue 99999
nocycle
nocache

select * from stuInfo;

delete from StuInfo where tid = 1;