import java.lang.reflect.Array;
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










    public void AllCombos() {
        int highestScore = 0;

        // Create Courses
        Course math = new Course("Math", "1");
        Course science = new Course("Science", "2");
        Course history = new Course("History", "3");
        Course english = new Course("English", "4");
        Course gym = new Course("Gym", "5");
        Course music = new Course("Music", "6");
        Course art = new Course("Art", "7");
        Course homeroom = new Course("Homeroom", "8");

        // Student suggested schedules
        ArrayList<Course> courses1 = new ArrayList<Course>();
        courses1.add(math);
        courses1.add(science);
        courses1.add(history);
        courses1.add(english);

        ArrayList<Course> courses2 = new ArrayList<Course>();
        courses2.add(science);
        courses2.add(history);
        courses2.add(gym);
        courses2.add(music);

        ArrayList<Course> courses3 = new ArrayList<Course>();
        courses3.add(math);
        courses3.add(science);
        courses3.add(gym);
        courses3.add(art);

        ArrayList<Course> courses4 = new ArrayList<Course>();
        courses4.add(math);
        courses4.add(gym);
        courses4.add(music);
        courses4.add(art);

        ArrayList<Course> courses5 = new ArrayList<Course>();
        courses5.add(english);
        courses5.add(gym);
        courses5.add(art);
        courses5.add(homeroom);

        ArrayList<Course> courses6 = new ArrayList<Course>();
        courses6.add(science);
        courses6.add(history);
        courses6.add(music);
        courses6.add(homeroom);

        ArrayList<Course> courses7 = new ArrayList<Course>();
        courses7.add(gym);
        courses7.add(music);
        courses7.add(art);
        courses7.add(homeroom);

        ArrayList<Course> courses8 = new ArrayList<Course>();
        courses8.add(math);
        courses8.add(science);
        courses8.add(history);
        courses8.add(gym);

        // Create Students
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

        // Sorted students
        ArrayList<Student> sortedStudents = sortByGPA();
        courses.add(math);
        courses.add(science);
        courses.add(history);
        courses.add(english);
        courses.add(gym);
        courses.add(music);
        courses.add(art);
        courses.add(homeroom);

        // Go through all combos and check scores

    }

    public static String convertToBase3(int N){
        String result = "";
        while(N>0){
            int rem = N%3;
            N = N/3;
            result = rem + result;
        }
        return result;
    }

    public ArrayList<ArrayList<Course>> createAllCgdgfdgombinations() {
        ArrayList<ArrayList<Course>> allCoursesWithArraylistsBeingSameCourseDifferentBlock = new ArrayList<ArrayList<Course>>();

            for (Course c : this.courses) {
                ArrayList<Course> oneClassWithAllBlocks = new ArrayList<Course>();
                Course c1 = new Course(c);
                c1.setBlock(Block.A);
                Course c2 = new Course(c);
                c1.setBlock(Block.B);
                Course c3 = new Course(c);
                c1.setBlock(Block.C);
                Course c4 = new Course(c);
                c1.setBlock(Block.D);

                oneClassWithAllBlocks.add(c1);
                oneClassWithAllBlocks.add(c2);
                oneClassWithAllBlocks.add(c3);
                oneClassWithAllBlocks.add(c4);

                allCoursesWithArraylistsBeingSameCourseDifferentBlock.add(oneClassWithAllBlocks);
            }

            // Using eight classes with 4 blocks

        return new ArrayList<ArrayList<Course>>();
    }

    public ArrayList<Course> assignBlocksUsingBaseThreeString(String baseThreeNumber, ArrayList<ArrayList<Course>> everything) {
        ArrayList<Course> scheduleOfBlocksAndClassesThatIsComplete = new ArrayList<Course>();
        for  (int i = 0; i < everything.size(); i += 1) {
            Course courseToAdd;
            courseToAdd = everything.get(i).get(Integer.parseInt(baseThreeNumber.substring(i, i)));
            scheduleOfBlocksAndClassesThatIsComplete.add(courseToAdd);
        }

        return scheduleOfBlocksAndClassesThatIsComplete;
    }

    public ArrayList<ArrayList<Course>> createAllCombinations() {
        ArrayList<ArrayList<Course>> combos = new ArrayList<ArrayList<Course>>();

        // NONSENSE FOR LOOP PARAMETERS
        for (int i = 0; i < 1; i += 1) {
            ArrayList<Course> currentSetup = new ArrayList<Course>();

            for (Course c : this.courses) {
                c.setBlock(Block.A);
                currentSetup.add(c);
            }

            combos.add(currentSetup);
        }

        return combos;
    }

    private Course findCourseByName(ArrayList<Course> currentSetupOfCourses, String name) {
        for (Course c: currentSetupOfCourses) {
            if (c.getName().equals(name)) {
                return c;
            }
        }

        return null;
    }

    public int calculateScore(ArrayList<Course> currentSetupOfCourses, int highestScore) {
        int currentScore = 0;
        for (Student s: this.students) {
            ArrayList<Block> setBlocksForStudent = new ArrayList<Block>();
            for (Course preferredCourse: s.getPreferredCourses()) {
                Course current = findCourseByName(currentSetupOfCourses, preferredCourse.getName());
                if (!setBlocksForStudent.contains(current.getBlock())) {
                    setBlocksForStudent.add(current.getBlock());
                    currentScore += 1;
                }
            }
        }

        if (currentScore > highestScore) {
            return currentScore;
        }

        return highestScore;
    }

    public void createSchedules() {
        Course math = new Course("Math", "1");
        Course science = new Course("Science", "2");
        Course history = new Course("History", "3");
        Course english = new Course("English", "4");
        Course gym = new Course("Gym", "5");
        Course music = new Course("Music", "6");
        Course art = new Course("Art", "7");
        Course homeroom = new Course("Homeroom", "8");

        ArrayList<Course> courses1 = new ArrayList<Course>();
        courses1.add(math);
        courses1.add(science);
        courses1.add(history);
        courses1.add(english);

        ArrayList<Course> courses2 = new ArrayList<Course>();
        courses2.add(science);
        courses2.add(history);
        courses2.add(gym);
        courses2.add(music);

        ArrayList<Course> courses3 = new ArrayList<Course>();
        courses3.add(math);
        courses3.add(science);
        courses3.add(gym);
        courses3.add(art);

        ArrayList<Course> courses4 = new ArrayList<Course>();
        courses4.add(math);
        courses4.add(gym);
        courses4.add(music);
        courses4.add(art);

        ArrayList<Course> courses5 = new ArrayList<Course>();
        courses5.add(english);
        courses5.add(gym);
        courses5.add(art);
        courses5.add(homeroom);

        ArrayList<Course> courses6 = new ArrayList<Course>();
        courses6.add(science);
        courses6.add(history);
        courses6.add(music);
        courses6.add(homeroom);

        ArrayList<Course> courses7 = new ArrayList<Course>();
        courses7.add(gym);
        courses7.add(music);
        courses7.add(art);
        courses7.add(homeroom);

        ArrayList<Course> courses8 = new ArrayList<Course>();
        courses8.add(math);
        courses8.add(science);
        courses8.add(history);
        courses8.add(gym);

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
        courses.add(math);
        courses.add(science);
        courses.add(history);
        courses.add(english);
        courses.add(gym);
        courses.add(music);
        courses.add(art);
        courses.add(homeroom);

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
