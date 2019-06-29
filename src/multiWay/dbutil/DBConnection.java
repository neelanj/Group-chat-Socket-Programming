/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiWay.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author pankaj
 */
public class DBConnection {
       private static Connection conn;
    static
    {
        try
{
 Class.forName("oracle.jdbc.OracleDriver");
 System.out.println("Driver Loaded Successfully... "); 
 conn=DriverManager.getConnection("jdbc:oracle:thin:@//yadav:1521/xe","chatdata","chatapp");
}catch(Exception e)
{JOptionPane.showMessageDialog(null,"error connecting to database"+e,"error!!",JOptionPane.ERROR_MESSAGE);
}
    
    }
    
public static Connection getConnection(){
return conn;}
public static void closeConnection()
{if(conn!=null)
{try
{conn.close();
}
catch(SQLException ex)
{JOptionPane.showMessageDialog(null,"Unable to connect to database ","error!!",JOptionPane.ERROR_MESSAGE);
System.out.println(ex);
}}
}
}
