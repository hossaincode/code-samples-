/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpproxyserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author MD SHAKHAWAT HOSSAIN
 */
public class server {
    ServerSocket defaultProxySocket=null;
    Socket newlyReturned =null;
    Boolean Active=true;
    logBook serverLog=null;
    server( logBook log) throws IOException
    {
        serverLog=log;
        defaultProxySocket = new ServerSocket (9999);
        System.out.println ("Proxy Server Waiting for client on port 9999");
    }
    public void acceptRequest() throws IOException
    {
        while(Active)
        {
            newlyReturned=defaultProxySocket.accept();
             Thread conn=new Thread(new processOneconnection(newlyReturned,serverLog));
             conn.start();
            
            
            
            
        
        
        
        }
        
    }
    
}
