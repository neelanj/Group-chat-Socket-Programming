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
import multiWay.pojo.ChatLogs;

/**
 *
 * @author pankaj
 */
public class ChatLogsDAO {
    public static boolean addChatLog(ChatLogs obj)throws SQLException
    {String qry="insert into chatlogs values(?,?,?)";
        boolean status=false;
        Connection conn=DBConnection.getConnection();
           PreparedStatement ps=conn.prepareStatement(qry);
           ps.setString(1,obj.getUserName());
           ps.setString(2,obj.getMessage());
           ps.setString(3,obj.getMsgTime());
         int ans=ps.executeUpdate();
           if(ans!=0)
               status=true;
           return status;
    }
    
}
