/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpproxyserver;

import java.io.IOException;

/**
 *
 * @author MD SHAKHAWAT HOSSAIN
 */
public class HTTPproxyServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        logBook singleton= new logBook();
        server HTTPproxy =new server(singleton);
        HTTPproxy.acceptRequest();
        
        // TODO code application logic here
    }
    
}
