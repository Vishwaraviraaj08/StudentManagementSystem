
var students: MutableList<Student> = mutableListOf()

fun main() {
    val student1 = Student("John", 2)
    student1.markAttendance("2024-08-28", 1)
    student1.markAttendance("2024-08-29", 0)
    student1.markAttendance("2024-08-30", 1)
    for(i in student1.subjects){
        student1.marks[student1.standard]?.set(i, 10.0)
    }

    student1.fee.setPaidAmount(1000.0)
    student1.fee.setPaidAmount(2000.0)
    students.add(student1)

    student1.getStudentInfo()
    println("---------------------------------")



    val student2 = Student("Henry", 4)
    student2.markAttendance("2024-08-28", 1)
    student2.markAttendance("2024-08-29", 0)
    student2.markAttendance("2024-08-30", 0)
    for(i in student2.subjects){
        student2.marks[student2.standard]?.set(i, 20.0)
    }

    student2.fee.setPaidAmount(1000.0)
    student2.fee.setPaidAmount(2000.0)
    students.add(student2)

    student2.getStudentInfo()
    println("---------------------------------")


    val student3 = Student("Alex", 5)
    student3.markAttendance("2024-08-28", 0)
    student3.markAttendance("2024-08-29", 0)
    student3.markAttendance("2024-08-30", 1)
    println("Marks for student 3")
    for(i in student3.subjects){
        print("$i : ")
        val mark = readln().toDouble();
        student3.marks[student3.standard]?.set(i, mark)
    }

    student3.fee.setPaidAmount(1000.0)
    student3.fee.setPaidAmount(2000.0)
    students.add(student3)
    println(student3.attendance.getAttendanceRecord())

    student3.getStudentInfo()
    println("---------------------------------")

//    displayHighestScorerOnTheStandard(2)
//    displayHighestScorerOnSubject("Maths", 2)
//
//    createStudent()
//    LocalDate.now().toString()


    completeAYear()


    displayStudentInfoByID("SEC-ID-1")
    println("PAID AMOUNT : " + student1.fee.paidAmount)

    updateAllSubjectMarks(students[0])

    displayStudentInfoByID("SEC-ID-1")

    bulkPresent(mutableListOf("SEC-ID-1", "SEC-ID-2"), "2024-08-31")
    bulkAbsent(mutableListOf("SEC-ID-3", "SEC-ID-4"), "2024-08-31")

}