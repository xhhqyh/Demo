CREATE TABLE users(
    userId INT PRIMARY KEY,
    userName VARCHAR2(10), 
    userPwd VARCHAR2(10) NOT NULL
);

INSERT INTO users VALUES('1', '张三', '123456');
INSERT INTO users VALUES('2', '李四', '123456');
INSERT INTO users VALUES('3', '王五', '123456');
INSERT INTO users VALUES('4', '赵六', '123456');
INSERT INTO users VALUES('5', '秦皇', '123456');
INSERT INTO users VALUES('6', '汉武', '123456');
INSERT INTO users VALUES('7', '西施', '123456');
INSERT INTO users VALUES('8', '昭君', '123456');
INSERT INTO users VALUES('9', '貂蝉', '123456');
INSERT INTO users VALUES('10', '玉环', '123456');
INSERT INTO users VALUES('11', '妲己', '123456');
INSERT INTO users VALUES('12', '月儿', '123456');
INSERT INTO users VALUES('13', '雪女', '123456');
INSERT INTO users VALUES('14', '紫女', '123456');
INSERT INTO users VALUES('15', '炎灵姬', '123456');
INSERT INTO users VALUES('16', '少司命', '123456');

SELECT * FROM users;
SELECT COUNT(*) count FROM users;
SELECT * FROM (SELECT s.*, ROWNUM rn FROM users s)u WHERE rn between 3 and 6;