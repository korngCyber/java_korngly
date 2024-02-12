import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Schedule schedule = new Schedule();
        // Populate teachers
        Teacher teacher1 = new Teacher(1, "Sza", "male");
        Teacher teacher2 = new Teacher(2, "Justint", "male");
        Teacher teacher3 = new Teacher(3, "Weeken", "male");
        Teacher teacher4 = new Teacher(4, "Woko", "female");
        Teacher teacher5 = new Teacher(5, "Ello", "female");

        int choosedOption;
        do {
            System.out.println("===========================><=================================");
            System.out.println("1. Check teacher");
            System.out.println("2. Check shift");
            System.out.println("3. Add teacher to class");
            System.out.println("4. Check all information");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            choosedOption = sc.nextInt();
            System.out.println("===========================><=================================");
            switch (choosedOption) {
                case 1:
                    System.out.println("All Teachers:");
                    for (Teacher teacher : Teacher.teachers) {
                        Teacher.check(teacher.id);
                    }
                    break;
                case 2:
                    System.out.print("Choose shift (1/Morning, 2/Afternoon, 3/Evening): ");
                    int shiftChoice = sc.nextInt();
                    Shift shift = null;
                    switch (shiftChoice) {
                        case 1:
                            shift = new Shift("Morning");
                            break;
                        case 2:
                            shift = new Shift("Afternoon");
                            break;
                        case 3:
                            shift = new Shift("Evening");
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            break;
                    }
                    if (shift != null) {
                        Shift.display(shift);
                    }
                    break;
                case 3:
                    System.out.print("Enter teacher ID: ");
                    int teacherId = sc.nextInt();
                    Teacher selectedTeacher = null;
                    for (Teacher teacher : Teacher.teachers) {
                        if (teacher.id == teacherId) {
                            selectedTeacher = teacher;
                            break;
                        }
                    }
                    if (selectedTeacher == null) {
                        System.out.println("Teacher ID not found!");
                        break;
                    }

                    System.out.print("Enter subject ID: ");
                    int subjectId = sc.nextInt();
                    Subject selectedSubject = null;
                    for (Subject subject : schedule.subjects) {
                        if (subject.subID == subjectId) {
                            selectedSubject = subject;
                            break;
                        }
                    }
                    if (selectedSubject == null) {
                        System.out.println("Subject ID not found!");
                        break;
                    }

                    System.out.print("Choose shift (1/Morning, 2/Afternoon, 3/Evening): ");
                    int shiftChoiceAdd = sc.nextInt();
                    String shiftName = "";
                    switch (shiftChoiceAdd) {
                        case 1:
                            shiftName = "Morning";
                            break;
                        case 2:
                            shiftName = "Afternoon";
                            break;
                        case 3:
                            shiftName = "Evening";
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            break;
                    }

                    if (!shiftName.equals("")) {
                        System.out.println("Selected Shift: " + shiftName);
                    }

                    if (!shiftName.equals("")) {
                        System.out.println("Classes available in " + shiftName + " shift:");
                        for (ClassRoom cr : new Shift(shiftName).getClasses()) {
                            System.out.println("\t" + cr.getClassNo() + ". " + cr.getClassName());
                        }
                        System.out.print("Choose a class by entering class ID that is available: ");
                        int classChoice = sc.nextInt();

                        if (!ClassRoom.isAvailableClassRoom(classChoice)) {
                            System.out.println("Invalid class choice. Class not available.");
                            break;
                        }

                        // Assign teacher to class
                        ClassRoom.assignTeacherToClass(selectedTeacher, selectedSubject, classChoice, shiftName);
                        System.out.println("Teacher assigned successfully to class " + classChoice + " in " + shiftName + " shift.");
                    }
                    break;
                case 4:
                    System.out.println("All Information:");
                    System.out.println("Subjects:");
                    for (Subject subject : schedule.subjects) {
                        System.out.println("Subject ID: " + subject.subID + ", Subject Name: " + subject.subName);
                    }
                    System.out.println("Teachers:");
                    for (Teacher teacher : Teacher.teachers) {
                        System.out.println("ID: " + teacher.id + ", Name: " + teacher.name + ", Gender: " + teacher.gender);
                    }
                    System.out.println("Shifts:");
                    for (Shift shiftt : new Shift[]{new Shift("Morning"), new Shift("Afternoon"), new Shift("Evening")}) {
                        Shift.display(shiftt);
                    }
                    System.out.println("Classrooms:");
                    ClassRoom.displayAvailableAndUnavailableClasses();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (choosedOption != 0);
        sc.close();
    }
}
