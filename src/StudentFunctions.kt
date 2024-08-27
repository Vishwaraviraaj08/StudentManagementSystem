fun createStudent(){
    print("Enter student name: ")
    val name = readln()
    var standard : Int;
    while(true){
        println("Enter student standard")
        standard = readLine()?.toInt() ?: -1
        if(standard in 1..10){
            break
        }
        println("Invalid Standard")
    }
    val student = Student(name, standard)

    students.add(student)

    println("Student added successfully with ID ${student.id}")
}





fun displayStudentInfo(student: Student){
    student.getStudentInfo()
}


fun displayAllStudentsInfo(){
    for(student in students){
        displayStudentInfo(student)
        println("---------------------------------")
    }
}

fun displayStudentInfoByName(name: String){
    val student = students.find { it.name == name }
    if (student != null) {
        displayStudentInfo(student)
    } else {
        println("No student found with name $name\n")

    }
}

fun displayStudentInfoByID(id: String){
    val student = students.find { it.id == id }
    if (student != null) {
        displayStudentInfo(student)
    } else {
        println("No student found for ID $id\n")
    }
}

fun displayStudentsInfoByStandard(standard: Int){
    val studentsInStandard = students.filter { it.standard == standard }
    if (studentsInStandard.isNotEmpty()) {
        for(student in studentsInStandard){
            displayStudentInfo(student)
            println("---------------------------------")
        }
    } else {
        println("No student found for standard $standard \n")
    }
}


fun displayStudentsInfoBySubject(subject: String){
    val studentsInSubject = students.filter { it.subjects.contains(subject) }
    if (studentsInSubject.isNotEmpty()) {
        for(student in studentsInSubject){
            displayStudentInfo(student)
            println("---------------------------------")
        }
    } else {
        println("No student found for subject $subject\n")
    }
}

fun displayStudentsInfoByFeeStatus(status: Boolean){
    val studentsWithFeeStatus = students.filter { it.fee.isPaid == status }
    if (studentsWithFeeStatus.isNotEmpty()) {
        for(student in studentsWithFeeStatus){
            displayStudentInfo(student)
            println("---------------------------------")
        }
    } else {
        println("No student found with fee status $status\n")
    }
}

fun completeAYear(){
    for (student in students){
        if (student.standard == 10){
            student.isActive = false
            continue
        }
        else {
            student.standard += 1
            student.subjects = Utilities.getSubjectsOfTheStandard(student.standard)
            student.marks[student.standard] = mutableMapOf<String, Double>().apply {
                for (subject in student.subjects) put(subject, 0.0)
            }
            student.fee.totalAmount += - student.fee.paidAmount + Utilities.getFeesForStandard(student.standard);
            student.fee.resetPaidAmount()
        }
    }
}




fun displayHighestScorerOnSubject(subject: String, standard : Int){
    val highestScorer = students.filter { it.standard == standard }
                                .maxByOrNull { it.marks[standard]?.get(subject)!! }
    if (highestScorer != null) {
        println("Highest scorer in $subject for standard $standard is ${highestScorer?.name} with marks ${highestScorer.marks[highestScorer.standard]?.get(subject)}\n")
    } else {
        println("No student found for standard $standard \n")
    }
}



fun displayHighestScorerOnTheStandard(standard: Int){
    val highestScorer = students.filter { it.standard == standard }
                                .maxBy { it.marks[standard]?.values?.sum()!! }
    println("Highest scorer in the $standard is ${highestScorer.marks[standard]?.values?.sum()} by ${highestScorer.name}\n")
    println()

}


// ---------------------- UPDATE STUDENT ----------------------


fun updateMark(student: Student, subject: String, marks: Double){
    student.marks[student.standard]?.set(subject, marks)
}

fun updateAllSubjectMarks(student: Student){
    for (subject in student.subjects){
        print("Enter marks for $subject: ")
        val marks = readLine()!!.toDouble()
        updateMark(student, subject, marks)
    }
    println("Marks updated successfully\n")
}


fun dropStudentByID(id : String){
    val student = students.find { it.id == id }
    if (student != null) {
        student.isActive = false
    } else {
        println("No student found for ID $id\n")
    }
}



// ---------------------- DELETE STUDENT ----------------------


fun deleteStudent(student: Student){
    students.remove(student)
}

fun deleteStudentByName(name: String){
    val student = students.find { it.name == name }
    if (student != null) {
        deleteStudent(student)
    } else {
        println("No student found with name $name\n")
    }
}

fun deleteStudentByID(id: String){
    val student = students.find { it.id == id }
    if (student != null) {
        deleteStudent(student)
    } else {
        println("No student found for ID $id\n")
    }
}