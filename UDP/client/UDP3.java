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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haidv
 */
public class UDP3 {
    
    public static void send(DatagramSocket ds, byte[] out, String data){
        try {
            InetAddress IP = InetAddress.getByName("127.0.0.1");
            int port = 1107;
            
            out = data.getBytes();
            
            DatagramPacket dp = new DatagramPacket(out, out.length, IP, port);
            ds.send(dp);
        } catch (IOException ex) {
            Logger.getLogger(UDP3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String receive(DatagramSocket ds, byte[] in){
        try {
            DatagramPacket dp = new DatagramPacket(in, in.length);
            ds.receive(dp);
            return new String(dp.getData(), 0, dp.getLength());
        } catch (IOException ex) {
            Logger.getLogger(UDP3.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static String solve(String str){
        String[] s1 = str.split(";");
        String[] s2 = s1[1].split(" ");
        String finalStr = s2[0].substring(0,1).toUpperCase() + s2[0].substring(1).toLowerCase();
        for(int i=1;i<s2.length;i++){
            finalStr = finalStr + " " + s2[i].substring(0,1).toUpperCase() + s2[i].substring(1).toLowerCase();
        }
        return finalStr;
    }
    
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket();
            byte[] in = new byte[65535];
            byte[] out = new byte[65535];
            send(ds, out, ";B17DCAT064;912");
            
            String data = receive(ds, in);
            send(ds, out, solve(data));
            
        } catch (SocketException ex) {
            Logger.getLogger(UDP3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
