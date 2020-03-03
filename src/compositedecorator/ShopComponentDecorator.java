package compositedecorator;

public abstract class ShopComponentDecorator extends ShopComponent{
	protected ShopComponent decoratedSC;
	
	public ShopComponentDecorator(ShopComponent decoratedSC) {
		this.decoratedSC = decoratedSC;
	}
	
	public Double compPrice() {
		return decoratedSC.compPrice();
	}
	public String toString() {
		return decoratedSC.toString();
	}
}
