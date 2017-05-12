<?php 
	namespace IMooc;

	class Factory
	{
		static function createObject()
		{
			$db = Database::getInstance();
			//把对象加到注册树上
			register::set('db1', $db);
			return $db;
		}
	}





 ?>