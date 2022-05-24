package service;

import java.util.ArrayList;

import DAO.CoffeeDAO;
import model.OwnerModel;
import model.StaffModel;
import model.TeaModel;

public  class CoffeeDetails implements AbcDetails{
	CoffeeDAO coffeeDao = new CoffeeDAO();
	ArrayList<OwnerModel> ownerList = new ArrayList<OwnerModel>();
	ArrayList<TeaModel> teaList = new ArrayList<TeaModel>();
	ArrayList<StaffModel> staffList = new ArrayList<StaffModel>();
	public void addcoffeeToList(OwnerModel em) throws ClassNotFoundException {
		ownerList.add(em);
		coffeeDao.storeCoffeeRecordInDb(ownerList);
	}
	public void addteaToList(TeaModel em) throws ClassNotFoundException {
		teaList.add(em);
		coffeeDao.storeteaRecordInDb(teaList);
	}
	public void addstaffToList(StaffModel em) throws ClassNotFoundException {
		staffList.add(em);
		coffeeDao.storestaffRecordInDb(staffList);
	}

}