package dao;

import java.util.ArrayList;
import java.util.StringTokenizer;
import domaine.Pays;

public class PaysDao {

    private final FileReader reader;
    
    public PaysDao(FileReader reader) { this.reader=reader; reader.setFile("Pays.txt"); }

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
