import java.io.File;
import java.io.FilenameFilter;


public class FileNameFilter implements FilenameFilter {  
    private String name;  
    private String extension;  
  
    public FileNameFilter(String name, String extension) {  
       this.name = name.toLowerCase();  
       this.extension = extension.toLowerCase();  
    }  
  
    public boolean accept(File directory, String filename) {  
       boolean ok = true;  
       if (extension != null) ok &= filename.toLowerCase().endsWith("." + extension);  
       return ok;  
    }  
 }  
