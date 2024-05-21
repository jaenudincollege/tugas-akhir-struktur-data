import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAdmin extends JFrame {

    public MenuAdmin(String username) {
        initComponents();
        setLocationRelativeTo(null);
        jLabel1.setText("Selamat datang, " + username);
    }

    private void initComponents() {
        jButton1 = new JButton();
        jLabel1 = new JLabel();
        jButton2 = new JButton();
        jButton4 = new JButton();
        jButton3 = new JButton();
        jButton5 = new JButton();
        JButton logoutButton = new JButton("Logout");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Yu Gothic UI", 1, 24));
        jButton1.setText("TAMBAH BUKU");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Database databaseFrame = new Database();
                databaseFrame.show(true);
                dispose();
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24));
        jLabel1.setText("MENU ADMIN");

        jButton2.setFont(new java.awt.Font("Yu Gothic UI", 1, 24));
        jButton2.setText("DAFTAR BUKU");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jButton3.setText("PENGEMBALIAN BUKU");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });

        jButton4.setFont(new java.awt.Font("Yu Gothic UI", 1, 24));
        jButton4.setText("DAFTAR PINJAM");
        jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                openDaftarPinjamFrame();
                dispose();
            }
        });

        jButton5.setFont(new java.awt.Font("Yu Gothic UI", 1, 24));
        jButton5.setText("PENGEMBALIAN");
        jButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                PengembalianBuku pengembalianFrame = new PengembalianBuku();
                pengembalianFrame.show(true);
                dispose();
            }
        });

        // Logout button
        logoutButton.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Perpustakaan perpustakaanFrame = new Perpustakaan();
                perpustakaanFrame.show(true);
                dispose();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(logoutButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(231, 231, 231)
                                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(75, 75, 75)
                                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(75, 75, 75)
                                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(75, 75, 75)
                                                .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(75, 75, 75)
                                                .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(236, Short.MAX_VALUE))
                        .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                .addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE) // Added logout button
                                .addContainerGap())
        );

        pack();
    }

    private void openDaftarPinjamFrame() {
        DaftarPinjam daftarPinjamFrame = new DaftarPinjam();
        daftarPinjamFrame.show(true);
        dispose(); // Close the current frame
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdmin("admin").setVisible(true);
            }
        });
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // Redirect to the DaftarBuku frame
        DaftarBuku daftarBukuFrame = new DaftarBuku(this);
        daftarBukuFrame.setLocationRelativeTo(null); // Set location to center of screen
        daftarBukuFrame.show(true); // Make the frame visible
        dispose();
    }        

    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JLabel jLabel1;
}