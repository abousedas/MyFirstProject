package domaine;

public class Pays {
    private int no;
    private String code;
    private String nom;
    
    public Pays(int no, String code, String nom) { this.no=no; this.code=code; this.nom=nom; }
    public Pays(int no) { this(no, null, null); }
    public Pays() { this(-1, null, null); }
    
    public int getNo() { 
        if(no <= -1) { return -1; } 
        return no;
    }
    public String getCode() { return code != null ? code : null; }
    public String getNom() { return nom != null ? nom : null; }
    
    public boolean equals(Object obj) { return this.no == ((Pays)obj).no; }
    public String toString() { return nom; }
}