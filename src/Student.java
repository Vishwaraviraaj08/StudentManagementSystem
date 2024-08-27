import java.util.*;
import java.util.stream.Collectors;

public class Student {


    String name;
    String id ;
    int standard;
    Fee fee;
    Attendance attendance;
    List<String> subjects;
    Map<Integer, Map<String, Double>> marks;
    boolean isActive = true;


    public Student(String name, int standard) {
        this.name = name;
        this.standard = standard;
        this.id = "SEC-ID-" + Utilities.assignID();

        this.fee = new Fee();
        this.fee.setTotalAmount(Utilities.getFeesForStandard(standard));

        this.attendance = new Attendance();
        this.subjects = Utilities.getSubjectsOfTheStandard(standard);

        this.marks = new HashMap<>(
                Map.of(
                        standard, new HashMap<>(
                                this.subjects.stream().map(subject -> Map.entry(subject, 0.0))
                                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                        )
                )
        );

    }

    public String getName() {
        return name;
    }

    public int getStandard() {
        return standard;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void markAttendance(String date, int present) {
        attendance.markAttendance(date, present == 1);
    }


    public void getStudentInfo() {
        System.out.println("Name: " + name + "\n" +
                "ID: " + id + "\n" +
                "Standard: " + standard + "\n" +
                "Total Fee: " + fee.getTotalAmount() + "\n" +
                "Amount Paid: " + fee.getPaidAmount()+ "\n" +
                "Subjects: " + subjects + "\n" +
                "Marks: " + marks.get(standard) + "\n" +
                "Attendance: " + attendance.getAttendanceRecord() + "\n" +
                "Marks History" + marks + "\n" ) ;
    }



}
