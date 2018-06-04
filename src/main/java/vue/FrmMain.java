package vue;

import metier.*;

public class FrmMain extends java.awt.Frame {
    protected ListPays listPays = new ListPays(); //NOSONAR
    protected ListDisciplines listDisciplines = new ListDisciplines(); //NOSONAR
    protected ListAthletes listAthletes = new ListAthletes(); //NOSONAR

    public FrmMain() {
        initComponents();
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

        setTitle("Liste des Athlètes aux JO 2018");
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            @Override
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

        tfPays.setEditable(false);

        lstSports.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                lstSportsItemStateChanged(evt);
            }
        });

        lstAthletes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                lstAthletesItemStateChanged(evt);
            }
        });

        tfSport.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
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
                        .addComponent(lstAthletes, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing //NOSONAR
        dispose();
    }//GEN-LAST:event_formWindowClosing
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed //NOSONAR
        System.exit(0);
    }//GEN-LAST:event_formWindowClosed

    private void lstPaysItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_lstPaysItemStateChanged //NOSONAR
        listPays.setPos(lstPays.getSelectedIndex());
    }//GEN-LAST:event_lstPaysItemStateChanged

    private void lstSportsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_lstSportsItemStateChanged //NOSONAR
        listDisciplines.setPos(lstSports.getSelectedIndex());
    }//GEN-LAST:event_lstSportsItemStateChanged

    private void lstAthletesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_lstAthletesItemStateChanged //NOSONAR
        listAthletes.setPos(lstAthletes.getSelectedIndex());
    }//GEN-LAST:event_lstAthletesItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.List lstAthletes;
    private java.awt.List lstPays;
    private java.awt.List lstSports;
    private java.awt.TextField tfNo;
    private java.awt.TextField tfNom;
    private java.awt.TextField tfPays;
    private java.awt.TextField tfPrenom;
    private java.awt.TextField tfSport;
    // End of variables declaration//GEN-END:variables

}
