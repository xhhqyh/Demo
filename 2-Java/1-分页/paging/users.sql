CREATE TABLE users(
    userId INT PRIMARY KEY,
    userName VARCHAR2(10), 
    userPwd VARCHAR2(10) NOT NULL
);

INSERT INTO users VALUES('1', '����', '123456');
INSERT INTO users VALUES('2', '����', '123456');
INSERT INTO users VALUES('3', '����', '123456');
INSERT INTO users VALUES('4', '����', '123456');
INSERT INTO users VALUES('5', '�ػ�', '123456');
INSERT INTO users VALUES('6', '����', '123456');
INSERT INTO users VALUES('7', '��ʩ', '123456');
INSERT INTO users VALUES('8', '�Ѿ�', '123456');
INSERT INTO users VALUES('9', '����', '123456');
INSERT INTO users VALUES('10', '��', '123456');
INSERT INTO users VALUES('11', '槼�', '123456');
INSERT INTO users VALUES('12', '�¶�', '123456');
INSERT INTO users VALUES('13', 'ѩŮ', '123456');
INSERT INTO users VALUES('14', '��Ů', '123456');
INSERT INTO users VALUES('15', '���鼧', '123456');
INSERT INTO users VALUES('16', '��˾��', '123456');

SELECT * FROM users;
SELECT COUNT(*) count FROM users;
SELECT * FROM (SELECT s.*, ROWNUM rn FROM users s)u WHERE rn between 3 and 6;