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
public class ByteStream6 {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(1107);
            Socket s = ss.accept();

            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            
            byte[] buf = new byte[65535];
            in.read(buf);
            System.out.println(new String(buf).trim());
            
            out.write("234;2,5,6,68,2,8".getBytes());
            out.flush();

            out.close();
            in.close();
            s.close();
            ss.close();
        } catch (IOException ex) {
            Logger.getLogger(ByteStream6.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
