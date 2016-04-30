import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class userJFrame extends javax.swing.JFrame 
{
    private static InetAddress host;
    private static final int PORT = 1234;
    private static Socket socket = null;
    private static PrintWriter out = null;
    private static String nickname = "";
    private static boolean connected;
    private static ArrayList<pmFrame> pmList;


    public userJFrame() {
        addWindowListener (new WindowAdapter ()
        {
            @Override
            public void windowClosing (WindowEvent e)
            {   
                if(getConnected() == true)
                    disconnect();
                System.exit(0);
            }
        });
        
        initComponents();
        
        changeNickDialog.addWindowListener (new WindowAdapter ()
        {
            @Override
            public void windowClosing (WindowEvent e)
            {   
                cannotChangeNick.setText("");
                changeNickDialog.setVisible(false);
                out.println("Nick change canceled");
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginDialog = new javax.swing.JDialog();
        nicknameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        sendNickname = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        userAlreadyExists = new javax.swing.JTextArea();
        changeNickDialog = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        cannotChangeNick = new javax.swing.JTextArea();
        newNick = new javax.swing.JButton();
        nicknameField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cancelChange = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        receivedMessageArea = new javax.swing.JTextArea();
        messageInput = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        usersList = new javax.swing.JTextArea();
        changeNickButton = new javax.swing.JButton();
        disconnectButton = new javax.swing.JButton();
        pmButton = new javax.swing.JButton();
        loggedInLabel = new javax.swing.JLabel();

        loginDialog.setMinimumSize(new java.awt.Dimension(340, 320));

        jLabel1.setText("Enter your nickname below :)");

        sendNickname.setText("That's me!");
        sendNickname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendNicknameActionPerformed(evt);
            }
        });

        userAlreadyExists.setEditable(false);
        userAlreadyExists.setColumns(20);
        userAlreadyExists.setRows(5);
        jScrollPane3.setViewportView(userAlreadyExists);

        javax.swing.GroupLayout loginDialogLayout = new javax.swing.GroupLayout(loginDialog.getContentPane());
        loginDialog.getContentPane().setLayout(loginDialogLayout);
        loginDialogLayout.setHorizontalGroup(
            loginDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginDialogLayout.createSequentialGroup()
                .addGroup(loginDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginDialogLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(loginDialogLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(sendNickname))
                    .addGroup(loginDialogLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(loginDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nicknameField, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        loginDialogLayout.setVerticalGroup(
            loginDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nicknameField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sendNickname)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        changeNickDialog.setMinimumSize(new java.awt.Dimension(393, 300));

        cannotChangeNick.setEditable(false);
        cannotChangeNick.setColumns(20);
        cannotChangeNick.setRows(5);
        jScrollPane2.setViewportView(cannotChangeNick);

        newNick.setText("Change it!");
        newNick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newNickActionPerformed(evt);
            }
        });

        jLabel2.setText("Enter your new nickname below!");

        cancelChange.setText("Cancel");
        cancelChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelChangeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout changeNickDialogLayout = new javax.swing.GroupLayout(changeNickDialog.getContentPane());
        changeNickDialog.getContentPane().setLayout(changeNickDialogLayout);
        changeNickDialogLayout.setHorizontalGroup(
            changeNickDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changeNickDialogLayout.createSequentialGroup()
                .addGroup(changeNickDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(changeNickDialogLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(changeNickDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nicknameField1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(changeNickDialogLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(newNick)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancelChange, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(changeNickDialogLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        changeNickDialogLayout.setVerticalGroup(
            changeNickDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changeNickDialogLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nicknameField1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(changeNickDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newNick)
                    .addComponent(cancelChange))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(564, 321));

        receivedMessageArea.setEditable(false);
        receivedMessageArea.setColumns(20);
        receivedMessageArea.setRows(5);
        receivedMessageArea.setFocusable(false);
        jScrollPane1.setViewportView(receivedMessageArea);

        messageInput.setText("Enter your message!");
        messageInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                messageInputFocusGained(evt);
            }
        });

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        usersList.setEditable(false);
        usersList.setColumns(20);
        usersList.setRows(5);
        usersList.setText("\n");
        jScrollPane4.setViewportView(usersList);

        changeNickButton.setText("Change nick");
        changeNickButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeNickButtonActionPerformed(evt);
            }
        });

        disconnectButton.setText("Disconnect");
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButtonActionPerformed(evt);
            }
        });

        pmButton.setText("PM!");
        pmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pmButtonActionPerformed(evt);
            }
        });

        loggedInLabel.setText("You are not logged in!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(sendButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(messageInput, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(loggedInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(pmButton)
                                        .addGap(95, 95, 95)
                                        .addComponent(changeNickButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(disconnectButton)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(loggedInLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pmButton)
                            .addComponent(changeNickButton)
                            .addComponent(loginButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(messageInput, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendButton)
                    .addComponent(disconnectButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        String toSend = messageInput.getText();
        if(!toSend.equals(""))
            out.println(nickname + ": " + toSend);
        messageInput.setText("");
    }//GEN-LAST:event_sendButtonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        loginDialog.setVisible(true);
        receivedMessageArea.setText("");
    }//GEN-LAST:event_loginButtonActionPerformed

    private void sendNicknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendNicknameActionPerformed
        userAlreadyExists.setText("");
        
        if(nickname.equals(""))
        {
            nickname = nicknameField.getText();
            try {
                host = InetAddress.getLocalHost();
            }
            catch(UnknownHostException e){
                System.out.println("The host could not be found!");
                System.exit(1);
            }
            try {
                socket = new Socket(host,PORT);
                out = new PrintWriter(socket.getOutputStream(),true);
                ReadThread userThread = new ReadThread(socket, this);
                userThread.start();
            } 
            catch (IOException ex) {
                Logger.getLogger(userJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
            nickname = nicknameField.getText();
        
        out.println(nickname);
        nicknameField.setText("");
    }//GEN-LAST:event_sendNicknameActionPerformed

    private void messageInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_messageInputFocusGained
        if(messageInput.getText().equals("Enter your message!"))
            messageInput.setText("");
    }//GEN-LAST:event_messageInputFocusGained

    private void newNickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newNickActionPerformed
        cannotChangeNick.setText("");
        String nick = nicknameField1.getText();
        out.println(nick);
        nicknameField1.setText("");
    }//GEN-LAST:event_newNickActionPerformed

    private void changeNickButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeNickButtonActionPerformed
        changeNickDialog.setVisible(true);
        out.println("Nick change coming");
    }//GEN-LAST:event_changeNickButtonActionPerformed

    private void cancelChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelChangeActionPerformed
        cannotChangeNick.setText("");
        changeNickDialog.setVisible(false);
        out.println("Nick change canceled");
    }//GEN-LAST:event_cancelChangeActionPerformed

    private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectButtonActionPerformed
        disconnect();
    }//GEN-LAST:event_disconnectButtonActionPerformed

    private void pmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pmButtonActionPerformed
        pmFrame pmUserFrame = new pmFrame(out, nickname);
        pmList.add(pmUserFrame);
        pmUserFrame.setVisible(true);
        pmUserFrame.getReceiverDialog().setVisible(true);
    }//GEN-LAST:event_pmButtonActionPerformed

    public static void main(String args[]) throws Exception
    {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(userJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        userJFrame myFrame = new userJFrame();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                myFrame.setVisible(true);
                myFrame.changeNickButton.setVisible(false);
                myFrame.disconnectButton.setEnabled(false);
                myFrame.pmButton.setEnabled(false);
                myFrame.sendButton.setEnabled(false);
            }
        });
        
        pmList = new ArrayList<pmFrame>();   
    }

    public void appendReceivedMessage(String message)
    {
        receivedMessageArea.append(message);
    }
    
    public void appendNameMessage(String message)
    {
        userAlreadyExists.append(message);
    }
    
    public void appendChangeMessage(String message)
    {
        cannotChangeNick.append(message);
    }
    
    public JTextArea getUsersArea()
    {
        return usersList;
    }
    
    public PrintWriter getPrintWriter()
    {
        return out;
    }
    
    public String getNickname()
    {
        return nickname;
    }
    
    public void setNickname(String s)
    {
        nickname = s;
        setLoggedInLabel();
    }
    
    public void setLoggedInLabel()
    {
        loggedInLabel.setText("You are logged in as: " + nickname);
    }
    
    public void setVisibleLoginDialog(boolean b)
    {
        loginDialog.setVisible(b);
    }
    
    public void setVisibleLogin(boolean b)
    {
        loginButton.setVisible(b);
        changeNickButton.setVisible(!b);
        disconnectButton.setEnabled(!b);
        pmButton.setEnabled(!b);
        sendButton.setEnabled(!b);
    }
    
    public void setVisibleChangeDialog(boolean b)
    {
        changeNickDialog.setVisible(b);
    }
    
    public void setConnected(boolean b)
    {
        connected = b;
    }
    
    public boolean getConnected()
    {
        return connected;
    }
    
    public void disconnect()
    {
        out.println(nickname + ": " + "Client wants to disconnect");
        sendButton.setEnabled(false);
        changeNickButton.setEnabled(false);
        disconnectButton.setEnabled(false);
        pmButton.setEnabled(false);
        usersList.setText("");
        loggedInLabel.setText("You are not logeed in!");
        connected = false;
    }
    
    public pmFrame getLastPmFrame()
    {
        return pmList.get(pmList.size() - 1);
    }
    
    public static pmFrame searchPmList(String name)
    {
        for(pmFrame p : pmList)
            if(p.getReceiver().equals(name))
                return p;
        return null;
    }
    
    public void addInPmList(pmFrame pmF)
    {
        pmList.add(pmF);
    }
    
    public static void removeFromPmList(String receiver)
    {
        for(pmFrame p : pmList)
            if(p.getReceiver().equals(receiver))
            {
                pmList.remove(p);
                return;
            }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelChange;
    private javax.swing.JTextArea cannotChangeNick;
    private javax.swing.JButton changeNickButton;
    private javax.swing.JDialog changeNickDialog;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel loggedInLabel;
    private javax.swing.JButton loginButton;
    private javax.swing.JDialog loginDialog;
    private javax.swing.JTextField messageInput;
    private javax.swing.JButton newNick;
    private javax.swing.JTextField nicknameField;
    private javax.swing.JTextField nicknameField1;
    private javax.swing.JButton pmButton;
    private javax.swing.JTextArea receivedMessageArea;
    private javax.swing.JButton sendButton;
    private javax.swing.JButton sendNickname;
    private javax.swing.JTextArea userAlreadyExists;
    private javax.swing.JTextArea usersList;
    // End of variables declaration//GEN-END:variables
}

class ReadThread extends Thread 
{
    Socket userSocket = null;
    userJFrame userFrame = null;
    Scanner in = null;
    
    ReadThread(Socket socket, userJFrame main) throws IOException{
        userSocket = socket;
        userFrame = main;
        in = new Scanner(socket.getInputStream());
    }
    
    @Override
    public void run() 
    {
        String message;
        do 
        {   
            message = in.nextLine();
            switch(message) 
            {
                case "Nickname is not available. Please choose another one!":
                    userFrame.appendNameMessage(message);
                    break;
                case "Nick okay!":
                    userFrame.setVisibleLoginDialog(false);
                    userFrame.setVisibleLogin(false);
                    userFrame.setConnected(true);
                    userFrame.setLoggedInLabel();
                    break;
                case "Nick change":
                    message = in.nextLine();
                    while(!message.equals("Nick change canceled")) 
                        if(message.equals("Nickname not available. Please try another one!"))
                        { 
                            userFrame.appendChangeMessage(message);
                            message = in.nextLine();
                        }
                        else
                            if(message.equals("Nick okay"))
                            {
                                userFrame.setVisibleChangeDialog(false);
                                message = in.nextLine();
                                userFrame.setNickname(message);
                                
                                //Get 'nick change canceled' message
                                message = in.nextLine();
                            }
                    break;
                case "Online users":
                    userFrame.getUsersArea().setText("");
                            do 
                            {
                                userFrame.getUsersArea().append(message + "\n");
                                message = in.nextLine();
                            }
                            while(!message.equals("End online users"));
                    break; 
                case "Whisper receiver not okay":
                    userFrame.getLastPmFrame().appendNoSuchUserMessage("Could not find user online. Please try again!");
                    break;
                case "Whisper receiver okay":
                    userFrame.getLastPmFrame().setVisibleReceiverDialog(false);
                    break;
                case "*whispermessage*":
                    //receiver + " " + nickname + " : " + toSend
                    message = in.nextLine();
                    String[] parts = message.split(" ");
                    
                    pmFrame pmF = userFrame.searchPmList(parts[0]);
                    if(pmF == null)
                    {
                        pmFrame pmUserFrame = new pmFrame(userFrame.getPrintWriter(), userFrame.getNickname());
                        userFrame.addInPmList(pmUserFrame);
                        pmUserFrame.setReceiver(parts[0]);
                        pmUserFrame.setVisible(true);
                        pmUserFrame.getReceiverDialog().setVisible(false);
                        
                        message = "";
                        for(int i=1; i<parts.length; i++)
                            message = message + parts[i] + " ";
                        pmUserFrame.appendMessage(message + "\n");
                    }
                    else 
                    {   
                        pmF.setVisible(true);
                        message = "";
                        for(int i=1; i<parts.length; i++)
                            message = message + parts[i] + " ";
                        pmF.appendMessage(message + "\n");
                    }
                    break;
                default:
                    if(!message.contains("Client wants to disconnect"))
                        userFrame.appendReceivedMessage(message + "\n");
                    break;
            }
            
        }while(!message.equals(userFrame.getNickname() + ": " + "Client wants to disconnect"));
        
        userFrame.appendReceivedMessage("You are now disconnected. You cannot send any messages!");

        this.interrupt();
    }
}