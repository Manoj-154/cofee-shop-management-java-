package Controller;

import java.util.Scanner;

import DAO.CoffeeDAO;
import model.OwnerModel;
import model.StaffModel;
import model.TeaModel;

import service.CoffeeDetails;

public class CoffeeController {
	CoffeeDAO coffeeDao = new CoffeeDAO();
	CoffeeDetails cd= new CoffeeDetails();
	Scanner sc= new Scanner(System.in);

 public void coffeeControl() throws ClassNotFoundException {
	 System.out.println("1)view Coffee Details\n2) Add Coffee\n3) Remove Coffee\n4) Back\n");
	 Scanner sc= new Scanner(System.in);
		int coffeeChoice = Integer.parseInt(sc.nextLine());
		switch(coffeeChoice) {
			case 1: {
				coffeeDao.viewCoffeeRecord();
				coffeeControl();
				break;
				
			}
			case 2:{
				System.out.println("enter the cofe details to add");
				String coffeeId;
				String coffeeName;

				int result=0;
				coffeeId = sc.nextLine();
					coffeeName = sc.nextLine();
					OwnerModel em = new OwnerModel(coffeeId,coffeeName);
					
					cd.addcoffeeToList(em);
				System.out.println("Coffee details added successfully.....");
				coffeeControl();
				break;
			}
			case 3:{
				System.out.println("enter the coffee to delete");
				String courseId = sc.nextLine();
				OwnerModel em = new OwnerModel();
				coffeeDao.deleteCoffeeRecordInDb(courseId);
				coffeeControl();
				break;
			}
			case 4:{
				break;
				
			}
			default:System.out.println("Invalid choice.....");
			coffeeControl();
			
			break;

		}
 	}
 
 
 public void teaControl() throws ClassNotFoundException {
	 System.out.println("1) View coffee Details\n2) Add coffee\n3) Remove remove\n4) Edit coffee details\n5) Back\n");
	 Scanner sc= new Scanner(System.in);
		int coffeeChoice = Integer.parseInt(sc.nextLine());
		switch(coffeeChoice) {
			case 1: {
				coffeeDao.viewteaRecord();
				teaControl();
				break;
				
			}
			case 2:{
				String cfid;
				String coffeename;
				int cost;
				String description;
				String coffeeid;
				int result=0;
				System.out.println("Enter cf id");
					cfid = sc.nextLine();
					System.out.println("Enter coffee Name");
					coffeename = sc.nextLine();
					System.out.println("Enter coffee cost");
					cost =Integer.parseInt(sc.nextLine());
					System.out.println("Enter coffee Description");
					description = sc.nextLine();
					System.out.println("Enter coffee Id");
					coffeeid = sc.nextLine();
					
					TeaModel em1 = new TeaModel(cfid, coffeename, cost,description,coffeeid);
					cd.addteaToList(em1);
				teaControl();
				break;
			}
			case 3:{
				System.out.println("enter the cf id to delete");
				String cfid = sc.nextLine();
				TeaModel em = new TeaModel();
				coffeeDao.deleteteaRecordInDb(cfid);
				teaControl();
				break;
			}
			case 4:{
				UpdateControl uc=new UpdateControl();
				uc.updateteaControl();
				teaControl();
				break;
				}
			case 5:{
				break;
				
			}
			default:System.out.println("Invalid choice.....");
			teaControl();

		}
 }
 public void staffControl() throws ClassNotFoundException {
	 System.out.println("1) View Staff Details\n2) Add Staff \n3) Remove Staff\n4) Back\n");
	 Scanner sc= new Scanner(System.in);
		int coffeeChoice = Integer.parseInt(sc.nextLine());
		switch(coffeeChoice) {
			case 1: {
				coffeeDao.viewstaffRecord();
				staffControl();
				break;
				
			}
			case 2:{
				
				String staffid;
				String staffname;
				int staffphoneNo;
				String staffaddress;

				int result=0;
				System.out.println("Enter staff id");
					staffid = sc.nextLine();
					System.out.println("Enter staff Name");
					staffname = sc.nextLine();
					System.out.println("Enter staff phone number");
					staffphoneNo =Integer.parseInt(sc.nextLine());
					System.out.println("Enter staff Address");
					staffaddress = sc.nextLine();
					
					StaffModel em1 = new StaffModel(staffid, staffname, staffphoneNo, staffaddress);
					cd.addstaffToList(em1);

				staffControl();
				break;
				
				
				
			}
			case 3:{
				System.out.println("enter the staff id to delete");
				String staffid = sc.nextLine();
				StaffModel em = new StaffModel();
				coffeeDao.deletestaffRecordInDb(staffid);
				staffControl();
				break;
			}
			
			case 4:{
				break;
				
			}
			default:System.out.println("Invalid choice.....");
			staffControl();

		}
 }

}
		