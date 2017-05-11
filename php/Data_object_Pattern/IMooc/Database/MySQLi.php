<?php 
	namespace IMooc\Database;

	use IMooc\Database;

	class MySQLi implements Database
	{
		protected $conn;

		function connect($host, $user, $passwd, $dbname)
		{
			$conn = mysqli_connect($host, $user, $passwd, $dbname);
			$this->conn = $conn;
		}

		function query($sql)
		{
			return mysqli_query($this->conn, $sql);
		}

		function close()
		{
			mysqli_close($this->conn);
		}
	}







 ?>