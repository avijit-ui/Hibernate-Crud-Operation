package com.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.demo.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
		
		Session session = factory.getCurrentSession(); 
		
		try {
					
			int studentId = 1;
			
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\n Getting student with id:" + studentId);
			
			Student mystudent = session.get(Student.class,studentId);
			
			//System.out.println("Deleting student: " + mystudent);
			//session.delete(mystudent);
			
			System.out.println("Deleting student id=2");
			
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			session.getTransaction().commit();
			
			
			
			System.out.println("done");
			
				
		}
		
		finally {
			factory.close();
		}
		
		

	}

}
