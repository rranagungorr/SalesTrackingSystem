
package CarSalesTracking;

import CorePackage.Customer;
import CorePackage.Seller;
import CorePackage.ITriggerer;
import CorePackage.User;
import CorePackage.UserDatabase;
import Main.MainFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author rana
 */
public class CustomerAccountDetailsPanel extends javax.swing.JPanel implements ITriggerer {

    private JPanel previousPanel;
    public Customer customer;

    public CustomerAccountDetailsPanel() {
        initComponents();
    }

    public void accountDetailsForDealer() {
        deleteAccountButton.setVisible(false);
        previousPanel = MainFrame.instance.getDealerControlPanel();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myAccountLabel = new javax.swing.JLabel();
        backButton = new SwingComponents.Button();
        deleteAccountButton = new SwingComponents.Button();
        jSeparator1 = new javax.swing.JSeparator();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        nameInformationLabel = new SwingComponents.Label();
        usernameInformationLabel = new SwingComponents.Label();
        phoneNoInformationLabel = new SwingComponents.Label();
        emailInformationLabel = new SwingComponents.Label();
        nameLabel = new SwingComponents.Label();
        usernameLabel = new SwingComponents.Label();
        phoneNoLabel = new SwingComponents.Label();
        emailLabel = new SwingComponents.Label();
        customerIDInformationLabel = new SwingComponents.Label();
        customerIDLabel = new SwingComponents.Label();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPrivacyAndSecurity = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(153, 153, 153));
        setPreferredSize(new java.awt.Dimension(900, 529));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        myAccountLabel.setBackground(new java.awt.Color(102, 102, 102));
        myAccountLabel.setFont(new java.awt.Font("SansSerif", 2, 24)); // NOI18N
        myAccountLabel.setForeground(new java.awt.Color(0, 0, 0));
        myAccountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        myAccountLabel.setText(" ACCOUNT DETAİLS");
        myAccountLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(myAccountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 390, 30));

        backButton.setBackground(new java.awt.Color(0, 0, 0));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackArrow.png"))); // NOI18N
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        deleteAccountButton.setBackground(new java.awt.Color(102, 102, 102));
        deleteAccountButton.setForeground(new java.awt.Color(0, 0, 0));
        deleteAccountButton.setText("Delete Account");
        deleteAccountButton.setFont(new java.awt.Font("Stencil", 2, 14)); // NOI18N
        deleteAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAccountButtonActionPerformed(evt);
            }
        });
        add(deleteAccountButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 460, 170, 40));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 103, 350, 0));

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameInformationLabel.setBackground(new java.awt.Color(153, 153, 153));
        nameInformationLabel.setForeground(new java.awt.Color(0, 0, 0));
        nameInformationLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jPanel2.add(nameInformationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 350, 50));

        usernameInformationLabel.setBackground(new java.awt.Color(153, 153, 153));
        usernameInformationLabel.setForeground(new java.awt.Color(0, 0, 0));
        usernameInformationLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jPanel2.add(usernameInformationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 350, 50));

        phoneNoInformationLabel.setBackground(new java.awt.Color(153, 153, 153));
        phoneNoInformationLabel.setForeground(new java.awt.Color(0, 0, 0));
        phoneNoInformationLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jPanel2.add(phoneNoInformationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 350, 50));

        emailInformationLabel.setBackground(new java.awt.Color(153, 153, 153));
        emailInformationLabel.setForeground(new java.awt.Color(0, 0, 0));
        emailInformationLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jPanel2.add(emailInformationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 350, 50));

        nameLabel.setBackground(new java.awt.Color(153, 153, 153));
        nameLabel.setForeground(new java.awt.Color(0, 0, 0));
        nameLabel.setText("Name : ");
        nameLabel.setFont(new java.awt.Font("Segoe UI Light", 3, 28)); // NOI18N
        jPanel2.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 210, 50));

        usernameLabel.setBackground(new java.awt.Color(153, 153, 153));
        usernameLabel.setForeground(new java.awt.Color(0, 0, 0));
        usernameLabel.setText("Username : ");
        usernameLabel.setFont(new java.awt.Font("Segoe UI Light", 3, 28)); // NOI18N
        jPanel2.add(usernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 210, 50));

        phoneNoLabel.setBackground(new java.awt.Color(153, 153, 153));
        phoneNoLabel.setForeground(new java.awt.Color(0, 0, 0));
        phoneNoLabel.setText("Phone No : ");
        phoneNoLabel.setFont(new java.awt.Font("Segoe UI Light", 3, 28)); // NOI18N
        jPanel2.add(phoneNoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 210, 50));

        emailLabel.setBackground(new java.awt.Color(153, 153, 153));
        emailLabel.setForeground(new java.awt.Color(0, 0, 0));
        emailLabel.setText("E-mail : ");
        emailLabel.setFont(new java.awt.Font("Segoe UI Light", 3, 28)); // NOI18N
        jPanel2.add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 210, 50));

        customerIDInformationLabel.setBackground(new java.awt.Color(153, 153, 153));
        customerIDInformationLabel.setForeground(new java.awt.Color(0, 0, 0));
        customerIDInformationLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jPanel2.add(customerIDInformationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 350, 50));

        customerIDLabel.setBackground(new java.awt.Color(153, 153, 153));
        customerIDLabel.setForeground(new java.awt.Color(0, 0, 0));
        customerIDLabel.setText("Customer ID :");
        customerIDLabel.setFont(new java.awt.Font("Segoe UI Light", 3, 28)); // NOI18N
        jPanel2.add(customerIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 210, 50));

        jTabbedPane1.addTab("my account info", jPanel2);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPrivacyAndSecurity.setBackground(new java.awt.Color(53, 53, 53));
        txtPrivacyAndSecurity.setColumns(20);
        txtPrivacyAndSecurity.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        txtPrivacyAndSecurity.setForeground(new java.awt.Color(255, 255, 255));
        txtPrivacyAndSecurity.setLineWrap(true);
        txtPrivacyAndSecurity.setRows(5);
        txtPrivacyAndSecurity.setText("\n Privacy and Security Policy\n\n The privacy and security of our users are our top priorities. Your personal information is \n collected and processed solely to provide our services and enhance your experience. This \n information is never shared with third parties without your explicit consent.\n\n Your data is protected using modern security protocols and technologies. Account information is  accessible only to authorized personnel, and regular updates are implemented to ensure your \n data remains secure.\n\n You can view, edit, or deactivate your account information through your account settings. If you \n have any questions or need more information regarding privacy and security, please contact us.\n\n\n\n contact info:\n support@ranacar.com\n 0212 000 0000");
        txtPrivacyAndSecurity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jScrollPane1.setViewportView(txtPrivacyAndSecurity);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 440, 290));

        jTabbedPane1.addTab("privacy policy", jPanel1);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 740, 420));
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        customer = null;
        MainFrame.instance.setPage(previousPanel);
    }//GEN-LAST:event_backButtonActionPerformed

    private void deleteAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAccountButtonActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Do you really want to delete your account? "
                + "This action cannot be undone!", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            UserDatabase.deleteUser(customer.getUserId());
            MainFrame.instance.logOut();
            customer = null;
        }

    }//GEN-LAST:event_deleteAccountButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private SwingComponents.Button backButton;
    private SwingComponents.Label customerIDInformationLabel;
    private SwingComponents.Label customerIDLabel;
    private SwingComponents.Button deleteAccountButton;
    private SwingComponents.Label emailInformationLabel;
    private SwingComponents.Label emailLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel myAccountLabel;
    private SwingComponents.Label nameInformationLabel;
    private SwingComponents.Label nameLabel;
    private SwingComponents.Label phoneNoInformationLabel;
    private SwingComponents.Label phoneNoLabel;
    private javax.swing.JTextArea txtPrivacyAndSecurity;
    private SwingComponents.Label usernameInformationLabel;
    private SwingComponents.Label usernameLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void PageOn() {

        if (customer == null) {
            customer = (Customer) MainFrame.instance.getAccount();
            previousPanel = MainFrame.instance.getCustomerControlPanel();
            deleteAccountButton.setVisible(true);
        }

        customerIDInformationLabel.setText(String.valueOf(customer.getUserId()));
        nameInformationLabel.setText(customer.getName());
        usernameInformationLabel.setText(customer.getUsername());
        phoneNoInformationLabel.setText(customer.getPhone());
        emailInformationLabel.setText(customer.getEmail());
        
    }
}
