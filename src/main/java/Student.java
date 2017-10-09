import java.util.ArrayList;

/**
 * Created by dkool on 8/19/2017.
 */
public class Student {

    private String name;

    public Student(String name, ArrayList<Course> preferredCourses, double gpa) {
        this (name, preferredCourses, "", gpa, 12, null);
    }

    public Student(String name, ArrayList<Course> preferredCourses, String email, double gpa, int year, ArrayList<Course> necessaryCourses) {
        this.name = name;
        this.preferredCourses = preferredCourses;
        this.email = email;
        this.gpa = gpa;
        this.year = year;
        this.necessaryCourses = necessaryCourses;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Course> getPreferredCourses() {
        return preferredCourses;
    }

    public void setPreferredCourses(ArrayList<Course> preferredCourses) {
        this.preferredCourses = preferredCourses;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<Course> getNecessaryCourses() {
        return necessaryCourses;
    }

    public void setNecessaryCourses(ArrayList<Course> necessaryCourses) {
        this.necessaryCourses = necessaryCourses;
    }

    private ArrayList<Course> preferredCourses;
    private String email;
    private double gpa;
    private int year;
    private ArrayList<Course> necessaryCourses;
}
