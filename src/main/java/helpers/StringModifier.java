package helpers;

/*
* class witch helps work with Strings
*
* For example:
* get rid of numbers from string, make string unique etc.
*
*
* */


import java.text.SimpleDateFormat;
import java.util.Date;

public class StringModifier {
    public static String getUniqueString(String str) {
        return str + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    }
}
