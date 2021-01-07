/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haidv
 */
public class UDP1 {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(1107);
            
            byte[] in = new byte[65535];
            byte[] out = new byte[65535];
            
            
            while(true){
                DatagramPacket dp = new DatagramPacket(in, in.length);
                ds.receive(dp);
                InetAddress IP = dp.getAddress();
                int port = dp.getPort();
                System.out.println(new String(dp.getData(),0, dp.getLength()));
                
                out = "1234;4,6,7,2,8,2,9".getBytes();
                dp = new DatagramPacket(out, out.length, IP, port);
                ds.send(dp);
            }
            
        } catch (SocketException ex) {
            Logger.getLogger(UDP1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UDP1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
