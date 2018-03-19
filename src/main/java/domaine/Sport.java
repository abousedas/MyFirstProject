package domaine;

public class Sport {
    private int no;
    private String nom;
    
    public Sport(int no, String nom) { this.no=no; this.nom=nom; }
    public Sport(int no) { this(no, ""); }
    
    public int getNo() { return no; }
    public String getNom() { return nom; }
    
    public boolean equals(Object obj) { return this.no == ((Sport)obj).no; }
    public String toString() { return nom; }
}