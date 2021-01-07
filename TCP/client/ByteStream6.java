/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haidv
 */
public class ByteStream6 {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1",1107); 
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            
            out.write(";B17DCAT064".getBytes());
            out.flush();
            
            byte[] buf = new byte[65535];
            in.read(buf);
            System.out.println(new String(buf).trim());
            
            out.close();
            in.close();
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(ByteStream6.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
