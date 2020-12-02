package net.thumbtack.school.elections;

import net.thumbtack.school.elections.exception.ServerException;
import net.thumbtack.school.elections.service.VoterService;

public class Server {

    private static VoterService voterService;

    public void startServer(String savedDataFileName) {
        voterService = new VoterService();
    }

    public void stopServer(String savedDataFileName){

    }

    public String registerVoter(String requestJsonString) {
        return voterService.registerVoter(requestJsonString);
    }
}
