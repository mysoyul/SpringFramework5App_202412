package myspring.di.xml;

import java.util.List;

public class Hello {
	String name;
	Printer printer;
	List<String> names;

	public Hello() {
		System.out.println(this.getClass().getName() + " 기본생성자 호출됨");
	}

	public Hello(String name, Printer printer) {
		System.out.println(this.getClass().getName() + " OverLoading 생성자 호출됨");
//		this.name = name;
//		this.printer = printer;
		setName(name);
		setPrinter(printer);
	}

	public List<String> getNames() {
		return this.names;
	}

	public void setNames(List<String> list) {
		this.names = list;
	}

	public void setName(String name) {
		System.out.println("setName() 호출됨 " + name);
		this.name = name;
	}

	public void setPrinter(Printer printer) {
		System.out.println("setPrinter() 호출됨 " + printer.getClass().getName());
		this.printer = printer;
	}

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}