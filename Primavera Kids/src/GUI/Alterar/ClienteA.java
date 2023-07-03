
package GUI.Alterar;

import GUI.cadastrar.*;
import GUI.*;
import DAO.ClienteDAO;
import modelo.Cliente;
import java.awt.Graphics;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author Carlos
 */
public class ClienteA extends javax.swing.JInternalFrame {

    /**
     * Creates new form Cliente
     */
    public ClienteA() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        jTable1.setRowSorter(new TableRowSorter(modelo));

        readJTable();
    
    }

    public void readJTable(){
        
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        ClienteDAO pdao = new ClienteDAO();
        
        for(Cliente c: pdao.read()){
            
            modelo.addRow(new Object[]{
            
            c.getId_cliente(),
            c.getNome_cliente(),
            c.getCpf_cliente(),
            c.getRg_cliente(),
            c.getEmail_cliente(),
            c.getEndereco_cliente(),
            c.getTelefone_cliente(),
            c.getIdade_cliente(),
            c.getData_nascimento_cliente(),
            c.getSexo_cliente()
            
            });
        
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

        nome = new javax.swing.JTextField();
        rg = new javax.swing.JFormattedTextField();
        cpf = new javax.swing.JFormattedTextField();
        email = new javax.swing.JTextField();
        sexo = new javax.swing.JComboBox<>();
        endereco = new javax.swing.JTextField();
        telefone = new javax.swing.JFormattedTextField();
        data = new com.toedter.calendar.JDateChooser();
        idade = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        salvar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setMinimumSize(new java.awt.Dimension(1270, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 350, 30));

        try {
            rg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(rg, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 350, 30));

        try {
            cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 350, 30));
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 350, 30));

        sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feminino", "Masculino" }));
        getContentPane().add(sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 350, 30));
        getContentPane().add(endereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 120, 290, 30));

        try {
            telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(telefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 180, 300, 30));

        data.setDateFormatString("yyyy/MM/dd"); // NOI18N
        getContentPane().add(data, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 240, 300, 30));
        getContentPane().add(idade, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 290, 300, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "RG", "Email", "Endereço", "Telefone", "Idade", "Data_Nascimento", "Sexo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 350, 700, 310));

        salvar.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        salvar.setText("Editar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });
        getContentPane().add(salvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, 160, 100));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Cliente.png"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(999999, 999999));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
    if (jTable1.getSelectedRow() != -1) {
    Cliente cliente = new Cliente();
    ClienteDAO dao = new ClienteDAO();
    
    cliente.setNome_cliente(nome.getText());
    cliente.setCpf_cliente(cpf.getText());
    cliente.setRg_cliente(rg.getText());
    cliente.setEmail_cliente(email.getText());
    cliente.setEndereco_cliente(endereco.getText());
    cliente.setTelefone_cliente(telefone.getText());
    cliente.setIdade_cliente(Integer.parseInt(idade.getText()));
    cliente.setData_nascimento_cliente(data.getDate());
    cliente.setSexo_cliente(sexo.getSelectedItem().toString());
    dao.atualizar(cliente);
    
    nome.setText("");
    cpf.setText("");
    rg.setText("");
    email.setText("");
    endereco.setText("");
    telefone.setText("");
    idade.setText("");
    data.setDateFormatString("");
    sexo.setSelectedItem("null");
    readJTable();
    }
    }//GEN-LAST:event_salvarActionPerformed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
    if (jTable1.getSelectedRow() != -1) {
      
        nome.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        cpf.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
        rg.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
        email.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
        endereco.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());
        telefone.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString());
        idade.setText(jTable1.getValueAt(jTable1.getSelectedRow(),7).toString());
        data.setDateFormatString(jTable1.getValueAt(jTable1.getSelectedRow(),8).toString());
        sexo.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(),9).toString());
      
      
      }
    }//GEN-LAST:event_jTable1KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    if (jTable1.getSelectedRow() != -1) {
      
       nome.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        cpf.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
        rg.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
        email.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
        endereco.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());
        telefone.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString());
        idade.setText(jTable1.getValueAt(jTable1.getSelectedRow(),7).toString());
        data.setDateFormatString(jTable1.getValueAt(jTable1.getSelectedRow(),8).toString());
        sexo.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(),9).toString());    
      
      }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField cpf;
    private com.toedter.calendar.JDateChooser data;
    private javax.swing.JTextField email;
    private javax.swing.JTextField endereco;
    private javax.swing.JTextField idade;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nome;
    private javax.swing.JFormattedTextField rg;
    private javax.swing.JButton salvar;
    private javax.swing.JComboBox<String> sexo;
    private javax.swing.JFormattedTextField telefone;
    // End of variables declaration//GEN-END:variables
}
