package aNext.first;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

import aTool.TreeNode;

public class SerizeTree {
	
	public void serize(TreeNode root) throws Exception{
		BufferedWriter bw = null;
		try {
			File newFile = new File("temp");
			bw = new BufferedWriter(new FileWriter(newFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(root!=null){
			bw.write(root.val+" ");
			stack.push(root);
			root = root.left;
		}
		bw.write("# ");
		while(!stack.isEmpty()){
			TreeNode temp = stack.pop();
			temp = temp.right;
			while(temp!=null){
				bw.write(temp.val+" ");
				stack.push(temp);
				temp = temp.left;
			}
			bw.write("# ");
		}
//		bw.flush();
		bw.close();
	}
	
	public TreeNode deserize(String fileName) throws Exception{
		BufferedReader fr = new BufferedReader(new FileReader(fileName));
		String line = fr.readLine();
		String[] lines = line.split(" ");
		int index = 0;
		if(lines[index].equals("#")){
			fr.close();
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(lines[index++]));
		TreeNode current = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		fr.read();
		while(!lines[index].equals("#")){
			current.left = new TreeNode(Integer.parseInt(lines[index++]));
			stack.push(current.left);
			current = current.left;
		}
		index++;
		current.left = null;
		
		while(!stack.isEmpty()){
			TreeNode temp = stack.pop();
			if(lines[index].equals("#")){
				index++;
				temp.right = null;
			}
			else{
				temp.right = new TreeNode(Integer.parseInt(lines[index++]));
				stack.push(temp.right);
				temp = temp.right;
				while(!lines[index].equals("#")){
					temp.left = new TreeNode(Integer.parseInt(lines[index++]));
					stack.push(temp.left);
					temp = temp.left;
				}
				index++;
				temp.left = null;
			}
		}
		fr.close();
		return root;
	}
	
	public String serizeRecursive(TreeNode root){
		if(root==null){
			return "# ";
		}
		else{
			String s = root.val+" ";
			return s+serizeRecursive(root.left)+serizeRecursive(root.right);
		}
	}
	
	private int strIndex = 0;
	public TreeNode deserizeRecursive(String[] str){
		if(str[strIndex].equals("#")){
			strIndex++;
			return null;
		}
		else{
			TreeNode root = new TreeNode(Integer.parseInt(str[strIndex]));
			strIndex++;
			root.left = deserizeRecursive(str);
			root.right = deserizeRecursive(str);
			return root;
		}
	}
	
	public static void main(String[] args) throws Exception{
    	TreeNode n1 = new TreeNode(30);
    	TreeNode n2 = new TreeNode(10);
    	TreeNode n3 = new TreeNode(20);
    	TreeNode n4 = new TreeNode(50);
    	TreeNode n5 = new TreeNode(45);
    	TreeNode n6 = new TreeNode(35);
    	n1.left = n2; n1.right = n3; n2.left = n4; n3.left = n5; n3.right = n6;
    	
    	SerizeTree test = new SerizeTree();
//    	test.serize(n1);
//    	test.deserize("temp");
//    	System.out.println(test.serizeRecursive(n1));
    	String[] s = test.serizeRecursive(n1).split(" ");
    	TreeNode root = test.deserizeRecursive(s);
    	System.out.println(root.val);
	}
}
