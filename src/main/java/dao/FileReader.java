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
        return new String[] {};
    }
}
