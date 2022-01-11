package com.org.hib.HIb_Onetoone;

import org.hibernate.*;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;    
    
public class Store {    
public static void main(String[] args) {    
      
	Configuration  cfg= new Configuration();
    cfg.configure("hibernate.cfg.xml");
    SessionFactory fact = cfg.buildSessionFactory();
    Session sess= fact.openSession();
    sess.beginTransaction();
    Employee e1=new Employee();    
    e1.setName("kalavathi R");    
    e1.setEmail("kala@gmail.com");    
        
    Address address1=new Address();    
    address1.setAddressLine1("Bellur cross");    
    address1.setCity("Bellur");    
    address1.setState("karnataka");    
    address1.setCountry("India");    
    address1.setPincode(571418);    
        
    e1.setAddress(address1);    
    address1.setEmployee(e1);    
        
    sess.save(e1);
    sess.save(address1);
    sess.getTransaction().commit();
    System.out.println("success");    
}    
}    