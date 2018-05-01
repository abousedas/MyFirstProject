package dao;

import java.util.ArrayList;
import java.util.StringTokenizer;
import domaine.Pays;

public class PaysDao {
        
    private static final String FICHIER_PAYS = "Pays.txt";
    private final FileReader reader;
    
    public PaysDao(FileReader reader) { this.reader=reader; reader.setFile(FICHIER_PAYS); }

    public ArrayList getListePays() {
        String[] tabPays = reader.read();
        ArrayList aLst = new ArrayList();
        for (int i = 0; i < tabPays.length; i++) {
            StringTokenizer strT = new StringTokenizer(tabPays[i], ";");
            aLst.add(new Pays(Integer.parseInt(strT.nextToken()), strT.nextToken(), strT.nextToken()));
        }
        return aLst;
    }
}
