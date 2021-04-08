package com.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.demo.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import java.util.List;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
		
		Session session = factory.getCurrentSession(); 
		
		try {
			
			session.beginTransaction();
			
			List<Student> theStudents = session.createQuery("from Student").list();
			for (Student tempstudent:theStudents) {
				System.out.println(tempstudent);
			}
			
			theStudents = session.createQuery("from Student s where s.lastname='roy'").list();
			
			System.out.println("\n\nstudents who have last name of roy");
			for (Student tempstudent:theStudents) {
				System.out.println(tempstudent);
			}
			
           theStudents = session.createQuery("from Student s where s.firstname='sam' OR s.lastname='raj'").list();
			
			System.out.println("\n\nstudents who have last name of raj and first name of sam");
			for (Student tempstudent:theStudents) {
				System.out.println(tempstudent);
			}
			
			theStudents = session.createQuery("from Student s where s.email like '%gmail.com'").list();
			
			System.out.println("\n\nstudents who have gmail id");
			for (Student tempstudent:theStudents) {
				System.out.println(tempstudent);
			}
			
			
			
			session.getTransaction().commit();
						
			System.out.println("done");
				
		}
		
		finally {
			factory.close();
		}
		
		

	}

	

}
