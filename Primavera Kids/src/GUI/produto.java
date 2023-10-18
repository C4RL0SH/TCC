/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUI;

import modelo.Produto;
import DAO.ProdutoDAO;
import java.awt.Color;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class produto extends javax.swing.JInternalFrame {

    /**
     * Creates new form produto
     */
    public produto() {
        initComponents();
       Color minhaCor = new Color(255,242,190);
        getContentPane().setBackground(minhaCor);
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        jTable1.setRowSorter(new TableRowSorter(modelo));
        readJTable();
    }

    public void limpar(){
        
        nome.setText("");
        fornecedor.setText("");
        data.setDate(null);
        cate.setSelectedItem(null);
        quant.setText("");
        tama.setText("");
        pp.setText("");
        pc.setText("");
        desc.setText("");
    } 
    
    
    public void readJTable(){
    
    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        ProdutoDAO cdao = new ProdutoDAO();
        
        for(Produto p: cdao.read()){
            
            modelo.addRow(new Object[]{
                p.getCodigo_produto(),
                p.getNome_produto(),
                p.getNome_fornecedor(),
                p.getCategoria(),
                p.getTamanho(),
                p.getData_registro(),
                p.getPreco_produto(),
                p.getPreco_compra(),                                
                p.getDesconto(),
                p.getQuantidade()
            });    
        }}
    
    public void tabela(){
    
    
    nome.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
    fornecedor.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
    cate.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
    tama.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
    data.setDate((Date)jTable1.getValueAt(jTable1.getSelectedRow(), 5));    
    pp.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString());
    pc.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString());
    desc.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 8).toString());
    quant.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 9).toString());
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nome = new javax.swing.JTextField();
        fornecedor = new javax.swing.JTextField();
        data = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        desc = new javax.swing.JTextField();
        quant = new javax.swing.JTextField();
        cate = new javax.swing.JComboBox<>();
        tama = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cod = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        pesq = new javax.swing.JTextField();
        pesquisa = new javax.swing.JButton();
        pc = new javax.swing.JFormattedTextField();
        pp = new javax.swing.JFormattedTextField();
        sal = new javax.swing.JButton();
        edi = new javax.swing.JButton();
        exc = new javax.swing.JButton();
        lim = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 242, 190));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Produto");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/cart.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(1069, 844));

        nome.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        nome.setPreferredSize(new java.awt.Dimension(150, 25));

        fornecedor.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        data.setDateFormatString("dd/MM/yyyy"); // NOI18N
        data.setPreferredSize(new java.awt.Dimension(202, 27));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Fornecedor:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Categoria:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Tamanho:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("Data de Registro:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setText("Preço do Produto:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setText("Preço de Compra:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setText("Desconto:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setText("Quantidade:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Fornecedor", "Categoria", "Tamanho", "Registro", "Preço do Produto", "Preço de Compra", "Desconto", "Quantidade"
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
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(200);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(200);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(120);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(200);
        }

        desc.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        quant.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        cate.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bolsas", "Camisetas", "Calça", "Meia", "Sapatinhos", "Sandálias", "Shorts" }));

        tama.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tama.setPreferredSize(new java.awt.Dimension(150, 25));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Código:");

        cod.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cod.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Pesquisa:");

        pesq.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        pesq.setPreferredSize(new java.awt.Dimension(150, 25));
        pesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesqActionPerformed(evt);
            }
        });

        pesquisa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/zoom.png"))); // NOI18N
        pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaActionPerformed(evt);
            }
        });

        pc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        pc.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        pp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        pp.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        sal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sal.setText("Salvar");
        sal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salActionPerformed(evt);
            }
        });

        edi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        edi.setText("Alterar");
        edi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ediActionPerformed(evt);
            }
        });

        exc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        exc.setText("Excluir");
        exc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excActionPerformed(evt);
            }
        });

        lim.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lim.setText("Limpar");
        lim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pesquisa)
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(exc)
                .addGap(18, 18, 18)
                .addComponent(edi)
                .addGap(18, 18, 18)
                .addComponent(lim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sal, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(tama, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                    .addComponent(cate, 0, 269, Short.MAX_VALUE)
                    .addComponent(fornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                    .addComponent(nome, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(cod))
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11)
                    .addComponent(data, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(quant, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(desc, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pp, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pc, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(17, 17, 17)))
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cod, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(cate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(tama, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pp, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quant, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pesq, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lim, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salActionPerformed

        Produto p = new Produto();
        ProdutoDAO dao = new ProdutoDAO();

        
        p.setNome_produto(nome.getText());        
        p.setNome_fornecedor(fornecedor.getText());
        p.setData_registro(new java.sql.Date (data.getDate().getTime()));
        p.setCategoria(cate.getSelectedItem().toString());
        p.setQuantidade(Integer.parseInt(quant.getText()));
        p.setTamanho(tama.getText());
        p.setPreco_produto(Double.parseDouble(pp.getText()));
        p.setPreco_compra(Double.parseDouble(pc.getText()));
        p.setDesconto(Integer.parseInt(desc.getText()));
        dao.salvar(p);

        limpar();

        readJTable();
    }//GEN-LAST:event_salActionPerformed

    private void ediActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ediActionPerformed

        if (jTable1.getSelectedRow() != -1) {

        Produto p = new Produto();
        ProdutoDAO dao = new ProdutoDAO();

        
        p.setNome_produto(nome.getText());        
        p.setNome_fornecedor(fornecedor.getText());
        p.setData_registro(new java.sql.Date (data.getDate().getTime()));
        p.setCategoria(cate.getSelectedItem().toString());
        p.setQuantidade(Integer.parseInt(quant.getText()));
        p.setTamanho(tama.getText());
        p.setPreco_produto(Double.parseDouble(pp.getText()));
        p.setPreco_compra(Double.parseDouble(pc.getText()));
        p.setDesconto(Integer.parseInt(desc.getText()));
        p.setCodigo_produto((int) jTable1.getValueAt(jTable1.getSelectedRow(), 0));
        dao.atualizar(p);

        limpar();

        readJTable();
        }
    }//GEN-LAST:event_ediActionPerformed

    private void excActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excActionPerformed

        if (jTable1.getSelectedRow() != -1) {

            Produto p = new Produto();
            ProdutoDAO dao = new ProdutoDAO();

            p.setCodigo_produto((int)jTable1.getValueAt(jTable1.getSelectedRow(),0));
            dao.excluir(p);

            limpar();

            readJTable();
        }

    }//GEN-LAST:event_excActionPerformed

    private void limActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limActionPerformed
        limpar();
    }//GEN-LAST:event_limActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (jTable1.getSelectedRow() != -1) {
            tabela();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        if (jTable1.getSelectedRow() != -1) {
            tabela();
        }
    }//GEN-LAST:event_jTable1KeyReleased

    private void pesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesqActionPerformed

    private void pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaActionPerformed
      DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
      final TableRowSorter<TableModel> classificador = new TableRowSorter<>(modelo);
      jTable1.setRowSorter(classificador);
      String Texto = pesq.getText();
      classificador.setRowFilter(RowFilter.regexFilter(Texto, 1));
     
    }//GEN-LAST:event_pesquisaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cate;
    private javax.swing.JTextField cod;
    private com.toedter.calendar.JDateChooser data;
    private javax.swing.JTextField desc;
    private javax.swing.JButton edi;
    private javax.swing.JButton exc;
    private javax.swing.JTextField fornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton lim;
    private javax.swing.JTextField nome;
    private javax.swing.JFormattedTextField pc;
    private javax.swing.JTextField pesq;
    private javax.swing.JButton pesquisa;
    private javax.swing.JFormattedTextField pp;
    private javax.swing.JTextField quant;
    private javax.swing.JButton sal;
    private javax.swing.JTextField tama;
    // End of variables declaration//GEN-END:variables
}
