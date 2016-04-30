
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintWriter;
import javax.swing.JDialog;
import javax.swing.SwingConstants;


public class pmFrame extends javax.swing.JFrame {

    private PrintWriter out = null;
    private String nickname = "";
    private String receiver = "";
    
    public pmFrame(PrintWriter output, String nick) {
        out = output;
        nickname = nick;
        addWindowListener (new WindowAdapter ()
        {
            @Override
            public void windowClosing (WindowEvent e)
            {   
                userJFrame.removeFromPmList(receiver);
                dispose();
            }
        });
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        receiverDialog = new javax.swing.JDialog();
        inputReceiverName = new javax.swing.JTextField();
        sendReceiverName = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        noSuchUser = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        pmMessageArea = new javax.swing.JTextArea();
        pmMessageInput = new javax.swing.JTextField();
        pmSendButton = new javax.swing.JButton();
        receiverLabel = new javax.swing.JLabel("", SwingConstants.CENTER);

        receiverDialog.setMinimumSize(new java.awt.Dimension(295, 270));

        sendReceiverName.setText("Send name");
        sendReceiverName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendReceiverNameActionPerformed(evt);
            }
        });

        jLabel1.setText("Enter pm receiver's name!");

        noSuchUser.setEditable(false);
        noSuchUser.setColumns(20);
        noSuchUser.setRows(5);
        jScrollPane2.setViewportView(noSuchUser);

        javax.swing.GroupLayout receiverDialogLayout = new javax.swing.GroupLayout(receiverDialog.getContentPane());
        receiverDialog.getContentPane().setLayout(receiverDialogLayout);
        receiverDialogLayout.setHorizontalGroup(
            receiverDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receiverDialogLayout.createSequentialGroup()
                .addGroup(receiverDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(receiverDialogLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(inputReceiverName, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(receiverDialogLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, receiverDialogLayout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addGroup(receiverDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, receiverDialogLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, receiverDialogLayout.createSequentialGroup()
                        .addComponent(sendReceiverName)
                        .addGap(91, 91, 91))))
        );
        receiverDialogLayout.setVerticalGroup(
            receiverDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receiverDialogLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(inputReceiverName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sendReceiverName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 272));

        pmMessageArea.setEditable(false);
        pmMessageArea.setColumns(20);
        pmMessageArea.setRows(5);
        jScrollPane1.setViewportView(pmMessageArea);

        pmMessageInput.setText("Enter your message!");
        pmMessageInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pmMessageInputFocusGained(evt);
            }
        });

        pmSendButton.setText("Send");
        pmSendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pmSendButtonActionPerformed(evt);
            }
        });

        receiverLabel.setText("bla bla");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pmMessageInput)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pmSendButton)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(receiverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(receiverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pmMessageInput, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pmSendButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendReceiverNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendReceiverNameActionPerformed
        noSuchUser.setText("");
        String r = inputReceiverName.getText();
        
        pmFrame pmF = userJFrame.searchPmList(r);
        if(pmF != null)
        {
            noSuchUser.append("You already have an open window for this user!");
            userJFrame.removeFromPmList("");
            dispose();
            return;
        }
        
        receiver = r;
        out.println("*whisperreceiver* " + receiver);
        inputReceiverName.setText("");
        receiverLabel.setText(receiver);
    }//GEN-LAST:event_sendReceiverNameActionPerformed

    private void pmMessageInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pmMessageInputFocusGained
        if(pmMessageInput.getText().equals("Enter your message!"))
            pmMessageInput.setText("");
    }//GEN-LAST:event_pmMessageInputFocusGained

    private void pmSendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pmSendButtonActionPerformed
        String toSend = pmMessageInput.getText();
        out.println("*whispermessage* " + receiver + " " + nickname + " : " + toSend);
        pmMessageInput.setText("");
    }//GEN-LAST:event_pmSendButtonActionPerformed

        
    public static void main(String args[]) 
    {
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
            java.util.logging.Logger.getLogger(pmFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pmFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pmFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pmFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
    }
    
    public JDialog getReceiverDialog()
    {
        return receiverDialog;
    }
    
    public String getReceiver()
    {
        return receiver;
    }
    
    public void setReceiver(String name)
    {
        receiver = name;
        receiverLabel.setText(name);
    }
    
    public void appendNoSuchUserMessage(String message)
    {
        noSuchUser.append(message);
    }
    
    public void appendMessage(String message)
    {
        pmMessageArea.append(message);
    }
    
    public void setVisibleReceiverDialog(boolean b)
    {
        receiverDialog.setVisible(b);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField inputReceiverName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea noSuchUser;
    private javax.swing.JTextArea pmMessageArea;
    private javax.swing.JTextField pmMessageInput;
    private javax.swing.JButton pmSendButton;
    private javax.swing.JDialog receiverDialog;
    private javax.swing.JLabel receiverLabel;
    private javax.swing.JButton sendReceiverName;
    // End of variables declaration//GEN-END:variables

}
