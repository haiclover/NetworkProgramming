/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haidv
 */
public class ObjectStream5 {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            ServerSocket ss = new ServerSocket(1107);
            
            Student student = new Student(913,"B17DCAT064",2.51f,"");
            while(true){
                Socket s = ss.accept();
                ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(s.getInputStream());

                String res = (String) in.readObject();
                System.out.println(res);

                out.writeObject(student);
                out.flush();
                
                student = (Student) in.readObject();
                System.out.println(student);
                
                in.close();
                out.close();
                s.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ObjectStream5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
