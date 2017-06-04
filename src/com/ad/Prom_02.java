package com.ad;

import java.util.*;
import java.io.FileInputStream;

public class Prom_02 {

	/**
	 * @param args
	 * 계산기 - 기출
	 */
	static int N, M, Answer;
	static char stack[];
	static int top;
	static int a[];
	static double res;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/prom02"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 0; tc < T; tc++) {
			/////////////////////////////////////////////
			String s = sc.next();
			
			List<String> list = new ArrayList<String>();
			String tmp = "";
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i) != '(' && s.charAt(i) != ')'  && s.charAt(i) != '+'  && s.charAt(i) != '-'  && s.charAt(i) != '*'  && s.charAt(i) != '/') {
					tmp += s.charAt(i);
					if(i == s.length() -1) {
						list.add(tmp);
					}
				} else {
					if(!tmp.equals("")) {
						list.add(tmp);
					}
					list.add(s.charAt(i) + "");
					tmp = "";
				}
			}
			for (int i = list.size()-1; i >= 0; i--) {
				if(list.get(i).equals("(")) {
					
					double a = Double.parseDouble(list.get(i+1));
					String b = list.get(i+2);
					double c = Double.parseDouble(list.get(i+3));
					double r = calc(a, b, c);
					list.remove(i+1);
					list.remove(i+1);
					list.remove(i+1);
					list.add(i+1, r + "");
					if (list.get(i+2).equals(")")) {
						list.remove(i);
						list.remove(i+1);
					} else{
						i++;
					}
					
				}
				//System.out.println(list);
			}
			
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list);
				double a = Double.parseDouble(list.get(i));
				String b = list.get(i+1);
				double c = Double.parseDouble(list.get(i+2));
				double r = calc(a, b, c);
				list.remove(i);
				list.remove(i);
				list.remove(i);
				list.add(i, r + "");
				i--;
				if(list.size() == 1) {
					res = Math.floor(Double.parseDouble(list.get(0)));
					break;
				}
				System.out.println(res);
			}
			
			System.out.println("#" + tc + " " +  Answer);
			/////////////////////////////////////////////
		} // end of testCase

	} // end of main
	public static double calc(double a, String b, double c) {
		if(b.equals("+")) {
			res = a + c;
		}
		if(b.equals("-")) {
			res = a - c;
		}
		if(b.equals("*")) {
			res = a * c;
		}
		if(b.equals("/")) {
			res = a / c;
		}
		return res;
	}
}
