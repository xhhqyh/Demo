<?php 
	namespace IMooc\Database;

	use IMooc\Database;

	class MySQL implements Database
	{
		protected $conn;

		function connect($host, $user, $passwd, $dbname)
		{
			$conn = mysql_connect($host, $user, $passwd);
			mysql_select_db($dbname, $conn);
			$this->conn = $conn;
		}

		function query($sql)
		{
			//echo $sql;
			$res = mysql_query($sql, $this->conn);
			//要把结果集保存到二维数组中
			while($key = mysql_fetch_assoc($res)){
				$keys[] = $key;
			}
			//print_r($keys);
			return $keys;
		}

		function close()
		{
			mysql_close($this->conn);
		}
	}




 ?>