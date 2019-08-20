/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpproxyserver;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

/**
 *
 * @author MD SHAKHAWAT HOSSAIN
 */
public class logBook {
    Logger logger =null;
    logBook() throws IOException
    {
        logger = Logger.getLogger("Proxy.log");
        FileHandler fh;
        try {  

                fh = new FileHandler("C:/temp/Proxy.log");
                logger.addHandler(fh);
                myFormatter myForma= new myFormatter();
                fh.setFormatter(myForma);
             } catch (SecurityException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
        e.printStackTrace();  
        }  
    
    
    }
    public void addLog(String s)
    {
        logger.info(s+"\r\n");
        
    
    
    
    }
    
}
