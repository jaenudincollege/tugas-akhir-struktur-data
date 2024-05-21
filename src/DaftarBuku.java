import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.table.DefaultTableModel;

public class DaftarBuku extends javax.swing.JFrame {

    public DaftarBuku() {
        initComponents();
        setLocationRelativeTo(null);
        addListeners();
    }

    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24));
        jLabel1.setText("Daftar Buku");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Buku", "Penulis", "Kategori", "ISBN"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        updateTable();

        jButton2.setFont(new java.awt.Font("Arial Narrow", 1, 14));
        jButton2.setText("MENU ADMIN");

        jButton3.setFont(new java.awt.Font("Arial Narrow", 1, 14));
        jButton3.setText("MENU USER");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGap(116, 116, 116))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jButton2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(78, 78, 78)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    )
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(36, 36, 36))
        );

        pack();
    }


    private void addListeners() {
        // Action listener for MENU ADMIN button
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                openAdminFrame();
            }
        });

        // Action listener for MENU USER button
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                openUserFrame();
            }
        });
    }

    private void openAdminFrame() {
        MenuAdmin adminFrame = new MenuAdmin("admin");
        adminFrame.setVisible(true);
        dispose(); // Close the current frame
    }

    private void openUserFrame() {
        User userFrame = new User();
        userFrame.setVisible(true);
        dispose(); // Close the current frame
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DaftarBuku().setVisible(true);
            }
        });
    }

    private void updateTable() {
        // Remove existing rows from the jTable
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        // Add rows corresponding to each book in the bookList
        LinkedList<Book> bookList = Database.getBookList();
        for (Book book : bookList) {
            Object[] row = { book.getName(), book.getAuthor(), book.getCategory(), book.getIsbn() };
            model.addRow(row);
        }
    }

    private User userFrame;
    private MenuAdmin adminFrame;

    public DaftarBuku(User userFrame) {
        initComponents();
        this.userFrame = userFrame;
        addListeners();
        hideMenuAdminButton();
    }

    public DaftarBuku(MenuAdmin adminFrame) {
        initComponents();
        this.adminFrame = adminFrame;
        addListeners();
        hideMenuUserButton();
    }

    private void hideMenuAdminButton() {
        jButton2.setVisible(false);
    }

    private void hideMenuUserButton() {
        jButton3.setVisible(false);
    }

    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}