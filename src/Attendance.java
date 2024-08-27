import java.util.HashMap;
import java.util.Map;

public class Attendance {
    Map<String, Boolean> attendanceRecord;

    public Attendance() {
        this.attendanceRecord = new HashMap<>();
    }

    public void markAttendance(String date, boolean present) {
        attendanceRecord.put(date, present);
    }

    public Boolean getAttendance(String date) {
        return attendanceRecord.get(date);
    }

    public Map<String, Boolean> getAttendanceRecord() {
        return attendanceRecord;
    }

    public int getNumberOfDaysPresent() {
        int count = 0;
        for (Boolean present : attendanceRecord.values()) {
            if (present) {
                count++;
            }
        }
        return count;
    }

    public int getNumberOfDaysAbsent() {
        int count = 0;
        for (Boolean present : attendanceRecord.values()) {
            if (!present) {
                count++;
            }
        }
        return count;
    }



}
