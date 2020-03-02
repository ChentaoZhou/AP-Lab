package threading;

import java.util.Scanner;
public class PrimeNum {
	
	public static boolean primeOrNot(int aNum){//A method to determine whether a number is prime or not.
		
		boolean isPrime = true;
		for(int i = 2; i < aNum; i++){
			if(aNum % i == 0){
				isPrime = false;
			}	
		}
		return isPrime;
	}
	
	public static void primeNums(int n){
		for(int i = 3; i<=n; i++){
			if(primeOrNot(i)){
				System.out.println(i);
			}
		}
		
	}
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.println("Please input a number, end by return.");
		int n = s.nextInt();
		s.nextLine();
		System.out.println("The prime numbers between 2 and " + n + " are:");
		primeNums(n);
	}
	

}
