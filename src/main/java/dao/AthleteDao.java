package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import domaine.Athlete;
import domaine.Pays;
import domaine.Sport;

public class AthleteDao {

    private static final String FICHIER_ATHLETES = "Athletes.txt";
    private final FileReader reader;
    
    public AthleteDao(FileReader reader) { this.reader=reader; reader.setFile(FICHIER_ATHLETES); }


    public List getListeAthletes(Pays pays, Sport sport) {
        String[] tabAthletes = reader.read();
        ArrayList aLst = new ArrayList();
        for (String tabAthlete : tabAthletes) {
            StringTokenizer strT = new StringTokenizer(tabAthlete, ";");
            Pays p = new Pays(Integer.parseInt(strT.nextToken()));
            Sport s = new Sport(Integer.parseInt(strT.nextToken()));
            if (p.equals(pays) && s.equals(sport)) {
                aLst.add(new Athlete(Integer.parseInt(strT.nextToken()), strT.nextToken(), strT.nextToken(), pays, sport));
            }
        }
        return aLst;
    }
}
