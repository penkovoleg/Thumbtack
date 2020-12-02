package net.thumbtack.school.elections.exception;

public enum ServerErrorCode {

    INVALID_FIRST_NAME("Невалидная фамилия"),
    INVALID_LAST_NAME("Невалидное имя"),
    INVALID_STREET("Невалидная улица"),
    INVALID_HOUSE("Невалидный дом"),
    INVALID_LOGIN("Невалидный логин"),
    INVALID_PASSWORD("Невалидный пароль");

    private String errorString;

    ServerErrorCode(String errorString){
        this.errorString = errorString;
    }

    ServerErrorCode() {

    }

    public String getErrorString(){
        return errorString;
    }
}
