package net.thumbtack.school.elections.dto.request;

import net.thumbtack.school.elections.exception.ServerErrorCode;
import net.thumbtack.school.elections.exception.ServerException;

public class RegisterVoterDtoRequest {

    private final String firstName, lastName, patronymic;
    private final String street, house, apartment;
    private final String login, password;

    public RegisterVoterDtoRequest(String lastName, String firstName, String patronymic,
                                   String street, String house, String apartment,
                                   String login, String password) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.login = login;
        this.password = password;
    }

    public RegisterVoterDtoRequest(String lastName, String firstName,
                                   String street, String house,
                                   String login, String password) {
        this(lastName, firstName, null, street, house, null, login, password);
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public String getApartment() {
        return apartment;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void validate() throws ServerException {
        if (lastName == null || lastName.equals(""))
            throw new ServerException(ServerErrorCode.INVALID_LAST_NAME);
        if(firstName == null || firstName.equals(""))
            throw new ServerException(ServerErrorCode.INVALID_FIRST_NAME);
        if(street == null || street.equals(""))
            throw new ServerException(ServerErrorCode.INVALID_STREET);
        if(house == null || house.equals(""))
            throw new ServerException(ServerErrorCode.INVALID_HOUSE);
        if(login == null || login.equals("") || login.length() < 8)
            throw new ServerException(ServerErrorCode.INVALID_LOGIN);
        if(password == null || password.equals("") || password.length() < 8)
            throw new ServerException(ServerErrorCode.INVALID_PASSWORD);
    }
}
