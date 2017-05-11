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

		//数据对象映射模式例子的工厂方法
		static function getUser($id)
		{
			//在工厂模式下，继续用注册器模式
			$key = 'user_'.$id;
			$user = Register::get($key);
			if (!$user) {
				$user = new User($id);
				Register::set($key, $user);
			}
			
			return $user;
		}
	}





 ?>