import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by dkool on 8/19/2017.
 */
public class Scheduler {

    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private ArrayList<Schedule> schedules;

    public Scheduler(ArrayList<Course> courses, ArrayList<Student> students) {
        this.courses = courses;
        this.students = students;
    }

    public Scheduler() {
        this.courses = new ArrayList<Course>();
        this.students = new ArrayList<Student>();
    }

    public static void main(String[] args) {
        Scheduler s = new Scheduler();
        s.createSchedules();
    }

    public void createSchedules() {
        Course a = new Course("Math", "1");
        Course b = new Course("Science", "2");
        Course c = new Course("History", "3");
        Course d = new Course("English", "4");
        Course e = new Course("Gym", "5");
        Course f = new Course("Music", "6");
        Course g = new Course("Art", "7");
        Course h = new Course("Homeroom", "8");

        ArrayList<Course> courses1 = new ArrayList<Course>();
        courses1.add(a);
        courses1.add(b);
        courses1.add(c);
        courses1.add(d);

        ArrayList<Course> courses2 = new ArrayList<Course>();
        courses2.add(b);
        courses2.add(c);
        courses2.add(e);
        courses2.add(f);

        ArrayList<Course> courses3 = new ArrayList<Course>();
        courses3.add(a);
        courses3.add(b);
        courses3.add(e);
        courses3.add(g);

        ArrayList<Course> courses4 = new ArrayList<Course>();
        courses4.add(a);
        courses4.add(e);
        courses4.add(f);
        courses4.add(g);

        ArrayList<Course> courses5 = new ArrayList<Course>();
        courses5.add(d);
        courses5.add(e);
        courses5.add(g);
        courses5.add(h);

        ArrayList<Course> courses6 = new ArrayList<Course>();
        courses6.add(b);
        courses6.add(c);
        courses6.add(f);
        courses6.add(h);

        ArrayList<Course> courses7 = new ArrayList<Course>();
        courses7.add(e);
        courses7.add(f);
        courses7.add(g);
        courses7.add(h);

        ArrayList<Course> courses8 = new ArrayList<Course>();
        courses8.add(a);
        courses8.add(b);
        courses8.add(c);
        courses8.add(e);

        Student s1 = new Student("Alison",courses1, 3.9);
        Student s2 = new Student("Bill",courses2, 3.7);
        Student s3 = new Student("Chris",courses3, 3.5);
        Student s4 = new Student("Dean",courses4, 3.3);
        Student s5 = new Student("Eleanor",courses5, 3.2);
        Student s6 = new Student("Frank",courses6, 3.1);
        Student s7 = new Student("Garth",courses7, 3.0);
        Student s8 = new Student("Heather",courses8, 2.9);

        this.students.add(s1);
        this.students.add(s2);
        this.students.add(s3);
        this.students.add(s4);
        this.students.add(s5);
        this.students.add(s6);
        this.students.add(s7);
        this.students.add(s8);

        ArrayList<Student> sortedStudents = sortByGPA();
        courses.add(a);
        courses.add(b);
        courses.add(c);
        courses.add(d);
        courses.add(e);
        courses.add(f);
        courses.add(g);
        courses.add(h);

        boolean switched;

        for (int i = 0; i < sortedStudents.size(); i += 1) {
            Schedule temp = scheduleIt(sortedStudents.get(i));

            if (temp.getCourses().size() < 4) {

            }
        }

        for (Student s : sortedStudents) {
            scheduleIt(s);
        }

    }

    private Schedule scheduleIt(Student student) {

        Schedule schedule = new Schedule(student);
        ArrayList<Course> classes = new ArrayList<Course>();
        ArrayList<Block> count = new ArrayList<Block>();
        count.add(Block.A);
        count.add(Block.B);
        count.add(Block.C);
        count.add(Block.D);

        ArrayList<Course> decidedCourses = new ArrayList<Course>();
        ArrayList<Course> undecidedCourses = new ArrayList<Course>();

        for (Course c : student.getPreferredCourses()) {
            if (c.getBlock() != Block.UNDECIDED) {
                decidedCourses.add(c);
            }
            else {
                undecidedCourses.add(c);
            }
        }

        ArrayList<Course> decidedFirst = new ArrayList<Course>();

        decidedCourses.addAll(undecidedCourses);

        decidedFirst = decidedCourses;

        for (Course c : decidedFirst) {

            Course current = new Course("", "");

            for (int i = 0; i < this.courses.size(); i += 1) {
                if (this.courses.get(i).equals(c)) {
                    current = this.courses.get(i);
                }
            }

            ArrayList<Block> blocksTaken = new ArrayList<Block>();

            for (Course classesAlready : classes) {
                blocksTaken.add(classesAlready.getBlock());
            }

            if (blocksTaken.contains(current.getBlock())) {

            }
            else if (current.getBlock() != Block.UNDECIDED) {
                count.remove(current.getBlock());
                c.setBlock(current.getBlock());
                classes.add( c);
            }
            else if (current.getBlock() == Block.UNDECIDED) {

                for (int i = 0; i < this.courses.size(); i += 1) {
                    if (this.courses.get(i).equals(c)) {

                        Block block = count.get(0);
                        count.remove(0);

                        switch(block) {
                            case A:
                                this.courses.get(i).setBlock(Block.A);
                                c.setBlock(Block.A);
                                break;
                            case B:
                                this.courses.get(i).setBlock(Block.B);
                                c.setBlock(Block.B);
                                break;
                            case C:
                                this.courses.get(i).setBlock(Block.C);
                                c.setBlock(Block.C);
                                break;
                            case D:
                                this.courses.get(i).setBlock(Block.D);
                                c.setBlock(Block.D);
                                break;
                        }
                    }
                }

                classes.add(c);
            }

        }

        schedule.setCourses(classes);

        System.out.println(schedule);

        return schedule;
    }

    private void assignCourses(ArrayList<Teacher> teachers) {
        for (Teacher teacher : teachers) {
            for (Course course : teacher.getCourses()) {
                course.setTeacher(teacher.getName());
                courses.add(course);

            }
        }
    }

    private ArrayList<Student> sortByGPA() {

        ArrayList<Student> sorted = new ArrayList<Student>();
        sorted.add(students.get(0));

        for (int i = 1; i < students.size(); i += 1) {
            for (int j = 0; j < sorted.size(); j += 1) {
                if (students.get(i).getGpa() > sorted.get(j).getGpa()) {
                    sorted.add(j, students.get(i));
                    break;
                }

                if (j == sorted.size() - 1) {
                    sorted.add(students.get(i));
                    break;
                }
            }
        }

        return sorted;
    }
}
