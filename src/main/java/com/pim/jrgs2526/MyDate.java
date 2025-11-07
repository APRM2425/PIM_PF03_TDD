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
        // --- B.3. UTILIDAD
    private static boolean isLeapYear(int y){
        if (y % 400 == 0) return true;
        if (y % 100 == 0) return false;
        return y % 4 == 0;
    }
        // --- B.2. UTILIDAD
    private static int daysInMonth(int y, Months m){
        switch (m){
            case JANUARY:
            case MARCH:
            case MAY:
            case JULY:
            case AUGUST:
            case OCTOBER:
            case DECEMBER:
                return 31;

            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:
                return 30;

            case FEBRUARY:
                return isLeapYear(y) ? 29 : 28;
            default:
                throw new IllegalArgumentException(ERR_INVALID_MONTH);
        }
    }
    public MyDate(int day, Months month, int year){
        // B. Validación en el constructor (para que pasen los tests de fechas válidas/invalidas)
        // --B.1. Mejora

        if (month == null) throw new IllegalArgumentException(ERR_INVALID_MONTH);
        int dim = daysInMonth(year, month);
        if (day < 1 || day > dim) throw new IllegalArgumentException(ERR_INVALID_DATE);

        this.year = year;
        this.month = month;
        this.day = day;
    }
    // C. Error: cannot find symbol method setMonth(...)
    public void setMonth(Months newMonth){
        if (newMonth == null) throw new IllegalArgumentException(ERR_INVALID_MONTH);
        int dim = daysInMonth(this.year, newMonth);
        // si el día actual NO cabe en el nuevo mes → ERR_INVALID_MONTH
        if (this.day < 1 || this.day > dim) throw new IllegalArgumentException(ERR_INVALID_MONTH);
        this.month = newMonth;
    }

    // D. Error: cannot find symbol method setDay(int)
    public void setDay(int newDay){
        int dim = daysInMonth(this.year, this.month);
        if (newDay < 1 || newDay > dim) {
            throw new IllegalArgumentException(ERR_INVALID_DAY);
        }
        this.day = newDay;
    }

    // E. Error: cannot find symbol method setYear(int)
    public void setYear(int newYear){
        if (newYear < 0) throw new IllegalArgumentException(ERR_INVALID_YEAR);
        int dim = daysInMonth(newYear, this.month);
        if (this.day < 1 || this.day > dim) throw new IllegalArgumentException(ERR_INVALID_YEAR);
        this.year = newYear;
    }
}
