package logic.entropy;

import config.Probabilities;
import logic.util.Logarithm;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculateEntropy {

    public static double calculate() {

        double sum = 0;

        for (Double prob : Probabilities.getProbabilities()) {
            sum += prob * Logarithm.log(prob, 2);
        }

        sum = -sum;

        return new BigDecimal(sum).setScale(4, RoundingMode.HALF_UP).doubleValue();

    }
}
