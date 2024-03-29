package multiWay.gui;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import multiWay.dao.ChatClientDAO;
import multiWay.dao.ChatLogsDAO;
import multiWay.pojo.ChatClient;
import multiWay.pojo.ChatLogs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pankaj
 */
public class Server extends javax.swing.JFrame {
ServerSocket svc;
ArrayList<String>userNames=new ArrayList<>();
ArrayList<PrintWriter>print=new ArrayList<>();
String clstr,msg;
    FileWriter file;
    PrintWriter fpw;
    SimpleDateFormat sdf;
   
    
/**
     * Creates new form Server
     */
    public Server() {
       initComponents();
       try{
           file=new FileWriter("E:\\java project\\socket programming\\chatlogs.txt",true);
     sdf=new SimpleDateFormat("HH;mm;ss,dd-mm-yyyy");
     fpw=new PrintWriter(file);
     }catch(IOException e)
     {System.out.println(e);
     }
     }
        
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtChat = new javax.swing.JTextArea();
        btnStartServer = new javax.swing.JButton();
        btnStopServer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("                   MULTI WAY CHAT APP");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SERVER MODULE");

        txtChat.setEditable(false);
        txtChat.setColumns(20);
        txtChat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtChat.setRows(5);
        jScrollPane1.setViewportView(txtChat);

        btnStartServer.setBackground(new java.awt.Color(0, 153, 153));
        btnStartServer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStartServer.setForeground(new java.awt.Color(255, 255, 255));
        btnStartServer.setText("START SERVER");
        btnStartServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartServerActionPerformed(evt);
            }
        });

        btnStopServer.setBackground(new java.awt.Color(0, 153, 153));
        btnStopServer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStopServer.setForeground(new java.awt.Color(255, 255, 255));
        btnStopServer.setText("STOP SERVER");
        btnStopServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopServerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(339, 339, 339)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btnStartServer, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnStopServer, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStartServer, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStopServer, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartServerActionPerformed
        txtChat.setText("Server waiting at port no 1300...");
        WaitForConnection waitingThread=new WaitForConnection();
        waitingThread.start();
        btnStartServer.setEnabled(false);
        btnStopServer.setEnabled(true);

    }//GEN-LAST:event_btnStartServerActionPerformed

    private void btnStopServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopServerActionPerformed
        try
        {
            svc.close();
btnStartServer.setEnabled(true);
fpw.close();
            JOptionPane.showMessageDialog(null, "Disconnected successfully from client");
        }catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null, "Exception in server:"+ex);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnStopServerActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       fpw.close();
       JOptionPane.showMessageDialog(null, "chat logged successfully");
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStartServer;
    private javax.swing.JButton btnStopServer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtChat;
    // End of variables declaration//GEN-END:variables
public class WaitForConnection extends Thread 
{Socket sock;
    
    public void run()
{try{
  svc=new ServerSocket(1300);
   
while(true)
{sock=svc.accept();

ChatHandlerThread chatHandler=new ChatHandlerThread(sock);
chatHandler.start();
}
   
}catch(Exception e1)
{
System.out.println("Error:"+e1);
}
}
}
class ChatHandlerThread extends Thread
{Socket sock;
String name;
Scanner kb;
PrintWriter pw;

public ChatHandlerThread(Socket sock)
        
{this.sock=sock;
}
public void  run()
{
try{
      kb=new Scanner(sock.getInputStream());
pw=new PrintWriter(sock.getOutputStream());
int count1=0,count2=0;
while(count1==0)
 {while(true)
{if(count2>0)
{pw.println("NAMEALREADYEXISTS");
pw.flush();
}
else
{
pw.println("NAMEREQUIRED");
pw.flush();
}
name=kb.nextLine();
    
if(!ChatClientDAO.findClient(name))
{userNames.add(name);
saveClientDetailsToDB();
count1++;
break;
}
count2++;
}
pw.println("NAMEACCEPTED"+name);
pw.flush();
if(userNames.size()>=1)
{txtChat.append("\n"+name+" where connected "+sock.getInetAddress()+"\n");
print.add(pw);
   }}
while(true){
msg=kb.nextLine();
  msg.trim();
  if(msg.equals("quit"))
{for(PrintWriter p:print){
    if(p.equals(pw)==false){
    p.println(name+" has quit the group chat");
        System.out.println("asa");
p.flush();}}
sock.close();
pw.close();
return;
}
  synchronized(fpw)
  {String timestamp=sdf.format(new java.util.Date());
      fpw.println("Clientname:"+name+" message:"+msg+" Time:"+timestamp);
  try{
  ChatLogs chat=new ChatLogs();
  chat.setUserName(name);
  chat.setMessage(msg);
  chat.setMsgTime(timestamp);
  boolean result=ChatLogsDAO.addChatLog(chat);
      System.out.println("Result:"+result);
  }catch(SQLException e)
          {JOptionPane.showMessageDialog(null,"DBconnection problem","Error!!",JOptionPane.ERROR_MESSAGE);
    }
          }
 for(PrintWriter p:print){   
       if(p.equals(pw)==false)
        { p.println(name+":"+msg);
p.flush();
        }
    
}
}}
catch(Exception e)
{System.out.println(e);
}
}
public void saveClientDetailsToDB()
{
    ChatClient c=new ChatClient();
c.setUserName(name);
c.setPassword(sock.getInetAddress().toString());
try{
  boolean result=ChatClientDAO.addClient(c);
    if(result)
    {JOptionPane.showMessageDialog(null,"Added Succesfully","Succes!!",JOptionPane.INFORMATION_MESSAGE);
    }
}catch(Exception e)
{System.out.println(e);
}
}}

}
