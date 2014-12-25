package dec24;

/**
 * @author Paul Qi
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. 
 * If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
 * You are responsible to gather all the input requirements up front.
 */

public class StringtoInteger7 {

	public static int atoi(String str) {
		int result = 0;
		boolean isPos = true;
		for(int i=0, j=0; i<str.length(); i++){
			if(j==0 && str.charAt(i) == '-'){
				isPos = false;
				j = 1;
			}
			else if(j==0 && str.charAt(i) == '+'){
				j = 1;
			}
			else if(j ==0 && str.charAt(i) == ' '){
				
			}
			else{
				//2147483648 overflow
				j = 1;
				switch(str.charAt(i)){
					case '0':	if(result>214748364)return isPos == true? Integer.MAX_VALUE:Integer.MIN_VALUE;
								result = result*10;break;
					case '1':	if(result>214748364)return isPos == true? Integer.MAX_VALUE:Integer.MIN_VALUE;
								result = result*10+1;break;
					case '2':	if(result>214748364)return isPos == true? Integer.MAX_VALUE:Integer.MIN_VALUE;
								result = result*10+2;break;
					case '3':	if(result>214748364)return isPos == true? Integer.MAX_VALUE:Integer.MIN_VALUE;
								result = result*10+3;break;
					case '4':	if(result>214748364)return isPos == true? Integer.MAX_VALUE:Integer.MIN_VALUE;
								result = result*10+4;break;
					case '5':	if(result>214748364)return isPos == true? Integer.MAX_VALUE:Integer.MIN_VALUE;
								result = result*10+5;break;
					case '6':	if(result>214748364)return isPos == true? Integer.MAX_VALUE:Integer.MIN_VALUE;
								result = result*10+6;break;
					case '7':	if(result>214748364)return isPos == true? Integer.MAX_VALUE:Integer.MIN_VALUE;
								result = result*10+7;break;
					case '8':	if(isPos && result >= 214748364) return Integer.MAX_VALUE;
								if(!isPos && result > 214748364) return Integer.MIN_VALUE;
								result = result*10+8;break;
					case '9':	if(result>=214748364)return isPos == true? Integer.MAX_VALUE:Integer.MIN_VALUE;
								result = result*10+9;break;
					default: return isPos == true? result:-result;
				}
			}
		}
		return isPos == true? result: -result;
	}
	
	public static void main(String[] args){
		System.out.println(atoi("     +004500"));
		System.out.println(atoi("  -0012a42"));
		System.out.println(atoi("   +0 123"));
		System.out.println(atoi("2147483648"));
	}
}
