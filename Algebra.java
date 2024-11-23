// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(-12,-3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x2 >= 0){ 
		    for (int i = 1; i <= x2; i++) {
			    x1++;
		    }
	    } else {
		    for (int i = -1; i >= x2; i--){ 
			    x1--;
		    }
		}	
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x2 >= 0){ 
		    for (int i = 1; i <= x2; i++) {
			    x1--;
		    }
		} else {
			for (int i = -1; i >= x2; i--) {
			    x1++;
			}	
		}	
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int res = 0;
		int result = 1;
		if (x2 > 0){
		    for (int i = 1; i <= x2; i++) {
			    res = plus(res, x1);
				result = res;
			}	
		} else if (x1 == 0 || x2 == 0) {
			result = 0;
		} else {
			for (int i = -1; i >= x2; i--) {
				res = plus(res, x1);
				result = -1 * res;
			}	
		}
		return result;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result = times(result, x);
		}
		if (x == 0) {
            result = 0;
		}	
		if (n == 0)	{
			result = 1;
		}
		return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int result = x1;
		int numberOfTimes = 0;
		if (x1 >= x2 &&  x2 > 0) {
		    for (int i = 1; result >= x2; i++) {
			    result = minus(result, x2);
		     	numberOfTimes = i;			
	    	}
		} else if (x1 >= x2 &&  x2 < 0) {
			for (int i = 1; result > 0; i++) {
			    result = plus(result, x2);
		     	numberOfTimes = -1 * i;
			}	
		} else if (x1 < 0 && x2 > 0) {
			for (int i = 1; result < 0; i++) {
			    result = plus(result, x2);
		     	numberOfTimes = -1 * i;
		    }
		} else if ( x1 < 0 && x2 < 0) {
			for (int i = 1; result < 0; i++) {
			    result = minus(result, x2);
		     	numberOfTimes = i;
		    }		
		} else if (x2 == 0) {
            numberOfTimes = -1;
		}
		return numberOfTimes;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int result = x1;
		for (int i = 1; result >= x2; i++) {
			result = minus(result, x2);	
		}
		return result;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int res = 0;
		int result = 0;
		for (int i = 1; res < x ; i++){
			res = times(i, i);
			result = i;
		}
		if (res > x) {
			result = minus(result, 1);
		}
		return result;
	}	  	  
}