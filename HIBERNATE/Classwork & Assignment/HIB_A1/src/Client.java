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
			c.insertRecordInDatabase(1,"Rohit",2,40000);
//			c.insertRecordInDatabase(2,"Virat",3,30000);
//			c.insertRecordInDatabase(3,"Rahul",4,20000);
//			c.insertRecordInDatabase(4,"Shreyas",2,100000);
//			c.insertRecordInDatabase(5,"Dhoni",1,30000);
//			c.displayRecords();
//			c.displayRecordCriteria();
		
//			c.addTenure(1,3);
			c.displayRecords();
			
//			c.deleteRecord(1);
//			c.displayRecords();
		}
		catch(HibernateException e) {
			System.out.println("Exception is "+e);
		}
	}
	
	public void insertRecordInDatabase(int policy_no, String name, int tenure, int amt_to_pay) throws HibernateException{
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Insurance ins = new Insurance(policy_no, name, tenure, amt_to_pay);
		session.save(ins);
		tx.commit();
		session.close();
		
	}
	
	public void display(List insList) {
		for(Iterator iterator = insList.iterator(); iterator.hasNext();) {
			Insurance ins = (Insurance) iterator.next();
			System.out.println("Policy_No : "+ins.getPolicyNo()+"\tName : "+ins.getName()+"\tTenure : "+ins.getTenure()+"\tAmount to be paid : "+ins.getAmountToPay());	
		}
	}
	
	public void displayRecords() throws HibernateException{
		Session session = factory.openSession();
		List insList = session.createQuery("From Insurance").list();
		display(insList);
//		Iterator it = insList.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		session.close();
	}
	
	public void displayRecordCriteria() throws HibernateException{
		Session session = factory.openSession();
		Criteria cr = session.createCriteria(Insurance.class);
		cr.add(Restrictions.ge("amountToPay", 30000));
		List insList = cr.list();
		display(insList);
	}
	
	public void displayRecords_NativeSQL() throws HibernateException{
		Session session = factory.openSession();
		String sql = "SELECT * FROM Insurance where tenure<3";
		SQLQuery query = session.createSQLQuery(sql);
		List insList = query.list();
		Iterator it = insList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		session.close();
	}
	
	public void addTenure(Integer policy, int incTenure) throws HibernateException{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Insurance ins = (Insurance) session.get(Insurance.class, policy);
		ins.setTenure(ins.getTenure()+incTenure);
		session.update(ins);
		tx.commit();
		session.close();
	}
	
	public void deleteRecord(Integer policy) throws HibernateException{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Insurance ins = (Insurance) session.get(Insurance.class, policy);
		session.delete(ins);
		tx.commit();
		session.close();
	}
}
