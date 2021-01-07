/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

/**
 *
 * @author haidv
 */
public class KiTuXHNhieuNhat {
    public static String solve(String str){
        String finalStr = "";
        
        String done = ""; //Chuoi luu ki tu da duyet
        char maxChar = str.charAt(0);
        int max = 0;
        
        for(int i=0;i<str.length();i++){
            int count = 0;
            if(done.indexOf(str.charAt(i)) != -1){
                continue;
            }
            for(int j=0;j<str.length();j++){
                if(str.charAt(i) == str.charAt(j)){
                    count++;
                }
            }
            done += str.charAt(i);
            if(count > max){
                max = count;
                maxChar = str.charAt(i);
            }
        }
        System.out.println(done);
        
        finalStr += maxChar + ";";
        
        char[] charArr = str.toCharArray();
        for(int i=0;i<charArr.length;i++){
            if(charArr[i] == maxChar){
                finalStr += i + ",";
            }
        }
             
        return finalStr;
//        return maxChar + " " + max;
    }
    
    public static void main(String[] args) {
        System.out.println(solve("aBcD123aCa9"));
    }
}
