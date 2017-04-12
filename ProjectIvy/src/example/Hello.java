package example;

import org.apache.commons.lang.WordUtils;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.*;


public class Hello {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String  message = "hello ivy !";
        System.out.println("standard message : " + message);
        System.out.println("capitalized by " + WordUtils.class.getName() 
                                + " : " + WordUtils.capitalizeFully(message));


	/*int nb = 0;
        int monmax = 0;
        CSVReader reade
r = new CSVReader(new FileReader("data.csv")); 
        List<String[]> myEntries = reader.readAll();
	//parcourt
        for(String[] num : myEntries) {
            nb = Integer.parseInt(Arrays.toString(num).substring(1, Arrays.toString(num).length()-1));
	if(nb > monmax){
                monmax = nb;
            }
	System.out.println("Lecture du nombre : " + nb);
            }*/
        
	int monmax=0;
        CSVReader reader = new CSVReader(new FileReader("data.csv"));
        List<String[]> myEntries = reader.readAll();
        
        System.out.println("Nb de lignes : "+myEntries.size());
        for(int i = 0; i < myEntries.size(); i++){
        	List<String> list= Arrays.asList((myEntries.get(i)));
        	System.out.println("Nb de nombres de la ligne : "+list.size());
        	for(int j = 0; j < myEntries.get(i).length; j++)
        	{
			System.out.println(myEntries.get(i)[j]);
        		Integer m = new Integer(myEntries.get(i)[j]);
			monmax = max(monmax,m.intValue());
        	}
        }

        reader.close();

	System.out.println( "Mon max final :  "+ monmax);
    }
	
    public static int max(int a,int b)
    {
    	return a > b ? a : b;
    	//return a; // Le stagiaire est passe par la
    }
}
        
