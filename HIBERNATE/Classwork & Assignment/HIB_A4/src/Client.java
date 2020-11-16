import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


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
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();

			Student hem = new Student(259, "V Hemanth Kumar");
			Student gsp = new Student(224, "G Shiva Prasadh");
			Student cjr = new Student(208, "CJ Chandrakanth");
			Student msr = new Student(232, "M Srikanth Reddy");
			
			Set<Student> shift1 = new HashSet<Student>();
			shift1.add(gsp);
			shift1.add(msr);
			
			Set<Student> shift2 = new HashSet<Student>();
			shift2.add(hem);
			shift2.add(cjr);
						
			Teacher raj = new Teacher(1, "C", "Raju", shift2);
			Teacher mss = new Teacher(2, "Java", "Suresh", shift1);
			Teacher mrz = new Teacher(3, "CNS", "Riaz", shift2);
			Teacher srv = new Teacher(4, "Linux", "Srinivas", shift1);

			session.save(raj);
			session.save(mss);
			session.save(mrz);
			session.save(srv);
			
			tx.commit();
			c.displayRecords();
			
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void displayRecords() throws HibernateException{
		Session session = factory.openSession();
		List tchList = session.createQuery("From Teacher").list();
		display(tchList);
		session.close();
	}
	
	public void display(List obj) {
		for(Iterator iterator = obj.iterator(); iterator.hasNext();) {
			Teacher clg = (Teacher) iterator.next();
			System.out.println("Students studying under "+clg.getName()+":\n");
			Set<Student> std = clg.getStd();
			Iterator it = std.iterator();
			while(it.hasNext()) {
				System.out.println(it.next().toString());
			}
		}
	}
	
	
}
