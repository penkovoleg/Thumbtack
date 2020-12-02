package net.thumbtack.school.elections.daoimpl;

import net.thumbtack.school.elections.dao.VoterDao;
import net.thumbtack.school.elections.database.DataBase;
import net.thumbtack.school.elections.exception.ServerException;
import net.thumbtack.school.elections.model.Voter;

public class VoterDaoImpl implements VoterDao {

    private final DataBase database;

    public VoterDaoImpl(){
        database = DataBase.getInstance();
    }

    @Override
    public String insertVoter(Voter voter) throws ServerException {
        return database.registerVoter(voter);
    }
}
