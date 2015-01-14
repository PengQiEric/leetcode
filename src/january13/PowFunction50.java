package january13;

/**
 * @author Paul Qi 
 * Implement pow(x, n).
 */

public class PowFunction50 {

	public double pow(double x, int n) {
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return x;
		} else if (n == -1) {
			return 1 / x;
		} else {
//			return pow(x, n / 2) * pow(x, n - n / 2);
			double result = pow(x,n/2);
			if(n%2 != 0){  // +1 or -1
				if(n>0){
					return result*result*x;
				}
				else{
					return result*result/x;
				}
			}
			else{
				return result*result;
			}
		}
	}

	public static void main(String[] args) {
		PowFunction50 test = new PowFunction50();
//		System.out.println(-3/2);
		System.out.println(test.pow(2, 3));
		System.out.println(test.pow(34.00515, -3));
		System.out.println(1/34.00515/34.00515/34.00515);
	}
}
