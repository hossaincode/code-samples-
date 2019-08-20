/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpproxyserver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 *
 * @author MD SHAKHAWAT HOSSAIN
 */
public class myFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        StringBuilder sb = new StringBuilder();
        DateFormat dateFormat = new SimpleDateFormat("d MMM yyyy HH:mm:ss");
        Date date = new Date();
        sb.append(dateFormat.format(date)).append(':');
        sb.append(record.getMessage());
        sb.append('\n');
        return sb.toString();   
        

    //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
