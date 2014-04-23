package hibernatetest;

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
import org.hibernate.service.ServiceRegistry;

public class ManageEmployee {
	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;
	public ManageEmployee() {
		// TODO Auto-generated constructor stub
	      try{
	    	  Configuration config = new Configuration();
	          config.configure();
	          serviceRegistry=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
	          factory=config.buildSessionFactory(serviceRegistry);
	       }catch (Throwable ex) { 
	          System.err.println("Failed to create sessionFactory object." + ex);
	          throw new ExceptionInInitializerError(ex); 
	       }
	}
	   public Integer addEmployee(Employee employee){
		      Session session = factory.openSession();
		      Transaction tx = null;
		      Integer employeeID = null;
		      try{
		         tx = session.beginTransaction();
		         employeeID = (Integer) session.save(employee); 
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace();
		      }finally {
		         session.close();
		      }
		      return employeeID;
		   }
	   public Integer addDepartment(Department dp){
		      Session session = factory.openSession();
		      Transaction tx = null;
		      Integer employeeID = null;
		      try{
		         tx = session.beginTransaction();
		         employeeID = (Integer) session.save(dp); 
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace();
		      }finally {
		         session.close();
		      }
		      return employeeID;
		   }
	   
	   public Integer selectDepartment(String dpname){
		   int dpid=0;
		   Session session=factory.openSession();
		   Transaction tx=null;
		   tx = session.beginTransaction();
		   String sql="FROM hibernatetest.Department dp WHERE dp.dept_name = :dpname";
		   List results= session.createQuery(sql).setParameter("dpname", dpname).list();
		   for(Iterator it=results.iterator();it.hasNext();){
			   Department dp=(Department)it.next();
			   System.out.println(dp.getDepartmentId()+":"+dp.getDept_name());
			   dpid=dp.getDepartmentId();
		   }
		   tx.commit();
		   session.close();
		   return dpid;
	   }
	   

}
