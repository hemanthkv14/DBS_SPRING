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

import oracle.net.TNSAddress.Address;


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
			Set<Student> vStd = new HashSet<Student>();
			Set<Student> cStd = new HashSet<Student>();
			Set<Student> kStd = new HashSet<Student>();
			Set<Student> mStd = new HashSet<Student>();
			vStd.add(new Student(259, "Hemanth Kumar V"));
			vStd.add(new Student(250, "Shoaib MD"));
			kStd.add(new Student(254, "Moses TS"));
			kStd.add(new Student(256, "Pawan Reddy T"));
			cStd.add(new Student(208, "Chandrakanth CJ"));
			cStd.add(new Student(251, "Laxman S"));
			mStd.add(new Student(224, "Shiva Prasadh G"));
			mStd.add(new Student(232, "Srikanth Reddy"));

			College vmeg = new College("VMEG", "Vardhaman College Of Engineering",vStd);
			College cbit = new College("CBIT", "Chaitanya Bharathi College Of Engineering",cStd);
			College mvsr = new College("MVSR", "MVSR College Of Engineering",mStd);
			College kmit = new College("KMIT", "Keshav Memorial Institute Of Tech.",kStd);

			session.save(vmeg);
			session.save(cbit);
			session.save(mvsr);
			session.save(kmit);
			tx.commit();
			c.displayRecords();
			
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void displayRecords() throws HibernateException{
		Session session = factory.openSession();

		List clgList = session.createQuery("From College").list();
		display(clgList);
		session.close();
	}
	
	public void display(List obj) {
		for(Iterator iterator = obj.iterator(); iterator.hasNext();) {
			College clg = (College) iterator.next();
			System.out.println(clg.toString());
		}
	}
	
	
}
