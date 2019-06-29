/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiWay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import multiWay.dbutil.DBConnection;
import multiWay.pojo.ChatClient;

/**
 *
 * @author pankaj
 */
public class ChatClientDAO {
   public static boolean findClient(String userName)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("select username from chatclient where username=?");
      ps.setString(1,userName);
      ResultSet rs=ps.executeQuery();
    return rs.next();
    }
   public static boolean addClient(ChatClient obj)throws SQLException
   {  String qry="insert into chatclient values(?,?)";
        boolean status=false;
        Connection conn=DBConnection.getConnection();
           PreparedStatement ps=conn.prepareStatement(qry);
           ps.setString(1,obj.getUserName());
           ps.setString(2,obj.getPassword());
           int ans=ps.executeUpdate();
           if(ans!=0)
               status=true;
           return status;
   }
}
