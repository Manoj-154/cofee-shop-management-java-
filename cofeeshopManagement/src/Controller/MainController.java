package Controller;

import java.util.Scanner;

import DAO.CoffeeDAO;

import model.TeaModel;


public class MainController {

	public static void main(String[] args) throws ClassNotFoundException {
		CoffeeDAO coffeeDao = new CoffeeDAO();
		System.out.println("  ===========================================================================================");
		System.out.println("||                                     COFFEE_SHOP_MANAGEMENT                            	 ||");
		System.out.println("  ===========================================================================================");
		boolean temp = true;
		while(temp) {
			System.out.println("1) Owner \n2) Staff\n3) Customer\n");
			Scanner sc = new Scanner(System.in);
			int option = Integer.parseInt(sc.nextLine());
			switch(option) {
				case 1: {
					System.out.println("Owner name");
					String ownerName = sc.nextLine();
					System.out.println("Owner password");
					String ownerPwd = sc.nextLine();
					if(ownerName.equals("owner") && ownerPwd.equals("own123")) {
						boolean temp1 = true;
						while(temp1) {
							System.out.println("Below are the options you can do Choose anyone");
							System.out.println("1) CoffeeType details\n 2) To do operations on Coffee \n 3) StaffDetails\n4) Logout");
							
							boolean flag1 = true;
							int ownerOption = 0;
							while(flag1) {
								try {
									ownerOption = Integer.parseInt(sc.nextLine());
									flag1 = false;
								}catch(Exception e) {
									System.out.println(" wrong Input.Give the correct option in number type");
									flag1 =true;
								}
							}
							switch(ownerOption) {
								case 1:{	
									CoffeeController cc=new CoffeeController();
									cc.coffeeControl();
									break;
									}
								
								case 2:{
									CoffeeController cc2=new CoffeeController();
									cc2.teaControl();
									break;
									}
								case 3:{
									CoffeeController cc3=new CoffeeController();
									cc3.staffControl();
									break;
									}
							
								case 4:{
									temp1 = false;
									break;
								}
								default:System.out.println("Invalid choice");
							}
						}
						
					}
					else {
						System.out.println("Incorrect username/password");
					}
					break;
				}
				case 2:{
					System.out.println("Enter your username");
					String adminName = sc.nextLine();
					System.out.println("Enter your password");
					String adminPwd = sc.nextLine();
					if(adminName.equals("staff") && adminPwd.equals("staff123")) {
						boolean temp1 = true;
						
						while(temp1) {
							System.out.println("Choose any one of an operation that you wish to do");
							System.out.println("1) View coffee\n 2)Back");
							
							boolean flag1 = true;
							int adminOption = 0;
							while(flag1) {
								try {
									adminOption = Integer.parseInt(sc.nextLine());
									flag1 = false;
								}catch(Exception e) {
									System.out.println("Input given type is wrong. Give the right option in number type");
									flag1 =true;
								}
							}
							
							switch(adminOption) {
						
							case 1:{	
									CoffeeController cc=new CoffeeController();
									coffeeDao.viewteaRecord();
									temp=false;
									break;
									}		
						
								case 2:{
									temp = false;
									break;
								}
								default:System.out.println("Invalid choice..............");
								break;
								
							}
						}
						
					}
					else {
						System.out.println("Incorrect username/password");
					}
					break;
				}
					case 3:{
						System.out.println("customer name");
						String adminName = sc.nextLine();
						System.out.println("Enter your phno");
						String adminPwd = sc.nextLine();
						if(adminName.equals("customer") && adminPwd.equals("12345")) {
							boolean temp1 = true;
						
							while(temp1) {
								System.out.println("Choose any one of an operation that you wish to do");
								System.out.println("1) View coffee\n2) View staff \n3) order coffee \n4) view your orders \n 5)back \n");
								
									boolean flag1 = true;
									int adminOption = 0;
									while(flag1) {
										try {
											adminOption = Integer.parseInt(sc.nextLine());
											flag1 = false;
										}catch(Exception e) {
											System.out.println("Input given type is wrong. Give the right option in number type");
											flag1 =true;
										}
									}
							
									switch(adminOption) {
									case 1:{	
										CoffeeController cc=new CoffeeController();
									
										coffeeDao.viewteaRecord();
										break;
										}
								
									case 2:{
										coffeeDao.viewstaffRecord();
//										temp=false;
										break;
									}
									

									case 3:{
										System.out.println("enter coffee id  to  order");
										String orderedid=sc.next();
										coffeeDao.orderitems(orderedid);
										break;
									}
									
									case 4:{
										coffeeDao.vieworderditems();
										break;
										
									}
								case 5:{
									temp1=false;
									break;
								}
								
								
								default:System.out.println("invalid choice");
								temp=false;
								break;
							}
						}
						
					}
					else {
						System.out.println("Incorrect username/password");
					}
					break;
				}
					
				
				case 4:{
					temp = false;
				}
		}
	}
		}
	
}