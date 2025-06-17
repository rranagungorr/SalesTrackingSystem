package CarSalesTracking;

import CorePackage.Customer;
import CorePackage.Seller;
import CorePackage.ITriggerer;
import CorePackage.User;
import CorePackage.Car;
import CorePackage.CarDatabase;
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
public class CustomerCarListPanel extends javax.swing.JPanel implements ITriggerer {

    private Customer customer;

    DefaultTableModel tableModel = new DefaultTableModel();
    String[] columNames = {"Dealer ID", "Name", "Car ID", "Brand", "Model", "Color", "Fuel Type", "Price", "Status"};
    String[] columNamesForDisplayDealers = {"Dealer ID", "Name", "Username", "Phone", "E-mail"};

    public CustomerCarListPanel() {

        initComponents();
        tableModel.setColumnIdentifiers(columNames);
        tableDark1.setModel(tableModel);

    }

    public void refreshTable() {
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(columNames);

        displayDealersButton.setText("Display Dealers");
        buyCarButton.setVisible(true);

        brandLabel.setVisible(true);
        brandFilterJComboBox.setVisible(true);
        typeLabel.setVisible(true);
        typeFilterJComboBox.setVisible(true);
        fuelLabel.setVisible(true);
        fuelFilterJComboBox.setVisible(true);
        dealerLabel.setVisible(true);
        dealerFilterJComboBox.setVisible(true);

        List<Car> cars = CarDatabase.getAllCars();
        for (Car car : cars) {
            Vector<Object> rowData = new Vector<>();

            User user = UserDatabase.getUserById(car.getSellerId());
            if (user instanceof Seller) {
                Seller dealer = (Seller) user;
                rowData.add(dealer.getUserId());
                rowData.add(dealer.getName());
            } else {
                System.err.println("User with ID " + car.getSellerId() + " is not a Seller.");
                continue; 
            }

            rowData.add(car.getCarId());
            rowData.add(car.getBrand());
            rowData.add(car.getModel());
            rowData.add(car.getColor());
            rowData.add(car.getFuelType());
            rowData.add(car.getPrice());
            rowData.add(car.getStatus());

            tableModel.addRow(rowData);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        carListLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDark1 = new SwingComponents.TableDark();
        backButton = new SwingComponents.Button();
        dealerFilterJComboBox = new javax.swing.JComboBox<>();
        brandFilterJComboBox = new javax.swing.JComboBox<>();
        fuelFilterJComboBox = new javax.swing.JComboBox<>();
        typeFilterJComboBox = new javax.swing.JComboBox<>();
        typeLabel = new javax.swing.JLabel();
        dealerLabel = new javax.swing.JLabel();
        brandLabel = new javax.swing.JLabel();
        fuelLabel = new javax.swing.JLabel();
        buyCarButton = new SwingComponents.Button();
        dealerInfoButton = new SwingComponents.Button();
        displayDealersButton = new SwingComponents.Button();

        setBackground(new java.awt.Color(153, 153, 153));
        setPreferredSize(new java.awt.Dimension(900, 529));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        carListLabel.setBackground(new java.awt.Color(102, 102, 102));
        carListLabel.setFont(new java.awt.Font("SansSerif", 2, 48)); // NOI18N
        carListLabel.setForeground(new java.awt.Color(0, 0, 0));
        carListLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        carListLabel.setText("CAR LIST");
        carListLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(carListLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 490, 60));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 840, 320));

        backButton.setBackground(new java.awt.Color(0, 0, 0));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackArrow.png"))); // NOI18N
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        dealerFilterJComboBox.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        dealerFilterJComboBox.setForeground(new java.awt.Color(255, 255, 255));
        dealerFilterJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        dealerFilterJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dealerFilterJComboBoxActionPerformed(evt);
            }
        });
        add(dealerFilterJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 105, -1, 30));

        brandFilterJComboBox.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        brandFilterJComboBox.setForeground(new java.awt.Color(255, 255, 255));
        brandFilterJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        brandFilterJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brandFilterJComboBoxActionPerformed(evt);
            }
        });
        add(brandFilterJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 105, -1, 30));

        fuelFilterJComboBox.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        fuelFilterJComboBox.setForeground(new java.awt.Color(255, 255, 255));
        fuelFilterJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        fuelFilterJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fuelFilterJComboBoxActionPerformed(evt);
            }
        });
        add(fuelFilterJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 105, -1, 30));

        typeFilterJComboBox.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        typeFilterJComboBox.setForeground(new java.awt.Color(255, 255, 255));
        typeFilterJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        typeFilterJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeFilterJComboBoxActionPerformed(evt);
            }
        });
        add(typeFilterJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 105, -1, 30));

        typeLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        typeLabel.setForeground(new java.awt.Color(0, 0, 0));
        typeLabel.setText("Type :");
        add(typeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, -1, -1));

        dealerLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        dealerLabel.setForeground(new java.awt.Color(0, 0, 0));
        dealerLabel.setText("Dealer :");
        add(dealerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        brandLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        brandLabel.setForeground(new java.awt.Color(0, 0, 0));
        brandLabel.setText("Brand :");
        add(brandLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, -1));

        fuelLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        fuelLabel.setForeground(new java.awt.Color(0, 0, 0));
        fuelLabel.setText("Fuel : ");
        add(fuelLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, -1, -1));

        buyCarButton.setBackground(new java.awt.Color(0, 0, 0));
        buyCarButton.setForeground(new java.awt.Color(255, 255, 255));
        buyCarButton.setText("Buy Car");
        buyCarButton.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        buyCarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyCarButtonActionPerformed(evt);
            }
        });
        add(buyCarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 480, 280, -1));

        dealerInfoButton.setBackground(new java.awt.Color(0, 0, 0));
        dealerInfoButton.setForeground(new java.awt.Color(255, 255, 255));
        dealerInfoButton.setText("Dealer Info");
        dealerInfoButton.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        dealerInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dealerInfoButtonActionPerformed(evt);
            }
        });
        add(dealerInfoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 170, -1));

        displayDealersButton.setBackground(new java.awt.Color(0, 0, 0));
        displayDealersButton.setForeground(new java.awt.Color(255, 255, 255));
        displayDealersButton.setText("Display Dealers");
        displayDealersButton.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        displayDealersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayDealersButtonActionPerformed(evt);
            }
        });
        add(displayDealersButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 480, 180, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        MainFrame.instance.setPage(MainFrame.instance.getCustomerControlPanel());
    }//GEN-LAST:event_backButtonActionPerformed

    private void dealerFilterJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dealerFilterJComboBoxActionPerformed
        tableModel.setRowCount(0);
        tableModel.setRowCount(0);

        try {
            String selectedDealerName = (String) dealerFilterJComboBox.getSelectedItem();

            
            List<User> users = UserDatabase.getAllUsers();
            for (User user : users) {
                if (user instanceof Seller) {
                    if (user.getName().equals(selectedDealerName)) {
                        List<Car> cars = CarDatabase.getCarsBySellerId(user.getUserId());
                        for (Car car : cars) {
                            Vector<Object> rowData = new Vector<>();
                            rowData.add(user.getUserId());
                            rowData.add(user.getName());
                            rowData.add(car.getCarId());
                            rowData.add(car.getBrand());
                            rowData.add(car.getModel());
                            rowData.add(car.getColor());
                            rowData.add(car.getFuelType());
                            rowData.add(car.getPrice());
                            rowData.add(car.getStatus());
                            tableModel.addRow(rowData);
                        }
                        break; 
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error filtering by dealer.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_dealerFilterJComboBoxActionPerformed

    private void dealerInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dealerInfoButtonActionPerformed
        try {
            int selectedRow = tableDark1.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "No dealer selected.", "Selection Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Object dealerIdObj = tableModel.getValueAt(selectedRow, 0);
            int dealerId;
            if (dealerIdObj instanceof Integer) {
                dealerId = (Integer) dealerIdObj;
            } else if (dealerIdObj instanceof String) {
                dealerId = Integer.parseInt((String) dealerIdObj);
            } else {
                JOptionPane.showMessageDialog(this, "Dealer ID is not valid.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            User user = UserDatabase.getUserById(dealerId);
            if (user instanceof Seller) {
                Seller dealer = (Seller) user;
                MainFrame.instance.getDealerAccountDetailsPanel().dealer = dealer;
                MainFrame.instance.getDealerAccountDetailsPanel().accountDetailsForCustomer();
                MainFrame.instance.setPage(MainFrame.instance.getDealerAccountDetailsPanel());
            } else {
                JOptionPane.showMessageDialog(this, "Selected user is not a dealer.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Dealer ID is not a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while fetching dealer details.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_dealerInfoButtonActionPerformed

    private void brandFilterJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brandFilterJComboBoxActionPerformed
        tableModel.setRowCount(0);
        try {
            String selectedBrand = (String) brandFilterJComboBox.getSelectedItem();
            List<Car> cars = CarDatabase.getAllCars();

            for (Car car : cars) {
                if (car.getBrand().equals(selectedBrand)) {
                    Seller seller = (Seller) UserDatabase.getUserById(car.getSellerId());
                    Vector<Object> rowData = new Vector<>();
                    rowData.add(seller.getUserId());
                    rowData.add(seller.getName());
                    rowData.add(car.getCarId());
                    rowData.add(car.getBrand());
                    rowData.add(car.getModel());
                    rowData.add(car.getColor());
                    rowData.add(car.getFuelType());
                    rowData.add(car.getPrice());
                    rowData.add(car.getStatus());
                    tableModel.addRow(rowData);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error filtering by brand.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_brandFilterJComboBoxActionPerformed

    private void displayDealersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayDealersButtonActionPerformed

        if (displayDealersButton.getText().equals("Display Dealers")) {
            tableModel.setRowCount(0);
            tableModel.setColumnIdentifiers(columNamesForDisplayDealers);
            displayDealersButton.setText("Display Cars");
            buyCarButton.setVisible(false);

            brandLabel.setVisible(false);
            typeLabel.setVisible(false);
            fuelLabel.setVisible(false);
            dealerLabel.setVisible(false);
            dealerFilterJComboBox.setVisible(true);
            brandFilterJComboBox.setVisible(true);
            typeFilterJComboBox.setVisible(true);
            fuelFilterJComboBox.setVisible(true);

            try {
                List<User> users = UserDatabase.getAllUsers();
                for (User user : users) {
                    if (user instanceof Seller) {
                        Vector<Object> rowData = new Vector<>();
                        rowData.add(user.getUserId());
                        rowData.add(user.getName());
                        rowData.add(user.getUsername());
                        rowData.add(user.getPhone());
                        rowData.add(user.getEmail());
                        tableModel.addRow(rowData);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error displaying dealers.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            refreshTable();
        }

    }//GEN-LAST:event_displayDealersButtonActionPerformed

    private void buyCarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyCarButtonActionPerformed
        try {
            int selectedRow = tableDark1.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a car to buy!", "Selection Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int carId = (int) tableModel.getValueAt(selectedRow, 2);
            Car car = CarDatabase.getCarById(carId);

            if (car == null) {
                JOptionPane.showMessageDialog(this, "Car not found in the database.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (car.getStatus().equals(Car.pending) || car.getStatus().equals(Car.accepted)) {
                JOptionPane.showMessageDialog(this, "This car is not available for purchase.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to buy this car?", "Confirm Purchase", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // Arabanın durumunu güncelle
                CarDatabase.updateCarStatus(car.getCarId(), Car.pending);

                // Orders tablosuna ekle
                int customerId = customer.getUserId();
                String orderStatus = "Pending"; // Sipariş durumu
                OrderDatabase.addOrder(customerId, car.getCarId(), orderStatus);

                JOptionPane.showMessageDialog(this, "Your purchase request has been submitted!", "Success", JOptionPane.INFORMATION_MESSAGE);
                refreshTable();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred while processing your request.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }//GEN-LAST:event_buyCarButtonActionPerformed

    private void typeFilterJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeFilterJComboBoxActionPerformed
        tableModel.setRowCount(0);
        try {
            String selectedType = (String) typeFilterJComboBox.getSelectedItem();
            List<Car> cars = CarDatabase.getAllCars();

            for (Car car : cars) {
                if (car.getModel().equalsIgnoreCase(selectedType)) {
                    Seller dealer = (Seller) UserDatabase.getUserById(car.getSellerId());
                    Vector<Object> rowData = new Vector<>();
                    rowData.add(dealer.getUserId());
                    rowData.add(dealer.getName());
                    rowData.add(car.getCarId());
                    rowData.add(car.getBrand());
                    rowData.add(car.getModel());
                    rowData.add(car.getColor());
                    rowData.add(car.getFuelType());
                    rowData.add(car.getPrice());
                    rowData.add(car.getStatus());
                    tableModel.addRow(rowData);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error filtering by type.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_typeFilterJComboBoxActionPerformed

    private void fuelFilterJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fuelFilterJComboBoxActionPerformed
        tableModel.setRowCount(0);
        try {
            String selectedFuel = (String) fuelFilterJComboBox.getSelectedItem();
            List<Car> cars = CarDatabase.getAllCars();

            for (Car car : cars) {
                if (car.getFuelType().equalsIgnoreCase(selectedFuel)) {
                    Seller dealer = (Seller) UserDatabase.getUserById(car.getSellerId());
                    Vector<Object> rowData = new Vector<>();
                    rowData.add(dealer.getUserId());
                    rowData.add(dealer.getName());
                    rowData.add(car.getCarId());
                    rowData.add(car.getBrand());
                    rowData.add(car.getModel());
                    rowData.add(car.getColor());
                    rowData.add(car.getFuelType());
                    rowData.add(car.getPrice());
                    rowData.add(car.getStatus());
                    tableModel.addRow(rowData);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error filtering by fuel type.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_fuelFilterJComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private SwingComponents.Button backButton;
    private javax.swing.JComboBox<String> brandFilterJComboBox;
    private javax.swing.JLabel brandLabel;
    private SwingComponents.Button buyCarButton;
    private javax.swing.JLabel carListLabel;
    private javax.swing.JComboBox<Object> dealerFilterJComboBox;
    private SwingComponents.Button dealerInfoButton;
    private javax.swing.JLabel dealerLabel;
    private SwingComponents.Button displayDealersButton;
    private javax.swing.JComboBox<String> fuelFilterJComboBox;
    private javax.swing.JLabel fuelLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private SwingComponents.TableDark tableDark1;
    private javax.swing.JComboBox<String> typeFilterJComboBox;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void PageOn() {
        customer = (Customer) MainFrame.instance.getAccount();
        refreshTable();

        dealerFilterJComboBox.removeAllItems();
        brandFilterJComboBox.removeAllItems();
        typeFilterJComboBox.removeAllItems();
        fuelFilterJComboBox.removeAllItems();

        try {
            List<User> users = UserDatabase.getAllUsers();
            for (User user : users) {
                if (user instanceof Seller) {
                    dealerFilterJComboBox.addItem(user.getName());
                }
            }

            for (String brand : Car.carBrand) {
                brandFilterJComboBox.addItem(brand);
            }

            for (String type : Car.carType) {
                typeFilterJComboBox.addItem(type);
            }

            for (String fuel : Car.carFuelType) {
                fuelFilterJComboBox.addItem(fuel);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error initializing filters.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }
}
