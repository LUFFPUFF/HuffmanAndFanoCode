package logic.calculatefanocode.calculatelength;

import logic.calculatefanocode.calculate.CalculateFanoCode;
import logic.calculatehuffmancode.config.ConfigHuffmanCode;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class CalculateLengthFano {

    private static final Map<String, String> codes = CalculateFanoCode.getCodes();
    private static final HashMap<String, Double> probabilities = ConfigHuffmanCode.frequencyMap;

    public static double calculate() {
        double averageLength = 0.0;

        for (Map.Entry<String, String> entry : codes.entrySet()) {
            String symbol = entry.getKey();
            String code = entry.getValue();
            double probability = probabilities.get(symbol);
            averageLength += code.length() * probability;
        }

        return new BigDecimal(averageLength).setScale(4, RoundingMode.HALF_UP).doubleValue();
    }
}
