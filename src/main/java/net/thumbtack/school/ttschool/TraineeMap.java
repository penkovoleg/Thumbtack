package net.thumbtack.school.ttschool;

import java.util.*;

public class TraineeMap {

    private Map<Trainee, String> info;

    public TraineeMap(){
        info = new HashMap<>();
    }

    public void addTraineeInfo(Trainee trainee, String institute) throws TrainingException{
        if(info.containsKey(trainee))
            throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);
        info.put(trainee, institute);
    }

    public void replaceTraineeInfo(Trainee trainee, String institute) throws TrainingException{
        if(info.containsKey(trainee))
            info.replace(trainee, institute);
        else throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);

    }

    public void removeTraineeInfo(Trainee trainee) throws TrainingException{
        if(!info.containsKey(trainee))
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        else info.remove(trainee);
    }

    public int getTraineesCount(){
        return info.size();
    }

    public String getInstituteByTrainee(Trainee trainee) throws TrainingException{
        if(!info.containsKey(trainee))
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        else return info.get(trainee);
    }

    public Set<Trainee> getAllTrainees(){
        return new HashSet<>(info.keySet());
    }

    public Set<String> getAllInstitutes(){
        return new HashSet<>(info.values());
    }

    public boolean isAnyFromInstitute(String institute){
        return info.containsValue(institute);
    }

}
