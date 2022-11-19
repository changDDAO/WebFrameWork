package chap4.ex1;
//Iterator
public class CalculatorImplDP implements Calculator{
	
	public long factorial(long n) {
		long res = 1;
	    if (n > 1) {
	        for (long i = 1; i <= n; i++) {
	            res = res * i;
	        }
	        return res;
	    }
	    else return res;
	    
	}
	
	public long fibo(long n) {
		if(n <= 1) {
			return n;
		}
		long cur = 1;
		long prev = 1;
		
		
		for(long i=2; i<n; i++) {
			
			long temp = cur;
			cur+= prev;
			prev = temp;
		}
		return cur;
		
	}
	
	
}
