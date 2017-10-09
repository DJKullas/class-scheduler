import java.util.ArrayList;

/**
 * Created by dkool on 8/19/2017.
 */
public class Schedule {

    private Student student;
    private ArrayList<Course> courses;

    public Schedule(Student student) {
        this (student, new ArrayList<Course>());
    }

    public Schedule(Student student, ArrayList<Course> courses) {

        this.student = student;
        this.courses = courses;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public String toString() {
        String temp = "Student: " + this.student.getName() + " ";

        for (Course c : this.courses) {
            temp += "Class: " + c.getName() + " Teacher:" + c.getTeacher() + " Block:" + c.getBlock() + " ";
        }

        return temp;
    }
}
