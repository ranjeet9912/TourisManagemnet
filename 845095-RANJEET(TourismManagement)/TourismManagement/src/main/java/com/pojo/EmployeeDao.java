package com.pojo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDao {

	private Configuration conf;
	private SessionFactory sf;
	private Session session;
	private Transaction tx;
	
	//register
	@SuppressWarnings("deprecation")
	public void saveData(Employee e) {
		
		conf = new Configuration().configure("cts_hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		tx= session.beginTransaction();
		session.save(e);
		tx.commit();
	}
	
	//login part
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public List login(String email, String pass) {
		conf = new Configuration().configure("cts_hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		String sql="from Employee  as e where e.femail=? and e.fpass=?";
		Query query1= session.createQuery(sql);
		query1.setParameter(0, email);
		query1.setParameter(1, pass);
		List list = query1.list();
		//list.add(email);
		return list;
	}
	
	
	//display data
	@SuppressWarnings("deprecation")
	public List displayData() {
		conf = new Configuration().configure("cts_hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		tx= session.beginTransaction();
		List list = session.createQuery("from Employee").list();
		return list;
	}

	
	//login disp part
	public List getData(Employee e1) {
		List li = new ArrayList();
		conf = new Configuration().configure("cts_hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		tx= session.beginTransaction();
		List list = session.createQuery("from Employee").list();
		Iterator it = list.iterator();
		while(it.hasNext())
		{
			Employee emp = (Employee)it.next();
			if( (e1.getFemail().equals(emp.getFemail())) && (e1.getFpass().equals(emp.getFpass())) )
			{
				Employee obj = new Employee();
				obj.setFac_id(emp.getFac_id());
				obj.setFname(emp.getFname());
				obj.setFaddress(emp.getFaddress());
				obj.setFdept(emp.getFdept());
				obj.setFemail(emp.getFemail());
				obj.setFdob(emp.getFdob());	
				li.add(obj);
			}
			
		}
		return li;
		
	}

	
	
	//search data..
	public List searchData(Employee e) {
		List li = new ArrayList();
		conf = new Configuration().configure("cts_hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		tx= session.beginTransaction();
		List list = session.createQuery("from Employee").list();
		Iterator it = list.iterator();
		while(it.hasNext())
		{
			Employee emp = (Employee)it.next();
			if(e.getFname().equalsIgnoreCase(emp.getFname()))
			{
				Employee obj = new Employee();
				obj.setFname(emp.getFname());
				obj.setFemail(emp.getFemail());
				obj.setFdept(emp.getFdept());
				obj.setFaddress(emp.getFaddress());
				li.add(obj);
			}
			
		}
		return li;
	}
	 //update data
	@SuppressWarnings("deprecation")
	public void updateData(Employee emp) {
		
		conf = new Configuration().configure("cts_hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		tx= session.beginTransaction();
		Employee obj = (Employee) session.get(Employee.class, emp.getFac_id());
		 obj.setFemail(emp.getFemail());
		 obj.setFname(emp.getFname());
		 obj.setFaddress(emp.getFaddress());
		 session.update(obj);
		 tx.commit();
	}
	//delete data
	@SuppressWarnings("deprecation")
	public void deleteData(Employee emp) {
		conf = new Configuration().configure("cts_hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		tx= session.beginTransaction();
		Employee obj = (Employee) session.get(Employee.class, emp.getFac_id());
		session.delete(obj);
		tx.commit();
		
		
	}

	
	
	
	
	
	
	
	

	
	// =========================================================================//
	//hod part
	
	public void saveHodData(HodEmployee e) {
		conf = new Configuration().configure("cts_hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		tx= session.beginTransaction();
		session.save(e);
		tx.commit();
		
	}

	public List hodlogin(String email, String pass) {
		conf = new Configuration().configure("cts_hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		String sql="from HodEmployee  as e where e.hemail=? and e.hpass=?";
		Query query1= session.createQuery(sql);
		query1.setParameter(0, email);
		query1.setParameter(1, pass);
		List list1 = query1.list();
		//list1.add(email);
		return list1;
	}

	@SuppressWarnings("deprecation")
	public List getHodData(HodEmployee e1) {
		List li = new ArrayList();
		conf = new Configuration().configure("cts_hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		tx= session.beginTransaction();
		List list = session.createQuery("from HodEmployee").list();
		Iterator it = list.iterator();
		while(it.hasNext())
		{
			HodEmployee emp = (HodEmployee)it.next();
			if( (e1.getHemail().equals(emp.getHemail())) && (e1.getHpass().equals(emp.getHpass())) )
			{
				HodEmployee obj = new HodEmployee();
				obj.setHid(emp.getHid());
				obj.setHname(emp.getHname());
				obj.setHaddress(emp.getHaddress());
				obj.setHdept(emp.getHdept());
				obj.setHemail(emp.getHemail());
				obj.setHdob(emp.getHdob());	
				li.add(obj);
			}
			
		}
		return li;
		
		
		
	}
	//hod display all hod data
	@SuppressWarnings("deprecation")
	public List hoddisplayData() {
		conf = new Configuration().configure("cts_hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		tx= session.beginTransaction();
		List list = session.createQuery("from HodEmployee").list();
		return list;
		
	}
	//hod update record
	@SuppressWarnings("deprecation")
	public void hodupdateData(HodEmployee emp) {
		conf = new Configuration().configure("cts_hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		tx= session.beginTransaction();
		HodEmployee obj = (HodEmployee) session.get(HodEmployee.class, emp.getHid());
		 obj.setHemail(emp.getHemail());
		 obj.setHname(emp.getHname());
		 obj.setHaddress(emp.getHaddress());
		 session.update(obj);
		 tx.commit();
		
	}
	//hod delete record
	@SuppressWarnings("deprecation")
	public void hoddeleteData(HodEmployee emp) {
		conf = new Configuration().configure("cts_hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		tx= session.beginTransaction();
		HodEmployee obj = (HodEmployee) session.get(HodEmployee.class, emp.getHid());
		session.delete(obj);
		tx.commit();
		
	}

	
	
}
