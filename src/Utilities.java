import javax.security.auth.Subject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utilities {

    private static int idCounter = 1;

    private static final Map<Integer, List<String>> standardMap = new HashMap<>(
            Map.of(
                    1, List.of("Maths", "Science", "English"),
                    2, List.of("Maths", "Science", "English"),
                    3, List.of("Maths", "Science", "English"),
                    4, List.of("Maths", "Social", "English"),
                    5, List.of("Maths", "Social", "English"),
                    6, List.of("Chemistry", "Physics", "Computer Science", "Math"),
                    7, List.of("Chemistry", "Physics", "Computer Science", "Math"),
                    8, List.of("Chemistry", "Physics", "Computer Science", "Math"),
                    9, List.of("Chemistry", "Physics", "Biology", "Math"),
                    10, List.of("Chemistry", "Physics", "Biology", "Math")
            )
    );


    private static final Map<Integer, Double> fees = new HashMap<>(
            Map.of(
                    1, 10000.0,
                    2, 15000.0,
                    3, 20000.0,
                    4, 25000.0,
                    5, 30000.0,
                    6, 35000.0,
                    7, 40000.0,
                    8, 45000.0,
                    9, 50000.0,
                    10, 55000.0
            )
    );


    public static List<String> getSubjectsOfTheStandard(int standard) {
        return standardMap.get(standard);
    }

    public static Double getFeesForStandard(int standard) {
        Double fee = fees.get(standard);
        if (fee == null) {
            throw new IllegalArgumentException("Invalid standard: " + standard);
        }
        return fee;
    }


    public static int assignID(){
        return idCounter++;
    }
}