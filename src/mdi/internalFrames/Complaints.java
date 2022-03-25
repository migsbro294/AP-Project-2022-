package mdi.internalFrames;

import client.Client;
import client.Options;
import hibernate.entity.Complaint;
import hibernate.entity.Customer;
import hibernate.entity.Employee;

import javax.persistence.Column;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Complaints extends javax.swing.JInternalFrame {

    // Variables declaration
    private javax.swing.JButton jButtonAssign;
    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList5;
    private javax.swing.JList<String> jListDetails;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextAreaResponse;

    private Client client = null;
    String empID="";
    public Complaints(Client clients,String id) {
        this.client = clients;
        this.empID=id;
        initComponents();
        addToTable();
        this.addTechnicianToList();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonSubmit = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextAreaResponse = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jListDetails = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jList5 = new javax.swing.JList<>();
        jButtonAssign = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Complaints");

        jLabel6.setFont(new java.awt.Font("Helvetica", 0, 18)); // NOI18N
        jLabel6.setText("                                     Complaints");

        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonSubmit.setText("Submit");
        jButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
       jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane4.setViewportView(jTextArea1);

        jTextAreaResponse.setColumns(20);
       jTextAreaResponse.setRows(5);
        jTextAreaResponse.setLineWrap(true);
        jTextAreaResponse.setWrapStyleWord(true);
        jScrollPane5.setViewportView(jTextAreaResponse);

        jScrollPane6.setViewportView(jListDetails);

        jLabel1.setText("All Complaints by Category");

        jLabel4.setText("Problem");

        jLabel5.setText("Customer Details");

        jLabel7.setText("Response");

        jList5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList5MouseClicked(evt);
            }
        });

        jScrollPane7.setViewportView(jList5);

        jButtonAssign.setText("Assign");
        jButtonAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAssignActionPerformed(evt);
            }
        });

        jLabel8.setText("Technician");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Cable", "Broadband", "Phone"
                }
        ));
        jScrollPane8.setViewportView(jTable1);

        jTable1.setEnabled(false);
        jLabel9.setText("Status");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pending", "completed" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(202, 202, 202)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(99, 99, 99)
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                        .addContainerGap()
                                                                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                        .addGap(10, 10, 10)
                                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                                                                        .addComponent(jScrollPane5))
                                                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                                                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                                        .addGap(28, 28, 28)
                                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                                        .addGap(56, 56, 56)
                                                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                                        .addGap(35, 35, 35)
                                                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(jButtonSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                        .addGap(28, 28, 28))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(jButtonAssign))))))
                                .addGap(33, 33, 33))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGap(14, 14, 14)
                                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(12, 12, 12)
                                                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGap(34, 34, 34)
                                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButtonAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(130, 130, 130))
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(58, 58, 58)
                                                .addComponent(jButtonSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }


    private void jButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmitActionPerformed
        // TODO add your handling code here:
        long millis=System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        Date date2 =date;
        String st= (String) jComboBox1.getSelectedItem();
        if(!jTextAreaResponse.getText().isEmpty()){
            client.sendOption(Options.UPDATE_COMPLAINT);
            List<String> params = new ArrayList<String>();
            params.add(complaint_id);
            params.add(customer_id);
            params.add(category);
            params.add(details);
            params.add(empID);
            params.add(st);
            params.add(String.valueOf(date2));
            params.add(jTextAreaResponse.getText());
            client.sendMultipleRequest(params);
            boolean isSubmit = (Boolean) client.getResponse();
            if (isSubmit){
                JOptionPane.showMessageDialog(null, "Complaint Was Submit Successfully",
                        " Complaint Status", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Complaint Submit Unsuccessfully " ,
                        " Complaint failure", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void jButtonAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAssignActionPerformed
        // TODO add your handling code here:
        if(!(technicianId.isEmpty() || complaint_id.isEmpty())){
            System.out.println(technicianId);
            System.out.println(complaint_id);
            client.sendOption(Options.ASSIGN_COMPLAINT);
            List<String> params = new ArrayList<String>();
            params.add(technicianId);
            params.add(complaint_id);
            client.sendMultipleRequest(params);
            boolean isAssign = (Boolean) client.getResponse();
            if (isAssign){
                JOptionPane.showMessageDialog(null, "Complaint Was Assign Successfully",
                        " Assign  Status", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Complaint Assign Unsuccessfully " ,
                        " Assign failure", JOptionPane.INFORMATION_MESSAGE);
            }
        }else {
            JOptionPane.showMessageDialog(null, " The complaint or the technician list is not click" ,
                    " Assign failure", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    DefaultListModel model2 = new DefaultListModel();
    private void addTechnicianToList(){
        DefaultListModel model = new DefaultListModel();
        client.sendOption(Options.READ_ALL_EMPLOYEE);
        List<Employee> read= (List<Employee>) client.getResponse();
        for(Employee employee:read){
            if(employee.getRole().equals("Technician")){
                model.addElement(employee.getFirstName()+" "+employee.getLastName());
                model2.addElement(employee.getEmployee_id());
            }
        }
        jList5.setModel(model);
    }


    String technicianId="";
    String complaintIdForTech="";
    private void jList5MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        int list=jList5.getAnchorSelectionIndex();
        Object id=model2.get(list);
        technicianId= (String) id;
    }

    private void addToTable(){
        client.sendOption(Options.READ_ALL_COMPLAINT);
        List<Complaint> readAll= (List<Complaint>) client.getResponse();
        for (Complaint complaint: readAll) {
            String category = complaint.getCatergory();
            String status = complaint.getStatus();
            String data1 = " ";
            String data2 = " ";
            String data3 = " ";
            if (category.equals("cable")) {
                data1 = complaint.getComplaint_id();
            } else if (category.equals("broadband")) {
                data2 = complaint.getComplaint_id();
            } else if (category.equals("phone")) {
                data3 = complaint.getComplaint_id();
            }
            Object[] row = {data1, data2, data3};
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.addRow(row);
        }

        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row=jTable1.rowAtPoint(e.getPoint());
                int col= jTable1.columnAtPoint(e.getPoint());
                details(jTable1.getValueAt(row,col).toString());
            }
        });
    }

    private String complaint_id="";
    private String customer_id="";
    private String category="";
    private String details="";

    private void details(String comId){
        DefaultListModel model = new DefaultListModel();
        try {
            client.sendOption(Options.GET_COMPLAINT2);
            client.sendOneRequest(comId);
            Complaint readAll= (Complaint) client.getResponse();
            complaint_id=comId;
            customer_id=readAll.getCustomer_id();
            category=readAll.getCatergory();
            details=readAll.getDetails();
            jTextArea1.setText(readAll.getDetails());

            if(!readAll.getInstructions().equals("0000")){
                jTextAreaResponse.setText(readAll.getInstructions());
            }
            client.sendOption(Options.GET_CUSTOMER);
            client.sendOneRequest(readAll.getCustomer_id());
            Customer get= (Customer) client.getResponse();

            model.addElement("ID: "+get.getCustomer_Id());
            model.addElement("First Name: "+get.getFirstName());
            model.addElement("Last Name: "+get.getLastname());
            model.addElement("Email: "+get.getEmail());
            model.addElement("Address: "+get.getAddress());
            model.addElement("Phone: "+get.getContactNumber());

            jListDetails.setModel(model);
        }catch (NullPointerException e){
            JOptionPane.showMessageDialog(null, "The Cell You select is Empty",
                    " Cell Status", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
