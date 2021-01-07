/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.io.Serializable;

/**
 *
 * @author haidv
 */
public class Product implements Serializable{
    private int id;
    private String code;
    private String name;
    private float importPrice;
    private float exportPrice;
    private String createdUser;
    private static final long serialVersionUID = 20151107;

    public Product() {
    }

    public Product(int id, String code, String name, float importPrice, float exportPrice, String createdUser) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.createdUser = createdUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", code=" + code + ", name=" + name + ", importPrice=" + importPrice + ", exportPrice=" + exportPrice + ", createdUser=" + createdUser + '}';
    }
    
    
}
