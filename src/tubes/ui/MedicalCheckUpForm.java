/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tubes.ui;

/**
 *
 * @author Lenovo
 */
import tubes.Model.MedicalCheckUp;
import tubes.Service.MedicalCheckUpService;
import java.sql.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import tubes.DAO.MedicalCheckUpDAO;
import tubes.DBConnection;

public class MedicalCheckUpForm extends javax.swing.JFrame {
    private MedicalCheckUpService medicalCheckUpService;
    /**
     * Creates new form MedicalCheckUpForm
     */
    public MedicalCheckUpForm(MedicalCheckUpService medicalCheckUpService) throws SQLException {
        this.medicalCheckUpService = medicalCheckUpService;
        initComponents();
        addActionListeners();
        loadMedicalCheckUpList();
    }

   private void addActionListeners() {
        btnScheduleCheckUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    scheduleCheckUp();
                } catch (SQLException ex) {
                    Logger.getLogger(MedicalCheckUpForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backToMainPage();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    updateMedicalCheckUp();
                } catch (SQLException ex) {
                    Logger.getLogger(MedicalCheckUpForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deleteMedicalCheckUp();
                } catch (SQLException ex) {
                    Logger.getLogger(MedicalCheckUpForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

       medicalCheckUpList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String selectedID = medicalCheckUpList.getSelectedValue();
                    try {
                        showMedicalCheckUpDetails(selectedID);
                    } catch (SQLException ex) {
                        Logger.getLogger(MedicalCheckUpForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }
   
   private void backToMainPage() {
        this.dispose();
        new MainPage().setVisible(true);
    }

    private void scheduleCheckUp() throws SQLException {
        String checkUpID = txtCheckUpID.getText();
        Date date = Date.valueOf(txtDate.getText());
        String result = txtResult.getText();
        String typeOfCheckUp = txtTypeOfCheckUp.getText();
        String doctorID = txtDoctorID.getText();
        String patientID = txtPatientID.getText();

        MedicalCheckUp checkUp = new MedicalCheckUp(checkUpID, date, result, typeOfCheckUp, doctorID, patientID);
        medicalCheckUpService.scheduleMedicalCheckUp(checkUp);

        JOptionPane.showMessageDialog(this, "Medical check-up scheduled successfully!");
        loadMedicalCheckUpList();
    }

    private void updateMedicalCheckUp() throws SQLException {
        String checkUpID = txtDetailCheckUpID.getText();
        Date date = Date.valueOf(txtDetailDate.getText());
        String result = txtDetailResult.getText();
        String typeOfCheckUp = txtDetailTypeOfCheckUp.getText();
        String doctorID = txtDetailDoctorID.getText();
        String patientID = txtDetailPatientID.getText();

        MedicalCheckUp checkUp = new MedicalCheckUp(checkUpID, date, result, typeOfCheckUp, doctorID, patientID);
        medicalCheckUpService.updateMedicalCheckUp(checkUp);

        JOptionPane.showMessageDialog(medicalCheckUpDetailsDialog, "Medical check-up updated successfully!");
        loadMedicalCheckUpList();
        medicalCheckUpDetailsDialog.dispose();
    }

    private void deleteMedicalCheckUp() throws SQLException {
        String checkUpID = txtDetailCheckUpID.getText();
        medicalCheckUpService.deleteMedicalCheckUp(checkUpID);

        JOptionPane.showMessageDialog(medicalCheckUpDetailsDialog, "Medical check-up deleted successfully!");
        loadMedicalCheckUpList();
        medicalCheckUpDetailsDialog.dispose();
    }

    private void showMedicalCheckUpDetails(String checkUpID) throws SQLException {
        MedicalCheckUp checkUp = medicalCheckUpService.getMedicalCheckUpById(checkUpID);
        if (checkUp != null) {
            txtDetailCheckUpID.setText(checkUp.getMedicalCheckUpID());
            txtDetailDate.setText(checkUp.getDate().toString());
            txtDetailResult.setText(checkUp.getResult());
            txtDetailTypeOfCheckUp.setText(checkUp.getTypeOfCheckUp());
            txtDetailDoctorID.setText(checkUp.getDoctorID());
            txtDetailPatientID.setText(checkUp.getPatientID());

            medicalCheckUpDetailsDialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Medical check-up not found!");
        }
    }

    private void loadMedicalCheckUpList() throws SQLException {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        List<MedicalCheckUp> checkUps = medicalCheckUpService.getAllMedicalCheckUps();
        for (MedicalCheckUp checkUp : checkUps) {
            listModel.addElement(checkUp.getMedicalCheckUpID());
        }
        medicalCheckUpList.setModel(listModel);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        medicalCheckUpDetailsDialog = new javax.swing.JDialog();
        txtDetailTypeOfCheckUp = new javax.swing.JTextField();
        txtDetailDoctorID = new javax.swing.JTextField();
        txtDetailPatientID = new javax.swing.JTextField();
        txtDetailCheckUpID = new javax.swing.JTextField();
        lblCheckUpID1 = new javax.swing.JLabel();
        lblDate1 = new javax.swing.JLabel();
        lblResult1 = new javax.swing.JLabel();
        lblTypeOfCheckUp1 = new javax.swing.JLabel();
        lblDoctorID1 = new javax.swing.JLabel();
        lblPatientID1 = new javax.swing.JLabel();
        txtDetailDate = new javax.swing.JTextField();
        txtDetailResult = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblCheckUpID = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblResult = new javax.swing.JLabel();
        lblTypeOfCheckUp = new javax.swing.JLabel();
        lblDoctorID = new javax.swing.JLabel();
        lblPatientID = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        txtResult = new javax.swing.JTextField();
        txtTypeOfCheckUp = new javax.swing.JTextField();
        txtDoctorID = new javax.swing.JTextField();
        txtPatientID = new javax.swing.JTextField();
        txtCheckUpID = new javax.swing.JTextField();
        btnScheduleCheckUp = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        medicalCheckUpList = new javax.swing.JList<>();
        btnBack = new javax.swing.JButton();

        medicalCheckUpDetailsDialog.setTitle("Detail");
        medicalCheckUpDetailsDialog.setMinimumSize(new java.awt.Dimension(500, 350));

        lblCheckUpID1.setText("Check-Up ID");

        lblDate1.setText("Date");

        lblResult1.setText("Result");

        lblTypeOfCheckUp1.setText("Type of Check-Up");

        lblDoctorID1.setText("Doctor ID");

        lblPatientID1.setText("Patient ID");

        btnUpdate.setText("Update");

        btnDelete.setText("Delete");

        javax.swing.GroupLayout medicalCheckUpDetailsDialogLayout = new javax.swing.GroupLayout(medicalCheckUpDetailsDialog.getContentPane());
        medicalCheckUpDetailsDialog.getContentPane().setLayout(medicalCheckUpDetailsDialogLayout);
        medicalCheckUpDetailsDialogLayout.setHorizontalGroup(
            medicalCheckUpDetailsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(medicalCheckUpDetailsDialogLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(medicalCheckUpDetailsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(medicalCheckUpDetailsDialogLayout.createSequentialGroup()
                        .addGroup(medicalCheckUpDetailsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCheckUpID1)
                            .addComponent(lblDate1)
                            .addComponent(lblResult1))
                        .addGap(34, 34, 34)
                        .addGroup(medicalCheckUpDetailsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDetailDate)
                            .addComponent(txtDetailResult)
                            .addComponent(txtDetailCheckUpID, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(medicalCheckUpDetailsDialogLayout.createSequentialGroup()
                        .addGroup(medicalCheckUpDetailsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTypeOfCheckUp1)
                            .addComponent(lblDoctorID1)
                            .addComponent(lblPatientID1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(medicalCheckUpDetailsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(medicalCheckUpDetailsDialogLayout.createSequentialGroup()
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDelete))
                            .addComponent(txtDetailTypeOfCheckUp)
                            .addComponent(txtDetailDoctorID)
                            .addGroup(medicalCheckUpDetailsDialogLayout.createSequentialGroup()
                                .addComponent(txtDetailPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        medicalCheckUpDetailsDialogLayout.setVerticalGroup(
            medicalCheckUpDetailsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(medicalCheckUpDetailsDialogLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(medicalCheckUpDetailsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCheckUpID1)
                    .addComponent(txtDetailCheckUpID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(medicalCheckUpDetailsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDate1)
                    .addComponent(txtDetailDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(medicalCheckUpDetailsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblResult1)
                    .addComponent(txtDetailResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(medicalCheckUpDetailsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTypeOfCheckUp1)
                    .addComponent(txtDetailTypeOfCheckUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(medicalCheckUpDetailsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDoctorID1)
                    .addComponent(txtDetailDoctorID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(medicalCheckUpDetailsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPatientID1)
                    .addComponent(txtDetailPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(medicalCheckUpDetailsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText(" Medical Check-Up Form");

        lblCheckUpID.setText("Check-Up ID");

        lblDate.setText("Date");

        lblResult.setText("Result");

        lblTypeOfCheckUp.setText("Type of Check-Up");

        lblDoctorID.setText("Doctor ID");

        lblPatientID.setText("Patient ID");

        btnScheduleCheckUp.setText("Create");

        medicalCheckUpList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(medicalCheckUpList);

        btnBack.setText("Back To Main Page");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCheckUpID)
                                    .addComponent(lblDate)
                                    .addComponent(lblResult))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDate)
                                    .addComponent(txtResult, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                    .addComponent(txtCheckUpID)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTypeOfCheckUp)
                                    .addComponent(lblDoctorID)
                                    .addComponent(lblPatientID))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTypeOfCheckUp)
                                    .addComponent(txtDoctorID)
                                    .addComponent(txtPatientID, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addGap(52, 52, 52)
                                .addComponent(btnScheduleCheckUp)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCheckUpID)
                            .addComponent(txtCheckUpID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDate)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblResult)
                            .addComponent(txtResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTypeOfCheckUp)
                            .addComponent(txtTypeOfCheckUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDoctorID)
                            .addComponent(txtDoctorID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPatientID)
                            .addComponent(txtPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnScheduleCheckUp)
                    .addComponent(btnBack))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException {
        MedicalCheckUpService medicalCheckUpService = new MedicalCheckUpService(new MedicalCheckUpDAO(DBConnection.getConnection()));
        new MedicalCheckUpForm(medicalCheckUpService).setVisible(true);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnScheduleCheckUp;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCheckUpID;
    private javax.swing.JLabel lblCheckUpID1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDate1;
    private javax.swing.JLabel lblDoctorID;
    private javax.swing.JLabel lblDoctorID1;
    private javax.swing.JLabel lblPatientID;
    private javax.swing.JLabel lblPatientID1;
    private javax.swing.JLabel lblResult;
    private javax.swing.JLabel lblResult1;
    private javax.swing.JLabel lblTypeOfCheckUp;
    private javax.swing.JLabel lblTypeOfCheckUp1;
    private javax.swing.JDialog medicalCheckUpDetailsDialog;
    private javax.swing.JList<String> medicalCheckUpList;
    private javax.swing.JTextField txtCheckUpID;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtDetailCheckUpID;
    private javax.swing.JTextField txtDetailDate;
    private javax.swing.JTextField txtDetailDoctorID;
    private javax.swing.JTextField txtDetailPatientID;
    private javax.swing.JTextField txtDetailResult;
    private javax.swing.JTextField txtDetailTypeOfCheckUp;
    private javax.swing.JTextField txtDoctorID;
    private javax.swing.JTextField txtPatientID;
    private javax.swing.JTextField txtResult;
    private javax.swing.JTextField txtTypeOfCheckUp;
    // End of variables declaration//GEN-END:variables
}
