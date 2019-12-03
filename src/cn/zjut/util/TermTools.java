package cn.zjut.util;

import java.util.Calendar;

public class TermTools {
    public static String getTerm() {
        String term;
        Calendar a = Calendar.getInstance();
        int currentYear = a.get(Calendar.YEAR);
        int currentMonth = a.get(Calendar.MONTH) + 1;
        if (currentMonth >= 3 && currentMonth < 9) {
            term = currentYear + "-" + String.valueOf(currentYear + 1) + "(2)";
        } else {
            term = String.valueOf(currentYear) + "-" + String.valueOf(currentYear + 1) + "(1)";
        }
        return term;
    }
}
