package aNext.first.feb20;

public class ValidNumber65 {
	
	// this needs to use RE or build a DFA by ourselves
	//   return s.matches("^\\s*[+-]?(\\d+|\\d*\\.\\d+|\\d+\\.\\d*)([eE][+-]?\\d+)?\\s*$");  
	// http://n00tc0d3r.blogspot.com/2013/06/valid-number.html

    public boolean isNumber(String s) {
        boolean hasE = false;
        boolean hasDot = false;
        int i =0;
        while(i<s.length() && s.charAt(i)==' '){
            i++;
        }
        
        if(s.length() == 1 && isDigit(s.charAt(i))){
            return true;
        }
        
        // first digit
        if(i<s.length() && (s.charAt(i)<49 || s.charAt(i)>57)){
            return false;
        } 
        i++;
        while(i<s.length()){
            char c = s.charAt(i);
            if(isDigit(c)){
                i++;
            }
            else if(c == '.' && !hasDot && !hasE){
                if(i+1<s.length()){
                    char temp = s.charAt(i+1);
                    if(!isDigit(temp)){
                        return false;
                    }
                    i += 2;
                }
                else{
                    return false;
                }
                hasDot = true;
            }
            else if((c == 'E' || c == 'e') && !hasE){
                if(i+1<s.length()){
                    char temp = s.charAt(i+1);
                    if(temp<49 || temp>57){
                        return false;
                    }
                    i += 2;
                }
                else{
                    return false;
                }
                hasE = true;
            }
            else{
                return false;
            }
        }
        return true;
    }
    
    private boolean isDigit(char c){
        return c>=48 && c<=57;
    }
    
    public static void main(String[] args){
    	ValidNumber65 test = new ValidNumber65();
    	System.out.println(test.isNumber("0"));
    }
}
