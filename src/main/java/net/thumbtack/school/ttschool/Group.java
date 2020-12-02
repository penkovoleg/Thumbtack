package net.thumbtack.school.ttschool;

import java.util.*;

public class Group {

    private String name;
    private String room;
    private List<Trainee> studentsList;


    public Group(String name, String room) throws TrainingException{
        nameEqualsNull(name);
        this.name = name;
        roomEqualsNull(room);
        this.room = room;
        this.studentsList = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public void setName(String name) throws TrainingException{
        nameEqualsNull(name);
        this.name = name;
    }

    public String getRoom(){
        return room;
    }

    public void setRoom(String room) throws TrainingException{
        roomEqualsNull(room);
        this.room = room;
    }

    public List<Trainee> getTrainees(){
        return studentsList;
    }

    public void addTrainee(Trainee trainee){
        studentsList.add(trainee);
    }

    public void removeTrainee(Trainee trainee) throws TrainingException{
        if(!studentsList.remove(trainee))
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public void removeTrainee(int index) throws TrainingException{
        if(index >= studentsList.size() || studentsList.remove(index) == null)
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public Trainee getTraineeByFirstName(String firstName) throws TrainingException{
        for(Trainee trainee : studentsList)
            if(trainee.getFirstName().equals(firstName))
                return trainee;
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public Trainee getTraineeByFullName(String fullName) throws TrainingException{
        for(Trainee trainee : studentsList)
            if(trainee.getFullName().equals(fullName))
                return trainee;
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public void sortTraineeListByFirstNameAscendant(){
        studentsList.sort(Comparator.comparing(Trainee::getFirstName));
    }

    public void sortTraineeListByRatingDescendant(){
        studentsList.sort(Comparator.comparing(Trainee::getRating).reversed());
    }

    public void reverseTraineeList(){
        Collections.reverse(studentsList);
    }

    public void rotateTraineeList(int positions){
        Collections.rotate(studentsList, positions);
    }

    public List<Trainee> getTraineesWithMaxRating() throws TrainingException{
        if (studentsList.size() == 0)
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);

        int max = 0;
        List<Trainee> list = new ArrayList<>();

        for(Trainee trainee : studentsList)
            if(trainee.getRating() > max)
                max = trainee.getRating();

        for(Trainee trainee : studentsList)
            if(max == trainee.getRating())
                list.add(trainee);

        return list;
    }

    public boolean hasDuplicates(){
        for(int i = 0; i < studentsList.size(); i++){
            for(int k = 0; k < studentsList.size(); k++){
                if(studentsList.get(i).equals(studentsList.get(k)) && i != k)
                    return true;
            }
        }
        return false;
    }

    public static void nameEqualsNull(String name) throws TrainingException{
        if(name == null || name.equals(""))
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
    }

    public static void roomEqualsNull(String room) throws TrainingException{
        if(room == null || room.equals(""))
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_ROOM);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name) &&
                Objects.equals(room, group.room) &&
                Objects.equals(studentsList, group.studentsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, room, studentsList);
    }

}
