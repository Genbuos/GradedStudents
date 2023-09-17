package classroom;

import java.util.ArrayList;
import java.util.Arrays;
/*
Part 1.1
* Declare an instance variable for each of the previously mentioned properties:
* String firstname;
* String lastname;
* ArrayList<Double> examscores;
* */
public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examscores;

    /*
    *
    Part 1.2
    *Define a constructor WHOSE PARAMETERS ARE USED TO INITIALIZE THE INSTANCE VARIABLES

    Part 1.3
    * Define getters and setters and an extra getter getNumberOfExamsTaken() which returns the total
    * number of exams taken by this student


    */
    public Student(String firstName, String lastName, Double[] testscores) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.examscores = new ArrayList<>(Arrays.asList(testscores));
    }

    public String getFullName(Student student){
        if(student.getFirstName() == this.firstName);
        return firstName + lastName;
    }

    public Integer getnumberOfExamsTaken(){
        return examscores.size();
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
/*
*
* Student should define a method which returns a string representation of all exams taken */
    public ArrayList<Double> getExamscores() {
        return examscores;
    }

    public void setExamscores(ArrayList<Double> examscores) {
        this.examscores = examscores;
    }

    public void addExamScore(double examScore){
    examscores.add(examScore);
    }

    public void setExamScore(int examNumber, double newScore){
    examscores.set(examNumber, newScore);
    }

    public Double getAverageExamScore(){
        double average = 0;
        double totalScore = 0;

        for (Double examScore:examscores) {
            totalScore = totalScore + examScore;
            average = totalScore / examscores.size();
        }
        return average;
    }
//OVERIDE the toString(); method by returning a clean representation of the person.
    @Override
    public String toString(){
        return  " Student Name: " + firstName + " " + lastName + "\n"
                + "Average Exam Score: " + getAverageExamScore() + "\n"
                + "Exam Scores: " + examscores + " ";
    }
}
