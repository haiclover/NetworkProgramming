/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haidv
 */
public class CharacterStream4 {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(1107);
            Socket s = ss.accept();
            
            BufferedWriter w = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            BufferedReader r = new BufferedReader(new InputStreamReader(s.getInputStream()));
            
            System.out.println(r.readLine());
            
            w.write("abd abc abf aaaabi  aa a a  - - -");
            w.newLine();
            w.flush();
            
            System.out.println(r.readLine());
            
            r.close();
            w.close();
            s.close();
            ss.close();
        } catch (IOException ex) {
            Logger.getLogger(CharacterStream4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
