/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haidv
 */
public class DataStream1 {
    
    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(1107);
            Socket s = socket.accept();
            
            DataOutputStream output = new DataOutputStream(s.getOutputStream());
            DataInputStream input = new DataInputStream(s.getInputStream());
            
            String msv = input.readUTF();
            System.out.println(msv);
            
            output.writeUTF("1234;5,5,1,4,6,1,3");
            
            output.close();
            input.close();
            s.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(DataStream1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
