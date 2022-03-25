package mdi.internalFrames;

import client.Client;
import client.Options;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class CreateAccount extends javax.swing.JInternalFrame {

    // Variables declaration
    private javax.swing.JButton jButtonSubmit2;
    private javax.swing.JCheckBox jCheckBoxRandomize;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabelEmpty2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextFieldAccountNumber;
    private javax.swing.JTextField jTextFieldAmount;
    private javax.swing.JTextField jTextFieldBalance;
    private javax.swing.JTextField jTextFieldCustID;
    private javax.swing.JTextField jTextFieldPaymentDate;



    private Client client = null;
    String empID="";

    public CreateAccount(Client clients,String id) {
        this.client = clients;
        this.empID=id;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jTextFieldAccountNumber = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextFieldCustID = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jTextFieldPaymentDate = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTextFieldBalance = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextFieldAmount = new javax.swing.JTextField();
        jLabelEmpty2 = new javax.swing.JLabel();
        jButtonSubmit2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jCheckBoxRandomize = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Create Account ");

        jLabel19.setFont(new java.awt.Font("Helvetica", 0, 18)); // NOI18N
        jLabel19.setText("                                     Create Account");

        jLabel20.setText(" Customer Id");

        jSeparator3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel21.setText(" Account Number");

        jLabel22.setText(" Status");

        jLabel23.setText(" Payment Date d-m-y");

        jLabel26.setText(" Balance ");

        jLabel27.setText(" Amount ");

        jLabelEmpty2.setForeground(new java.awt.Color(255, 0, 0));
        jLabelEmpty2.setText("* flieds are empty");

        jButtonSubmit2.setText("Submit");
        jButtonSubmit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmit2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pending ", "completed" }));

        jCheckBoxRandomize.setText("Randomize");
        jCheckBoxRandomize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxRandomizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldCustID, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addGap(182, 182, 182)
                                                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addComponent(jLabelEmpty2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jCheckBoxRandomize)))
                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jTextFieldAccountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(282, 282, 282)
                                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextFieldPaymentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextFieldBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextFieldAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(305, 305, 305)
                                                .addComponent(jButtonSubmit2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextFieldAccountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldPaymentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(21, 21, 21)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextFieldCustID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(15, 15, 15)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextFieldAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabelEmpty2)
                                                        .addComponent(jCheckBoxRandomize))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                                .addComponent(jButtonSubmit2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(170, 170, 170))
        );

        jLabelEmpty2.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }



    private void jButtonSubmit2ActionPerformed(java.awt.event.ActionEvent evt) {

        if(!(jTextFieldAccountNumber.getText().isEmpty() || jTextFieldCustID.getText().isEmpty() || jTextFieldPaymentDate.getText().isEmpty() ||
                jTextFieldBalance.getText().isEmpty() || jTextFieldAmount.getText().isEmpty())){

            String st= (String) jComboBox1.getSelectedItem();
            client.sendOption(Options.CREATE_ACCOUNT);
            List<String> params = new ArrayList<String>();
            params.add(jTextFieldAccountNumber.getText());
            params.add(jTextFieldCustID.getText());
            params.add(st);
            params.add(jTextFieldPaymentDate.getText());
            params.add(jTextFieldBalance.getText());
            params.add(jTextFieldAmount.getText());
            client.sendMultipleRequest(params);
            boolean isSubmit = (Boolean) client.getResponse();

            if (isSubmit){
                JOptionPane.showMessageDialog(null, "Account Was Created Successfully",
                        " Account Status", JOptionPane.INFORMATION_MESSAGE);
                jTextFieldAmount.setText("");
                jTextFieldAccountNumber.setText("");
                jTextFieldCustID.setText("");
                jTextFieldPaymentDate.setText("");
                jTextFieldBalance.setText("");
                jCheckBoxRandomize.setSelected(false);

            }else{
                JOptionPane.showMessageDialog(null, "Account Was Create Unsuccessfully " ,
                        " Account failure", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            jLabelEmpty2.setVisible(true);
        }

    }

    private void jCheckBoxRandomizeActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(jCheckBoxRandomize.isSelected()){
            int accountId = (new Random()).nextInt(800000) + 100000;
            jTextFieldAccountNumber.setText(String.valueOf(accountId));
        }
    }




}
