package Library;

import java.util.ArrayList;

public class Media extends Item{
	String 	description = null;
	
	public Media() {
		super();
	}
	public Media(String title, String material, String description) {
		super(title, "Media", material);
		this.description = description;
	}
	public Media(String title, String material, String description, boolean isLoaned, int daysLoaned, int maxLoan) {
		super(title, "Media", material, isLoaned, daysLoaned, maxLoan);
		this.description = description;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public void updateItem(String title, String item_Type, String material, int price, String description) {
		// TODO Auto-generated method stub
		updateItem(title, item_Type, material, price);
		this.description =  	description != null ? 
								description : this.description;;
	}
	@Override
	public void updateLoan(int daysLoaned) {
		this.setDaysLoaned(daysLoaned);
	}

	
}
