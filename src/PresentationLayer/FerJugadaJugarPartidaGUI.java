/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DomainLayer.Excepcions.ExcepcionsAS;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


/**
 *
 * @author joaquin.campos
 */
public class FerJugadaJugarPartidaGUI extends javax.swing.JFrame {

    private int posicioCasellaModificada;
    private String lletraCasellaModificada;
    
    /**
     * Creates new form FerJugadaJugarPartidaGUI
     * @param puntuacioInicial
     * @param nombreMaximErrors
     * @param puntuacioPerEncert
     * @param puntuacioPerError
     * @param nombreCaselles
     */
    
    public FerJugadaJugarPartidaGUI(int puntuacioInicial, int nombreMaximErrors,
                                    int puntuacioPerEncert, int puntuacioPerError,
                                    int nombreCaselles) {
        initComponents();
        mostrarCaselles(nombreCaselles);
        pEncertLabel.setText(String.valueOf(puntuacioPerEncert));
        pErrorLabel.setText(String.valueOf(puntuacioPerError));
        nMaxErrorsLabel.setText(String.valueOf(nombreMaximErrors));
        nEncertsLabel.setText("0");
        nErrorsLabel.setText("0");
        nPuntuacioLabel.setText(String.valueOf(puntuacioInicial));
    
        DocumentListener casellasListener = new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {}
            @Override
            public void removeUpdate(DocumentEvent e) {}
            @Override
            public void insertUpdate(DocumentEvent e) {
                disableCaselles();
                Object owner = e.getDocument().getProperty("owner");
                if (owner == casella0TextField) {
                    posicioCasellaModificada = 0;
                    lletraCasellaModici
                }
                else if (owner == casella1TextField)
                    posicioCasella = 1;
                else if (owner == casella2TextField)
                    posicioCasella = 2;
                else if (owner == casella3TextField)
                    posicioCasella = 3;
                else if (owner == casella4TextField)
                    posicioCasella = 4;
                else if (owner == casella5TextField)
                    posicioCasella = 5;
                else if (owner == casella6TextField)
                    posicioCasella = 6;
                else if (owner == casella7TextField)
                    posicioCasella = 7;
                else if (owner == casella8TextField)
                    posicioCasella = 8;
            }
        };
        
        casella0TextField.getDocument().addDocumentListener(casellasListener);
        casella1TextField.getDocument().addDocumentListener(casellasListener);
        casella2TextField.getDocument().addDocumentListener(casellasListener);
        casella3TextField.getDocument().addDocumentListener(casellasListener);
        casella4TextField.getDocument().addDocumentListener(casellasListener);
        casella5TextField.getDocument().addDocumentListener(casellasListener);
        casella6TextField.getDocument().addDocumentListener(casellasListener);
        casella7TextField.getDocument().addDocumentListener(casellasListener);
        casella8TextField.getDocument().addDocumentListener(casellasListener);
    }
    
    private void disableCaselles() {   
        casella0TextField.setEnabled(false);
        casella1TextField.setEnabled(false);
        casella2TextField.setEnabled(false);
        casella3TextField.setEnabled(false);
        casella4TextField.setEnabled(false);
        casella5TextField.setEnabled(false);
        casella6TextField.setEnabled(false);
        casella7TextField.setEnabled(false);
        casella8TextField.setEnabled(false);     
    }
    
    private void mostrarCaselles(int nombreCaselles) {
        
        switch(nombreCaselles) {
            case 8:
                casella8TextField.setVisible(false);
                break;
            case 7:
                casella8TextField.setVisible(false);
                casella7TextField.setVisible(false);
                break;
            case 6:
                casella8TextField.setVisible(false);
                casella7TextField.setVisible(false);
                casella6TextField.setVisible(false);
                break;
            case 5:
                casella8TextField.setVisible(false);
                casella7TextField.setVisible(false);
                casella6TextField.setVisible(false);
                casella5TextField.setVisible(false);
                break;
            case 4:
                casella8TextField.setVisible(false);
                casella7TextField.setVisible(false);
                casella6TextField.setVisible(false);
                casella5TextField.setVisible(false);
                casella4TextField.setVisible(false);
                break;
            case 3:
                casella8TextField.setVisible(false);
                casella7TextField.setVisible(false);
                casella6TextField.setVisible(false);
                casella5TextField.setVisible(false);
                casella4TextField.setVisible(false);
                casella3TextField.setVisible(false);
                break;
            case 2:
                casella8TextField.setVisible(false);
                casella7TextField.setVisible(false);
                casella6TextField.setVisible(false);
                casella5TextField.setVisible(false);
                casella4TextField.setVisible(false);
                casella3TextField.setVisible(false);
                casella2TextField.setVisible(false);
                break;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        marginHeader = new javax.swing.JPanel();
        casellesPanel = new javax.swing.JPanel();
        casella0TextField = new javax.swing.JTextField();
        casella1TextField = new javax.swing.JTextField();
        casella2TextField = new javax.swing.JTextField();
        casella3TextField = new javax.swing.JTextField();
        casella4TextField = new javax.swing.JTextField();
        casella5TextField = new javax.swing.JTextField();
        casella6TextField = new javax.swing.JTextField();
        casella7TextField = new javax.swing.JTextField();
        casella8TextField = new javax.swing.JTextField();
        staticInfoPanel = new javax.swing.JPanel();
        puntsPerEncertLabel = new javax.swing.JLabel();
        pEncertLabel = new javax.swing.JLabel();
        puntsPerErrorLabel = new javax.swing.JLabel();
        pErrorLabel = new javax.swing.JLabel();
        nombreMaximDErrorsLabel = new javax.swing.JLabel();
        nMaxErrorsLabel = new javax.swing.JLabel();
        dynamicInfoPanel = new javax.swing.JPanel();
        javax.swing.ImageIcon tickImage = new javax.swing.ImageIcon("images/tick.png", "Encerts");
        tickImageLabel = new javax.swing.JLabel(tickImage);
        javax.swing.ImageIcon crossImage = new javax.swing.ImageIcon("images/cross.png", "Errors");
        crossImageLabel = new javax.swing.JLabel(crossImage);
        encertsLabel = new javax.swing.JLabel();
        errorsLabel = new javax.swing.JLabel();
        nEncertsLabel = new javax.swing.JLabel();
        nErrorsLabel = new javax.swing.JLabel();
        puntuacioLabel = new javax.swing.JLabel();
        nPuntuacioLabel = new javax.swing.JLabel();
        enviarLletraButton = new javax.swing.JButton();
        marginButtons = new javax.swing.JPanel();
        aturarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fer Jugada - Jugar Partida");
        setMinimumSize(new java.awt.Dimension(512, 384));
        setResizable(false);
        getContentPane().setLayout(new java.awt.FlowLayout());

        marginHeader.setMinimumSize(new java.awt.Dimension(512, 40));
        marginHeader.setPreferredSize(new java.awt.Dimension(512, 40));

        javax.swing.GroupLayout marginHeaderLayout = new javax.swing.GroupLayout(marginHeader);
        marginHeader.setLayout(marginHeaderLayout);
        marginHeaderLayout.setHorizontalGroup(
            marginHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );
        marginHeaderLayout.setVerticalGroup(
            marginHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(marginHeader);

        casellesPanel.setMaximumSize(new java.awt.Dimension(275, 35));
        casellesPanel.setMinimumSize(new java.awt.Dimension(275, 35));
        casellesPanel.setPreferredSize(new java.awt.Dimension(275, 35));

        casella0TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        casella0TextField.setMinimumSize(new java.awt.Dimension(25, 25));
        casella0TextField.setPreferredSize(new java.awt.Dimension(25, 25));
        casellesPanel.add(casella0TextField);

        casella1TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        casella1TextField.setMinimumSize(new java.awt.Dimension(25, 25));
        casella1TextField.setPreferredSize(new java.awt.Dimension(25, 25));
        casellesPanel.add(casella1TextField);

        casella2TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        casella2TextField.setMinimumSize(new java.awt.Dimension(25, 25));
        casella2TextField.setPreferredSize(new java.awt.Dimension(25, 25));
        casellesPanel.add(casella2TextField);

        casella3TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        casella3TextField.setMinimumSize(new java.awt.Dimension(25, 25));
        casella3TextField.setPreferredSize(new java.awt.Dimension(25, 25));
        casellesPanel.add(casella3TextField);

        casella4TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        casella4TextField.setMinimumSize(new java.awt.Dimension(25, 25));
        casella4TextField.setPreferredSize(new java.awt.Dimension(25, 25));
        casellesPanel.add(casella4TextField);

        casella5TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        casella5TextField.setMinimumSize(new java.awt.Dimension(25, 25));
        casella5TextField.setPreferredSize(new java.awt.Dimension(25, 25));
        casellesPanel.add(casella5TextField);

        casella6TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        casella6TextField.setMinimumSize(new java.awt.Dimension(25, 25));
        casella6TextField.setPreferredSize(new java.awt.Dimension(25, 25));
        casellesPanel.add(casella6TextField);

        casella7TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        casella7TextField.setMinimumSize(new java.awt.Dimension(25, 25));
        casella7TextField.setPreferredSize(new java.awt.Dimension(25, 25));
        casellesPanel.add(casella7TextField);

        casella8TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        casella8TextField.setMinimumSize(new java.awt.Dimension(25, 25));
        casella8TextField.setPreferredSize(new java.awt.Dimension(25, 25));
        casellesPanel.add(casella8TextField);

        getContentPane().add(casellesPanel);

        staticInfoPanel.setMinimumSize(new java.awt.Dimension(200, 90));
        staticInfoPanel.setPreferredSize(new java.awt.Dimension(200, 90));

        puntsPerEncertLabel.setText("Punts per encert:");

        pEncertLabel.setText("pEncert");
        pEncertLabel.setMaximumSize(new java.awt.Dimension(30, 15));
        pEncertLabel.setMinimumSize(new java.awt.Dimension(30, 15));
        pEncertLabel.setPreferredSize(new java.awt.Dimension(30, 15));

        puntsPerErrorLabel.setText("Punts per error:");

        pErrorLabel.setText("pError");
        pErrorLabel.setMaximumSize(new java.awt.Dimension(30, 15));
        pErrorLabel.setMinimumSize(new java.awt.Dimension(30, 15));
        pErrorLabel.setPreferredSize(new java.awt.Dimension(30, 15));

        nombreMaximDErrorsLabel.setText("<html> Nombre màxim <br> \nd'errors:");

        nMaxErrorsLabel.setText("nMaxErrors");

        javax.swing.GroupLayout staticInfoPanelLayout = new javax.swing.GroupLayout(staticInfoPanel);
        staticInfoPanel.setLayout(staticInfoPanelLayout);
        staticInfoPanelLayout.setHorizontalGroup(
            staticInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staticInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(staticInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(staticInfoPanelLayout.createSequentialGroup()
                        .addComponent(puntsPerEncertLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pEncertLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(staticInfoPanelLayout.createSequentialGroup()
                        .addComponent(puntsPerErrorLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(staticInfoPanelLayout.createSequentialGroup()
                        .addComponent(nombreMaximDErrorsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nMaxErrorsLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        staticInfoPanelLayout.setVerticalGroup(
            staticInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staticInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(staticInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(puntsPerEncertLabel)
                    .addComponent(pEncertLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(staticInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(puntsPerErrorLabel)
                    .addComponent(pErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(staticInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(staticInfoPanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(nombreMaximDErrorsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(staticInfoPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(nMaxErrorsLabel))))
        );

        getContentPane().add(staticInfoPanel);

        dynamicInfoPanel.setMinimumSize(new java.awt.Dimension(512, 150));
        dynamicInfoPanel.setPreferredSize(new java.awt.Dimension(512, 150));

        encertsLabel.setText("Encerts:");
        encertsLabel.setMaximumSize(new java.awt.Dimension(58, 32));
        encertsLabel.setMinimumSize(new java.awt.Dimension(58, 32));
        encertsLabel.setPreferredSize(new java.awt.Dimension(58, 32));

        errorsLabel.setText("Errors:");
        errorsLabel.setMaximumSize(new java.awt.Dimension(48, 32));
        errorsLabel.setMinimumSize(new java.awt.Dimension(48, 32));
        errorsLabel.setPreferredSize(new java.awt.Dimension(48, 32));

        nEncertsLabel.setText("nEncert");

        nErrorsLabel.setText("nErrors");

        puntuacioLabel.setText("Puntuació:");

        nPuntuacioLabel.setText("nPunts");

        javax.swing.GroupLayout dynamicInfoPanelLayout = new javax.swing.GroupLayout(dynamicInfoPanel);
        dynamicInfoPanel.setLayout(dynamicInfoPanelLayout);
        dynamicInfoPanelLayout.setHorizontalGroup(
            dynamicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dynamicInfoPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(dynamicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dynamicInfoPanelLayout.createSequentialGroup()
                        .addComponent(crossImageLabel)
                        .addGap(18, 18, 18)
                        .addGroup(dynamicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dynamicInfoPanelLayout.createSequentialGroup()
                                .addComponent(puntuacioLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nPuntuacioLabel))
                            .addGroup(dynamicInfoPanelLayout.createSequentialGroup()
                                .addComponent(errorsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nErrorsLabel))))
                    .addGroup(dynamicInfoPanelLayout.createSequentialGroup()
                        .addComponent(tickImageLabel)
                        .addGap(18, 18, 18)
                        .addComponent(encertsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nEncertsLabel)))
                .addContainerGap(328, Short.MAX_VALUE))
        );
        dynamicInfoPanelLayout.setVerticalGroup(
            dynamicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dynamicInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dynamicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tickImageLabel)
                    .addComponent(encertsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nEncertsLabel))
                .addGap(13, 13, 13)
                .addGroup(dynamicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crossImageLabel)
                    .addComponent(errorsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nErrorsLabel))
                .addGap(18, 18, 18)
                .addGroup(dynamicInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(puntuacioLabel)
                    .addComponent(nPuntuacioLabel))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(dynamicInfoPanel);

        enviarLletraButton.setText("Enviar lletra");
        enviarLletraButton.setMaximumSize(new java.awt.Dimension(120, 25));
        enviarLletraButton.setMinimumSize(new java.awt.Dimension(120, 25));
        enviarLletraButton.setPreferredSize(new java.awt.Dimension(120, 25));
        enviarLletraButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarLletraButtonActionPerformed(evt);
            }
        });
        getContentPane().add(enviarLletraButton);

        marginButtons.setMinimumSize(new java.awt.Dimension(100, 25));
        marginButtons.setPreferredSize(new java.awt.Dimension(100, 25));

        javax.swing.GroupLayout marginButtonsLayout = new javax.swing.GroupLayout(marginButtons);
        marginButtons.setLayout(marginButtonsLayout);
        marginButtonsLayout.setHorizontalGroup(
            marginButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        marginButtonsLayout.setVerticalGroup(
            marginButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        getContentPane().add(marginButtons);

        aturarButton.setText("Aturar");
        aturarButton.setMaximumSize(new java.awt.Dimension(120, 25));
        aturarButton.setMinimumSize(new java.awt.Dimension(120, 25));
        aturarButton.setPreferredSize(new java.awt.Dimension(120, 25));
        aturarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aturarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(aturarButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enviarLletraButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarLletraButtonActionPerformed
        
        JugarPartidaController controlador = new JugarPartidaController();

        try {
            int [] jugada = controlador.enviaLletra(posicioCasella, );
            
            if (jugada[0] == 1) {
                if (jugada[1] == 1){
                    JOptionPane.showMessageDialog(this, "Has guanyat!\nPuntuacio total: " + jugada[3]);
                    controlador.premerAturar();
                    System.exit(0);
                }
                else {
                    nErrorsLabel.setText("" + jugada[4]);
                }
            }
            else if (jugada[1] == 1) {
                JOptionPane.showMessageDialog(this, "Has perdut!\nPuntuacio total: " + jugada[3]);
                    controlador.premerAturar();
                    System.exit(0);
            }
            else {  //No se ha acabado la partida. Actualizamos la vista.
                int numErrors = Integer.parseInt(nErrorsLabel.getText());
                if (jugada[4] != numErrors) //Si ha habido error, se actualiza el label.
                    nErrorsLabel.setText("" + jugada[4]);
                else {
                    int numEncerts = Integer.parseInt(nEncertsLabel.getText());
                    nEncertsLabel.setText(String.valueOf(numEncerts+1));
                }
                nPuntuacioLabel.setText(String.valueOf(jugada[2]));
                
            }
        }
        catch (ExcepcionsAS eAS) {
            if (eAS.getMessage().equals("La lletra es Incorrecta"))JOptionPane.showMessageDialog(this, "Caracter no valid");
        }       

    }//GEN-LAST:event_enviarLletraButtonActionPerformed

    private void aturarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aturarButtonActionPerformed
        new DomainLayer.DomainControllers.JugarPartidaUseCaseController().AturarPartida();
        System.exit(0);
    }//GEN-LAST:event_aturarButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FerJugadaJugarPartidaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FerJugadaJugarPartidaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FerJugadaJugarPartidaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FerJugadaJugarPartidaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FerJugadaJugarPartidaGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aturarButton;
    private javax.swing.JTextField casella0TextField;
    private javax.swing.JTextField casella1TextField;
    private javax.swing.JTextField casella2TextField;
    private javax.swing.JTextField casella3TextField;
    private javax.swing.JTextField casella4TextField;
    private javax.swing.JTextField casella5TextField;
    private javax.swing.JTextField casella6TextField;
    private javax.swing.JTextField casella7TextField;
    private javax.swing.JTextField casella8TextField;
    private javax.swing.JPanel casellesPanel;
    private javax.swing.JLabel crossImageLabel;
    private javax.swing.JPanel dynamicInfoPanel;
    private javax.swing.JLabel encertsLabel;
    private javax.swing.JButton enviarLletraButton;
    private javax.swing.JLabel errorsLabel;
    private javax.swing.JPanel marginButtons;
    private javax.swing.JPanel marginHeader;
    private javax.swing.JLabel nEncertsLabel;
    private javax.swing.JLabel nErrorsLabel;
    private javax.swing.JLabel nMaxErrorsLabel;
    private javax.swing.JLabel nPuntuacioLabel;
    private javax.swing.JLabel nombreMaximDErrorsLabel;
    private javax.swing.JLabel pEncertLabel;
    private javax.swing.JLabel pErrorLabel;
    private javax.swing.JLabel puntsPerEncertLabel;
    private javax.swing.JLabel puntsPerErrorLabel;
    private javax.swing.JLabel puntuacioLabel;
    private javax.swing.JPanel staticInfoPanel;
    private javax.swing.JLabel tickImageLabel;
    // End of variables declaration//GEN-END:variables
}
