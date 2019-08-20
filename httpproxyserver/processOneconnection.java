/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpproxyserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MD SHAKHAWAT HOSSAIN
 */
public class processOneconnection  implements Runnable{
    Socket connection=null;
    BufferedReader inFromClient = null; // request from the client (browser)
    DataOutputStream outToClient = null;
    logBook serverLogger=null;
    String headerLine=null;
    String printfull=null;
    StringTokenizer tokenizer=null;
    String httpMethod=null;
    String httpQueryString=null;
    String port=null;
    String attachwithGet=null;
    Socket socketforRealserver =null; 
    PrintWriter outTomainServer=null;
    InputStream inFromMainServer = null;
    public processOneconnection(Socket s,logBook lb ) {
        connection=s;
        serverLogger=lb;
        System.out.print("reached in constructor \n");
        
    }

    @Override
    public void run() {
        
        System.out.print("reached in thread \n");
        try {
            inFromClient = new BufferedReader(new InputStreamReader (connection.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(processOneconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            outToClient = new DataOutputStream(connection.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(processOneconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        try {
            headerLine = inFromClient.readLine();
            
           // serverLogger.addLog(headerLine);
        } catch (IOException ex) {
            Logger.getLogger(processOneconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        /*try {
            System.out.print(headerLine);
            while((printfull = inFromClient.readLine())!=null)
            {
                System.out.print(printfull);
                
                
            }
        } catch (IOException ex) {
            Logger.getLogger(processOneconnection.class.getName()).log(Level.SEVERE, null, ex);
        }*/
         if(headerLine!=null){
             tokenizer= new StringTokenizer(headerLine);
              httpMethod= tokenizer.nextToken();
            httpQueryString = tokenizer.nextToken();
         }
        
         
        
        System.out.print(httpMethod+"\n");
        System.out.print(httpQueryString+"\n");
        if(httpMethod.equals("GET"))
        {
            //String delims;
            //delims = "[//]";
           // String[] tokens = httpQueryString.split(delims);
            httpQueryString=httpQueryString.replaceFirst("^http://", "");
            String[] parts = httpQueryString.split("/", 2);
            
            
            for(int i=0;i<parts.length;i++)
            {
                System.out.print("tokens:"+parts[i]+"\n");
            
            }
            
            System.out.print("reached get");
            try {
                socketforRealserver = new Socket(parts[0],80);
            } catch (IOException ex) {
                Logger.getLogger(processOneconnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                 outTomainServer=  new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketforRealserver.getOutputStream())));
            } catch (IOException ex) {
                Logger.getLogger(processOneconnection.class.getName()).log(Level.SEVERE, null, ex);
            }
          String command="GET / "+parts[1]+"  HTTP/1.1";
            //String command="GET / "+parts[1]+"  HTTP/1.0\r\n\r\n";
            //while writing  home.html this command from browser it sending lots of request not just home.html
          //  String command="GET / "+headerLine+"  HTTP/1.0";
           // outTomainServer.println("GET /  HTTP/1.1");
            //outTomainServer.println("GET /   HTTP/1.1");
        // outTomainServer.println("GET /   HTTP/1.0\r\n\r\n"); //working for google
        // outTomainServer.println("GET / home.html  HTTP/1.1");// working for buet,amazon,yahoo
            //outTomainServer.println("GET / home.php  HTTP/1.1");// working for buet
          // outTomainServer.println("GET /index.html HTTP/1.1");
          // outTomainServer.println("GET / home.html  HTTP/1.1");
           // System.out.print("GET / "+tokens[tokens.length-1]+"  HTTP/1.1");
          outTomainServer.println(command);
            
            
            outTomainServer.println(); 
            outTomainServer.flush();
            try {
                inFromMainServer=socketforRealserver.getInputStream();
            } catch (IOException ex) {
                Logger.getLogger(processOneconnection.class.getName()).log(Level.SEVERE, null, ex);
            }
             
            byte[] buffer = new byte[10000] ;
            int bytesRead;
            int totalbyte=0;

            try {
                
                while((bytesRead = inFromMainServer.read(buffer))!=-1)
                {
                    outToClient.write(buffer, 0, bytesRead);
                    totalbyte=totalbyte+bytesRead;
                }
            } catch (IOException ex) {
                Logger.getLogger(processOneconnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            serverLogger.addLog(" 127.0.0.1 "+parts[0]+" "+String.valueOf(totalbyte));
            
        }
        else
        {
           
            try {
                Thread.sleep(1000000000);
            } catch (InterruptedException ex) {
                Logger.getLogger(processOneconnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        
        }
        
             //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
