
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 계산기 {

	static double result;
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		int inputLen = input.length();
		
		String temp = "";
		List<String> inputList = new ArrayList<String>();
		
		for(int i = 0; i < inputLen; i++) {
			
			if(input.charAt(i)!='(' && input.charAt(i)!=')' && input.charAt(i)!='+' && input.charAt(i)!='-' && input.charAt(i)!='*' && input.charAt(i)!='/') {
				temp = temp + input.charAt(i);
				
				if(i == inputLen - 1) {
					inputList.add(temp);
				}
			}
			else {
				if(!temp.equals("")) {
					inputList.add(temp);
				}
				inputList.add(input.charAt(i)+"");
				temp = "";
			}
			System.out.println(inputList);
		}
		
//		for(int i = inputList.size()-1; i >= 0; i--){
//			
//			if(inputList.get(i).equals("(")){
//				double a = Double.parseDouble(inputList.get(i+1));
//				String b = inputList.get(i+2);
//				double c = Double.parseDouble(inputList.get(i+3));
//				
//				double r = cal(a, b, c);
//				inputList.remove(i+1);
//				inputList.remove(i+1);
//				inputList.remove(i+1);
//				inputList.add(i+1, r+"");
//				
//				if(inputList.get(i+2).equals(")")){
//					inputList.remove(i);
//					inputList.remove(i+1);
//				}
//				else{
//					i++;
//				}
//				System.out.println(inputList);
//			}
//			//System.out.println(inputList);
//		}
//		
		for(int i = 0; i < inputList.size(); i++){
			System.out.println(inputList);
			double a = Double.parseDouble(inputList.get(i));
			String b = inputList.get(i+1);
			double c = Double.parseDouble(inputList.get(i+2));
			
			double r = cal(a, b, c);
			inputList.remove(i);
			inputList.remove(i);
			inputList.remove(i);
			inputList.add(i, r+"");
			
			i--;
			
			if(inputList.size() == 1){
				result = Math.floor(Double.parseDouble(inputList.get(0)));
				break;
			}
		}		
//		
//		
//		System.out.println((int)result);
	}
	
	public static double cal(double a, String b, double c){
		
		if(b.equals("+")){
			result = a + c;
		}
		else if(b.equals("-")){
			result = a - c;
		}
		if(b.equals("*")){
			result = a * c;
		}
		if(b.equals("/")){
			result = a / c;
		}
		
		return result;
	}
}
/*

1+(2*(2+1+3))+1

1+(2*2*3)+1

1-4/2

3/2

*/
