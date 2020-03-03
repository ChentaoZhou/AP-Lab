package compositedecorator;

public class Test {
	public static void main(String[] args) {
		ShopComponent base = new ShopLeaf(100.0, "book1");
		System.out.println("This is "+base.toString()+" cost "+base.compPrice());
		
		ShopComponent student1 = new StudentDiscountDecorator(new ShopLeaf(100.0,"book1"));
		System.out.println("This is "+student1.toString()+" cost "+student1.compPrice());
		
		ShopComponent staff1 = new StaffDiscountDecorator(new ShopLeaf(100.0,"book1"));
		System.out.println("This is "+staff1.toString()+" cost "+staff1.compPrice());
		
		ShopComponent youngstaff = new StaffDiscountDecorator(new StudentDiscountDecorator(new ShopLeaf(100.0,"book1")));
		System.out.println("This is "+youngstaff.toString()+" cost "+youngstaff.compPrice());
	}
}
