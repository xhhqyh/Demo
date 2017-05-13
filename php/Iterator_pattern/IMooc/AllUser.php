<?php 
	namespace IMooc;

	class AllUser implements \Iterator
	{
		protected $ids;
		protected $data = array();
		protected $index;

		function __construct()
		{
			//$db = Factory::getDatabase();
			$db = new \IMooc\Database\MySQL();
			$db->connect('127.0.0.1', 'root', 'root', 'test');
			$this->ids = $db->query("select id from user");
		}

		function current()
		{
			$id = $this->ids[$this->index]['id'];
			return Factory::getUser($id);
		}

		function next()
		{
			$this->index ++;
		}

		function valid()
		{
			return $this->index < count($this->ids);
		}

		function rewind()
		{
			$this->index = 0;
		}

		function key()
		{
			return $this->index;
		}
	}











 ?>