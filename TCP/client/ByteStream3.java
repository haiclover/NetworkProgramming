/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haidv
 */
public class ByteStream3 {

    public static String solve(String str){
        String[] s1 = str.split(";");
        int[] n = Arrays.stream(s1[1].split(",")).mapToInt(Integer::parseInt).toArray();
        
        
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i=0;i<n.length;i++){
            max = Math.max(max, n[i]);
            min = Math.min(min, n[i]);
        }
        
        return s1[0] + ";" + max + "," + min;
    }
    
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1", 1107);

            OutputStream out = s.getOutputStream();
            InputStream in = s.getInputStream();

            out.write(";B17DCAT064".getBytes());
            out.flush();

            byte[] buf = new byte[1024];
            in.read(buf);
            String res = new String(buf).trim();
            System.out.println(solve(res));
            
            in.close();
            out.close();
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(ByteStream3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
