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
    private ArrayList<Course> courses;

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public double checkScore(ArrayList<Course> courses) {
        ArrayList<Course> preferredCoursesWithBlocks = new ArrayList<Course>();

        for (Course c : courses) {
            for (Course pc : this.getPreferredCourses()) {
                if (c.getName().equals(pc.getName())) {
                    preferredCoursesWithBlocks.add(c);
                }
            }
        }

        ArrayList<Block> blocks = new ArrayList<Block>();

        for (Course c : preferredCoursesWithBlocks) {
            if (!blocks.contains(c.getBlock())) {
                blocks.add(c.getBlock());
            }
        }

        return blocks.size();// * this.getGpa();
    }

    public void printSchedule(ArrayList<Course> courses) {
        System.out.print(getName() + ": ");
        for (Course c : courses) {
            for (Course pc : this.getPreferredCourses()) {
                if (c.getName().equals(pc.getName())) {
                    System.out.print(c.getName() + "  " + c.getBlock() + "  ");
                }
            }
        }
        System.out.println("");
    }
}
