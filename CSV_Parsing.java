
/**
 * Write a description of CSV_Parsing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class CSV_Parsing {    
    
    public String countryInfo(CSVParser parser, String country){
        for(CSVRecord record : parser){
            String countries = record.get("Country");
            if(countries.contains(country)){
                return (country + ": " + record.get("Exports") + ": " + 
                        record.get("Value (dollars)"));
            }
        }
        return "NOT FOUND";
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1,
        String exportItem2){
            for(CSVRecord record : parser){
                String exports = record.get("Exports");
                if(exports.contains(exportItem1) && exports.contains(exportItem2)){
                    System.out.println(record.get("Country"));
                }
            }
        }
    
    public int numberOfExporters(CSVParser parser, String exportItem){
        int count = 0;
        for(CSVRecord record : parser){
            String exports = record.get("Exports");
            if(exports.contains(exportItem)){
                count++;
            }
        }
        return count;
    }
    
    public void bigExporters(CSVParser parser, String amount){
        for(CSVRecord record : parser){
            String exports = record.get("Value (dollars)");
            if(exports.length() > amount.length()){
                System.out.println(record.get("Country") + " " + record.get("Value (dollars)"));
            }
        }
        
    }
    
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //5
        bigExporters(parser, "$999,999,999,999");
        //to reset the parser
        parser = fr.getCSVParser();
        //4
        System.out.println("\nnumberOfExporters(cocoa) = " + numberOfExporters(parser, "cocoa"));
        parser = fr.getCSVParser();        
        //3
        System.out.println("\nlistExportersTwoProducts(cotton, flowers) = ");
        listExportersTwoProducts(parser, "cotton", "flowers");
        //2
        parser = fr.getCSVParser();
        System.out.println("\ncountryInfo(Nauru)\n" + countryInfo(parser, "Nauru"));
    }
}
