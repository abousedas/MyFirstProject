package dao;

import java.util.ArrayList;
import java.util.StringTokenizer;
import domaine.Pays;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PaysDao {

    private static final String FICHIER_PAYS = "Pays.txt";

    public static ArrayList getListePays() {
        String[] tabPays = outils.FileStr.read(FICHIER_PAYS);
        ArrayList aLst = new ArrayList();
        for (int i = 0; i < tabPays.length; i++) {
            StringTokenizer strT = new StringTokenizer(tabPays[i], ";");
            aLst.add(new Pays(Integer.parseInt(strT.nextToken()), strT.nextToken(), strT.nextToken()));
        }
        return aLst;
    }
}
