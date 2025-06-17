package CarSalesTracking;

import CorePackage.Customer;
import CorePackage.Seller;
import CorePackage.ITriggerer;
import CorePackage.User;
import CorePackage.Car;
import CorePackage.CarDatabase;
import CorePackage.Order;
import CorePackage.OrderDatabase;
import CorePackage.UserDatabase;
import Main.MainFrame;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rana
 */
public class CustomerMyOrdersPanel extends javax.swing.JPanel implements ITriggerer {

    private Customer customer;

    DefaultTableModel tableModel = new DefaultTableModel();
    String[] columNames = {"Dealer ID", "Name", "Car ID", "Car Brand", "Car Model", "Price", "Status"};

    public CustomerMyOrdersPanel() {
        initComponents();

        tableModel.setColumnIdentifiers(columNames);
        tableDark1.setModel(tableModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myOrdersLabel = new javax.swing.JLabel();
        backButton = new SwingComponents.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDark1 = new SwingComponents.TableDark();
        dealerInfoButton = new SwingComponents.Button();
        cancelOrderButton = new SwingComponents.Button();
        informationLabel = new SwingComponents.Label();

        setBackground(new java.awt.Color(153, 153, 153));
        setPreferredSize(new java.awt.Dimension(900, 529));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        myOrdersLabel.setBackground(new java.awt.Color(102, 102, 102));
        myOrdersLabel.setFont(new java.awt.Font("SansSerif", 2, 48)); // NOI18N
        myOrdersLabel.setForeground(new java.awt.Color(0, 0, 0));
        myOrdersLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        myOrdersLabel.setText("MY ORDERS");
        myOrdersLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(myOrdersLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 490, 60));

        backButton.setBackground(new java.awt.Color(0, 0, 0));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackArrow.png"))); // NOI18N
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 840, 330));

        dealerInfoButton.setBackground(new java.awt.Color(0, 0, 0));
        dealerInfoButton.setForeground(new java.awt.Color(255, 255, 255));
        dealerInfoButton.setText("Dealer Info");
        dealerInfoButton.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        dealerInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dealerInfoButtonActionPerformed(evt);
            }
        });
        add(dealerInfoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, 180, -1));

        cancelOrderButton.setBackground(new java.awt.Color(0, 0, 0));
        cancelOrderButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelOrderButton.setText("Cancel Order");
        cancelOrderButton.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        cancelOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelOrderButtonActionPerformed(evt);
            }
        });
        add(cancelOrderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 440, 190, -1));

        informationLabel.setForeground(new java.awt.Color(255, 255, 255));
        informationLabel.setText("If you don't see your pending status vehicle in your table, the account of the dealer selling the vehicle or the vehicle itself has been deleted by the admin.");
        informationLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        add(informationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 850, -1));
    }// </editor-fold>//GEN-END:initComponents

    public void refreshTable() {
        tableModel.setRowCount(0);

        try {
            List<Order> orders = OrderDatabase.listOrders();
            for (Order order : orders) {
                if (order.getCustomerId() == customer.getUserId()) {
                    Car car = CarDatabase.getCarById(order.getCarId());
                    Seller dealer = (Seller) UserDatabase.getUserById(car.getSellerId());
                    Vector<Object> rowData = new Vector<>();
                    rowData.add(dealer.getUserId());
                    rowData.add(dealer.getName());
                    rowData.add(order.getOrderId());
                    rowData.add(car.getBrand());
                    rowData.add(car.getModel());
                    rowData.add(car.getPrice());
                    rowData.add(order.getOrderStatus());
                    tableModel.addRow(rowData);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading orders.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        MainFrame.instance.setPage(MainFrame.instance.getCustomerControlPanel());
    }//GEN-LAST:event_backButtonActionPerformed

    private void dealerInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dealerInfoButtonActionPerformed
        try {
            int selectedRow = tableDark1.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "No dealer selected.", "Selection Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Tablo hücresindeki değeri doğrudan Integer olarak al
            Object dealerIdValue = tableModel.getValueAt(selectedRow, 0);
            int dealerId;

            if (dealerIdValue instanceof Integer) {
                dealerId = (Integer) dealerIdValue;
            } else {
                dealerId = Integer.parseInt(dealerIdValue.toString()); 
            }

            Seller dealer = (Seller) UserDatabase.getUserById(dealerId);
            if (dealer != null) {
                MainFrame.instance.getDealerAccountDetailsPanel().dealer = dealer;
                MainFrame.instance.getDealerAccountDetailsPanel().accountDetailsForCustomer();
                MainFrame.instance.setPage(MainFrame.instance.getDealerAccountDetailsPanel());
            } else {
                JOptionPane.showMessageDialog(this, "Dealer not found. It may have been deleted.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid dealer ID format. Please check the data.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred while fetching dealer details.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_dealerInfoButtonActionPerformed

    private void cancelOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelOrderButtonActionPerformed

        try {
            int selectedRow = tableDark1.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select an order to cancel.", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int orderId = (int) tableModel.getValueAt(selectedRow, 0);
            String status = (String) tableModel.getValueAt(selectedRow, 5);

            if (status.equalsIgnoreCase("Pending")) {
                int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel this order?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    OrderDatabase.deleteOrder(orderId);
                    refreshTable();
                    JOptionPane.showMessageDialog(this, "Order canceled successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Only pending orders can be canceled.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error canceling order.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_cancelOrderButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private SwingComponents.Button backButton;
    private SwingComponents.Button cancelOrderButton;
    private SwingComponents.Button dealerInfoButton;
    private SwingComponents.Label informationLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel myOrdersLabel;
    private SwingComponents.TableDark tableDark1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void PageOn() {
        customer = (Customer) MainFrame.instance.getAccount();
        refreshTable();
    }
}
