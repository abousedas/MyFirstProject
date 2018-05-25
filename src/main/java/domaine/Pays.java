package domaine;

public class Pays {
    private int no;
    private String code;
    private String nom;
    
    public Pays(int no, String code, String nom) { this.no=no; this.code=code; this.nom=nom; }
    public Pays(int no) { this(no, null, null); }
    public Pays() { this(-1, null, null); }
    
    public int getNo() { return no; }
    public String getCode() { return code; }
    public String getNom() { return nom; }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) { return false; }
        if(obj instanceof Pays) {
            return this.no == ((Pays)obj).no;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public String toString() { return nom; }
}