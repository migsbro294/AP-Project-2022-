package mdi;

import client.Client;
import client.Options;
import hibernate.entity.Complaint;
import hibernate.entity.Customer;
import hibernate.entity.Employee;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerDashboard extends JFrame {

    // Variables declaration
    private ButtonGroup buttonGroup1;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel6;
    private JLabel jLabel8;
    private JList<String> jList1;
    private JList<String> jList2;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JPanel jPanel1;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JSeparator jSeparator1;


    private Client client = null;
    String custID="";



    public CustomerDashboard(Client clients,String id) {
        client = clients;
        initComponents();
        nameAndDate(id);
        addComplaint(id);
        custID=id;
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        buttonGroup1 = new ButtonGroup();
        jPanel1 = new JPanel();
        jPanel3 = new JPanel();
        jLabel6 = new JLabel();
        jSeparator1 = new JSeparator();
        jLabel8 = new JLabel();
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();
        jLabel14 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jScrollPane2 = new JScrollPane();
        jList1 = new JList<>();
        jScrollPane1 = new JScrollPane();
        jList2 = new JList<>();
        jLabel15 = new JLabel();
        jButton3 = new JButton();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenuItem1 = new JMenuItem();
        jMenu2 = new JMenu();
        jMenuItem2 = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cable Vision");
        setResizable(false);

        jPanel1.setBackground(new Color(192, 173, 225));

        jLabel6.setFont(new Font("Helvetica", 0, 18)); // NOI18N
        jLabel6.setText("                                     Customer Dashboard");

        jSeparator1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        jLabel8.setText("Welcome ");

        jLabel12.setText("place customer here");

       jLabel13.setText("place the date here");

        jLabel14.setFont(new Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel14.setText("Past complaints");

        jButton1.setText("Lodge Complaint");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("View Account");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jList1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jList1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jScrollPane1.setViewportView(jList2);

        jLabel15.setFont(new Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel15.setText("Details");

        jButton3.setText("Live Chat");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 568, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 547, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(225, 225, 225)
                                                                .addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(288, 288, 288)
                                                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel14, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(118, 118, 118)
                                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel15, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(54, 54, 54)
                                .addComponent(jButton3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(34, 34, 34)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel14, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel15, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1)
                                        .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
                                .addGap(48, 48, 48))
        );

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, 0));
        jMenuItem1.setText("jMenuItem1");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem2.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Personal details");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        dispose();
        new CustomerComplaint(client,custID);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        dispose();
        new CustomerAccount(client,custID);

    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        dispose();
        new CustomerDetails(client,custID);
    }

    private void jList1AncestorAdded(javax.swing.event.AncestorEvent evt) {
        // TODO add your handling code here:
    }



    DefaultListModel defaultListModel2 = new DefaultListModel();
    DefaultListModel defaultListModel3 = new DefaultListModel();
    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:

        DefaultListModel model2= new DefaultListModel();
        int list=jList1.getAnchorSelectionIndex();
        Object data2=defaultListModel2.get(list);
        Object data3=defaultListModel3.get(list);
        model2.addElement(data2);
        model2.addElement("-----------------------------------------------------");
        model2.addElement(data3);
        Dimension d = jList2.getPreferredSize();
        d.height = 100;
        jList2.setPreferredSize(d);

        jList2.setModel(model2);
        MyCellRenderer cellRenderer = new MyCellRenderer(250);
        jList2.setCellRenderer(cellRenderer);

    }

    
    public void addComplaint(String customerID){

        DefaultListModel defaultListModel = new DefaultListModel();
        Date date; String eid;
        String detail, reponse="";

        client.sendOption(Options.GET_COMPLAINT);
        client.sendOneRequest(customerID);
        ArrayList<Complaint> info= (ArrayList<Complaint>) client.getResponse();


        defaultListModel.removeAllElements();
        for (Complaint complaint: info) {
            String names="No Response As Yet!";
            date=complaint.getDate();
            eid=complaint.getEmployee_id();
            detail=complaint.getDetails();
            if(!complaint.getInstructions().equals("0000")){
                reponse=complaint.getInstructions();
            }else {
                reponse="";
            }



            if(!eid.equals("0000")){
                Employee employee;
                client.sendOption(Options.GET_EMPLOYEE);
                client.sendOneRequest(eid);
                employee = (Employee) client.getResponse();
                names=employee.getFirstName()+" "+employee.getLastName();
            }



            defaultListModel.addElement(date+"  "+names.toUpperCase());
            defaultListModel2.addElement("YOU : "+detail);
            defaultListModel3.addElement(names.toUpperCase()+" : "+reponse);
        }
        MyCellRenderer cellRenderer = new MyCellRenderer(120);
        jList1.setModel(defaultListModel);
        jList1.setCellRenderer(cellRenderer);

    }


    private void nameAndDate(String id) {//display customer name and the current date on the gui
        String name = "none";

        Customer cust = new Customer();
        client.sendOption(Options.GET_CUSTOMER);
        client.sendOneRequest(id);
        cust = (Customer) client.getResponse();
        name= cust.getFirstName()+" "+cust.getLastname();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        LocalDate localDate1 = LocalDate.now();
        jLabel12.setText(name);
        jLabel13.setText("Date " + dateTimeFormatter.format(localDate1));
    }

}
class MyCellRenderer extends DefaultListCellRenderer {
    public static final String HTML_1 = "<html><body style='width: ";
    public static final String HTML_2 = "px'>";
    public static final String HTML_3 = "</html>";
    private int width;

    public MyCellRenderer(int width) {
        this.width = width;
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        String text = HTML_1 + String.valueOf(width) + HTML_2 + value.toString()
                + HTML_3;
        return super.getListCellRendererComponent(list, text, index, isSelected,
                cellHasFocus);
    }

}