package model;

public class StaffModel {
	private String staffid;
	private String staffname;
	private int staffphoneNo;
	private String staffaddress;
	public StaffModel(String staffid, String staffname, int staffphoneNo, String staffaddress) {
		super();
		this.staffid = staffid;
		this.staffname = staffname;
		this.staffphoneNo = staffphoneNo;
		this.staffaddress = staffaddress;
	}
	public StaffModel() {
		super();
	}
	public String getStaffid() {
		return staffid;
	}
	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}
	public String getStaffname() {
		return staffname;
	}
	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}
	public int getStaffphoneNo() {
		return staffphoneNo;
	}
	public void setStaffphoneNo(int staffphoneNo) {
		this.staffphoneNo = staffphoneNo;
	}
	public String getStaffaddress() {
		return staffaddress;
	}
	public void setStaffaddress(String staffaddress) {
		this.staffaddress = staffaddress;
	}
	
	
}
