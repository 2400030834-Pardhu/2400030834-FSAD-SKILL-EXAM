package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Date;
import java.util.Scanner;

public class ClientDemo {
    
    public static void main(String[] args) {
        try {
            // Create SessionFactory from Configuration
            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Hospital.class)
                    .buildSessionFactory();
            
            Scanner scanner = new Scanner(System.in);
            
            while(true) {
                System.out.println("\n===== Hospital Management System =====");
                System.out.println("1. Insert new Hospital Record");
                System.out.println("2. View Hospital Record by ID");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                
                int choice = scanner.nextInt();
                scanner.nextLine();
                
                Session session = factory.openSession();
                Transaction transaction = null;
                
                switch(choice) {
                    case 1:
                        insertHospital(session);
                        break;
                    case 2:
                        viewHospitalById(session, scanner);
                        break;
                    case 3:
                        System.out.println("Thank you for using Hospital Management System!");
                        session.close();
                        factory.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
                
                session.close();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void insertHospital(Session session) {
        Scanner scanner = new Scanner(System.in);
        Transaction transaction = null;
        
        try {
            System.out.println("\n--- Insert New Hospital Record ---");
            System.out.print("Enter Hospital Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Description: ");
            String description = scanner.nextLine();
            System.out.print("Enter Status: ");
            String status = scanner.nextLine();
            System.out.print("Enter Location: ");
            String location = scanner.nextLine();
            System.out.print("Enter Phone Number: ");
            String phone = scanner.nextLine();
            
            Hospital hospital = new Hospital(name, description, new Date(), status, location, phone);
            
            transaction = session.beginTransaction();
            Integer id = (Integer) session.save(hospital);
            transaction.commit();
            
            System.out.println("\nHospital Record Inserted Successfully!");
            System.out.println("Generated ID: " + id);
        } catch(Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public static void viewHospitalById(Session session, Scanner scanner) {
        try {
            System.out.println("\n--- View Hospital Record ---");
            System.out.print("Enter Hospital ID: ");
            int id = scanner.nextInt();
            
            Hospital hospital = session.get(Hospital.class, id);
            
            if(hospital != null) {
                System.out.println("\n--- Hospital Details ---");
                System.out.println("ID: " + hospital.getId());
                System.out.println("Name: " + hospital.getName());
                System.out.println("Description: " + hospital.getDescription());
                System.out.println("Date: " + hospital.getDate());
                System.out.println("Status: " + hospital.getStatus());
                System.out.println("Location: " + hospital.getLocation());
                System.out.println("Phone: " + hospital.getPhone());
            } else {
                System.out.println("\nHospital Record with ID " + id + " not found!");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
