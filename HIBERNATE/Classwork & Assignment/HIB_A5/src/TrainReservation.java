import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name="TrainReservation")


public class TrainReservation{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int id;
	private String passangerName;
	private int age;
	private String journeyDate;
	private int ticketNo;


	public TrainReservation() {
		
	}
	
	public TrainReservation(int id, String passangerName, int age, String journeyDate, int ticketNo) {
		this.id = id;
		this.passangerName = passangerName;
		this.age = age;
		this.journeyDate = journeyDate;
		this.ticketNo = ticketNo;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPassangerName(String passangerName) {
		this.passangerName = passangerName;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}
	
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getPassangerName() {
		return this.passangerName;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getJourneyDate() {
		return this.journeyDate;
	}

	public int getTicketNo() {
		return this.ticketNo;
	}
	
	@Override
	public String toString() {
		return "Id : "+this.getId()+"\tName : "+this.getPassangerName()+"\tAge : "+this.getAge()+"\tJourney Date : "+this.getJourneyDate()+"\tTicketNo : "+this.getTicketNo();
	}

}