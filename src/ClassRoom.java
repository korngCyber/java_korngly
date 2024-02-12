import java.util.ArrayList;

class ClassRoom {
    private int classNo;
    private String className;
    private boolean assigned = false; // Track if the class is assigned
    private Teacher assignedTeacher; // Reference to the assigned teacher
    private Subject assignedSubject; // Reference to the assigned subject

    private static ArrayList<ClassRoom> classes = new ArrayList<>();

    public ClassRoom() {
    }

    public ClassRoom(int classNo, String className) {
        this.classNo = classNo;
        this.className = className;
        classes.add(this);
    }

    public int getClassNo() {
        return classNo;
    }

    public void setClassNo(int classNo) {
        this.classNo = classNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public Teacher getAssignedTeacher() {
        return assignedTeacher;
    }

    public Subject getAssignedSubject() {
        return assignedSubject;
    }

    public static ArrayList<ClassRoom> getClasses() {
        return classes;
    }

    public static boolean isAvailableClassRoom(int id) {
        for (ClassRoom classroom : classes) {
            if (classroom.getClassNo() == id && !classroom.isAssigned()) {
                return true;
            }
        }
        return false;
    }

    public static boolean assignTeacherToClass(Teacher teacher, Subject subject, int classNo, String shiftName) {
        for (ClassRoom classroom : classes) {
            if (classroom.getClassNo() == classNo && !classroom.isAssigned()) {
                // Assign teacher and subject to class
                classroom.assignedTeacher = teacher;
                classroom.assignedSubject = subject;
                classroom.assigned = true;
                break;
            }
        }
        return false;
    }

    public static void checkClassRoom(int id) {
        for (ClassRoom classroom : classes) {
            if (classroom.getClassNo() == id) {
                System.out.println("Class ID: " + classroom.classNo);
                System.out.println("Class Name: " + classroom.className);
                return;
            }
        }
        System.out.println("Classroom not found!");
    }

    public static void displayAvailableAndUnavailableClasses() {
        System.out.println("Available Classes:");
        for (ClassRoom classroom : classes) {
            if (!classroom.isAssigned()) {
                System.out.println("Class ID: " + classroom.classNo + ", Class Name: " + classroom.className);
            }
        }
        System.out.println("\nUnavailable Classes:");
        for (ClassRoom classroom : classes) {
            if (classroom.isAssigned()) {
                Teacher teacher = classroom.getAssignedTeacher();
                Subject subject = classroom.getAssignedSubject();
                System.out.println("Class ID: " + classroom.classNo + ", Class Name: " + classroom.className +
                        ", Assigned Teacher: " + teacher.getName() + " (ID: " + teacher.id + "), Assigned Subject: " + subject.subName + " (ID: " + subject.subID + ")");
            }
        }
    }
}
