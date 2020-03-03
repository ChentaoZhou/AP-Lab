package compositedecorator;

public class StudentDiscountDecorator extends ShopComponentDecorator{
	
	
	public StudentDiscountDecorator(ShopComponent decoratedSC) {
		super(decoratedSC);
	}
	
	public Double compPrice() {
		return super.compPrice()*0.9;
	}
	public String toString() {
		return super.toString()+" Student enjoys 10% dicount!";
	}
	
}
