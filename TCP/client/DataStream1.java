/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haidv
 */
public class DataStream1 {
    
    public static String solve(String str){
        
        String substr[] = str.split(";");
        String reqID = substr[0];
        
        int num[] = Arrays.stream(substr[1].split(",")).mapToInt(Integer::parseInt).toArray();
        
//        String number[] = substr[1].split(",");
//        int num[] = new int[number.length];
//        for(int i=0;i<number.length;i++){
//            num[i] = Integer.parseInt(number[i]);
//        }
        
        int max = 0,min = 9999999;
        for(int i=0;i<num.length;i++){
            max = Math.max(max, num[i]);
            min = Math.min(min, num[i]);
        }
        return reqID + ";" + max + "," + min;
    }
    
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",1107);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            out.writeUTF(";B17DCAT064");
            
            String rec = in.readUTF();
            System.out.println(solve(rec));
            
            out.close();
            in.close();
            socket.close();
            
        } catch (IOException ex) {
            Logger.getLogger(DataStream1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
