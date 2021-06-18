package com.bridgelabz.selenium.utility;

public class utility {
    public static String getString(String Itr) {
        Itr = Itr.replaceAll("[^\\d]", " ");
        Itr = Itr.trim();
        Itr = Itr.replaceAll(" +", " ");
        return Itr;
    }

    public static String getValue(String Itr) {
        Itr = Itr.replaceAll("[^\\d]", " ");
        Itr = Itr.trim();
        Itr = Itr.replaceAll(" +", " ");
        return Itr;
    }

    public static String[] getArray(String Itr) {
        String ItrArray[] = Itr.split(" ");
        return ItrArray;
    }
}
