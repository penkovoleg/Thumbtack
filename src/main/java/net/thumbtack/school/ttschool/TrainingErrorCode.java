package net.thumbtack.school.ttschool;

public enum TrainingErrorCode {

    TRAINEE_WRONG_FIRSTNAME,
    TRAINEE_WRONG_LASTNAME,
    TRAINEE_WRONG_RATING,
    GROUP_WRONG_NAME,
    GROUP_WRONG_ROOM,
    TRAINEE_NOT_FOUND,
    SCHOOL_WRONG_NAME,
    DUPLICATE_GROUP_NAME,
    GROUP_NOT_FOUND,
    DUPLICATE_TRAINEE,
    EMPTY_TRAINEE_QUEUE;

    private String errorString;

    TrainingErrorCode(String errorString){
        this.errorString = errorString;
    }

    TrainingErrorCode() {

    }

    public String getErrorString(){
        return errorString;
    }

}
