package demo;

public class Student {
	
	private int pin;
	private String name;
	private int age;
	
	public Student() {
		
	}
	
	public Student(int pin, String name, int age) {
		this.pin = pin;
		this.name = name;
		this.age = age;
	}
	
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getPin() {
		return this.pin;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	@Override
	public String toString() {
		return "Name : "+this.getName()+"\tPin : "+this.getPin()+"\tAge : "+this.getAge();
	}
	
}
