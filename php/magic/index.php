<?php 
	define('BASEDIR', __DIR__);
	include BASEDIR.'/IMooc/Loader.php';
	spl_autoload_register('\\IMooc\\Loader::autoload');

	$obj = new IMooc\Object();
	//当对一个不存在的属性进行赋值时，就会调用__set方法
	//$obj->title = "hello world!";
	// 当读取一个属性不存在时会调用__get方法
	//echo $obj->title;

	//测试__call魔术方法，当调用的方法不存在时，会调用__call
	//echo $obj -> test("hello", 124);

	//测试__callStatic静态方法
	//echo IMooc\Object::test("hello", 1234);

	//测试__toString
	//echo $obj;

	//测试__invoke
	echo $obj("test1");
 ?>