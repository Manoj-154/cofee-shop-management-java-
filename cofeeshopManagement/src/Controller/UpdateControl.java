package Controller;

import java.util.Scanner;

import DAO.CoffeeDAO;

public class UpdateControl {
	Scanner sc= new Scanner(System.in);
	CoffeeDAO coffeeDao= new CoffeeDAO();
 public void updateteaControl() throws ClassNotFoundException {
	 System.out.println("Enter cfid to update existing coffeetype Id");
		String cfid = sc.nextLine();
		System.out.println("Select any one of the detail to get updated.\n1) coffee Name\n2) coffee cost\n3) coffee Description\n5) Back ");
		int updateOption = Integer.parseInt(sc.nextLine());
		switch(updateOption) {
		case 1:{
			System.out.println("Enter the new coffee name which has an cfid as "+cfid);
			String newcoffeename = sc.nextLine();
			coffeeDao.updateteaRecord(updateOption,cfid,newcoffeename);
			System.out.println("updated Successfully");
			
			break;
		}
		case 2:{
			System.out.println("Enter the coffee new cost which has an cfid as "+cfid);
			int newcost = Integer.parseInt(sc.nextLine());
			coffeeDao.updateteaRecord(updateOption,cfid,newcost);
			System.out.println("updated Successfully");
			
			break;
		}
		case 3:{
			System.out.println("Enter the coffee new description which has an cfid as "+cfid);
			String newdescription = sc.nextLine();
			coffeeDao.updateteaRecord(updateOption,cfid,newdescription);
			System.out.println("updated Successfully");
			
			break;
		}
		
		case 5:{
			break;
		}
		default:System.out.println("Invalid choice");
		}
 }
}
