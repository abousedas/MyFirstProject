package dao;

import java.util.ArrayList;
import java.util.StringTokenizer;
import domaine.Sport;

public class SportDao {

    private static final String FICHIER_SPORTS = "Sports.txt";
    private final FileReader reader;
    
    public SportDao(FileReader reader) { this.reader=reader; reader.setFile(FICHIER_SPORTS);}

    public ArrayList getListeSports() {
        String[] tabSports = reader.read();
        ArrayList aLst = new ArrayList();
        for (int i = 0; i < tabSports.length; i++) {
            StringTokenizer strT = new StringTokenizer(tabSports[i], ";");
            aLst.add(new Sport(Integer.parseInt(strT.nextToken()), strT.nextToken()));
        }
        return aLst;
    }
}
