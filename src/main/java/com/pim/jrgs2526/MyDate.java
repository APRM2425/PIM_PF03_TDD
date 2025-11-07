package com.pim.jrgs2526;

public class MyDate {

    public static final String ERR_INVALID_YEAR = "Year value not valid";
    public static final String ERR_INVALID_MONTH = "Month value not valid";
    public static final String ERR_INVALID_DAY = "Day value not valid";
    public static final String ERR_INVALID_DATE = "Invalid date";

    public enum Months {
        JANUARY(1),
        FEBRUARY(2),
        MARCH(3),
        APRIL(4),
        MAY(5),
        JUNE(6),
        JULY(7),
        AUGUST(8),
        SEPTEMBER(9),
        OCTOBER(10),
        NOVEMBER(11),
        DECEMBER(12);

        public final int monthNumber;

        private Months(int monthNumber) {
            this.monthNumber = monthNumber;
        }

        public static Months toMonth( int monthNumber ) {
            for (Months m : values())
                if (m.monthNumber == monthNumber)
                    return m;
            return null;
        }
    }
    // A. Error: constructor MyDate … required: no arguments; found: int, Months, int
    // ---A.1. CAMPOS (necesarios para los setters que prueban los tests)
    private int year;
    private Months month;
    private int day;

    // ---A.2. Constructor vacío
    public MyDate(){ this.year=2000; this.month=Months.JANUARY; this.day=1; }

    // ---A.3. Constructor con parámetros (de momento SOLO asigna)
    public MyDate(int day, Months month, int year){
        this.year = year;
        this.month = month;
        this.day = day;
    }
}
