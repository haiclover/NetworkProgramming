/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

/**
 *
 * @author haidv
 */
public class ByteStream2 {
    public static String solve(String str){
        String[] s1 = str.split(";");
        int[] s2 = Arrays.stream(s1[1].split(",")).mapToInt(Integer::parseInt).toArray();
        
        int max = 0, min = 9999999;
        for(int i=0;i<s2.length;i++){
            max = Math.max(max, s2[i]);
            min = Math.min(min, s2[i]);
        }
        
        return s1[0] + ";" + max + "," + min;
    }
    
    public static void main(String[] args) throws IOException {
        try{
            Socket s = new Socket("localhost",1108);
            
            BufferedOutputStream out = new BufferedOutputStream(s.getOutputStream());
            BufferedInputStream in = new BufferedInputStream(s.getInputStream());

            out.write(";B17DCAT064".getBytes());
            out.flush();

            String res = "";
            int b;
            while((b = in.read()) != -1){
                res += (char) b;
            }  

            System.out.println(solve(res));

            in.close();
            out.close();
            s.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
