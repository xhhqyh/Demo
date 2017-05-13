<?php 
	namespace IMooc;

	class config
	{
		public $res;
		function __construct()
		{
			$this->db = new \IMooc\Database\MySQL();
			$this->db->connect('127.0.0.1', 'root', 'root', 'test');
			//$this->res = $this->db->query("select * from user");
		
		}
	}











 ?>