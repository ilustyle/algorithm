package com.traning;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class tmp2 {

    static int TC, N;
    static int Div[];

    public static void main(String args[]) throws Exception{

         // System.setIn(new FileInputStream("src/jungol02/B_약수"));
          Scanner sc = new Scanner(System.in);

          TC = sc.nextInt();

          for (int testcase = 1; testcase <= TC; testcase++) {
              N = sc.nextInt();
              Div = new int[N];
              int aaa = N;
              //System.out.println(aaa);
              for (int i = 1; i <= N; i++) {
                  //System.out.println("i ==>"+i);
                if(aaa%i == 0){//System.out.println("i ==>"+i);
                   // Div[i] = i;
                	System.out.println(i);
                }
//                  else{
//                    Div[i] = 0;
//                }
            }
              //System.out.println("# "+testcase);
              for (int i = 1; i <= 24; i++) {
                 if(Div[i] !=0){
                      System.out.print(Div[i]+" ");
                  }
            }System.out.println();

          }


    }


}
