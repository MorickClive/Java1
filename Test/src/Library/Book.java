package Library;

import java.util.ArrayList;

public class Book extends Item {
	
	String genre = null;
	boolean isHardback = false;

	public Book() {
		super();
	}
	public Book(String title, String material, String Genre, boolean isHardback) {
		super(title, "Book", material);
		this.genre = Genre;
		this.isHardback = isHardback;
	}
	public Book(String title, String material, String Genre, boolean isHardback, boolean isLoaned, int daysLoaned, int maxLoan) {
		super(title, "Book", material,isLoaned, daysLoaned, maxLoan);
		this.genre = Genre;
		this.isHardback = isHardback;
	}
	
	
	@Override
	public void updateItem(String title, String item_Type, String material, int price) {
		this.title = 		title != null ? 
							title : this.title;
		this.item_Type = 	item_Type != null ? 
							item_Type : this.item_Type;
		this.material = 	material != null ? 
							material : this.material;
		this.price = 		price != 0 ? 
							price : this.price;		
	}
	
	public void updateItem(String title, String material, int price, String genre, boolean isHardback) {
		updateItem(title, item_Type, material, price);
		this.genre = 			genre != null ? 
								genre : this.genre;	
		this.isHardback = 		isHardback;	
	}

	public void updateLoan(int daysLoaned) {
		this.setDaysLoaned(daysLoaned);
	}
	
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public boolean isHardback() {
		return isHardback;
	}
	public void setHardback(boolean isHardback) {
		this.isHardback = isHardback;
	}
	

	
	public String detailsBookFormated(){
		return 	detailsFormated() +
				"genre:" + getGenre() + "\n" +
				"hardBack:" + isHardback() + "\n";
	}
	
}
