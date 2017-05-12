PHP设计模式-- 装饰器模式

1.装饰器模式（Decorator），可以动态的添加修改类的功能
2.一个类提供了一项功能，如果要在修改并添加额外的功能，传统的编程模式，需要写一个子类继承它，并重新实现类的方法。
3.使用装饰器模式，仅需在运行时添加一个装饰器对象即可实现，可以实现最大的灵活性

文件：
	1)index.php主文件
	2)DrawDecorator.php接口文件
	3)两个装饰器文件
		ColorDrawDecorator.php和SizeDrawDecorator.php