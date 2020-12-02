package net.thumbtack.school.elections;

import com.google.gson.Gson;
import net.thumbtack.school.elections.database.DataBase;
import net.thumbtack.school.elections.dto.request.RegisterVoterDtoRequest;
import net.thumbtack.school.elections.dto.response.RegisterVoterDtoResponse;
import net.thumbtack.school.elections.exception.ServerErrorCode;
import net.thumbtack.school.elections.exception.ServerException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ServerTest {

    private Gson gson = new Gson();
    private Server server = new Server();
    private DataBase dataBase = new DataBase();

    @Test
    public void testRegisterVoter() throws ServerException {
        server.startServer(null);
        int count = dataBase.getVoters().size();

        RegisterVoterDtoRequest request1 = new RegisterVoterDtoRequest("Иван", "Иванов", "Иванович", "Ленина", "20", "2", "Ivan", "123456789");
        RegisterVoterDtoRequest request2 = new RegisterVoterDtoRequest("Иван", "Иванов", "Ленина", "20", "IvanIvanov", "123456");
        RegisterVoterDtoRequest request3 = new RegisterVoterDtoRequest("Петр", "Иванов", "", "20", "IvanIvanov", "123456789");

        RegisterVoterDtoRequest request4 = new RegisterVoterDtoRequest("Иван", "Иванов", "Иванович", "Ленина", "20", "2", "IvanIvanov", "123456789");
        RegisterVoterDtoRequest request5 = new RegisterVoterDtoRequest("Петр", "Иванов", "Ленина", "20", "IvanIvanov", "123456789");

        String serverResult1 = server.registerVoter(gson.toJson(request1));
        String serverResult2 = server.registerVoter(gson.toJson(request2));
        String serverResult3 = server.registerVoter(gson.toJson(request3));

        String serverResult4 = server.registerVoter(gson.toJson(request4));
        String serverResult5 = server.registerVoter(gson.toJson(request5));

        RegisterVoterDtoResponse result1 = gson.fromJson(serverResult4, RegisterVoterDtoResponse.class);
        RegisterVoterDtoResponse result2 = gson.fromJson(serverResult5, RegisterVoterDtoResponse.class);

        assertEquals(serverResult1, gson.toJson(new ServerException(ServerErrorCode.INVALID_LOGIN)));
        assertEquals(serverResult2, gson.toJson(new ServerException(ServerErrorCode.INVALID_PASSWORD)));
        assertEquals(serverResult3, gson.toJson(new ServerException(ServerErrorCode.INVALID_STREET)));
        assertNotEquals(serverResult3, gson.toJson(new ServerException(ServerErrorCode.INVALID_FIRST_NAME)));
        assertNotEquals(serverResult3, gson.toJson(new ServerException(ServerErrorCode.INVALID_LAST_NAME)));

        assertEquals(2, dataBase.getVoters().size());
        assertEquals(gson.toJson(result1), serverResult4);
        assertEquals(gson.toJson(result2), serverResult5);
        /*String jsonRequest = "{\"lastName\":\"Пётр\",\"firstName\":\"Петров\",\"patronymic\":\"Петрович\"," +
                "\"street\":\"Ленина\",\"house\":\"1\",\"apartment\":\"1\"," +
                "\"login\":\"PetrPetrov\",\"password\":\"Petrov228\"}";
        server.registerVoter(jsonRequest);
         */
        server.stopServer(null);
    }
}
