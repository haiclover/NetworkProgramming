/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP.server;

import UDP.client.Student933;
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
public class UDP2 {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(1107);
            byte[] in = new byte[65535];
            byte[] out = new byte[65535];
            while(true){
                DatagramPacket dp = new DatagramPacket(in, in.length);
                ds.receive(dp);
                
                ByteArrayInputStream bis = new ByteArrayInputStream(in);
                ObjectInputStream ois = new ObjectInputStream(bis);
                Student933 student = (Student933) ois.readObject();
                System.out.println(student.getCode());
                student.setId("1909");
                student.setName("diNh viEt HaI");
                InetAddress IP = dp.getAddress();
                int port = dp.getPort();
                
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(bos);
                oos.writeObject(student);
                out = bos.toByteArray();
                
                dp = new DatagramPacket(out,out.length,IP,port);
                ds.send(dp);
                
                dp = new DatagramPacket(in, in.length);
                ds.receive(dp);
                bis = new ByteArrayInputStream(in);
                ois = new ObjectInputStream(bis);
                student = (Student933)ois.readObject();
                
                
                System.out.println(student.getEmail() + " " + student.getName());
                
                if(student.getEmail().equals("haidv@ptit.edu.vn") && student.getName().equals("Dinh Viet Hai")){
                    System.out.println("TRUE");
                }
                else{
                    System.out.println("FALSE");
                }
                
            }
            
        } catch (SocketException ex) {
            Logger.getLogger(UDP2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UDP2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UDP2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
