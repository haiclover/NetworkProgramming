/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.util.Arrays;

/**
 *
 * @author haidv
 */
public class SoThieu {
    
    public static String check(String s){
        String finalStr = "";
        String[] str = s.split(";");
        int len = Integer.parseInt(str[0]);
        int[] num = Arrays.stream(str[1].split(",")).mapToInt(Integer::parseInt).toArray();
        for(int i=1;i<=len;i++){
            int check = 0;
            for(int j=0;j<num.length;j++){
                if(num[j] == i){
                    check = 1;
                }
            }
            if(check == 0){
                finalStr += i + ",";
            }
        }
        return finalStr;
    }
        
    
    public static void main(String[] args) {
        System.out.println(check("10;2,3,5,6"));
    }
}
