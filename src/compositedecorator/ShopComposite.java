package compositedecorator;
import java.util.ArrayList;
public class ShopComposite extends ShopComponent {
	private ArrayList<ShopComponent> children;
	private String name;
	
	public ShopComposite(String n) {
		children = new ArrayList<ShopComponent>();
		name = n;
	}

	public Double compPrice() {
		Double price = 0.0;
		for(ShopComponent a: children) {
			price += a.compPrice();
		}
		return price;
	}
	
	public void add(ShopComponent a) {
		children.add(a);
	}
	public void remove(ShopComponent a) {
		children.remove(a);
	}

	public String toString() {
		String totalString = name;
		totalString += " {";
		for(ShopComponent a: children) {
			totalString += a + ",";
		}
		totalString += "}";
		return totalString;
	}

}