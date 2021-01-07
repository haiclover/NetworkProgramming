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
public class ChuInHoaDauTien {
    public static String solve(String str){
        str = str.toLowerCase();
        String[] strArr = null;
        String f = "";
        
        for(int i=0;i<str.length();i++){
            strArr = str.split("\\s");
        }
        
        for(int i=0;i<strArr.length;i++){
            char first = Character.toUpperCase(strArr[i].charAt(0));
            String second = strArr[i].substring(1);
            if(i != strArr.length - 1){
                f += first + second + " ";
            }
            else{
                f += first + second;
            }
        }
        
        return f;
        
        
    }
    
    public static void main(String[] args) {
        String test = "dinH viEt hAi";
        System.out.println(solve(test));
    }
}
