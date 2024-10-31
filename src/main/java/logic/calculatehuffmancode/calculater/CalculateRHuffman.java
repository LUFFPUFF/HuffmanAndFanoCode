package logic.calculatehuffmancode.calculater;

import logic.calculatehuffmancode.calculateHuffmanlength.CalculateLengthHuffman;
import logic.entropy.CalculateEntropy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculateRHuffman {

    public static double calculate() {
        double result = CalculateLengthHuffman.calculate() - CalculateEntropy.calculate();
        return new BigDecimal(result).setScale(4, RoundingMode.HALF_UP).doubleValue();
    }
}
