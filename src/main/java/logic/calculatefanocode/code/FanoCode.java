package logic.calculatefanocode.code;

import logic.calculatefanocode.calculate.CalculateFanoCode;

import java.util.ArrayList;
import java.util.List;

public class FanoCode {

    public static String z1 = CalculateFanoCode.getCodes().get("z1");
    public static String z2 = CalculateFanoCode.getCodes().get("z2");
    public static String z3 = CalculateFanoCode.getCodes().get("z3");
    public static String z4 = CalculateFanoCode.getCodes().get("z4");
    public static String z5 = CalculateFanoCode.getCodes().get("z5");
    public static String z6 = CalculateFanoCode.getCodes().get("z6");
    public static String z7 = CalculateFanoCode.getCodes().get("z7");
    public static String z8 = CalculateFanoCode.getCodes().get("z8");
    public static String z9 = CalculateFanoCode.getCodes().get("z9");
    public static String z10 = CalculateFanoCode.getCodes().get("z10");

    public static List<String> getFanoCode() {
        return new ArrayList<>(List.of(
                z1, z2, z3, z4, z5, z6, z7, z8, z9, z10
        ));
    }
}
