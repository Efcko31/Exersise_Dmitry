package ru.Oop.StudentAspirant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Aspirant extends Student {
    protected String scientificWork;

    private static final Integer SCHOLARSHIP_FOR_EXCELLENT_STUDENT_STUDIES = 2500;
    private static final Integer SCHOLARSHIP_FOR_THE_STUDENT_STUDIES = 2200;
    protected static final Double EXCELLENT_MARK = 5.0;
    public Aspirant(String firstName, String lastName, String group, Double averageMark, String scientificWork) {
        super(firstName, lastName, group, averageMark);
        this.scientificWork = scientificWork;
    }

    @Override
    public int getScholarship() {
        return EXCELLENT_MARK.equals(averageMark) ?
                SCHOLARSHIP_FOR_EXCELLENT_STUDENT_STUDIES :
                SCHOLARSHIP_FOR_THE_STUDENT_STUDIES;
    }
}

