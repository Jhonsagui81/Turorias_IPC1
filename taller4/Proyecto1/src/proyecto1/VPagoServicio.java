package proyecto1;

import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class VPagoServicio extends javax.swing.JInternalFrame {

    public int indiceCuenta;
    public int indiceServicio;
    Clientes[] infoPersona = new Clientes[5];

    public VPagoServicio(Clientes[] persona) {
        this.infoPersona = persona;
        initComponents();
        mostrarInformacionCuentas();
        mostrarInformacionPagos();
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
        comboCuentas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        comboServicio = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Pago de Servicios");

        jLabel1.setText("CUENTA A DEBITAR:");

        comboCuentas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("SERVICIO SOLICITADO:");

        comboServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("MONTO DEL SERVICIO:");

        jButton1.setText("REALIZAR PAGO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(comboCuentas, 0, 367, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(comboServicio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(txtMonto)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Para mostrar la cuenta a la que se le puede debitar el monto
    public void mostrarInformacionCuentas() {
        comboCuentas.removeAllItems();
        for (int i = 0; i < infoPersona.length; i++) {
            if (infoPersona[i].getNombre() != null) {  //si el nombre esta vacio NO SE CUENTA
                for (int j = 0; j < 5; j++) {   // depues de elegir la posicion de la persona, se utilizara este for para recorrer sus cuentas
                    if (infoPersona[i].cuentaAsociada[j].getIdCuenta() != 0) { //Cuentas con id = 0 NO SE CUENTAN 
                        comboCuentas.addItem(infoPersona[i].cuentaAsociada[j].getIdCuenta() + " - Cuenta de " + infoPersona[i].getNombre() + " " + infoPersona[i].getApellido());
                    }
                }
            }
        }
    }
    
    //Elegir el tipo de pago a realizar 
    public void mostrarInformacionPagos() {
        comboServicio.removeAllItems();
        comboServicio.addItem("Luz Electrica");
        comboServicio.addItem("Agua");
        comboServicio.addItem("Servicio Telefonico");
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
        String cantidad = txtMonto.getText();

        if (!txtMonto.getText().isEmpty()) { //validar que el campo no este vacio

            try {
                // pasarlo la cantidad a entero
                double monto = Double.parseDouble(cantidad);

                indiceCuenta = comboCuentas.getSelectedIndex();
                //Para obtener el servicio elegido y pasarlo al historial
                indiceServicio = comboServicio.getSelectedIndex();
                
                //Para determinar el servicio elegido y pasarlo al historial
                String n1;
                switch (indiceServicio) {
                    case 0:
                        n1 = "Luz Electrica";
                        break;
                    case 1:
                        n1 = "Agua";
                        break;
                    default:
                        n1 = "Servicio Telefonico";
                        break;
                }

                // validaciones y operaciones de la ventana
                if (monto > 0) {
                    for (int i = 0; i < infoPersona.length; i++) { // recorre arreglo de clientes
                        if (infoPersona[i].getNombre() != null) { // excepto los que no estan asignados = Null
                            for (int j = 0; j < 5; j++) {  // recorre arreglo de las cuentas del cliente al 
                                if (infoPersona[i].cuentaAsociada[j].getIdCuenta() == (indiceCuenta + 1)) { //valida que un cliente tenga el id de la cuenta
                                    //validar que el monto no supere el saldo de la cuenta 
                                    if (infoPersona[i].cuentaAsociada[j].getSaldoCuenta() >= monto) {   // validar que el monto a debitar sea mayor al saldo de la cuenta
                                        infoPersona[i].cuentaAsociada[j].retirarSaldo(monto);   // de cumplirse, se retira el fondo
                                        JOptionPane.showMessageDialog(null, "Pago realizado exitosamente.");

                                        // Realizar asignacion al historial
                                        LocalDateTime horaFecha = LocalDateTime.now(); //guardar la fecha y la hora
                                        String info = "Pago de servicio - " + n1;   // guardar la descripcion de la operacion
                                        double saldoActual = infoPersona[i].cuentaAsociada[j].getSaldoCuenta();
                                        infoPersona[i].cuentaAsociada[j].AsociarOperacion(Proyecto1.ContadorOperaciones, horaFecha, info, monto, 0, saldoActual); //asignar datos a la operacion
                                        Proyecto1.ContadorOperaciones++; //aumenta la cantidad de operaciones

                                    } else {
                                        JOptionPane.showMessageDialog(null, "La cuenta origen no tiene suficientes fondos.");
                                    }
                                }
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El monto del deposito debe ser mayor a cero.");
                }
                txtMonto.setText("");
                // FINALIZA
                
            } catch (Exception Ex) {
                JOptionPane.showMessageDialog(null, "¡Ingrese los datos como lo indica el manual de usuario!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "¡Debe rellenar todos los campos!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboCuentas;
    private javax.swing.JComboBox<String> comboServicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
