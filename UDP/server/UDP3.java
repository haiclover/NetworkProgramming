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
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haidv
 */
public class UDP3 {
    
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(1107);
            
            byte[] in = new byte[65535];
            byte[] out = new byte[65535];
            DatagramPacket dp = new DatagramPacket(in, in.length);
            ds.receive(dp);
            System.out.println(new String(dp.getData(), 0, dp.getLength()));
            
            InetAddress IP = dp.getAddress();
            int port = dp.getPort();
            in = "198;diNh ViEt hAI".getBytes();
            dp = new DatagramPacket(in, in.length, IP, port);
            ds.send(dp);
            
            dp = new DatagramPacket(in, in.length);
            ds.receive(dp);
            System.out.println(new String(dp.getData(), 0, dp.getLength()));
            
        } catch (SocketException ex) {
            Logger.getLogger(UDP3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UDP3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
