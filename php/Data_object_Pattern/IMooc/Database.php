<?php 
	namespace IMooc;

	// class Database
	// {
	// 	protected $db;
	// 	private function __construct()
	// 	{

	// 	}
	// 	//单一设计模式
	// 	static function getInstance()
	// 	{
	// 		if (self::$db) {
	// 			return self::$db;
	// 		} else {
	// 			self::$db= new self();
	// 			return self::$db;
	// 		}
	// 	}
	// }

	//适配器模式借接口
	interface Database
	{
		function connect($host, $user, $passwd, $dbname);
		function query($sql);
		function close();
	}


 ?>