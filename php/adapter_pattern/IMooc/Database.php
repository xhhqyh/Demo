<?php 
	namespace IMooc;

	interface Database
	{
		function connect($host, $user, $passwd, $dbname);
		function query($sql);
		function close();
	}



 ?>