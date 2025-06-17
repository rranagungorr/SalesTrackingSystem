package CarSalesTracking;

import CorePackage.Seller;
import CorePackage.ITriggerer;
import CorePackage.Car;
import CorePackage.CarDatabase;
import Main.MainFrame;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author rana
 */
public class DealerAddCarPanel extends javax.swing.JPanel implements ITriggerer {

    public DealerAddCarPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addCarPanelLabel = new javax.swing.JLabel();
        backButton = new SwingComponents.Button();
        modelLabel = new SwingComponents.Label();
        fuelTypejComboBox = new javax.swing.JComboBox<>();
        priceLabel = new SwingComponents.Label();
        brandLabel = new SwingComponents.Label();
        typeLabel = new SwingComponents.Label();
        txtPrice = new SwingComponents.TextField();
        txtModel = new SwingComponents.TextField();
        typejComboBox = new javax.swing.JComboBox<>();
        colorLabel = new SwingComponents.Label();
        yearLabel = new SwingComponents.Label();
        yearjComboBox = new javax.swing.JComboBox<>();
        fuelTypeLabel = new SwingComponents.Label();
        txtColor = new SwingComponents.TextField();
        addCarButton = new SwingComponents.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        brandjList = new javax.swing.JList<>();

        setBackground(new java.awt.Color(153, 153, 153));
        setMinimumSize(new java.awt.Dimension(900, 529));
        setPreferredSize(new java.awt.Dimension(900, 529));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addCarPanelLabel.setBackground(new java.awt.Color(102, 102, 102));
        addCarPanelLabel.setFont(new java.awt.Font("SansSerif", 2, 48)); // NOI18N
        addCarPanelLabel.setForeground(new java.awt.Color(0, 0, 0));
        addCarPanelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addCarPanelLabel.setText("ADD CAR PANEL");
        addCarPanelLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(addCarPanelLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 490, 60));

        backButton.setBackground(new java.awt.Color(0, 0, 0));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackArrow.png"))); // NOI18N
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        modelLabel.setBackground(new java.awt.Color(153, 153, 153));
        modelLabel.setForeground(new java.awt.Color(0, 0, 0));
        modelLabel.setText("Model :");
        modelLabel.setFont(new java.awt.Font("Segoe UI Light", 3, 28)); // NOI18N
        add(modelLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 180, 40));

        fuelTypejComboBox.setBackground(new java.awt.Color(153, 153, 153));
        fuelTypejComboBox.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        fuelTypejComboBox.setForeground(new java.awt.Color(0, 0, 0));
        fuelTypejComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(fuelTypejComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, 180, 40));

        priceLabel.setBackground(new java.awt.Color(153, 153, 153));
        priceLabel.setForeground(new java.awt.Color(0, 0, 0));
        priceLabel.setText("Price :");
        priceLabel.setFont(new java.awt.Font("Segoe UI Light", 3, 28)); // NOI18N
        add(priceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, 180, 40));

        brandLabel.setBackground(new java.awt.Color(153, 153, 153));
        brandLabel.setForeground(new java.awt.Color(0, 0, 0));
        brandLabel.setText("Brand :");
        brandLabel.setFont(new java.awt.Font("Segoe UI Light", 3, 28)); // NOI18N
        add(brandLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 180, 40));

        typeLabel.setBackground(new java.awt.Color(153, 153, 153));
        typeLabel.setForeground(new java.awt.Color(0, 0, 0));
        typeLabel.setText("Type :");
        typeLabel.setFont(new java.awt.Font("Segoe UI Light", 3, 28)); // NOI18N
        add(typeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 180, 40));

        txtPrice.setForeground(new java.awt.Color(0, 0, 0));
        txtPrice.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 410, 180, 40));

        txtModel.setForeground(new java.awt.Color(0, 0, 0));
        txtModel.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        add(txtModel, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 180, 40));

        typejComboBox.setBackground(new java.awt.Color(153, 153, 153));
        typejComboBox.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        typejComboBox.setForeground(new java.awt.Color(0, 0, 0));
        typejComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(typejComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 180, 40));

        colorLabel.setBackground(new java.awt.Color(153, 153, 153));
        colorLabel.setForeground(new java.awt.Color(0, 0, 0));
        colorLabel.setText("Color :");
        colorLabel.setFont(new java.awt.Font("Segoe UI Light", 3, 28)); // NOI18N
        add(colorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 180, 40));

        yearLabel.setBackground(new java.awt.Color(153, 153, 153));
        yearLabel.setForeground(new java.awt.Color(0, 0, 0));
        yearLabel.setText("Year :");
        yearLabel.setFont(new java.awt.Font("Segoe UI Light", 3, 28)); // NOI18N
        add(yearLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 180, 40));

        yearjComboBox.setBackground(new java.awt.Color(153, 153, 153));
        yearjComboBox.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        yearjComboBox.setForeground(new java.awt.Color(0, 0, 0));
        yearjComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        yearjComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearjComboBoxActionPerformed(evt);
            }
        });
        add(yearjComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, 180, 40));

        fuelTypeLabel.setBackground(new java.awt.Color(153, 153, 153));
        fuelTypeLabel.setForeground(new java.awt.Color(0, 0, 0));
        fuelTypeLabel.setText("Fuel Type :");
        fuelTypeLabel.setFont(new java.awt.Font("Segoe UI Light", 3, 28)); // NOI18N
        add(fuelTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 180, 40));

        txtColor.setForeground(new java.awt.Color(0, 0, 0));
        txtColor.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        add(txtColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, 180, 40));

        addCarButton.setBackground(new java.awt.Color(0, 0, 0));
        addCarButton.setForeground(new java.awt.Color(255, 255, 255));
        addCarButton.setText("Add Car");
        addCarButton.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        addCarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCarButtonActionPerformed(evt);
            }
        });
        add(addCarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 480, 180, -1));

        brandjList.setBackground(new java.awt.Color(235, 235, 235));
        brandjList.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        brandjList.setForeground(new java.awt.Color(0, 0, 0));
        brandjList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(brandjList);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 170, 210));
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        MainFrame.instance.setPage(MainFrame.instance.getDealerManageCarPanel());
    }//GEN-LAST:event_backButtonActionPerformed

    private void addCarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCarButtonActionPerformed
        Seller dealer = (Seller) MainFrame.instance.getAccount();
        if (txtModel.getText().isEmpty() || txtColor.getText().isEmpty() || txtPrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fill All Entries.",
                    "Failure", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            double price = Double.parseDouble(txtPrice.getText());
            int year = Integer.parseInt((String) yearjComboBox.getSelectedItem());

            Car car = new Car(
                    0, 
                    brandjList.getSelectedValue(),
                    txtModel.getText(),
                    txtColor.getText(),
                    fuelTypejComboBox.getSelectedItem().toString(),
                    price,
                    Car.available,
                    dealer.getUserId()
            );

            CarDatabase.addCar(car);

            JOptionPane.showMessageDialog(this, "Successfully Created A Car ",
                    "Operation Successful", JOptionPane.INFORMATION_MESSAGE);

            // Formu sıfırla
            brandjList.setSelectedIndex(0);
            txtModel.setText("");
            typejComboBox.setSelectedIndex(0);
            txtColor.setText("");
            yearjComboBox.setSelectedIndex(0);
            fuelTypejComboBox.setSelectedIndex(0);
            txtPrice.setText("");

            MainFrame.instance.setPage(MainFrame.instance.getDealerManageCarPanel());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Price must be a numeric value.",
                    "Failure", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred while adding the car.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }


    }//GEN-LAST:event_addCarButtonActionPerformed

    private void yearjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearjComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearjComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private SwingComponents.Button addCarButton;
    private javax.swing.JLabel addCarPanelLabel;
    private SwingComponents.Button backButton;
    private SwingComponents.Label brandLabel;
    private javax.swing.JList<String> brandjList;
    private SwingComponents.Label colorLabel;
    private SwingComponents.Label fuelTypeLabel;
    private javax.swing.JComboBox<String> fuelTypejComboBox;
    private javax.swing.JScrollPane jScrollPane1;
    private SwingComponents.Label modelLabel;
    private SwingComponents.Label priceLabel;
    private SwingComponents.TextField txtColor;
    private SwingComponents.TextField txtModel;
    private SwingComponents.TextField txtPrice;
    private SwingComponents.Label typeLabel;
    private javax.swing.JComboBox<String> typejComboBox;
    private SwingComponents.Label yearLabel;
    private javax.swing.JComboBox<String> yearjComboBox;
    // End of variables declaration//GEN-END:variables

    @Override
    public void PageOn() {
        typejComboBox.removeAllItems();
        yearjComboBox.removeAllItems();
        fuelTypejComboBox.removeAllItems();

        DefaultListModel<String> model = new DefaultListModel<>();
        for (int i = 0; i < Car.carBrand.length; i++) {
            model.addElement(String.valueOf(Car.carBrand[i]));
        }
        brandjList.setModel(model);

        for (int i = 0; i < Car.carType.length; i++) {
            typejComboBox.addItem(Car.carType[i]);
        }

        for (int i = 2002; i <= 2023; i++) {
            yearjComboBox.addItem(i + "");
        }

        for (int i = 0; i < Car.carFuelType.length; i++) {
            fuelTypejComboBox.addItem(Car.carFuelType[i]);
        }

    }
}
