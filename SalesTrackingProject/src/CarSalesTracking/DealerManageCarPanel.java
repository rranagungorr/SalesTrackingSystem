package CarSalesTracking;

import CorePackage.*;
import Main.MainFrame;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rana
 */
public class DealerManageCarPanel extends javax.swing.JPanel implements ITriggerer {

    private Seller dealer;

    DefaultTableModel tableModel = new DefaultTableModel();
    String[] columNames = {"ID", "Brand", "Model", "Color","Fuel Type", "Price", "Status"};

    public DealerManageCarPanel() {
        initComponents();
        tableModel.setColumnIdentifiers(columNames);
        tableDark1.setModel(tableModel);

    }

    public void refreshTable() {
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(columNames);

        try {
            List<Car> cars = CarDatabase.getCarsBySellerId(dealer.getUserId());
            for (Car car : cars) {
                Vector<Object> rowData = new Vector<>();
                rowData.add(car.getCarId());
                rowData.add(car.getBrand());
                rowData.add(car.getModel());
                rowData.add(car.getColor());
                rowData.add(car.getFuelType());
                rowData.add(car.getPrice());
                rowData.add(car.getStatus());

                tableModel.addRow(rowData);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading cars.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myCarsLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDark1 = new SwingComponents.TableDark();
        addCarButton = new SwingComponents.Button();
        deleteCarButton = new SwingComponents.Button();
        backButton = new SwingComponents.Button();

        setBackground(new java.awt.Color(153, 153, 153));
        setMinimumSize(new java.awt.Dimension(900, 529));
        setPreferredSize(new java.awt.Dimension(900, 529));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        myCarsLabel.setBackground(new java.awt.Color(102, 102, 102));
        myCarsLabel.setFont(new java.awt.Font("SansSerif", 2, 42)); // NOI18N
        myCarsLabel.setForeground(new java.awt.Color(0, 0, 0));
        myCarsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        myCarsLabel.setText("MY CARS");
        myCarsLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(myCarsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 350, 60));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 840, 320));

        addCarButton.setBackground(new java.awt.Color(0, 0, 0));
        addCarButton.setForeground(new java.awt.Color(255, 255, 255));
        addCarButton.setText("Add Car");
        addCarButton.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        addCarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCarButtonActionPerformed(evt);
            }
        });
        add(addCarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, 180, -1));

        deleteCarButton.setBackground(new java.awt.Color(0, 0, 0));
        deleteCarButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteCarButton.setText("Delete Car");
        deleteCarButton.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        deleteCarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCarButtonActionPerformed(evt);
            }
        });
        add(deleteCarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 460, 180, -1));

        backButton.setBackground(new java.awt.Color(0, 0, 0));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackArrow.png"))); // NOI18N
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        MainFrame.instance.setPage(MainFrame.instance.getDealerControlPanel());
    }//GEN-LAST:event_backButtonActionPerformed

    private void addCarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCarButtonActionPerformed
        MainFrame.instance.setPage(MainFrame.instance.getDealerAddCarPanel());
    }//GEN-LAST:event_addCarButtonActionPerformed

    private void deleteCarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCarButtonActionPerformed
        try {
            int selectedRow = tableDark1.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "No Data Selected from the Table.",
                        "Selection Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int carId = (Integer) tableModel.getValueAt(selectedRow, 0);
            String carStatus = (String) tableModel.getValueAt(selectedRow, 6);

            if (carStatus.equals(Car.accepted)) {
                JOptionPane.showMessageDialog(this, "This car cannot be deleted because it has been sold.",
                        "Incorrect Operation", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (carStatus.equals(Car.pending)) {
                JOptionPane.showMessageDialog(this, "This car cannot be deleted because it has a pending request.",
                        "Incorrect Operation", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Do you really want to delete this car?",
                    "WARNING", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                CarDatabase.deleteCar(carId);
                refreshTable();
                JOptionPane.showMessageDialog(this, "Car deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error deleting car.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }//GEN-LAST:event_deleteCarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private SwingComponents.Button addCarButton;
    private SwingComponents.Button backButton;
    private SwingComponents.Button deleteCarButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel myCarsLabel;
    private SwingComponents.TableDark tableDark1;
    // End of variables declaration//GEN-END:variables

    public void PageOn() {
        dealer = (Seller) MainFrame.instance.getAccount();
        refreshTable();
    }
}
