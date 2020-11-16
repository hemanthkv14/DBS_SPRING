public class Student {
	
	private int id;
	private String name;
	private int age;
	private String branch;
	
	Student(){}
	Student(int id, String name, int age, String branch){
		this.id = id;
		this.name = name;
		this.age = age;
		this.branch = branch;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getBranch() {
		return this.branch;
	}
	
}
