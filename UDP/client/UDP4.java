/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
public class UDP4 {
    
    public static void send(DatagramSocket ds, byte[] out, SinhVien933 sinhvien){
        try {
            InetAddress IP = InetAddress.getByName("127.0.0.1");
            int port = 1107;
            
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(sinhvien);
            out = bos.toByteArray();
                    
            DatagramPacket dp = new DatagramPacket(out, out.length, IP, port);
            ds.send(dp);
        } catch (UnknownHostException ex) {
            Logger.getLogger(UDP4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UDP4.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static SinhVien933 receive(DatagramSocket ds, byte[] in){
        try {
            SinhVien933 sinhvien = new SinhVien933();
            DatagramPacket dp = new DatagramPacket(in, in.length);
            ds.receive(dp);
            ByteArrayInputStream bis = new ByteArrayInputStream(in);
            ObjectInputStream dis = new ObjectInputStream(bis);
            
            return (SinhVien933) dis.readObject();
        } catch (IOException ex) {
            Logger.getLogger(UDP4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UDP4.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static SinhVien933 solve(SinhVien933 sv){
        String name = sv.getName();
        String[] s1 = name.split(" ");
        String finalName = s1[0].substring(0,1).toUpperCase() + s1[0].substring(1).toLowerCase();
        for(int i=1;i<s1.length;i++){
            finalName = finalName + " " + s1[i].substring(0,1).toUpperCase() + s1[i].substring(1).toLowerCase();
        }
        sv.setName(finalName);
        
        String finalEmail = s1[s1.length - 1];
        for(int i=0;i<s1.length-1;i++){
            finalEmail = finalEmail + s1[i].substring(0,1);
        }
        finalEmail += "@ptit.edu.vn";
        sv.setEmail(finalEmail);
        return sv;
    }
    
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket();
            byte[] in = new byte[65535];
            byte[] out = new byte[65535];
            
            SinhVien933 sv = new SinhVien933();
            sv.setCode("B17DCAT064");
            send(ds, out, sv);
            
            sv = receive(ds, in);
            
            send(ds, out, solve(sv));
            
        } catch (SocketException ex) {
            Logger.getLogger(UDP4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
