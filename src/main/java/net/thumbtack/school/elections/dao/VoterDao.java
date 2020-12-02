package net.thumbtack.school.elections.dao;

import net.thumbtack.school.elections.exception.ServerException;
import net.thumbtack.school.elections.model.Voter;

public interface VoterDao {

    String insertVoter(Voter voter) throws ServerException;

}
