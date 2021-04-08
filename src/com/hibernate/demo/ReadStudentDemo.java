package com.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.demo.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
		
		Session session = factory.getCurrentSession(); 
		
		try {
			System.out.println("Creating new student object..");
			Student tempStudent = new Student("avi2","roy2","a.b1@gmail.com");
			
			session.beginTransaction();
			
			System.out.println("Saving the student...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			session.getTransaction().commit();
			System.out.println("Saved student.generated Id:" + tempStudent.getId());
			
			
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\n Getting student with id:" + tempStudent.getId());
			
			Student mystudent = session.get(Student.class,tempStudent.getId());
			
			System.out.println("get complete:" + mystudent);
			
			session.getTransaction().commit();
			System.out.println("done");
			
				
		}
		
		finally {
			factory.close();
		}
		
		

	}

}
