package compositedecorator;

public class StaffDiscountDecorator extends ShopComponentDecorator{
	public StaffDiscountDecorator(ShopComponent decoratedSC) {
		super(decoratedSC);
	}
	
	public Double compPrice() {
		return super.compPrice()*0.5;
	}
	public String toString() {
		return super.toString()+" stuff enjoys 50% discount!";
	}
}
