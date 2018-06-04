package domaine;

public class Sport {
    private int no;
    private String nom;
    
    public Sport(int no, String nom) { this.no=no; this.nom=nom; }
    public Sport(int no) { this(no, null); }
    
    public int getNo() { return no; }
    public String getNom() { return nom; }
    
    public boolean equals(Object obj) {
        if(obj == null) { return false; }
        if(obj instanceof Sport) {
            return this.no == ((Sport)obj).no;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


    public String toString() { return nom; }
}