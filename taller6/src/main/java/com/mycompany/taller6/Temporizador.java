
package com.mycompany.taller6;


public class Temporizador extends javax.swing.JFrame {
    
    //ATRIBUTOS
   

    
    //CONTRUCTOR de la ventana
    public Temporizador(int activida, int descanso, int DescansoSet) {
        initComponents();
     
        //OBjeto Cronometro (temporizador) tipo hilo   
        Cronometro tiempo = new Cronometro(activida,descanso, DescansoSet, this);
        //Inicia el hilo
        tiempo.start();
        
        //OBjeto Cronometro1 tipo hilo 
        Cronometro1 time = new Cronometro1(this);
        time.start();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jlabelTime = new javax.swing.JLabel();
        jLabelIndicador = new javax.swing.JLabel();
        jLabelMover = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tiempo Total: ");

        jlabelTime.setBackground(new java.awt.Color(153, 153, 153));
        jlabelTime.setFont(new java.awt.Font("Liberation Sans", 3, 48)); // NOI18N
        jlabelTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelTime.setText("00");
        jlabelTime.setOpaque(true);
        jlabelTime.setRequestFocusEnabled(false);

        jLabelIndicador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIndicador.setText("listo??");

        jLabelMover.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMover.setText("0");
        jLabelMover.setOpaque(true);

        jLabelTotal.setText("0:00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTotal))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlabelTime, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(jLabelIndicador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelMover, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabelTotal))
                        .addGap(78, 78, 78)
                        .addComponent(jlabelTime, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelIndicador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMover, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabelIndicador;
    public javax.swing.JLabel jLabelMover;
    public javax.swing.JLabel jLabelTotal;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel jlabelTime;
    // End of variables declaration//GEN-END:variables
}