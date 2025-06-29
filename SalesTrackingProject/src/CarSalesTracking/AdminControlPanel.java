package CarSalesTracking;

import CorePackage.*;
import Main.MainFrame;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rana
 */
public class AdminControlPanel extends javax.swing.JPanel implements ITriggerer {

    DefaultTableModel tableModel = new DefaultTableModel();
    String[] columNames = {"ID", "Name", "Username", "E-mail", "Phone"};
    String[] columNamesCars = {"ID", "Dealer", "Brand", "Model", "Type", "Color", "Year", "Price", "Status"};

    public AdminControlPanel() {
        initComponents();
        tableModel.setColumnIdentifiers(columNames);
        tableDark1.setModel(tableModel);

    }

    public void refreshTable() {
        tableModel.setRowCount(0); 

    if (jComboBox1.getSelectedItem().equals("Customer")) {
        tableModel.setColumnIdentifiers(columNames);
        deleteButton.setText("Delete Customer");

        for (User user : UserDatabase.getAllUsers()) { 
            if (user instanceof Customer customer) {
                Vector<Object> rowData = new Vector<>();
                rowData.add(customer.getUserId());
                rowData.add(customer.getName());
                rowData.add(customer.getUsername());
                rowData.add(customer.getEmail());
                rowData.add(customer.getPhone());
                tableModel.addRow(rowData);
            }
        }
    } else if (jComboBox1.getSelectedItem().equals("Dealer")) {
        tableModel.setColumnIdentifiers(columNames);
        deleteButton.setText("Delete Dealer");

        for (User user : UserDatabase.getAllUsers()) {
            if (user instanceof Seller dealer) {
                Vector<Object> rowData = new Vector<>();
                rowData.add(dealer.getUserId());
                rowData.add(dealer.getName());
                rowData.add(dealer.getUsername());
                rowData.add(dealer.getEmail());
                rowData.add(dealer.getPhone());
                tableModel.addRow(rowData);
            }
        }
    } else if (jComboBox1.getSelectedItem().equals("Car")) {
        tableModel.setColumnIdentifiers(columNamesCars);
        deleteButton.setText("Delete Car");

        for (Car car : CarDatabase.getAllCars()) { 
            Vector<Object> rowData = new Vector<>();
            rowData.add(car.getCarId());
            rowData.add(UserDatabase.getUserById(car.getSellerId()).getName()); // Satıcı adı
            rowData.add(car.getBrand());
            rowData.add(car.getModel());
            rowData.add(car.getColor());
            rowData.add(car.getFuelType());
            rowData.add(car.getPrice());
            rowData.add(car.getStatus());
            tableModel.addRow(rowData);
        }
    }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableDark1 = new SwingComponents.TableDark();
        adminControlPanelLabel = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        deleteButton = new SwingComponents.Button();
        backButton = new SwingComponents.Button();

        setBackground(new java.awt.Color(153, 153, 153));
        setPreferredSize(new java.awt.Dimension(900, 529));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableDark1.setBackground(new java.awt.Color(102, 102, 102));
        tableDark1.setForeground(new java.awt.Color(255, 255, 255));
        tableDark1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableDark1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 860, 320));

        adminControlPanelLabel.setBackground(new java.awt.Color(102, 102, 102));
        adminControlPanelLabel.setFont(new java.awt.Font("SansSerif", 2, 48)); // NOI18N
        adminControlPanelLabel.setForeground(new java.awt.Color(0, 0, 0));
        adminControlPanelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminControlPanelLabel.setText("ADMIN CONTROL PANEL");
        adminControlPanelLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(adminControlPanelLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 640, 50));

        jComboBox1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customer", "Dealer", "Car", "" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 110, 30));

        deleteButton.setBackground(new java.awt.Color(0, 0, 0));
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Delete Customer");
        deleteButton.setBorderPainted(false);
        deleteButton.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 470, 310, -1));

        backButton.setBackground(new java.awt.Color(0, 0, 0));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackArrow.png"))); // NOI18N
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        refreshTable();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        try {
        int selectedId = (Integer) tableModel.getValueAt(tableDark1.getSelectedRow(), 0);

        if (jComboBox1.getSelectedItem().equals("Customer")) {
            if (confirmDelete("Customer")) {
                UserDatabase.deleteUser(selectedId); 
                refreshTable();
            }
        } else if (jComboBox1.getSelectedItem().equals("Dealer")) {
            if (confirmDelete("Dealer")) {
                UserDatabase.deleteUser(selectedId); 
                refreshTable();
            }
        } else if (jComboBox1.getSelectedItem().equals("Car")) {
            if (CarDatabase.getCarById(selectedId).getStatus().equals("sold")) {
                JOptionPane.showMessageDialog(this, "This car cannot be deleted because it has been sold.",
                        "Incorrect Operation", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (confirmDelete("Car")) {
                CarDatabase.deleteCar(selectedId); 
                refreshTable();
            }
        }
    } catch (IndexOutOfBoundsException e) {
        JOptionPane.showMessageDialog(this, "No data selected from the table.",
                "Selection Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private boolean confirmDelete(String type) {
    return JOptionPane.showConfirmDialog(this,
            "Do you really want to delete this " + type + "? This action cannot be undone!",
            "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
}
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed

        if ((JOptionPane.showConfirmDialog(this, "Do You Want To Log Out?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)) {
            MainFrame.instance.logOut();
        } else {
        }

    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminControlPanelLabel;
    private SwingComponents.Button backButton;
    private SwingComponents.Button deleteButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private SwingComponents.TableDark tableDark1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void PageOn() {

    }
}
