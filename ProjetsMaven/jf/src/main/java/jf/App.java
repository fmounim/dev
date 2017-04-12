package jf;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.apache.commons.collections4.CollectionUtils;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        System.out.println( "It's me!" );
        int a = max(4,5);
        System.out.println( a );
        
        int monmax=0;
    	String[] monOut;
        CSVWriter writer = new CSVWriter(new FileWriter("data-filtered.csv"),',',CSVWriter.NO_QUOTE_CHARACTER);
        CSVReader reader = new CSVReader(new FileReader("data.csv"));
        List<String[]> myEntries = reader.readAll();
        
        System.out.println("Nb de lignes : "+myEntries.size());
        for(int i = 0; i < myEntries.size(); i++){
        	List<String> list= Arrays.asList((myEntries.get(i)));
        	System.out.println("Nb de nombres de la ligne : "+list.size());
        	Vector<String>out=new Vector<String>();
        	CollectionUtils.select(list,new MonPredicat<String>(),out);
        	System.out.println( "OUT:"+ out);
        	if (out.toString() != "[]"){
        		monOut = out.toArray(new String[0]);
        		writer.writeNext(monOut);
        	}
        	for(int j = 0; j < myEntries.get(i).length; j ++)
        	{
        		Integer m = new Integer(myEntries.get(i)[j]);
            	monmax = max(monmax,m.intValue());
        	}
        }
        reader.close();
        writer.close();
        
        System.out.println( "Mon max final :  "+ monmax);
    }
    	
    public static int max(int a,int b)
    {
    	return a > b ? a : b;
    	//return a; // Le stagiaire est passe par la
    }
}
