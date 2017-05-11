<?php 
namespace IMooc;

//定义为抽象类,事件发生者基类
abstract class EventGenerator {

	private $observers = array();

	//增加观察者
	function addObserver(Observer $observer)
	{
		$this->observers[] = $observer;
	}

	//更新后通知观察者自行更新
	function notify()
	{
		foreach ($this->observers as $observer) 
		{
			$observer->update();
		}
	}
}






 ?>