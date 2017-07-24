package Library;

import java.util.ArrayList;

public class Map extends Item{

	String 	location = null, 
			language = null;
	
	public Map() {
		super();
	}
	public Map(String title, String material, String location, String language) {
		super(title, "Map", material);
		this.location = location;
		this.language = language;
	}
	public Map(String title, String material, String location, String language, boolean isLoaned, int daysLoaned, int maxLoan) {
		super(title, "Map", material,isLoaned, daysLoaned, maxLoan);
		this.location = location;
		this.language = language;
	}
	
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public void updateItem(String title, String item_Type, String material, int price) {
		// TODO Auto-generated method stub
		this.title = 		title != null ? 
							title : this.title;
		this.item_Type = 	item_Type != null ? 
							item_Type : this.item_Type;
		this.material = 	material != null ? 
							material : this.material;
		this.price = 		price != 0 ? 
							price : this.price;			
	}
	public void updateItem(String title, String material, int price, String location, String language) {
		// TODO Auto-generated method stub
		updateItem(title, "Map", material, price);
		this.location = 	location != null ? 
							location : this.location;
		this.language = 	language != null ? 
							language : this.language;
	}
	@Override
	public void updateLoan(int daysLoaned) {
		this.setDaysLoaned(daysLoaned);
	}	

	
}
