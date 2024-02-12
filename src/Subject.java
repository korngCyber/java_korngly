import java.util.ArrayList;

class Subject {
    int subID;
    String subName;
    static final ArrayList<Subject> subjects = new ArrayList<>();

    public Subject(int subID, String subName) {
        this.subID = subID;
        this.subName = subName;
        subjects.add(this);
    }

    public static void check(int id) {
        for (Subject subj : subjects) {
            if (subj.subID == id) {
                System.out.println("Subject ID: " + subj.subID);
                System.out.println("Subject Name: " + subj.subName);
                return;
            }
        }
        System.out.println("Subject not found");
    }
}