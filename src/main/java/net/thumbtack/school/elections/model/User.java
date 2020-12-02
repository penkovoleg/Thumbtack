package net.thumbtack.school.elections.model;

import java.util.Objects;

public class User {
    private final String firstName, lastName, patronymic;
    private final String street, house, apartment;
    private final String login, password;

    public User(String lastName, String firstName, String patronymic, String street, String house, String apartment, String login, String password){
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.login = login;
        this.password = password;
    }

    public User(String lastName, String firstName, String street, String house, String login, String password){
        this(lastName, firstName, null, street, house, null, login, password);
    }

    public String getLastName(){
        return lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getPatronymic(){
        return patronymic;
    }

    public String getStreet(){
        return street;
    }

    public String getHouse(){
        return house;
    }

    public String getApartment(){
        return apartment;
    }

    public String getLogin(){
        return login;
    }

    public String getPassword(){
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(patronymic, user.patronymic) &&
                Objects.equals(street, user.street) &&
                Objects.equals(house, user.house) &&
                Objects.equals(apartment, user.apartment) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, patronymic, street, house, apartment, login, password);
    }
}
