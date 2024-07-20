package Formularios;

import Clases.CConexion;
import Clases.CProductos;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FormPrincipal extends javax.swing.JFrame {
    private File archivoSeleccionado;

    public FormPrincipal() {
        initComponents();
        CConexion objetoConexion = new CConexion();
        objetoConexion.estableceConexion();
        CProductos objetoProductos = new CProductos(objetoConexion.getConnection());
        objetoProductos.MostrarProductos(tablaTotalProductos);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
      
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        fabricante = new javax.swing.JTextField();
        precio = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnExplorar = new javax.swing.JButton();
        txtRuta = new javax.swing.JTextField();
        lblimagen = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTotalProductos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Productos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos"));
        jLabel1.setText("Id");
        jLabel2.setText("Nombre");
        jLabel3.setText("Fabricante");
        jLabel4.setText("Precio");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Foto"));
        btnExplorar.setText("Explorar");
        btnExplorar.addActionListener(this::btnExplorarActionPerformed);
        txtRuta.setEditable(false);
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Imagen seleccionada");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);
        btnEditar.setText("Editar");
        btnEditar.addActionListener(this::btnEditarActionPerformed);
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblimagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExplorar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRuta)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnExplorar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblimagen, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Productos"));
        tablaTotalProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Id", "Nombre", "Fabricante", "Precio", "Imagen"
            }
        ));
        jScrollPane1.setViewportView(tablaTotalProductos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(nombre)
                    .addComponent(fabricante)
                    .addComponent(precio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(fabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
        pack();
    }

    private void btnExplorarActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes", "jpg", "jpeg", "png");
        fc.setFileFilter(filter);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            archivoSeleccionado = fc.getSelectedFile();
            txtRuta.setText(archivoSeleccionado.getAbsolutePath());
            try {
                Image img = ImageIO.read(archivoSeleccionado);
                lblimagen.setIcon(new ImageIcon(img.getScaledInstance(lblimagen.getWidth(), lblimagen.getHeight(), Image.SCALE_SMOOTH)));
            } catch (IOException ex) {
                System.out.println("Error al cargar imagen: " + ex.getMessage());
            }
        }
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            CConexion objetoConexion = new CConexion();
            objetoConexion.estableceConexion();
            CProductos objetoProductos = new CProductos(objetoConexion.getConnection());
            objetoProductos.AgregarProducto(
                    Integer.parseInt(id.getText()), 
                    nombre.getText(), 
                    fabricante.getText(), 
                    Float.parseFloat(precio.getText()), 
                    archivoSeleccionado
            );
            objetoProductos.MostrarProductos(tablaTotalProductos);
        } catch (IOException ex) {
            System.out.println("Error al guardar producto: " + ex.getMessage());
        }
    }

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            CConexion objetoConexion = new CConexion();
            objetoConexion.estableceConexion();
            CProductos objetoProductos = new CProductos(objetoConexion.getConnection());
            objetoProductos.ModificarProducto(
                    Integer.parseInt(id.getText()), 
                    nombre.getText(), 
                    fabricante.getText(), 
                    Float.parseFloat(precio.getText()), 
                    archivoSeleccionado
            );
            objetoProductos.MostrarProductos(tablaTotalProductos);
        } catch (IOException ex) {
            System.out.println("Error al modificar producto: " + ex.getMessage());
        }
    }

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {
        CConexion objetoConexion = new CConexion();
        objetoConexion.estableceConexion();
        CProductos objetoProductos = new CProductos(objetoConexion.getConnection());
        objetoProductos.EliminarProducto(Integer.parseInt(id.getText()));
        objetoProductos.MostrarProductos(tablaTotalProductos);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new FormPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExplorar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JTextField fabricante;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblimagen;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField precio;
    private javax.swing.JTable tablaTotalProductos;
    private javax.swing.JTextField txtRuta;
    // End of variables declaration
}
