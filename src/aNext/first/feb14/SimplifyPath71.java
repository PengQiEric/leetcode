package aNext.first.feb14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author PAUL QI
 *
 * Given an absolute path for a file (Unix-style), simplify it.

	For example,
	path = "/home/", => "/home"
	path = "/a/./b/../../c/", => "/c"
	click to show corner cases.
	
	Corner Cases:
	Did you consider the case where path = "/../"?
	In this case, you should return "/".
	Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
	In this case, you should ignore redundant slashes and return "/home/foo".
 */

public class SimplifyPath71 {
	// also we can solve this problem using in-place. Change the string to char array
	
	// using the method split.
    public String simplifyPath(String path) {
        String[] str = path.split("/+");
        Stack<String> stack = new Stack<String>();
        for(int i=0; i<str.length; i++){
            if(str[i].equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }
            else if(!str[i].equals(".") && !str[i].equals("")){
                stack.push(str[i]);
            }
        }
        List<String> temp = new ArrayList<String>();
        while(!stack.isEmpty()){
            temp.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        if(path.length()>0 && path.charAt(0) == '/'){
            sb.append("/");
        }
        for(int i=temp.size()-1; i>=0; i--){
            if(i == 0){
                sb.append(temp.get(i));
            }
            else{
                sb.append(temp.get(i)+"/");
            }
        }
        return sb.toString();
    }
    
	// a lot of details needing considering
    public String simplifyPath_trival(String path) {
    	boolean root = false;
        LinkedList<String> stack = new LinkedList<String>();
        int begin = 0;
        for(int i=0; i<path.length();){
            if(i == 0 && path.charAt(i) == '/'){
            	root = true;
                begin = 1;
                i++;
                while(i<path.length() && path.charAt(i) == '/'){
                    i++;
                    begin++;
                }
            }
            else if(path.charAt(i) == '/'){
                String s = path.substring(begin,i);
                if(s.equals("..")){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                }
                else if(!s.equals(".")){
                    stack.push(s);
                }
                begin = i+1;
                i++;
                while(i<path.length() && path.charAt(i) == '/'){
                    i++;
                    begin++;
                }
            }
            else if( i == path.length()-1){
            	String s = path.substring(begin);
                if(s.equals("..")){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                }
                else if(!s.equals(".")){
                    stack.push(s);
                }
                i++;
            }
            else{
            	i++;
            }
        }
        String str = "";
        while(!stack.isEmpty()){
        	str = stack.pop()+"/"+str;
        }
        if(root){
        	str = "/"+str;
        }
        return str.length()<=1? str: str.substring(0,str.length()-1);
    }
    
    public static void main(String[] args){
    	SimplifyPath71 test = new SimplifyPath71();
//    	System.out.println(test.simplifyPath("/..."));
//    	System.out.println(test.simplifyPath("/."));
//    	System.out.println(test.simplifyPath("/./"));
    	System.out.println(test.simplifyPath("/abc/..."));
    	
    	String[] str = "///abcs///das//asdas".split("/+");
    	System.out.println(str);
    }
}
