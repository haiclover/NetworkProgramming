/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haidv
 */
public class UDP1 {
    public static String solve(String str){
        String[] newStr = str.split(";");
        int[] num = Arrays.stream(newStr[1].split(",")).mapToInt(Integer::parseInt).toArray();
        
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i=0;i<num.length;i++){
            max = Math.max(max, num[i]);
            min = Math.min(min, num[i]);
        }
        
        return newStr[0] + ";" + max + "," + min;
    }
    
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket();
            
            byte[] in = new byte[65535];
            byte[] out = new byte[65535];
            
            InetAddress IP = InetAddress.getByName("192.168.75.102");
            int port = 1107;
            
            out = "B17DCAT064;1109".getBytes();
            
            DatagramPacket dp = new DatagramPacket(out, out.length, IP, port);
            ds.send(dp);
            
            dp = new DatagramPacket(in, in.length);
            ds.receive(dp);
            
            String res = new String(dp.getData(),0,dp.getLength());
            System.out.println(res);
            
            out = solve(res).getBytes();
            dp = new DatagramPacket(out, out.length, IP, port);
            ds.send(dp);
            
            ds.close();
        } catch (SocketException ex) {
            Logger.getLogger(UDP1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(UDP1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UDP1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
