import java.time.LocalDate
import java.util.Date

fun bulkPresent(studentsToMarkPresent: MutableList<String>, date: String = LocalDate.now().toString()){
    val studentObjects = students.filter { it.id in studentsToMarkPresent }
    for(student in studentObjects){
        student.markAttendance(date, 1)
    }

    bulkPresentSupporter(students.filter { it !in studentObjects }.toMutableList(), date)
}


fun bulkPresentSupporter(studentsToMarkAbsent: MutableList<Student>, date: String = LocalDate.now().toString()) {
    for (student in studentsToMarkAbsent) {
        student.markAttendance(date, 0)
    }
}






fun bulkAbsent(studentsToMarkAbsent: MutableList<String>, date: String = LocalDate.now().toString()){
    val studentObjects = students.filter { it.id in studentsToMarkAbsent }
    for(student in studentObjects){
        student.markAttendance(date, 0)
    }

    bulkAbsentSupporter(students.filter { it !in studentObjects }.toMutableList(), date)
}


fun bulkAbsentSupporter(studentsToMarkPresent: MutableList<Student>, date: String = LocalDate.now().toString()) {
    for (student in studentsToMarkPresent) {
        student.markAttendance(date, 1)
    }
}

