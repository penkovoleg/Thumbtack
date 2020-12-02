package net.thumbtack.school.ttschool;

public class TrainingException extends Exception{

    private TrainingErrorCode error;

    TrainingException(TrainingErrorCode error){
        this.error = error;
    }

    public TrainingErrorCode getErrorCode(){
        return error;
    }
}
