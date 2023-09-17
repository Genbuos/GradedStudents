package classroom;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Classroom classroom3 = new Classroom();
        int maxNumberOfStudents = 1;
        Classroom classroom2 = new Classroom(maxNumberOfStudents);

        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };
        Double[] examScores2 = {225.0, 25.0};
        Double[] examScore3 = { 100.0, 150.0, 250.0, 0.0 };

        Student student3 = new Student("Leon", "Hunter", examScore3);
        Student student2 = new Student("Henry", "Santos", examScores2);
        Student student = new Student("Jordy","Mitchell",examScores);

        Student[] students = {student, student2};
        Classroom classroom = new Classroom(students);
                //ValueOf() this method returns the String representation of the boolean, char, char array, int
        //  long, float and DOUBLE arguments. (ALSO OBJECTS)
        // ValueOf() is a part of the String class - This will help me return a string representation of our double object.
        //toString(); will also work

        // When
        String output = student.getExamscores().toString();

        // Then
        System.out.println(output + "\n");

        //Adding exam score
        //When
        student.addExamScore(150.0);
        String output2 = String.valueOf(student.getExamscores());

        //Then
        System.out.println(output2 + " After adding\n");


        //Setting examScore
        //When
        student.setExamScore(0, 175d);
        String output3 = student.getExamscores().toString();

        //Then
        System.out.println(output3 + " After setting the very first position\n");

        //Geting Average Exam Score
        //When
        Double output4 = student.getAverageExamScore();

        //Then
        System.out.println(output4 + " : The average exam score for jordy\n");



        //OVERIDE the toString(); method by returning a clean String representation of the person.
        //When
        String output5 = student.toString();

        //Then
        System.out.println("The overriden toString(); Method \n" + output5 + "\n");

        // Classroom get average Score
        //When
        double output6 = classroom.getAverageExamScore();

        //Then
        System.out.println(output6 + " : Average of the Classroom\n");

        // addStudent method
        //When
        Student[] preEnrollment = classroom2.getStudents();
        classroom2.addStudent(student3);
        Student[] postEnrollment = classroom2.getStudents();

        //Then
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);
        System.out.println("===========================");
        System.out.println(preEnrollmentAsString);
        System.out.println("===========================");
        System.out.println(postEnrollmentAsString + "\n");

        // remove student method

        //When
        classroom2.removeStudent("Leon", "Hunter");

        //Then
        System.out.println(Arrays.toString(classroom2.getStudents()) + " Succefully removed a student\n");

        //getStudentsByScore
        //and order them lexigraphically

        System.out.println(Arrays.toString(classroom.getStudentsByScore()) + "\n");


        //getGradeBook
        classroom.getGradeBook();







    }
}
