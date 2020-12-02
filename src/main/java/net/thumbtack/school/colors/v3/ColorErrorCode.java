package net.thumbtack.school.colors.v3;

public enum ColorErrorCode {

    WRONG_COLOR_STRING, NULL_COLOR;

    private String errorString;

    ColorErrorCode(String errorString){
        this.errorString = errorString;
    }

    ColorErrorCode() {

    }

    public String getErrorString(){
        return errorString;
    }
}
