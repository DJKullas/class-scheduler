import java.util.ArrayList;

/**
 * Created by dkool on 8/19/2017.
 */
public class Teacher {

    private String name;
    private Block requestedPrep;
    private Block actualPrep;
    private ArrayList<Course> courses;
    private int years;

    public Teacher(String name, Block prep, ArrayList<Course> courses, int years) {
        this.name = name;
        this.requestedPrep = prep;
        this.courses = courses;
        this.years = years;
        this.actualPrep = Block.UNDECIDED;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Block getRequestedPrep() {
        return requestedPrep;
    }

    public void setRequestedPrep(Block prep) {
        this.requestedPrep = prep;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public Block getActualPrep() {
        return actualPrep;
    }

    public void setActualPrep(Block actualPrep) {
        this.actualPrep = actualPrep;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;

    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
}
