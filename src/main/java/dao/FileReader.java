/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import outils.FileStr;

/**
 *
 * @author samyabouseda
 */
public class FileReader {
    
    private static final String FICHIER_PAYS = "Pays.txt";
    
    public String[] read() { return FileStr.read(FICHIER_PAYS); }
}
