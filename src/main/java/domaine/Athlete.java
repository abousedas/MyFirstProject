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
    public boolean equals(Object obj) { return this.no == ((Athlete)obj).no; }
    @Override
    public String toString() { 
        if(prenom == null && nom == null) { return null; }
        return prenom+" "+nom; }
}