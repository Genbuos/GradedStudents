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
        this.students = new Student[30];
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

    public HashMap<String, String> getGradeBook(){

        HashMap<String, String> gradeBook = new HashMap<>();
        //Hash table based implementation of the Map Interface.
        // our key value pairs are k = student.getFullName, v = the grade of the student
        //converting the array of students for easier manipulation.
        ArrayList<Student> studentsAsList = new ArrayList<>(Arrays.asList(students));
        //calculate the maximum average exam score among all students
        Double maxNumber =
                // Stream.max() returns the maximum element of the stream based on the provided Comparator.
                // A Comparator is a comparison function, which imposes a total ordering on some
                // collection of objects.
                          studentsAsList.stream()

                        // max() is a terminal operation which combines stream elements and returns
                        // a summary result. So, max() is a special case of reduction.
                        // The method returns Optional instance.
                                  // Returns the maximum element of this stream according to the provided
                                  // Comparator.
                                  // This is a special case of a reduction.
                                  //This is a terminal operation.
                                  //an Optional describing the maximum element of this stream,
                                  // or an empty Optional if the stream is empty

                                  // the lambda expression (a, b) ->  specifies two parameters
                                  //that we will compare/ in our case student against student

                                  //we are using compareTo(); method from the String class
                                  // even though we are comparing doubles we are in a stream
                                  //

                             .max((x, y) -> x.getAverageExamScore().compareTo(y.getAverageExamScore()))


                  //The get method is retreiving the optionals Value which is the object Student
                .get()
                                  //get the average exam score
                .getAverageExamScore();
        // calculate the grading curve as the difference between 100 and at the maximum score
        Double gradingCurve = 100 - maxNumber;
        //iterate through students
        for (Student student: students) {
            double studentScore = student.getAverageExamScore();
            String grade;

        //Determine the letter grade based on the student's score and the grading curve in specific percentile
            //ranges. 10th percentile, between 11th and 29th percentile, between 30 and 50th percentile,
            // between 51st and 89th percentile.
            if (studentScore >= (maxNumber - 0.10 * gradingCurve)) {
                grade = "A";
            } else if (studentScore >= (maxNumber - 0.29 * gradingCurve)) {
                grade = "B";
            } else if (studentScore >= (maxNumber - 0.50 * gradingCurve)) {
                grade = "C";
            } else if (studentScore >= (maxNumber - 0.89 * gradingCurve)) {
                grade = "D";
            } else {
                grade = "F";
            }

            String fullName = student.getFullName(student);
            gradeBook.put(fullName, grade);
        }
        return gradeBook;
    }

}
