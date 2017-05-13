<?php 
	namespace IMooc;

	class User
	{
		public $id;
		public $name;
		public $pass;
		public $time;
		public $res;

		protected $db;

		//构造方法
		function __construct($id)
		{
			$this->id = $id;
			$this->db = new \IMooc\Database\MySQL();
			$this->db->connect('127.0.0.1', 'root', 'root', 'test');
			//$this->res = $this->db->query("select * from user");
			

		}

		//析构方法
		// function __destruct()
		// {
		// 	$this->db->query("update user set name = '{$this->name}', pass = '{$this->pass}', time = '{$this->time}' where id = '{$this->id}' limit 1");
		// } 


 	}



  ?>