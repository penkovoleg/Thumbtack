package net.thumbtack.school.elections.database;

import net.thumbtack.school.elections.model.Voter;

import java.io.Serializable;
import java.util.*;

public class DataBase implements Serializable {

    private static DataBase instance;
    private Map<Voter, String> voters;

    public DataBase(){
        voters = new HashMap<>();
    }

    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    public String registerVoter(Voter voter) {
        String token = UUID.randomUUID().toString();
        voters.put(voter, token);
        return token;
    }

    public Map<Voter, String> getVoters(){
        return voters;
    }

}
