package net.thumbtack.school.elections.dto.response;

public class RegisterVoterDtoResponse {

    private String token;

    public RegisterVoterDtoResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
