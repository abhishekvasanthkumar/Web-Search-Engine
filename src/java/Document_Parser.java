import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Document_Parser {

    static HashMap<String,HashMap<Integer,Integer>> hm = new HashMap();
    public void parseFiles(File f,int docId) throws FileNotFoundException, IOException {
        BufferedReader in = null;
        
            if (f.getName().endsWith(".txt")) {
                in = new BufferedReader(new FileReader(f));
                String currentLine="";
                while ((currentLine = in.readLine()) != null) {
                    
                    for (String term : currentLine.split(" ")) {
                        
                    if (hm.containsKey(term)) 
                    {
                        HashMap<Integer,Integer> temp = hm.get(term);
                        if(temp.containsKey(docId))
                            temp.put(docId,temp.getOrDefault(docId,0)+1);
                        else
                            temp.put(docId,1);
                    }
                    else
                    {
                        HashMap<Integer,Integer> temp = new HashMap();
                        temp.put(docId,1);
                        hm.put(term,temp);
                    }
                }
                }       
        }
    }}
    
