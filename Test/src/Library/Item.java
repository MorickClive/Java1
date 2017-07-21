package Library;

public abstract class Item {
	protected static int total_Items = 0;
	protected int ID = 0;

	protected String 	title = null, // this particular object is called
					item_Type = null, // this item is a typical example of (assigned through inheritance)
					material = null; // this particular object is considered (glass, paper, cardboard, gloss paper, etc)
	
	// loaned
	protected int			customer_ID = 0; // who is it loaned by
	protected boolean 	isLoaned = false; // is it in the library, or out?
	protected int 		daysLoaned = 0, // currently loaned time in days
						maxLoan = 15, // think in terms of days
						price = 0; // if this book is lost or under consideration for purchase, this would be the price.

	public Item() {
		total_Items++;
		
		ID = total_Items;
	}	
	public Item(String title, String item_Type, String material) {
		total_Items++;
		
		ID = total_Items;
		this.title = title;
		this.item_Type = item_Type;
		this.material = material;
	}
	public Item(String title, String item_Type, String material, boolean isLoaned, int daysLoaned, int maxLoan) {
		total_Items++;
		
		ID = total_Items;
		this.title = title;
		this.item_Type = item_Type;
		this.material = material;
		this.isLoaned = isLoaned;
		this.daysLoaned = daysLoaned;
		this.maxLoan = maxLoan;
	}
	
	////
	// Methods
	///
	
	// ID
	public int getID() {
		return ID;
	}
	
	// Title
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	// Item Type
	public void setItem_Type(String item_type) {
		item_Type = item_type;
	}

	public String getItem_Type() {
		return item_Type;
	}

	// Material
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	
	public boolean isLoaned() {
		return isLoaned;
	}
	public void setLoaned(boolean isLoaned) {
		this.isLoaned = isLoaned;
	}

	public int getDaysLoaned() {
		return daysLoaned;
	}
	
	public void setDaysLoaned(int daysLoaned) {
		this.daysLoaned = daysLoaned;
	}
	
	public int getMaxLoan() {
		return maxLoan;
	}
	
	public void setMaxLoan(int maxLoan) {
		this.maxLoan = maxLoan;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCustomer_ID() {
		return customer_ID;
	}
	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
	}
	
	////
	// Behaviours
	///

	public abstract void updateItem(String title, String item_Type, String material, int price);
	public abstract void updateLoan(int daysLoaned, int maxLoan);

}
