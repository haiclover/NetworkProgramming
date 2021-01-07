/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP.server;

import UDP.client.SinhVien933;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
public class UDP4 {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(1107);
            byte[] in = new byte[65535];
            byte[] out = new byte[65535];
            
            DatagramPacket dp = new DatagramPacket(in, in.length);
            ds.receive(dp);
            ByteArrayInputStream bis = new ByteArrayInputStream(in);
            ObjectInputStream ois = new ObjectInputStream(bis);
            SinhVien933 sv = (SinhVien933) ois.readObject();
            System.out.println(sv.getCode());
            
            sv.setId("1909");
            sv.setName("dinh viet hai");
            InetAddress IP = dp.getAddress();
            int port = dp.getPort();
            
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(sv);
            out = bos.toByteArray();
            dp = new DatagramPacket(out, out.length, IP, port);
            ds.send(dp);
            
            dp = new DatagramPacket(in, in.length);
            ds.receive(dp);
            bis = new ByteArrayInputStream(in);
            ois = new ObjectInputStream(bis);
            sv = (SinhVien933) ois.readObject();
            System.out.println(sv.getName() + " " + sv.getEmail());
            
            
        } catch (SocketException ex) {
            Logger.getLogger(UDP4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UDP4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UDP4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
