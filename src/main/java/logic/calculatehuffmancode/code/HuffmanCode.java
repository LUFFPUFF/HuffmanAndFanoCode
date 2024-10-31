package logic.calculatehuffmancode.code;

import logic.calculatehuffmancode.calculate.CalculateHuffmanCode;
import logic.calculatehuffmancode.config.ConfigHuffmanCode;

import java.util.ArrayList;
import java.util.List;

public class HuffmanCode {

    public static String z1 = CalculateHuffmanCode.getCodes(ConfigHuffmanCode.root).get("z1");
    public static String z2 = CalculateHuffmanCode.getCodes(ConfigHuffmanCode.root).get("z2");
    public static String z3 = CalculateHuffmanCode.getCodes(ConfigHuffmanCode.root).get("z3");
    public static String z4 = CalculateHuffmanCode.getCodes(ConfigHuffmanCode.root).get("z4");
    public static String z5 = CalculateHuffmanCode.getCodes(ConfigHuffmanCode.root).get("z5");
    public static String z6 = CalculateHuffmanCode.getCodes(ConfigHuffmanCode.root).get("z6");
    public static String z7 = CalculateHuffmanCode.getCodes(ConfigHuffmanCode.root).get("z7");
    public static String z8 = CalculateHuffmanCode.getCodes(ConfigHuffmanCode.root).get("z8");
    public static String z9 = CalculateHuffmanCode.getCodes(ConfigHuffmanCode.root).get("z9");
    public static String z10 = CalculateHuffmanCode.getCodes(ConfigHuffmanCode.root).get("z10");

    public static List<String> getHuffmanCode() {
        return new ArrayList<>(List.of(
                z1, z2, z3, z4, z5, z6, z7, z8, z9, z10
        ));
    }
}
