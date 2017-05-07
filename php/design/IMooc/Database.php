<?php 
	namespace IMooc;

	class Database
	{
		protected $db;
		private function __construct()
		{

		}
		//单一设计模式
		static function getInstance()
		{
			if (self::$db) {
				return self::$db;
			} else {
				self::$db= new self();
				return self::$db;
			}
		}
	}



 ?>