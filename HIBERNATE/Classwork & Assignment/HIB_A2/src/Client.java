import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import org.hibernate.Transaction;

public class Client {
	
	private static SessionFactory factory;
	
	public static void getSessionFactory() {
		
		try {
			Configuration conf = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
			factory = conf.buildSessionFactory(builder.build());
		}
		
		catch(Throwable ex) {
			System.err.println("Failed to create Session Factory Object "+ex);	
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static void main(String args[]) {
		try
		{
			getSessionFactory();
			Client c = new Client();
			
			Address add = new Address("Ameerpet","Hyderabad","Telangana",53);
			Student std = new Student(6,"Shoaib",21,"CSE");
			std.setAddress(add);
			System.out.println("Hello");
			c.insertData(std,add);
			System.out.println("Hello");
			
			Address add2 = new Address("RR Nagar","Bangalore","India",65);
			Student std2 = new Student(7,"Samson",21,"IT",add2);
			c.insertData(std2,add2);
			
			c.displayRecords();
			
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void insertData(Student stdObj, Address addObj) throws HibernateException{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(stdObj);
		session.save(addObj);
		tx.commit();
		System.out.println("Student and Address are inserted in the database");
		session.close();
		
	}
	
	public void displayRecords() throws HibernateException{
		Session session = factory.openSession();
		
		List stdList = session.createQuery("From Student").list();
		
		display(stdList);
		session.close();
	}
	
	public void display(List stdList) {
		for(Iterator iterator = stdList.iterator(); iterator.hasNext();) {
			Student std = (Student) iterator.next();
			System.out.println("ID : "+std.getId()+"\tName : "+std.getName()+"\tAge : "+std.getAge()+"\tBranch : "+std.getBranch());
			Address add = std.getAddress();
			System.out.println("Street : "+add.getStreet()+"\tCity : "+add.getCity()+"\tState : "+add.getState()+"\tZipCode : "+add.getZipCode());
		}
	}
	
	
}
