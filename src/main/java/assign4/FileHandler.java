package assign4;

import assign4.model.Team;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class FileHandler {
    private String pathToFile;

    public FileHandler(){
        pathToFile = "TeamData.csv";
    }

    public ArrayList<Team> readCsvFile() throws IOException {
        String row = "";
        ArrayList<Team> teams = new ArrayList<>();
        BufferedReader csvReader = new BufferedReader(new FileReader(pathToFile));
        while ((row = csvReader.readLine()) != null) {
            String[] split = row.split(",");
            Team t = new Team(split[0],Integer.parseInt(split[1]));
            teams.add(t);
        }
        csvReader.close();
        return teams;
    }

}
