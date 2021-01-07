/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI.client;

import RMI.IProduct;
import RMI.Product;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haidv
 */
public class RMIClient {
    public static void main(String[] args) {
        try {
            IProduct product = (IProduct) Naming.lookup("rmi://127.0.0.1:2345/Product");
            Product p = product.getProduct("B17DCAT064");
            System.out.println(p.getId());
            System.out.println(p.toString());
            
            float importPrice = 10.1f;
            float exportPrice = 10.2f;
            
            
            p.setImportPrice(importPrice);
            p.setExportPrice(exportPrice);
            
            boolean state = product.insertProduct(p);
            System.out.println(state);
            
        } catch (NotBoundException ex) {
            Logger.getLogger(RMIClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(RMIClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(RMIClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
