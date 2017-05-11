PHP设计模式 - 数据对象映射模式


1.数据对象映射模式，是将对象和数据存储起来，对一个对象的操作会映射为对数据存储的操作。
2.在代码中实现数据对象映射模式，我们将实现一个ORM类，将复杂的SQl语句映射成对象属性的操作
3.结合使用数据对象映射模式，工厂模式，注册模式。

文件：
	1)index.php主文件
	2)User.php操作文件
	3)Factory.php工厂类文件
	4)Register.php注册器类文件
	5)Database.php适配器接口文件
	6)Mysql.php连接数据库文件