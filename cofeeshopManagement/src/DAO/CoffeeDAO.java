package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.OwnerModel;
import model.StaffModel;
import model.TeaModel;
import utility.ConnectionManager;

public class CoffeeDAO extends GetConnection{

	Connection dbConn = null;
	@Override
	public Connection getDbConnection() throws ClassNotFoundException {
		Connection dbCon = ConnectionManager.getConnection();
		return dbCon;
	}

	

	public void viewCoffeeRecord() throws ClassNotFoundException {
		dbConn = getDbConnection();
		String sql = "Select * from coffee";
		try {
			Statement stmt = dbConn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("==========================================================================");
			System.out.format("%-10s %-25s\n","Cofee Id","Coffee Name");
			System.out.println("==========================================================================");
			while(rs.next()) {
				
				System.out.format("%-10s %-25s \n",rs.getString(1), rs.getString(2));
				
			}
			System.out.println("==========================================================================");
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	//to insert the coffeedetails to coffee table
	public void storeCoffeeRecordInDb(ArrayList<OwnerModel> empList) throws ClassNotFoundException {
		dbConn = getDbConnection();
		String sql = "insert into coffee(coffeeid,coffeename) values (?,?)";
		
		try {
			PreparedStatement ps = dbConn.prepareStatement(sql);
			for(OwnerModel em: empList) {
				ps.setString(1, em.getcoffeeCode());
				ps.setString(2, em.getCoffeeName());
				int result = ps.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
		
		//to delete the coffee
		public void deleteCoffeeRecordInDb(String coffeeid)  throws ClassNotFoundException {
			dbConn = getDbConnection();
			String sql = "delete from coffee where coffeeid=?";
			try {
				PreparedStatement ps = dbConn.prepareStatement(sql);
				
				 OwnerModel em= new OwnerModel();
				ps.setString(1, coffeeid);
				int result = ps.executeUpdate();
				if(result==1) {
				System.out.println("Coffee Details deleted Successfully.....");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println();
	}
	
		


	public void viewteaRecord() throws ClassNotFoundException {
		dbConn = getDbConnection();
		String sql = "Select * from coffeedetailstable";
		try {
			Statement stmt = dbConn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("====================================================================================================================");
			System.out.format("%-20s %-20s %-20s %-20s  \n","cfid","coffeeName","cost","description1");
			
			System.out.println("====================================================================================================================");
			while(rs.next()) {
				System.out.format("%-20s %-20s %-20s %-20s \n",rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4));				
			}
			System.out.println("====================================================================================================================");
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void storeteaRecordInDb(ArrayList<TeaModel> teaList) throws ClassNotFoundException {
		dbConn = getDbConnection();
		String sql = "insert into coffeedetailstable(cfid,coffeename,cost,description1) values (?,?,?,?)";
		try {
			PreparedStatement ps = dbConn.prepareStatement(sql);
			for(TeaModel em: teaList) {
				ps.setString(1, em.getCfid());
				ps.setString(2, em.getCoffeename());
				ps.setInt(3, em.getCost());
				ps.setString(4, em.getDescription());
				int result = ps.executeUpdate();
				if(result == 1) {
					System.out.println("coffee details added successfully.....");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
		
		public void deleteteaRecordInDb(String cfid)  throws ClassNotFoundException {
			dbConn = getDbConnection();
			String sql = "delete from coffeedetailstable where cfid=?";
			try {
				PreparedStatement ps = dbConn.prepareStatement(sql);
				TeaModel em= new TeaModel();
					ps.setString(1, cfid);
				int result = ps.executeUpdate();	
				System.out.println("coffee types Deleted Successfully.....");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

			public void updateteaRecord(int option, String cfid, String newEmpDetail) throws ClassNotFoundException {
				
			dbConn = getDbConnection();
			String sql = null;
			if(option == 1) {
				sql = "update coffeedetailstable set coffeename = ? where cfid = ?";	
			}
			else if(option == 3) {
				sql = "update coffeedetailstable set description = ? where cfid = ?";	
			}
			
			try {
				PreparedStatement ps = dbConn.prepareStatement(sql);
				ps.setString(1, newEmpDetail);
				ps.setString(2, cfid);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void updateteaRecord(int option, String cfid, int newcoffeetypedetails) throws ClassNotFoundException {
			dbConn = getDbConnection();
			String sql=null;
			if(option == 2) {
				sql = "update coffeedetailstable set cost = ? where cfid = ?";	
			}
			
			
			try {
				PreparedStatement ps = dbConn.prepareStatement(sql);
				ps.setInt(1, newcoffeetypedetails);
				ps.setString(2,cfid);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		public void viewstaffRecord() throws ClassNotFoundException {
			dbConn = getDbConnection();
			String sql = "Select * from staff";
			try {
				Statement stmt = dbConn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				System.out.println("====================================================================================================================================================");
				System.out.format("%-20s %-20s %-20s %-20s \n","staffId","staffName","PhoneNumber","Address");
					
				System.out.println("====================================================================================================================================================");
				while(rs.next()) {
					System.out.format("%-20s %-20s %-20s %-20s \n",rs.getString(1),rs.getString(2), rs.getInt(3),rs.getString(4));				
				}
				System.out.println("====================================================================================================================================================");
				System.out.println();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public void viewstaffRecord(String staffid) throws ClassNotFoundException {
			dbConn = getDbConnection();
			String sql = "Select staffid,staffwork from staff where staffid=?";
			
			try {
				PreparedStatement ps= dbConn.prepareStatement(sql);
				ps.setString(1, staffid);
				ResultSet rs = ps.executeQuery();
				System.out.println("=====================================================================");
				System.out.format("%-20s %-20s \n","staffId","staffwork");
				System.out.println("=====================================================================");
				while(rs.next()) {
					System.out.format("%-20s %-20s \n",rs.getString(1),rs.getString(2));				
				}
				System.out.println("=====================================================================");
				System.out.println();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public void storestaffRecordInDb(ArrayList<StaffModel> staffList) throws ClassNotFoundException {
			dbConn = getDbConnection();
			String sql = "insert into staff(staffid,staffname,staffphoneNo,staffaddress) values (?,?,?,?)";
			try {
				PreparedStatement ps = dbConn.prepareStatement(sql);
				for(StaffModel em: staffList) {
					ps.setString(1, em.getStaffid());
					ps.setString(2, em.getStaffname());
					ps.setInt(3, em.getStaffphoneNo());
					ps.setString(4, em.getStaffaddress());
					int result = ps.executeUpdate();
					if(result == 1) {
						System.out.println("staff details added successfully.....");
					}
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
			
			public void deletestaffRecordInDb(String staffid)  throws ClassNotFoundException {
				dbConn = getDbConnection();
				String sql = "delete from staff where staffid=?";
				try {
					PreparedStatement ps = dbConn.prepareStatement(sql);
					TeaModel em= new TeaModel();
						ps.setString(1, staffid);
					int result = ps.executeUpdate();	
					System.out.println("Deleted Successful.....");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

			public void updatestaffRecord(int option, String rollno, String newEmpDetail) throws ClassNotFoundException {
				dbConn = getDbConnection();
				String sql = null;
				if(option == 1) {
					sql = "update cofeedetails set coffeename = ? where cfid = ?";	
				}
				else if(option == 3) {
					sql = "update coffeedetailstable set description1 = ? where cfid = ?";	
				}
				
				try {
					PreparedStatement ps = dbConn.prepareStatement(sql);
					ps.setString(1, newEmpDetail);
					ps.setString(2, rollno);
					ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			public void updatestaffRecord(int option, String cfid, int newteaDetails) throws ClassNotFoundException {
				dbConn = getDbConnection();
				String sql=null;
				if(option == 2) {
					sql = "update coffeedetailstable set cost = ? where cfid = ?";	
				}
				else if(option == 4) {
					sql = "update coffeedetailstable set semester = ? where cfid = ?";	
				}
				
				
				try {
					PreparedStatement ps = dbConn.prepareStatement(sql);
					ps.setInt(1, newteaDetails);
					ps.setString(2,cfid);
					ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}


			     public void orderitems(String sid) throws ClassNotFoundException{
			    		
			    	    Class.forName("com.mysql.jdbc.Driver");
			    	    String sql = "Select * from coffeedetailstable";
			    	   
			    	    try {
			    	      	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffeeshopmanagement","root","Manoj@154"); 	
			    	    	 Statement stmt = con.createStatement();
			    	    	 ResultSet rs = stmt.executeQuery(sql);
			    	    	 while(rs.next()) {
			    	    		 if(rs.getString(1).equals(sid)) {
			    	            	     String sq = "insert into orderitem(cfid,coffeename,cost,description1) values (?,?,?,?)";
			    	            	     PreparedStatement ps = con.prepareStatement(sq);
			    				      
			    				    	 ps.setString(1,rs.getString(1));
			    				      	 ps.setString(2,rs.getString(2));
			    				    	 ps.setInt(3,rs.getInt(3));
			    				    	 ps.setString(4,(rs.getString(4)));
			    					     int result = ps.executeUpdate();
			    				     	 if(result == 1) {
			    					     	System.out.println("coffee orderd successfully");
			    					     }
			    	                  }
			    	                 
			    	    		}
			    	    }
			    	    catch(SQLException e) {
			    	    	e.printStackTrace();
			    	    }
			    	   }
			     
			     public void vieworderditems() throws ClassNotFoundException {
			    	 dbConn = getDbConnection();
			    	 String sql = "Select * from orderitem";
			    	 try {
			    		 Statement stmt = dbConn.createStatement();
			    		 ResultSet rs = stmt.executeQuery(sql);
			    		 System.out.println("====================================================================================================================");
			    		 System.out.format("%-20s %-20s %-20s %-20s  \n","cfid","coffeeName","cost","description1");
			
			    		 System.out.println("====================================================================================================================");
			    		 while(rs.next()) {
			    			 System.out.format("%-20s %-20s %-20s %-20s \n",rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4));				
			    		 }
			    		 System.out.println("====================================================================================================================");
			    		 System.out.println();
			    	 } catch (SQLException e) {
			// TODO Auto-generated catch block
			    		 e.printStackTrace();
			    	 }
		
			     }		
	
	
	

}