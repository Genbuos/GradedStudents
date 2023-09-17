package classroom;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Classroom {
    Student[] students;

    public Classroom(Student[] students) {
        this.students = students;
    }


    public Classroom(int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
    }

    //Composite students object;
    public Classroom() {
        students = new Student[30];
    }

    public Student[] getStudents() {
        return this.students;
    }



    public Double getAverageExamScore() {
        Double totalAverageScore = 0.0;
        for (Student student: students){
            totalAverageScore += student.getAverageExamScore();
        }
        return totalAverageScore/students.length;
    }

    // gain an understanding on what this code means

    // Array list was empty
    public void addStudent(Student student) {
        ArrayList<Student> students1 = new ArrayList<>(Arrays.asList(students));


        students1.add(student);
        this.students = students1.toArray(new Student[students1.size()]);
    }

    public void removeStudent(String firstname, String lastName){
        ArrayList<Student> studs = new ArrayList<>(Arrays.asList(students));

//        Find the student with the given first name and last name
        for (Student student : studs) {
            if ( student != null && student.getFirstName() != null && student.getLastName() != null &&
                student.getFirstName().equals(firstname) && student.getLastName().equals(lastName)) {
                studs.remove(student); // Remove the found student from the ArrayList
                break; // Exit the loop once a student is removed
            }
        }
        this.students = studs.toArray(new Student[0]);
    }

    public Student[] getStudentsByScore(){
        //Converting the array to an arrayList for easier manipulation.

        List<Student> studentListe = new ArrayList<>(Arrays.asList(students));



        //sorting the arrayList (a part of the collections' framework) with the .sort() method in the
        //Collections class
        //with a Comaparator object to determine the sorting order
      Collections.sort(studentListe, new Comparator<Student>() {

          //This code was automatically generated when `new Comparator` was typed
          // so we are overriding the compare method in the Comparator Interface and making it compare
          // two different student objects.
          @Override
          public int compare(Student o1, Student o2) {

              double score1 =o1.getAverageExamScore();
              double score2 = o2.getAverageExamScore();

              if(score1 > score2){
                  return -1; //Student 1 will be before Student 2
                  } else if (score1 < score2){
                  return 1;//Student 2 will be before Student 1


              } else {
                   return  o1.getFullName(o1).compareTo(o2.getFullName(o2)); // sorts students with the
                  //score lexigraphically by their fullnames

              }
          }
      });

                return studentListe.toArray(new Student[0]); // returns an array of Student objects after data manipulation
    }

    public void getGradeBook(){
        //converting the array of students for easier manipulation.
        ArrayList<Student> studentsAsList = new ArrayList<>(Arrays.asList(students));
        //calculate the maximum average exam score among all students
        Double maxNumber = studentsAsList.stream()
                .max((x, y) -> x.getAverageExamScore().compareTo(y.getAverageExamScore()))
                .get()
                .getAverageExamScore();
        // calculate the grading curve as the difference between 100 and at the maximum score
        Double gradingCurve = 100 - maxNumber;
        //iterate through students
        for (Student student: students) {
            double studentScore = student.getAverageExamScore();
            String grade;

        //Determine the letter grade based on the student's score and the grading curve
            if (studentScore >= (maxNumber - 0.10 * gradingCurve)) {
                grade = "A";
            } else if (studentScore >= (maxNumber - 0.20 * gradingCurve)) {
                grade = "B";
            } else if (studentScore >= (maxNumber - 0.50 * gradingCurve)) {
                grade = "C";
            } else if (studentScore >= (maxNumber - 0.70 * gradingCurve)) {
                grade = "D";
            } else {
                grade = "F";
            }

            System.out.println(student.getFullName(student) + " : " + grade);
        }

    }

}
