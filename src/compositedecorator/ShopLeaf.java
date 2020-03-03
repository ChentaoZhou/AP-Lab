package compositedecorator;
public class ShopLeaf extends ShopComponent {
	protected Double basePrice;
	
	protected String name;
	// Constructor - set the properties of the item
	public ShopLeaf(Double base,String n) {
		basePrice = base;
		name = n;
	}
	
	public Double compPrice() {
			return basePrice;
		
	}
	
	public String toString() {
		return name;
	}

}