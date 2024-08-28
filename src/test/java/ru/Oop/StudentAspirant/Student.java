package ru.Oop.StudentAspirant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    protected String firstName;
    protected String lastName;
    protected String group;
    protected Double averageMark;

    private static final Integer SCHOLARSHIP_FOR_EXCELLENT_STUDENT_STUDIES = 2000;
    private static final Integer SCHOLARSHIP_FOR_THE_STUDENT_STUDIES = 1900;
    protected static final Double EXCELLENT_MARK = 5.0;
    public int getScholarship() {
    return EXCELLENT_MARK.equals(averageMark)
            ? SCHOLARSHIP_FOR_EXCELLENT_STUDENT_STUDIES :
            SCHOLARSHIP_FOR_THE_STUDENT_STUDIES;
    }
}
