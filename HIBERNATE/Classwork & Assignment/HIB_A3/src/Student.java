import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT_OTM")
public class Student {
	
	@Id
	@Column(name = "pin")
	private int pin;
	@Column(name = "name")
	private String name;
	
	Student(){
		
	}
	
	Student(int pin, String name){
		this.pin = pin;
		this.name = name;
	}
	
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPin() {
		return this.pin;
	}
	
	public String getName() {
		return this.name;
	}
	
}
