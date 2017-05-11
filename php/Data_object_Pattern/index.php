<?php 
	define('BASEDIR', __DIR__);
	include BASEDIR.'/IMooc/Loader.php';
	spl_autoload_register('\\IMooc\\Loader::autoload');

	
//分别对user对象里的一个对象的两个字段进行修改
class Page
{
	function index()
	{
		//工厂方法
		$user = IMooc\Factory::getUser(1);
		$user->name = 'qiyansgfds';

		//用注册器模式后,用var_dump()查看两个类是否是一个
		var_dump($user);
		$this->test();

		echo "ok";
	}

	function test()
	{
		$user = IMooc\Factory::getUser(1);
		$user->pass = '11111111';
		//用注册器模式后,用var_dump()查看两个类是否是一个
		var_dump($user);
	}
}

$page = new Page();

$page->index();

 ?>