import java.util.*;

public class SchedulerTry2 {
    public ArrayList<Course> courses;
    public ArrayList<Student> students;
    public Map<Course, ArrayList<Student>> coursesToStudentList;
    public double highestScore = 0;
    public ArrayList<Course> highestScoreArray = new ArrayList<Course>();

    public SchedulerTry2() {
        this.courses = new ArrayList<Course>();
        this.students = new ArrayList<Student>();
        this.coursesToStudentList = new HashMap<Course, ArrayList<Student>>();
    }

    public static void main(String[] args) {

        SchedulerTry2 s = new SchedulerTry2();
        s.InitializeData();
        s.addStudentsToMap();
        s.useMapOfCourseNameToAllBlocksToCreateAllPermutationsOfCoursesAndBlocks(s.go());

    }

    public void checkCompatibilityOnAllBlockPermutations() {
        ArrayList<ArrayList<Course>> allBlockCombinationsForCourses = new ArrayList<ArrayList<Course>>();

        // populate it

        for (ArrayList<Course> oneSetOfBlocks : allBlockCombinationsForCourses) {
            this.checkStudentsCompatibility(oneSetOfBlocks);
        }
    }

    public void checkStudentsCompatibility(ArrayList<Course> courses)
    {
        double score = 0;
        for (Student s : this.students) {
            score += s.checkScore(courses);
        }

        if (score > this.highestScore) {
            this.highestScore = score;
            this.highestScoreArray = new ArrayList<Course>(courses);
        }
    }





    private void addStudentsToMap() {
        for (Student s : this.students) {
            for (Course c : s.getPreferredCourses()) {
                boolean alreadyAdded = false;

                for (Course c2 : this.courses) {
                    if (c.getName().equals(c2.getName())) {
                        alreadyAdded = true;
                    }
                }

                if (alreadyAdded) {
                    this.coursesToStudentList.get(c).add(s);
                }
                else {
                    this.courses.add(c);
                    this.coursesToStudentList.put(c, new ArrayList<Student>());
                    this.coursesToStudentList.get(c).add(s);
                }
            }
        }
    }

    private void InitializeData() {
        // Create Courses
        Course math = new Course("Math", "1");
        Course science = new Course("Science", "2");
        Course history = new Course("History", "3");
        Course english = new Course("English", "4");
        Course gym = new Course("Gym", "5");
        Course music = new Course("Music", "6");
        Course art = new Course("Art", "7");
        Course homeroom = new Course("Homeroom", "8");
        Course film = new Course("Film", "9");

        // Student suggested schedules
        ArrayList<Course> alisonCourse = new ArrayList<Course>();
        alisonCourse.add(math);
        alisonCourse.add(science);
        alisonCourse.add(history);
        alisonCourse.add(english);

        ArrayList<Course> billCourse = new ArrayList<Course>();
        billCourse.add(science);
        billCourse.add(history);
        billCourse.add(gym);
        billCourse.add(music);

        ArrayList<Course> chrisCourse = new ArrayList<Course>();
        chrisCourse.add(math);
        chrisCourse.add(science);
        chrisCourse.add(gym);
        chrisCourse.add(art);

        ArrayList<Course> deanCourse = new ArrayList<Course>();
        deanCourse.add(math);
        deanCourse.add(gym);
        deanCourse.add(music);
        deanCourse.add(art);

        ArrayList<Course> eleanorCourse = new ArrayList<Course>();
        eleanorCourse.add(english);
        eleanorCourse.add(gym);
        eleanorCourse.add(art);
        eleanorCourse.add(homeroom);

        ArrayList<Course> frankCourse = new ArrayList<Course>();
        frankCourse.add(science);
        frankCourse.add(history);
        frankCourse.add(music);
        frankCourse.add(homeroom);

        ArrayList<Course> garthCourse = new ArrayList<Course>();
        garthCourse.add(gym);
        garthCourse.add(music);
        garthCourse.add(art);
        garthCourse.add(homeroom);

        ArrayList<Course> heatherCourse = new ArrayList<Course>();
        heatherCourse.add(math);
        heatherCourse.add(science);
        heatherCourse.add(history);
        heatherCourse.add(gym);

        ArrayList<Course> ivanCourse = new ArrayList<Course>();
        ivanCourse.add(science);
        ivanCourse.add(music);
        ivanCourse.add(english);
        ivanCourse.add(history);

        ArrayList<Course> jakeCourse = new ArrayList<Course>();
        jakeCourse.add(homeroom);
        jakeCourse.add(gym);
        jakeCourse.add(art);
        jakeCourse.add(film);

        ArrayList<Course> kevinCourse = new ArrayList<Course>();
        kevinCourse.add(math);
        kevinCourse.add(music);
        kevinCourse.add(english);
        kevinCourse.add(history);

        ArrayList<Course> lauraCourse = new ArrayList<Course>();
        lauraCourse.add(art);
        lauraCourse.add(music);
        lauraCourse.add(english);
        lauraCourse.add(homeroom);

        // Create Students
        Student s1 = new Student("Alison",alisonCourse, 3.9);
        Student s2 = new Student("Bill",billCourse, 3.7);
        Student s3 = new Student("Chris",chrisCourse, 3.5);
        Student s4 = new Student("Dean",deanCourse, 3.3);
        Student s5 = new Student("Eleanor",eleanorCourse, 3.2);
        Student s6 = new Student("Frank",frankCourse, 3.1);
        Student s7 = new Student("Garth",garthCourse, 3.0);
        Student s8 = new Student("Heather",heatherCourse, 2.9);
        Student s9 = new Student("Ivan",ivanCourse, 2.8);
        Student s10 = new Student("Jake",jakeCourse, 2.8);
        Student s11 = new Student("Kevin",kevinCourse, 2.8);
        Student s12 = new Student("Laura",lauraCourse, 2.8);

        this.students.add(s1);
        this.students.add(s2);
        this.students.add(s3);
        this.students.add(s4);
        this.students.add(s5);
        this.students.add(s6);
        /*
        this.students.add(s7);
        this.students.add(s8);
        this.students.add(s9);
        this.students.add(s10);
        this.students.add(s11);
        this.students.add(s12);*/
    }

// Makes map of course name to list of the course repeated with different blocks
    public Map<String, ArrayList<Course>> go() {
        Map<String, ArrayList<Course>> nameOfCourseToListOfAllBlocks = new HashMap<String, ArrayList<Course>>();

        for (Course c : this.courses) {
            nameOfCourseToListOfAllBlocks.put(c.getName(), new ArrayList<Course>());
            for (Block b : Block.values()) {
                if (b != Block.UNDECIDED) {
                    Course courseToAdd = new Course(c);
                    courseToAdd.setBlock(b);
                    nameOfCourseToListOfAllBlocks.get(c.getName()).add(courseToAdd);
                }
            }
        }

        return nameOfCourseToListOfAllBlocks;
    }



    static int[] digits = new int[] {1, 2, 3, 4};

    ArrayList<Integer> listOfAllNumberCombos = new ArrayList<Integer>();

    public void Rec(int current, int numDigits) {

        if(numDigits==0) {
            listOfAllNumberCombos.add(current);
            //System.out.println(current);
        }
        else {
            for (int x : digits)
                Rec(current * 10 + x, numDigits - 1);
        }
    }

    public void useMapOfCourseNameToAllBlocksToCreateAllPermutationsOfCoursesAndBlocks(Map<String, ArrayList<Course>> nameOfCourseToListOfAllBlocks) {
        ArrayList<Course> current = new ArrayList<Course>();
        Map<String, Integer> counterOfIndexForEachCourseArrayInMap = new HashMap<String, Integer>();

        ArrayList<String> names = new ArrayList<String>(nameOfCourseToListOfAllBlocks.keySet());

        this.Rec(0, names.size());

        for (int i = 0; i < listOfAllNumberCombos.size(); i += 1) {


                counterOfIndexForEachCourseArrayInMap.clear();

                for (int j = 0; j < names.size(); j += 1) {
                    String number = String.valueOf(listOfAllNumberCombos.get(i));

                    counterOfIndexForEachCourseArrayInMap.put(names.get(j), Integer.parseInt(String.valueOf(number.charAt(j))) - 1);
                }


                for (int j = 0; j < names.size(); j += 1) {
                    // Adds the course of the specified name with the corresponding block in the counter hash to the current list of classes
                    current.add(nameOfCourseToListOfAllBlocks.get(names.get(j)).get(counterOfIndexForEachCourseArrayInMap.get(names.get(j))));
                }

                this.checkStudentsCompatibility(current);
                current.clear();
        }

        System.out.println(highestScore);

        for (Student s : students) {
            s.printSchedule(this.highestScoreArray);
        }

        /*for (int i = 0; i < highestScoreArray.size(); i += 1) {
            System.out.println(highestScoreArray.get(i).getName() + "     Block: " + highestScoreArray.get(i).getBlock());
        }*/
    }
}
