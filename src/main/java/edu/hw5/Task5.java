package edu.hw5;

public class Task5 {

    private Task5() {

    }

    public static boolean validatePlateNumber(String plateNumber) {
        String regex = "[A-Z]\\d{3}[A-Z]{2}\\d{2,3}";
        return plateNumber.matches(regex);

    }
}
