package user.validation.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class UserData implements Serializable{
	
	@Id
	@Column
	private int id;

	@Column
	private String name;

	@Column
	private String password;

	UserData(){
		
	}
	
	public UserData(int id, String name, String password){
		this.id = id;
		this.name = name;
		this.password = password;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	@Override
	public String toString() {
		return "Id : "+this.getId()+"\tName : "+this.getName()+"\tPassword"+this.getPassword();
	}
}
