/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haidv
 */
public class ByteStream2 {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(1108);
            Socket s = ss.accept();
            
            
            BufferedInputStream input = new BufferedInputStream(s.getInputStream());
            BufferedOutputStream output = new BufferedOutputStream(s.getOutputStream());
            
            
            int b;
            String str = "";
            
            while(input.available() > 0){
                System.out.print((char) input.read());
            }
            
            output.write("1234;3,6,3,5,2,3,7,4,9".getBytes());
            output.flush();
            
            output.close();
            input.close();
            s.close();
            ss.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
