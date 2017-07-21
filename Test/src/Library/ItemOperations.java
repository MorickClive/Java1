package Library;

public interface ItemOperations {
	
	public void updateItem();
	public void updateLoan();
	
	
	// access Book
	public void updateItem(String title, String material, int price, String genre, boolean isHardback);
	// access Map
	public void updateItem(String title, String material, int price, String location, String language);
	// access Media
	public void updateItem(String title, String item_Type, String material, int price, String description);
	
}
