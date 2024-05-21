import java.util.LinkedList;
import java.util.Iterator;

public class Peminjam {
    private String name;
    private String npm;
    private String email;
    private String telepon;
    private String judulbuku;

    // Constructor
    public Peminjam(String name, String npm, String email, String telepon, String judulbuku) {
        this.name = name;
        this.npm = npm;
        this.email = email;
        this.telepon = telepon;
        this.judulbuku = judulbuku;
    }

    // Getters and Setters (optional)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getJudulBuku() {
        return judulbuku;
    }

    public void setJudulBuku(String judulbuku) {
        this.judulbuku = judulbuku;
    }

    public static void deleteByData(LinkedList<Peminjam> peminjamList, String data) {
        Iterator<Peminjam> iterator = peminjamList.iterator();
        while (iterator.hasNext()) {
            Peminjam peminjam = iterator.next();
            if (peminjam.getJudulBuku().equals(data)) {
                iterator.remove();
            }
        }
    }
}