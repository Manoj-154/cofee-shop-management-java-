package model;

public class OwnerModel {
	private String coffeeCode;
	private String coffeeName;
	
	
	public OwnerModel(String coffeeCode, String coffeeName)
	{
		
		super();
		this.coffeeCode = coffeeCode;
		this.coffeeName = coffeeName;
	}
	
	public OwnerModel() {
		super();
	}
	public String getcoffeeCode() {
		return coffeeCode;
	}
	public void setcoffeeCode(String coffeeCode) {
		this.coffeeCode = coffeeCode;
	}
	public String getCoffeeName() {
		return coffeeName;
	}
	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}
	
}
