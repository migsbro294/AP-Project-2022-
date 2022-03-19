package mdi;


import client.Client;
import client.Options;
import hibernate.entity.Complaint;
import hibernate.entity.Customer;
import hibernate.entity.Employee;
import jdbc.controllers.ComplaintController;
import mdi.internalFrames.Complaints;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDashboard extends javax.swing.JFrame {


    // Variables declaration - do not modify
    private javax.swing.JButton jButtonComplains;
    private javax.swing.JButton jButtonSend;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuComplains;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItemCreate;
    private javax.swing.JMenuItem jMenuItemCreateEmployee;
    private javax.swing.JMenuItem jMenuItemDelete;
    private javax.swing.JMenuItem jMenuItemDeleteEmployee;
    private javax.swing.JMenuItem jMenuItemGet;
    private javax.swing.JMenuItem jMenuItemProfile;
    private javax.swing.JMenuItem jMenuItemUpdate;
    private javax.swing.JMenuItem jMenuItemViewComplaints;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextAreaMessages;
    private javax.swing.JTextField jTextFieldMessage;
    // End of variables declaration


    private Client client = null;
    String empID="";

    public EmployeeDashboard(Client clients,String id) {
        client = clients;
        empID=id;
        initComponents();
        listOfComplaintsName();
        nameAndDate(id);
        status();
        setVisible(true);
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaMessages = new javax.swing.JTextArea();
        jTextFieldMessage = new javax.swing.JTextField();
        jButtonSend = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButtonComplains = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemProfile = new javax.swing.JMenuItem();
        jMenuItemCreateEmployee = new javax.swing.JMenuItem();
        jMenuItemDeleteEmployee = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemUpdate = new javax.swing.JMenuItem();
        jMenuItemDelete = new javax.swing.JMenuItem();
        jMenuItemCreate = new javax.swing.JMenuItem();
        jMenuItemGet = new javax.swing.JMenuItem();
        jMenuComplains = new javax.swing.JMenu();
        jMenuItemViewComplaints = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        jMenuItem7.setText("jMenuItem7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cable Vision");
        setResizable(false);

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(892, 758));

        jPanel1.setBackground(new java.awt.Color(192, 173, 225));

        jPanel2.setPreferredSize(new java.awt.Dimension(792, 702));

        jLabel6.setFont(new java.awt.Font("Helvetica", 0, 18)); // NOI18N
        jLabel6.setText("                                     Employee Dashboard");

        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setText("Welcome ");

        jLabelName.setText("place employee name here");

        jLabelDate.setText("place the date here");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "Services", "Resolved", "Outstanding"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Helvetica", 1, 13)); // NOI18N
        jLabel1.setText("Complaints status ");

        jTextAreaMessages.setEditable(false);
        jTextAreaMessages.setColumns(20);
        jTextAreaMessages.setRows(5);
        jScrollPane2.setViewportView(jTextAreaMessages);

        jButtonSend.setText("Send");
        jButtonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendActionPerformed(evt);
            }
        });

        jLabel2.setText("Live Chat");

        jLabel3.setText("List of Customer that Have Complaints");

        jScrollPane3.setViewportView(jList1);

        jButtonComplains.setText("View Complaints");
        jButtonComplains.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComplainsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(47, 47, 47)
                                                .addComponent(jLabel1))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabelName)
                                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButtonComplains, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(111, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabelDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jTextFieldMessage)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonSend))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(109, 109, 109)))
                                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addGap(1, 1, 1)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextFieldMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButtonSend, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonComplains, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(57, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
                jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
                jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, 0));
        jMenuItem1.setText("jMenuItem1");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItemProfile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemProfile.setText("Edit Profile ");
        jMenuItemProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProfileActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemProfile);

        jMenuItemCreateEmployee.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItemCreateEmployee.setText("Create Employee");
        jMenuItemCreateEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCreateEmployeeActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemCreateEmployee);

        jMenuItemDeleteEmployee.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItemDeleteEmployee.setText("Delete Employee");
        jMenuItemDeleteEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDeleteEmployeeActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemDeleteEmployee);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Customer Profile");

        jMenuItemUpdate.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemUpdate.setText("Update");
        jMenuItemUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUpdateActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemUpdate);

        jMenuItemDelete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemDelete.setText("Delete");
        jMenuItemDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDeleteActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemDelete);

        jMenuItemCreate.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemCreate.setText("Create ");
        jMenuItemCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCreateActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemCreate);

        jMenuItemGet.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemGet.setText("Get");
        jMenuItemGet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGetActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemGet);

        jMenuBar1.add(jMenu3);

        jMenuComplains.setText("Complaints");
        jMenuComplains.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuComplainsActionPerformed(evt);
            }
        });

        jMenuItemViewComplaints.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemViewComplaints.setText("View Complaints");
        jMenuItemViewComplaints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemViewComplaintsActionPerformed(evt);
            }
        });
        jMenuComplains.add(jMenuItemViewComplaints);

        jMenuBar1.add(jMenuComplains);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void jMenuItemProfileActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        //  jDesktopPane1.removeAll();
        //  EditProfile profile=new EditProfile();
        //  jDesktopPane1.add(profile).setVisible(true);
    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jMenuItemUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        //  jDesktopPane1.removeAll();
        // UpdateCustomer customer=new UpdateCustomer();
        //jDesktopPane1.add(customer).setVisible(true);
    }

    private void jMenuItemDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        // jDesktopPane1.removeAll();
        // DeleteCustomer delete=new DeleteCustomer();
        // jDesktopPane1.add(delete).setVisible(true);
    }

    private void jMenuItemCreateActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        // jDesktopPane1.removeAll();
//        CreateCustomer create=new CreateCustomer(client);
//        jDesktopPane1.add(create).setVisible(true);

    }

    private void jMenuItemGetActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        //  jDesktopPane1.removeAll();
        // ReadCustomer read=new ReadCustomer();
        //jDesktopPane1.add(read).setVisible(true);
    }

    private void jButtonSendActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String message = jTextFieldMessage.getText();
        if(!message.isEmpty()){
            jTextAreaMessages.append("You: "+message+"\n");
        }


        jTextFieldMessage.setText("");
    }

    private void jMenuComplainsActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        //jDesktopPane1.removeAll();
        //Complaints complaints=new Complaints();
        //jDesktopPane1.add(complaints).setVisible(true);
    }

    private void jButtonComplainsActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

    }

    private void jMenuItemViewComplaintsActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        //jDesktopPane1.removeAll();
        Complaints complaints=new Complaints(client,empID);
        jDesktopPane1.add(complaints).setVisible(true);
    }

    private void jMenuItemDeleteEmployeeActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        //jDesktopPane1.removeAll();
        // DeleteEmployee delete=new DeleteEmployee();
        // jDesktopPane1.add(delete).setVisible(true);
    }

    private void jMenuItemCreateEmployeeActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        //jDesktopPane1.removeAll();
        //CreateEmployee create=new CreateEmployee();
        //jDesktopPane1.add(create).setVisible(true);

    }

    public void listOfComplaintsName(){
        DefaultListModel defaultListModel = new DefaultListModel();
        String names;
        client.sendOption(Options.READ_ALL_COMPLAINT);
        List<Complaint> readAll= (List<Complaint>) client.getResponse();
        defaultListModel.removeAllElements();
        for (Complaint complaint: readAll){
            String id=complaint.getCustomer_id();

            Customer cust = new Customer();
            client.sendOption(Options.GET_CUSTOMER);
            client.sendOneRequest(id);
            cust = (Customer) client.getResponse();
            names= cust.getFirstName()+" "+cust.getLastname();

            defaultListModel.addElement(names);
        }
        jList1.setModel(defaultListModel);
    }

    private void nameAndDate(String id) {//display customer name and the current date on the gui
        String name = "none";

        Employee employee = new Employee();
        client.sendOption(Options.GET_EMPLOYEE);
        client.sendOneRequest(id);
        employee = (Employee) client.getResponse();
        name= employee.getFirstName()+" "+employee.getLastName();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        LocalDate localDate1 = LocalDate.now();
        jLabelName.setText(name);
        jLabelDate.setText("Date " + dateTimeFormatter.format(localDate1));
    }

    int cablePending=0, broadbandPending=0,phonePending=0;
    int cableCompleted=0,broadbandCompleted=0,phoneCompleted=0;
    public void status(){
        client.sendOption(Options.READ_ALL_COMPLAINT);
        List<Complaint> readAll= (List<Complaint>) client.getResponse();
        for (Complaint complaint: readAll){
            String category=complaint.getCatergory();
            String status = complaint.getStatus();
            if (category.equals("cable")){
                if (status.equals("pending")){
                    cablePending +=1;
                }else  if (status.equals("completed")){
                    cableCompleted+=1;
                }
            } else if (category.equals("broadband")){
                if (status.equals("pending")){
                    broadbandPending +=1;
                }else  if (status.equals("completed")){
                    broadbandCompleted+=1;
                }
            }else if (category.equals("phone")){
                if (status.equals("pending")){
                    phonePending +=1;
                }else  if (status.equals("completed")){
                    phoneCompleted+=1;
                }
            }
        }

        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        model.addRow(new Object[]{"cable", cableCompleted, cablePending});
        model.addRow(new Object[]{"broadband", broadbandCompleted, broadbandPending});
        model.addRow(new Object[]{"phone", phoneCompleted, phonePending});
    }
}
