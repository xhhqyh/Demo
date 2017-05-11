<?php 
	namespace IMooc;

	class MaleUserStrategy implements UserStrategy {
		function showAd()
		{
			echo "Iphone6 Plus";
		}

		function showCategory()
		{
			echo "电子产品";
		}
	}

 ?>