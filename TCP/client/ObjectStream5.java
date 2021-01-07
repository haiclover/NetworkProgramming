/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP.client;

import TCP.server.Student;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haidv
 */
public class ObjectStream5 {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1",1107);
            
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            
            out.writeObject((String)"B17DCAT064;913");
            out.flush();
            
            Student st = (Student) in.readObject();
            
            float gpa = st.getGpa();
            String gpaLetter = "";
            if(gpa == 2.51f){
                gpaLetter = "C";
            }
            st.setGpaLetter(gpaLetter);
            
            out.writeObject(st);
            out.flush();
            
            in.close();
            out.close();
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(ObjectStream5.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObjectStream5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
