package model;

public class TeaModel {
	private String cfid;
	private String coffeename;
	private int cost;
	private String description;
	private String coffeeid;
	public TeaModel(String cfid, String coffeename, int cost, String description,String coffeeid) {
		super();
		this.cfid = cfid;
		this.coffeename = coffeename;
		this.cost = cost;
		this.description = description;
		this.coffeeid=coffeeid;
	}
	public TeaModel() {
		super();
	}
	public String getCfid() {
		return cfid;
	}
	public void setCfid(String cfid) {
		this.cfid= cfid;
	}
	public String getCoffeename() {
		return coffeename;
	}
	public void setCoffeename(String coffeename) {
		this.coffeename = coffeename;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost= cost;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCoffeeid() {
		return coffeeid;
	}
	public void setCoffeeid(String coffeeid) {
		this.coffeeid = coffeeid;
	}
	
	
}


