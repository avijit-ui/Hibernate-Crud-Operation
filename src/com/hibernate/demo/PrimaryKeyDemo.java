package com.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.demo.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
		
		Session session = factory.getCurrentSession(); 
		
		try {
			System.out.println("Creating new student object..");
			Student tempStudent1 = new Student("parbati","bat","p.b@gmail.com");
			Student tempStudent2 = new Student("sam","roy","b.c@gmail.com");
			Student tempStudent3 = new Student("ayan","raj","d.s@gmail.com");
			
			session.beginTransaction();
			
			System.out.println("Saving the student...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			session.getTransaction().commit();
			System.out.println("done");
				
		}
		
		finally {
			factory.close();
		}
		
		

	}

}
