import java.util.ArrayList;
import java.util.Objects;

class Teacher {
    Integer id;

    public Teacher() {

    }

    public String getName() {
        return name;
    }

    String name;
    String gender;
    static ArrayList<Teacher> teachers = new ArrayList<>();

    public Teacher(Integer id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        teachers.add(this);
    }

    public static void check(Integer id) {
        boolean found = false;
        for (Teacher teacher : teachers) {
            if (Objects.equals(teacher.id, id)) {
                System.out.print("ID: " + teacher.id);
                System.out.print("\t\tName: " + teacher.name);
                System.out.print("\t\tGender: " + teacher.gender);
                System.out.println();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Teacher ID not found!");
        }
    }


}