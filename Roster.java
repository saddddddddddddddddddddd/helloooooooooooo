import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Roster {
    private ArrayList<List<String>> myRoster;
    public Roster(String roster){
    	String COMMA_DELIMETER = ",";
        myRoster = new ArrayList<>(); // object for roster
        List<String> bufferedList = new ArrayList<>();
        try {
              BufferedReader br = new BufferedReader(new FileReader(roster));
              String line;
              while((line = br.readLine()) != null){            	
                String[] newValues = line.split(COMMA_DELIMETER);

              }
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) { // intellij kept complaining, so I added two catches
            e.printStackTrace();
        }


    	}


    }