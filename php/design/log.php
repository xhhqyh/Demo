PHP设计模式--3种基本设计模式
	1)工厂模式，工厂方法或者类生成对象，而不是在代码中直接new
	2)单例模式，使某个类的对象仅允许创建一个
	3)注册模式，全局共享和交换对象

--IMooc中Factory.php是工厂模式的例子
	优点：当调用的一个类名字改变时，修改一处就可以了
	调用工厂$db = IMooc\Factory::createDatabase();

--IMooc中Database.php是单例模式的例子
	 在工厂模式中结合单一设计模式
	 $db = Database::getInstance();

--IMooc中Register.php是注册树模式的例子
	 在工厂模式中加上
	 	register::set('db1', $db);
	 在前台调用，在注册树上调用出来即可
	 	$db = \IMooc\Register::get('db1');
