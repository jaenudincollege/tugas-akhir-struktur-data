import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.LinkedList;

public class PengembalianBuku extends JFrame {

    private static LinkedList<Peminjam> peminjamList = new LinkedList<>();

    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JTextField jTextField1;

    public PengembalianBuku() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jLabel1 = new JLabel();
        jTextField1 = new JTextField();
        jButton1 = new JButton();
        jButton2 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] { "Nama", "NPM", "Email", "Telepon", "Judul Buku" }
        ));
        jScrollPane1.setViewportView(jTable1);
        updateTable();

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14));
        jLabel1.setText("Judul Buku");

        jButton1.setFont(new java.awt.Font("Arial Narrow", 1, 14));
        jButton1.setText("Kembalikan Buku (Hapus)");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial Narrow", 1, 14));
        jButton2.setText("MENU ADMIN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new MenuAdmin("admin").setVisible(true);
                dispose();
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 82,
                                                                        GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE,
                                                                        122, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jButton1, GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addComponent(jButton2)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 22,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        LinkedList<Peminjam> peminjamList = PeminjamBuku.getPeminjamList();
        String dataToDelete = jTextField1.getText();
        Peminjam.deleteByData(peminjamList, dataToDelete);
        updateTable();
    }

    private void updateTable() {
        // Remove existing rows from the jTable
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        // Add rows corresponding to each book in the bookList
        LinkedList<Peminjam> peminjamList = PeminjamBuku.getPeminjamList();
        for (Peminjam peminjam : peminjamList) {
            Object[] row = { peminjam.getName(), peminjam.getNpm(), peminjam.getEmail(), peminjam.getTelepon(), peminjam.getJudulBuku() };
            model.addRow(row);
        }
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PengembalianBuku().setVisible(true);
            }
        });
    }

    public void deleteByData(String data) {
        if (peminjamList == null || peminjamList.isEmpty()) return;

        Peminjam toRemove = null;
        for (Peminjam peminjam : peminjamList) {
            if (peminjam.getJudulBuku().equals(data)) {
                toRemove = peminjam;
                break;
            }
        }

        if (toRemove != null) {
            peminjamList.remove(toRemove);
            System.out.println("Deleted: " + toRemove);
        } else {
            System.out.println("Data not found: " + data);
        }
    }

    public static LinkedList<Peminjam> getPeminjamList() {
        return peminjamList;
    }
}
