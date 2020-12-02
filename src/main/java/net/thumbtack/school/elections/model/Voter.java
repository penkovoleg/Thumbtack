package net.thumbtack.school.elections.model;

import net.thumbtack.school.elections.dto.request.RegisterVoterDtoRequest;

public class Voter extends User{

    public Voter(String lastName, String firstName, String patronymic,
                 String street, String house, String apartment,
                 String login, String password) {
        super(lastName, firstName, patronymic, street, house, apartment, login, password);
    }

    public Voter(String lastName, String firstName,
                 String street, String house,
                 String login, String password) {
        super(lastName, firstName, null, street, house, null, login, password);
    }

    public Voter(Candidate candidate) {
        super(candidate.getLastName(), candidate.getFirstName(), candidate.getPatronymic(),
                candidate.getStreet(), candidate.getHouse(), candidate.getApartment(),
                candidate.getLogin(), candidate.getPassword());
    }

}
