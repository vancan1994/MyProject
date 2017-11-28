package business;
public class Student {
    private int studentID;
    private String studentName;

  
    //This is fist
    public Student(int studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
   //to String
    @Override
    public String toString() {
        return "xxxxxxxxxxxxxxxx";
    }
}
