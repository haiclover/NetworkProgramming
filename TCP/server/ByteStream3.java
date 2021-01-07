/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haidv
 */
public class ByteStream3 {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(1107);
            Socket s = ss.accept();
            OutputStream out = s.getOutputStream();
            InputStream in = s.getInputStream();
            
            byte[] buf = new byte[1024];
            in.read(buf);
            String res = new String(buf).trim();
            System.out.println(res);
            
            
            out.write("123;4,5,3,7,3,8,1,9".getBytes());
            out.flush();
            
            
            
            in.close();
            out.close();
            s.close();
            ss.close();
        } catch (IOException ex) {
            Logger.getLogger(ByteStream3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
