<?php 
	define('BASEDIR', __DIR__);
	include BASEDIR.'/IMooc/Loader.php';
	spl_autoload_register('\\IMooc\\Loader::autoload');

	//适配器模式
	$db = new IMooc\Database\MySQL();
	$db->connect('127.0.0.1', 'root', 'root', 'test');
	$row = $db->query("select * from user");
	print_r($row);
	$db->close();


 ?>