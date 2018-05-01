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
    
    private String file = null;
    
    public void setFile(String file) { this.file=file; }
    
    public String[] read() { 
        if (file != null) { return FileStr.read(file); }
        return null;
    }
}
