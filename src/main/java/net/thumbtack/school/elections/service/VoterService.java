package net.thumbtack.school.elections.service;

import com.google.gson.Gson;
import net.thumbtack.school.elections.dao.VoterDao;
import net.thumbtack.school.elections.daoimpl.VoterDaoImpl;
import net.thumbtack.school.elections.dto.request.RegisterVoterDtoRequest;
import net.thumbtack.school.elections.dto.response.RegisterVoterDtoResponse;
import net.thumbtack.school.elections.exception.ServerException;
import net.thumbtack.school.elections.model.Voter;

public class VoterService {

    private Gson gson = new Gson();
    private final VoterDao voterDao;

    public VoterService() {
        voterDao = new VoterDaoImpl();
    }

    public String registerVoter(String requestJsonString) {
        try {
            RegisterVoterDtoRequest registerRequest = gson.fromJson(requestJsonString, RegisterVoterDtoRequest.class);
            registerRequest.validate();
            Voter voter = createVoter(registerRequest);
            RegisterVoterDtoResponse registerResponse = new RegisterVoterDtoResponse(voterDao.insertVoter(voter));
            return gson.toJson(registerResponse);
        } catch (ServerException e) {
            return gson.toJson(e.getExceptionErrorInfo().getErrorCode() + "\n" + e.getExceptionErrorInfo().getErrorString());
        }
    }

    private Voter createVoter(RegisterVoterDtoRequest data) {
        return new Voter(data.getLastName(), data.getFirstName(), data.getPatronymic(),
                data.getStreet(), data.getHouse(), data.getApartment(),
                data.getLogin(), data.getPassword());
    }
}
