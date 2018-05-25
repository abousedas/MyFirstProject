package domaine;

public class Athlete {
    private int no;
    private String prenom;
    private String nom;
    private Pays pays;
    private Sport sport;
    
    public Athlete(int no, String prenom, String nom, Pays pays, Sport sport) { this.no=no; this.prenom=prenom; this.nom=nom; this.pays=pays; this.sport=sport; }
    public Athlete(int no) { this(no, null, null, null, null); }
    
    public int getNo() { return no; }
    public String getPrenom() { return prenom; }
    public String getNom() { return nom; }
    public Pays getPays() { return pays; }
    public Sport getSport() { return sport; }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null) { return false; }
        if(obj instanceof Athlete) {
            return this.no == ((Athlete) obj).no;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        if(nom == null) { return prenom == null ? "" : prenom; }
        return prenom+" "+nom;
    }
}