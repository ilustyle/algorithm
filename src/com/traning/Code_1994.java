package com.traning;
import java.util.*;
import java.io.FileInputStream;
public class Code_1994 {

	/**
	 * @param args
	 * 
	 * 행복한 수
	 */
	static int N, Answer;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("src/data/code04.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
        boolean l_isStop = false;
        int l_inValue = 0;
        
        ArrayList<Integer> l_buffer = null;
        for(int i = N ; i>=0; i-- ) {
              l_buffer = new ArrayList<Integer>();
              l_inValue = i;
              while( !l_buffer.contains(l_inValue) ) {
                    l_buffer.add(l_inValue);                       
                    l_inValue = calculateValue(l_inValue);              
                    if( l_inValue == 1) {
                         System.out.println(i);
                         l_isStop = true;
                         break;
                    }
              }
              if( l_isStop )
                    break;
        }

	}
    public static int calculateValue(int p_value) {
          char[] l_value = String.valueOf(p_value).toCharArray();
          int l_sum = 0;
          for( char ch : l_value ) {
              l_sum += (int)Math.pow((double)(Integer.valueOf(ch)-48), 2.0); 
          }
          return l_sum;
    } 
}
