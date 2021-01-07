/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author haidv
 */
public class ProductImpl extends UnicastRemoteObject implements IProduct{

    public ProductImpl() throws RemoteException{
        
    }
    
    @Override
    public Product getProduct(String code) throws RemoteException {
        return new Product(2333, code, "hhhhhhhhh", (float) 50.5, (float) 70.0, "true");
    }

    @Override
    public boolean insertProduct(Product product) throws RemoteException {
        if (product.getName().length() <= 8 || product.getName().length() >= 20 || product.getExportPrice() < product.getImportPrice()){
            return false;
        }
        return true;
    }    
}