import java.util.ArrayList;

class Shift {
    String shiftName;
    private ArrayList<ClassRoom> classes = new ArrayList<>();

    public Shift() {
    }

    public Shift(String shiftName) {
        this.shiftName = shiftName;
        if (shiftName.equals("Morning")) {
            classes.add(new ClassRoom(101, "M1"));
            classes.add(new ClassRoom(102, "M2"));
            classes.add(new ClassRoom(103, "M3"));
            classes.add(new ClassRoom(104, "M4"));
        } else if (shiftName.equals("Afternoon")) {
            classes.add(new ClassRoom(101, "A1"));
            classes.add(new ClassRoom(102, "A2"));
            classes.add(new ClassRoom(103, "A3"));
            classes.add(new ClassRoom(104, "A4"));

        } else if (shiftName.equals("Evening")) {
            classes.add(new ClassRoom(101, "E1"));
            classes.add(new ClassRoom(102, "E2"));
            classes.add(new ClassRoom(103, "E3"));
            classes.add(new ClassRoom(104, "E4"));
        }
    }

    public String getShiftName() {
        return shiftName;
    }
    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }
    public ArrayList<ClassRoom> getClasses() {
        return classes;
    }
    public static void display(Shift s) {
        System.out.println("Shift Name: " + s.getShiftName());
        for (ClassRoom classroom : s.getClasses()) {
            System.out.println("Class Available: Class Name: " + classroom.getClassName() + ", Class No: " + classroom.getClassNo());
        }
    }
}