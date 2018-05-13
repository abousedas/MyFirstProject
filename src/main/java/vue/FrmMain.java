package vue;

import java.io.InputStream;
import java.util.Properties;
import metier.*;

public class FrmMain extends java.awt.Frame {
    private ListPays listPays = new ListPays();
    private ListDisciplines listDisciplines = new ListDisciplines();
    private ListAthletes listAthletes = new ListAthletes();
    private String version = null;

    public FrmMain() {
        initComponents();
        loadVersion();
        initObservers();
        loadData();
    }

    private void initObservers() {
        listPays.addObserver(new ListPaysObserver(lstPays, listAthletes));
        listDisciplines.addObserver(new ListDisciplinesObserver(lstSports, listAthletes));
        listAthletes.addObserver(new ListAthletesObserver(lstAthletes));
        listAthletes.addObserver(new ListAthletesDetails(tfNo, tfPrenom, tfNom, tfPays, tfSport));
    }

    private void loadData() {
        listPays.chargerDonnes();
        listDisciplines.chargerDonnes();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lstPays = new java.awt.List();
        tfNo = new java.awt.TextField();
        tfPrenom = new java.awt.TextField();
        tfNom = new java.awt.TextField();
        tfPays = new java.awt.TextField();
        lstSports = new java.awt.List();
        lstAthletes = new java.awt.List();
        tfSport = new java.awt.TextField();
        lblVersionTxt = new java.awt.Label();
        lblVersionNbr = new java.awt.Label();

        setTitle("Liste des Athlètes aux JO 2018");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lstPays.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                lstPaysItemStateChanged(evt);
            }
        });

        tfNo.setEditable(false);

        tfPrenom.setEditable(false);

        tfNom.setEditable(false);
        tfNom.setName(""); // NOI18N

        tfPays.setEditable(false);

        lstSports.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                lstSportsItemStateChanged(evt);
            }
        });

        lstAthletes.setName(""); // NOI18N
        lstAthletes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                lstAthletesItemStateChanged(evt);
            }
        });

        tfSport.setEditable(false);

        lblVersionTxt.setText("Version");

        lblVersionNbr.setText("1.0.0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblVersionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(lblVersionNbr, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(lstAthletes, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfPays, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfNom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfPrenom, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(tfNo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lstPays, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lstSports, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lstPays, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(lstSports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(tfNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lstAthletes, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblVersionNbr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVersionTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblVersionNbr.getAccessibleContext().setAccessibleName("lblVersionNbr");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        dispose();
    }//GEN-LAST:event_formWindowClosing
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        System.exit(0);
    }//GEN-LAST:event_formWindowClosed

    private void lstPaysItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_lstPaysItemStateChanged
        listPays.setPos(lstPays.getSelectedIndex());
    }//GEN-LAST:event_lstPaysItemStateChanged

    private void lstSportsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_lstSportsItemStateChanged
        listDisciplines.setPos(lstSports.getSelectedIndex());
    }//GEN-LAST:event_lstSportsItemStateChanged

    private void lstAthletesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_lstAthletesItemStateChanged
        listAthletes.setPos(lstAthletes.getSelectedIndex());
    }//GEN-LAST:event_lstAthletesItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label lblVersionNbr;
    private java.awt.Label lblVersionTxt;
    private java.awt.List lstAthletes;
    private java.awt.List lstPays;
    private java.awt.List lstSports;
    private java.awt.TextField tfNo;
    private java.awt.TextField tfNom;
    private java.awt.TextField tfPays;
    private java.awt.TextField tfPrenom;
    private java.awt.TextField tfSport;
    // End of variables declaration//GEN-END:variables

    private void loadVersion() {
        Properties properties = new Properties();
        version = "N/A";
        try {
            InputStream stream = getClass().getClassLoader().getResourceAsStream("application.properties");
            properties.load(stream);
            version = properties.getProperty("version");
            System.out.println(version);
        } catch (Exception e) { e.printStackTrace(); }
        lblVersionNbr.setText(version);
    }
    
    public String getVersion() {
        if(version != null) { return version; }
        return "N/A";
    }
}
