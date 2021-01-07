/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haidv
 */
public class CharacterStream4 {
    public static String solve(String str){
        HashSet<String> hs  = new HashSet<String>();
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i) != ' '){
                hs.add(""+str.charAt(i));
            }
        }
        
        int max = Integer.MIN_VALUE;
        String a = "";
        for(String c : hs){
            int num;
//            if(Character.isAlphabetic(c.charAt(0))){
//                num = str.split(c).length - 1;
//            }else{
//                num = str.split("\\"+c).length - 1;
//            }     
            num = str.split(c).length - 1;
            if(num > max){
                max = num;
                a = c;
            }
            
        }
        String kq = a+";"+max; 





//        String done = "";
//        str = str.replace("\\s", "");
//        
//        int max = 0;
//        String maxChar = "";
//        
//        for(int i=0;i<str.length();i++){
//            int counter = 0;
//            if(done.indexOf(str.charAt(i)) != -1){
//                continue;
//            }
//            for(int j=0;j<str.length();j++){
//                if(str.charAt(i) == str.charAt(j)){
//                    counter++;
//                }
//            }
//            done += str.charAt(i);
//            if(counter > max){
//                maxChar = str.charAt(i) + "";
//                max = counter;
//            }
//        }
//        String kq = maxChar + ";" + max;
        return kq;
    }
    
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1",1107);
            
            BufferedWriter w = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            BufferedReader r = new BufferedReader(new InputStreamReader(s.getInputStream()));
            
            w.write(";B17DCAT064;123");
            w.newLine();
            w.flush();

            String sol = solve(r.readLine());
            w.write(sol);
            w.newLine();
            w.flush();
            
            r.close();
            w.close();
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(CharacterStream4.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
