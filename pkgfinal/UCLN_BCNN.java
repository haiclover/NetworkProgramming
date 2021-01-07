/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

/**
 *
 * @author haidv
 */
public class UCLN_BCNN {
    
    public static int UCLN(int a,int b){
        int tmp;
        while(b != 0){
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
    
    public static int BCNN(int a, int b){
        return (a*b) / UCLN(a,b);
    }
    
    public static void main(String[] args) {
        System.out.println(UCLN(15,9));
        System.out.println(BCNN(15,9));
    }
}
