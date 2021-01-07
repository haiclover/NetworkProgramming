/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author haidv
 */
public class DemSoLanXH {
    
    public static String counter(String str){
        int[] c = new int[200];
        
        String f = "";
        
        for(int i=0;i<c.length;i++){
            c[i] = 0;
        }
        
        for(int i=0; i<str.length(); i++){
            int num = str.charAt(i);
            c[num] += 1;
        }
        
        LinkedHashSet<String> setStr = new LinkedHashSet<>();
        for(int i=0;i<str.length();i++){
            setStr.add(str.charAt(i) + "");
        }
        System.out.println(setStr);
        String newStr = "";
        for(String s:setStr){
            newStr += s;
        }
        
        for(int i=0; i<newStr.length(); i++){
            int num = newStr.charAt(i);
            f += newStr.charAt(i);
            f += c[num];
        }
        return f;
    }
    
    public static void main(String[] args) {
        String test = "abcXyJh123aIqM33hsaB";
        System.out.println(counter(test));;
    }
}
