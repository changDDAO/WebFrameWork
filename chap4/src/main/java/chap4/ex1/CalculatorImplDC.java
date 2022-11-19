package chap4.ex1;

public class CalculatorImplDC implements Calculator{
	//recursion
public long factorial(long n) {
	if(n<=1) {
		return 1;
	}
	else {
		return n * factorial(n-1);
	}
	
}
	
	public long fibo(long n) {
		
		if(n <= 1) {
			return n;
		}
		return fibo(n-1) + fibo(n-2);
	
	}

}
