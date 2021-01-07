/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP.client;

import TCP.server.Student;
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
    public static String normalize(String str){
        String[] s1 = str.split(" ");
        String finalStr = s1[0].substring(0,1).toUpperCase() + s1[0].substring(1).toLowerCase();
        for(int i=1;i<s1.length;i++){
            finalStr = finalStr + " " + s1[i].substring(0,1).toUpperCase() + s1[i].substring(1).toLowerCase();
        }
        return finalStr;
    }
    
    public static String convertEmail(String str){
        str = str.toLowerCase();
        String[] s1 = str.split(" ");
        String finalStr = s1[s1.length - 1];
        for(int i=0;i<s1.length-1;i++){
            finalStr += s1[i].substring(0,1);
        }
        return finalStr + "@ptit.edu.vn";
    }
    
    
    public static void send(byte[] out, Student933 student, DatagramSocket ds){
        try {
            
            InetAddress IP = InetAddress.getByName("127.0.0.1");
            int port = 1107;
            
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(student);
            out = bos.toByteArray();
            
            DatagramPacket dp = new DatagramPacket(out,out.length,IP,port);
            ds.send(dp);
        } catch (SocketException ex) {
            Logger.getLogger(UDP2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UDP2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static Student933 receive(byte[] in, DatagramSocket ds){
        Student933 student = null;
        try {
            DatagramPacket dp = new DatagramPacket(in, in.length);
            ds.receive(dp);
            ByteArrayInputStream bis = new ByteArrayInputStream(in);
            ObjectInputStream ois = new ObjectInputStream(bis);
            student = (Student933) ois.readObject();
        } catch (SocketException ex) {
            Logger.getLogger(UDP2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UDP2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UDP2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return student;
    }
    
    public static void main(String[] args) {
        try {
            byte[] in = new byte[65535];
            
            Student933 student = new Student933();
            student.setCode("B17DCAT064");
            
            byte[] out = new byte[65535];
            
            DatagramSocket ds = new DatagramSocket();
            send(out, student,ds);
            student = receive(in,ds);
            
            String normalizeStr = normalize(student.getName());
            student.setName(normalizeStr);
            String email = convertEmail(student.getName());
            student.setEmail(email);

            out = new byte[65535];
            send(out, student, ds);
        } catch (SocketException ex) {
            Logger.getLogger(UDP2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
