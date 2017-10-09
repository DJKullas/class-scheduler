/**
 * Created by dkool on 8/19/2017.
 */
public class Course {
    private String name;
    private Block block;
    private int lunch;
    private String teacher;
    private int size;
    private int limit;

    public Course(String name, String teacher) {
        this(name, Block.UNDECIDED, 0, teacher);
    }

    public Course(String name, Block block, int lunch, String teacher) {
        this.name = name;
        this.block = block;
        this.lunch = lunch;
        this.teacher = teacher;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public int getLunch() {
        return lunch;
    }

    public void setLunch(int lunch) {
        this.lunch = lunch;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Course))return false;
        Course course = (Course) other;

        return this.getTeacher().equals(course.getTeacher())&& this.getName().equals(course.getName()) &&
                this.getBlock() == course.getBlock() && this.getLimit() == course.getLimit() &&
                this.getLunch() == course.getLunch()  &&
                this.getSize() == course.getSize();
    }
}
