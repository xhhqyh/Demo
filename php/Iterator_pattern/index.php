<?php 
	define('BASEDIR', __DIR__);
	include BASEDIR.'/IMooc/Loader.php';
	spl_autoload_register('\\IMooc\\Loader::autoload');

	$users = new \IMooc\AllUser();
	foreach($users as $user)
	{
		echo "<br>";
		print_r($users);
	}

 ?>