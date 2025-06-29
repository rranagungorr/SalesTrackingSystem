package CarSalesTracking;

import CorePackage.Seller;
import CorePackage.ITriggerer;
import CorePackage.Car;
import CorePackage.CarDatabase;
import Main.MainFrame;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author rana
 */
public class DealerAccountDetailsPanel extends javax.swing.JPanel implements ITriggerer {

    private JPanel previousPanel;
    public Seller dealer;

    public DealerAccountDetailsPanel() {
        initComponents();

    }

    public void accountDetailsForCustomer() {
        deleteAccountButton.setVisible(false);
        previousPanel = MainFrame.instance.getCustomerControlPanel();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myAccountLabel = new javax.swing.JLabel();
        dealerIDLabel = new SwingComponents.Label();
        nameLabel = new SwingComponents.Label();
        usernameLabel = new SwingComponents.Label();
        phoneNoLabel = new SwingComponents.Label();
        emailLabel = new SwingComponents.Label();
        backButton = new SwingComponents.Button();
        emailInformationLabel = new SwingComponents.Label();
        dealerIDInformationLabel = new SwingComponents.Label();
        nameInformationLabel = new SwingComponents.Label();
        usernameInformationLabel = new SwingComponents.Label();
        phoneNoInformationLabel = new SwingComponents.Label();
        deleteAccountButton = new SwingComponents.Button();
        button1 = new SwingComponents.Button();

        setBackground(new java.awt.Color(153, 153, 153));
        setPreferredSize(new java.awt.Dimension(900, 529));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        myAccountLabel.setBackground(new java.awt.Color(102, 102, 102));
        myAccountLabel.setFont(new java.awt.Font("SansSerif", 2, 48)); // NOI18N
        myAccountLabel.setForeground(new java.awt.Color(0, 0, 0));
        myAccountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        myAccountLabel.setText(" ACCOUNT INFO:");
        myAccountLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(myAccountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 470, 60));

        dealerIDLabel.setBackground(new java.awt.Color(153, 153, 153));
        dealerIDLabel.setForeground(new java.awt.Color(0, 0, 0));
        dealerIDLabel.setText("Dealer ID :");
        dealerIDLabel.setFont(new java.awt.Font("Segoe UI Light", 3, 28)); // NOI18N
        add(dealerIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 210, 50));

        nameLabel.setBackground(new java.awt.Color(153, 153, 153));
        nameLabel.setForeground(new java.awt.Color(0, 0, 0));
        nameLabel.setText("Name : ");
        nameLabel.setFont(new java.awt.Font("Segoe UI Light", 3, 28)); // NOI18N
        add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 210, 50));

        usernameLabel.setBackground(new java.awt.Color(153, 153, 153));
        usernameLabel.setForeground(new java.awt.Color(0, 0, 0));
        usernameLabel.setText("Username : ");
        usernameLabel.setFont(new java.awt.Font("Segoe UI Light", 3, 28)); // NOI18N
        add(usernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 210, 50));

        phoneNoLabel.setBackground(new java.awt.Color(153, 153, 153));
        phoneNoLabel.setForeground(new java.awt.Color(0, 0, 0));
        phoneNoLabel.setText("Phone No : ");
        phoneNoLabel.setFont(new java.awt.Font("Segoe UI Light", 3, 28)); // NOI18N
        add(phoneNoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 210, 50));

        emailLabel.setBackground(new java.awt.Color(153, 153, 153));
        emailLabel.setForeground(new java.awt.Color(0, 0, 0));
        emailLabel.setText("E-mail : ");
        emailLabel.setFont(new java.awt.Font("Segoe UI Light", 3, 28)); // NOI18N
        add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 210, 50));

        backButton.setBackground(new java.awt.Color(0, 0, 0));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackArrow.png"))); // NOI18N
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        emailInformationLabel.setBackground(new java.awt.Color(153, 153, 153));
        emailInformationLabel.setForeground(new java.awt.Color(0, 0, 0));
        emailInformationLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        add(emailInformationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, 350, 50));

        dealerIDInformationLabel.setBackground(new java.awt.Color(153, 153, 153));
        dealerIDInformationLabel.setForeground(new java.awt.Color(0, 0, 0));
        dealerIDInformationLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        add(dealerIDInformationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 350, 50));

        nameInformationLabel.setBackground(new java.awt.Color(153, 153, 153));
        nameInformationLabel.setForeground(new java.awt.Color(0, 0, 0));
        nameInformationLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        add(nameInformationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 350, 50));

        usernameInformationLabel.setBackground(new java.awt.Color(153, 153, 153));
        usernameInformationLabel.setForeground(new java.awt.Color(0, 0, 0));
        usernameInformationLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        add(usernameInformationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 350, 50));

        phoneNoInformationLabel.setBackground(new java.awt.Color(153, 153, 153));
        phoneNoInformationLabel.setForeground(new java.awt.Color(0, 0, 0));
        phoneNoInformationLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        add(phoneNoInformationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, 350, 50));

        deleteAccountButton.setBackground(new java.awt.Color(102, 102, 102));
        deleteAccountButton.setForeground(new java.awt.Color(0, 0, 0));
        deleteAccountButton.setText("Delete Account");
        deleteAccountButton.setFont(new java.awt.Font("Stencil", 2, 14)); // NOI18N
        deleteAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAccountButtonActionPerformed(evt);
            }
        });
        add(deleteAccountButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 480, 170, 40));

        button1.setBackground(new java.awt.Color(102, 102, 102));
        button1.setForeground(new java.awt.Color(0, 0, 0));
        button1.setText("About us");
        button1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 480, 80, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void deleteAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAccountButtonActionPerformed

        if (JOptionPane.showConfirmDialog(this, "Do you really want to delete your account? This action cannot be undone!",
                "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            List<Car> cars = CarDatabase.getCarsBySellerId(dealer.getUserId());
            for (Car car : cars) {
                if (car.getStatus().equalsIgnoreCase(Car.pending)) {
                    JOptionPane.showMessageDialog(this,
                            "You cannot delete your account because there are pending requests for your cars.",
                            "Operation Denied", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }

            // Silme işlemleri
            CarDatabase.deleteAllCarsForSeller(dealer.getUserId());
            dealer.deleteAccount();
            MainFrame.instance.logOut();
        }
        dealer = null;
    }//GEN-LAST:event_deleteAccountButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        dealer = null;
        MainFrame.instance.setPage(previousPanel);
    }//GEN-LAST:event_backButtonActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        AboutUsPanel aboutUsPanel = new AboutUsPanel();
        aboutUsPanel.setLocationRelativeTo(this); 
        aboutUsPanel.setVisible(true); 
    }//GEN-LAST:event_button1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private SwingComponents.Button backButton;
    private SwingComponents.Button button1;
    private SwingComponents.Label dealerIDInformationLabel;
    private SwingComponents.Label dealerIDLabel;
    private SwingComponents.Button deleteAccountButton;
    private SwingComponents.Label emailInformationLabel;
    private SwingComponents.Label emailLabel;
    private javax.swing.JLabel myAccountLabel;
    private SwingComponents.Label nameInformationLabel;
    private SwingComponents.Label nameLabel;
    private SwingComponents.Label phoneNoInformationLabel;
    private SwingComponents.Label phoneNoLabel;
    private SwingComponents.Label usernameInformationLabel;
    private SwingComponents.Label usernameLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void PageOn() {
        if (dealer == null) {
            dealer = (Seller) MainFrame.instance.getAccount();
            previousPanel = MainFrame.instance.getDealerControlPanel();
            deleteAccountButton.setVisible(true);
        }

        dealerIDInformationLabel.setText(String.valueOf(dealer.getUserId()));
        nameInformationLabel.setText(dealer.getName());
        usernameInformationLabel.setText(dealer.getUsername());
        phoneNoInformationLabel.setText(dealer.getPhone());
        emailInformationLabel.setText(dealer.getEmail());
    }
}
