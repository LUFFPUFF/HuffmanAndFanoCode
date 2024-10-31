package logic.calculatefanocode.calculater;

import logic.calculatefanocode.calculatelength.CalculateLengthFano;
import logic.entropy.CalculateEntropy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculateRFano {

    public static double calculate() {
        double result = CalculateLengthFano.calculate() - CalculateEntropy.calculate();
        return new BigDecimal(result).setScale(4, RoundingMode.HALF_UP).doubleValue();
    }
}
