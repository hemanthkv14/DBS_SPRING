import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
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
			c.InsertRecordInDatabase(1,"Rohit",22,"CSE");
			c.InsertRecordInDatabase(2,"Virat",21,"ECE");
			c.InsertRecordInDatabase(3,"Rahul",20,"CSE");
			c.InsertRecordInDatabase(4,"Shreyas",24,"MECH");
			c.InsertRecordInDatabase(5,"Dhoni",20,"IT");
			c.DisplayRecords();
			c.displayRecordCriteria();
		
			c.UpdateRecord(1,35);
			c.DisplayRecords();
			
			c.DeleteRecord(1);
			c.DisplayRecords();
		}
		catch(HibernateException e) {
			System.out.println("Exception is "+e);
		}
	}
	
	public void InsertRecordInDatabase(int id, String name, int age, String branch) throws HibernateException{
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Student std = new Student(id, name, age, branch);
		session.save(std);
		tx.commit();
		session.close();
		
	}
	
	public void display(List stdList) {
		for(Iterator iterator = stdList.iterator(); iterator.hasNext();) {
			Student std = (Student) iterator.next();
			System.out.println("ID : "+std.getId()+"\tName : "+std.getName()+"\tAge : "+std.getAge()+"\tBranch : "+std.getBranch());	
		}
	}
	
	public void DisplayRecords() throws HibernateException{
		Session session = factory.openSession();
		List stdList = session.createQuery("From Student").list();
		display(stdList);
		session.close();
	}
	
	public void displayRecordCriteria() throws HibernateException{
		Session session = factory.openSession();
		Criteria cr = session.createCriteria(Student.class);
		cr.add(Restrictions.eq("branch","CSE"));
		List stdList = cr.list();
		display(stdList);
	}
	
	public void DisplayRecords_NativeSQL() throws HibernateException{
		Session session = factory.openSession();
		String sql = "SELECT * FROM student where branch='CSE'";
		SQLQuery query = session.createSQLQuery(sql);
		List stdList = query.list();
		Iterator it = stdList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		session.close();
	}
	
	public void UpdateRecord(Integer id, int age) throws HibernateException{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Student std = (Student) session.get(Student.class, id);
		std.setAge(age);
		session.update(std);
		tx.commit();
		session.close();
	}
	
	public void DeleteRecord(Integer id) throws HibernateException{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Student std = (Student) session.get(Student.class,id);
		session.delete(std);
		tx.commit();
		session.close();
	}
}
