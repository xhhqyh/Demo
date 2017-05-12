<?php 
	define('BASEDIR', __DIR__);
	include BASEDIR.'/IMooc/Loader.php';
	spl_autoload_register('\\IMooc\\Loader::autoload');

	$convas1 = new IMooc\Canvas();
	$convas1->init();
	$convas1->addDecorator(new \IMooc\ColorDrawDecorator('green'));
	$convas1->addDecorator(new \IMooc\SizeDrawDecorator('14px'));
	$convas1->rect(3, 6, 4, 12);
	$convas1->draw();
 ?>