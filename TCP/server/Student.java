/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP.server;

import java.io.Serializable;

/**
 *
 * @author haidv
 */
public class Student implements Serializable{
    private int id;
    private String code;
    private float gpa;
    private String gpaLetter;
    
    private static final long serialVersionUID = 20151107;

    public Student() {
    }

    public Student(int id, String code, float gpa, String gpaLetter) {
        this.id = id;
        this.code = code;
        this.gpa = gpa;
        this.gpaLetter = gpaLetter;
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

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getGpaLetter() {
        return gpaLetter;
    }

    public void setGpaLetter(String gpaLetter) {
        this.gpaLetter = gpaLetter;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", code=" + code + ", gpa=" + gpa + ", gpaLetter=" + gpaLetter + '}';
    }
    
    
    
}
