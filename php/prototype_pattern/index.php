<?php 
	define('BASEDIR', __DIR__);
	include BASEDIR.'/IMooc/Loader.php';
	spl_autoload_register('\\IMooc\\Loader::autoload');

	$prototype = new IMooc\Canvas();
	$prototype->init();

	$canvas1 = clone $prototype;
	$canvas1->rect(3, 6, 4, 12);
	$canvas1->draw();
	echo "============="."<br>";
	$canvas2 = clone $prototype;
	$canvas2->rect(1, 3, 2, 6);
	$canvas2->draw();


 ?>