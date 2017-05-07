<?php 
	define('BASEDIR', __DIR__);
	include BASEDIR.'/IMooc/Loader.php';
	spl_autoload_register('\\IMooc\\Loader::autoload');

	$db = IMooc\Factory::createObject();
	$db -> test();

 ?>