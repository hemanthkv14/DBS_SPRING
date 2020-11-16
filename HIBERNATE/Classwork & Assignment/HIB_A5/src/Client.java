import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;


public class Client {
	
	private static SessionFactory factory;
	
	public static void getSessionFactory() {
		try {
			Configuration conf = new Configuration().configure();
			StandardServiceRegistryBuilder builder =  new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
			factory = conf.buildSessionFactory(builder.build());
		} catch(Throwable ex) {
			System.err.println("Failed to create sessionFactory object. "+ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			getSessionFactory();
			Client c = new Client();
			
			c.InsertRecordInDatabase(1, "Hemanth", 22, "12/12/2020", 101);
			c.InsertRecordInDatabase(2, "Chandra", 23, "1/2/2021", 102);
			c.InsertRecordInDatabase(3, "Moses", 28, "1/12/2020", 104);
			c.InsertRecordInDatabase(4, "Srikanth", 16, "15/12/2020", 201);
			c.InsertRecordInDatabase(5, "Shiva", 56, "17.2.2021", 205);
			c.InsertRecordInDatabase(6, "Laxman", 34, "31.3.2021", 216);
			c.InsertRecordInDatabase(7, "Bharath", 70, "24.14.2020", 312);
			c.InsertRecordInDatabase(8, "Shoaib", 68, "10.12.2020", 350);
			
			c.DisplayRecordsCriteria();
			
		} catch(HibernateException e) {
			System.out.println("Exception is :"+e);
		}
		
	}
	
	public void InsertRecordInDatabase(int id, String passangerName, int age, String journeyDate, int ticketNo) throws HibernateException {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		TrainReservation tr1 = new TrainReservation(id, passangerName, age, journeyDate, ticketNo);
		session.save(tr1);
		tx.commit();
		session.close();
	}
	
	public void DisplayRecordsCriteria() throws HibernateException {
		Session session = factory.openSession();
		Criteria cr = session.createCriteria(TrainReservation.class);
		
		int minAge = 25;
		int maxAge = 65;
		cr.add(Restrictions.gt("age", minAge));
		cr.add(Restrictions.lt("age", maxAge));
		List employees = cr.list();
		
		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next().toString());
		}
		
	}
	
}