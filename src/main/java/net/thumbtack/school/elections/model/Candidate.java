package net.thumbtack.school.elections.model;

import java.util.Objects;

public class Candidate extends User{

    private String login, password;

    public Candidate(String lastName, String firstName, String patronymic,
                     String street, String house, String apartment,
                     String login, String password) {
        super(lastName, firstName, patronymic, street, house, apartment, login, password);
    }

    public Candidate(String lastName, String firstName,
                     String street, String house,
                     String login, String password) {
        super(lastName, firstName, null, street, house, null, login, password);
    }

    public Candidate(Voter voter) {
        super(voter.getLastName(), voter.getFirstName(), voter.getPatronymic(),
                voter.getStreet(), voter.getHouse(), voter.getApartment(),
                voter.getLogin(), voter.getPassword());
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Candidate candidate = (Candidate) o;
        return Objects.equals(login, candidate.login) &&
                Objects.equals(password, candidate.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), login, password);
    }
}
