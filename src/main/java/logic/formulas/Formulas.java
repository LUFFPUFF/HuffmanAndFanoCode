package logic.formulas;

import logic.calculatefanocode.calculate.CalculateFanoCode;
import logic.calculatehuffmancode.config.ConfigHuffmanCode;
import config.Probabilities;

import java.util.HashMap;
import java.util.Map;

import static logic.calculatehuffmancode.calculateHuffmanlength.CalculateLengthHuffman.calculateCodeLengths;

public class Formulas {

    public static final String formulasR = "r = L - H(X) = ";

    public static String getFormulasAvgLengthHuffman() {
        StringBuilder builder = new StringBuilder();
        Map<String, Integer> codeLengths = calculateCodeLengths(ConfigHuffmanCode.root);

        for (Map.Entry<String, Double> entry : ConfigHuffmanCode.frequencyMap.entrySet()) {
            String symbol = entry.getKey();
            double frequency = entry.getValue();
            int codeLength = codeLengths.getOrDefault(symbol, 0);
            builder.append("(").append(frequency).append(" * ").append(codeLength).append(")").append(" + ");
        }
        return "L = " + builder;
    }

    public static String getFormulasAvgLengthFano() {
        Map<String, String> codes = CalculateFanoCode.getCodes();
        HashMap<String, Double> probabilities = ConfigHuffmanCode.frequencyMap;
        StringBuilder builder = new StringBuilder();

        for (Map.Entry<String, String> entry : codes.entrySet()) {
            String symbol = entry.getKey();
            String code = entry.getValue();
            double probability = probabilities.get(symbol);

            builder.append("(").append(code.length()).append(" * ").append(probability).append(")").append(" + ");
        }

        return "L = " + builder;
    }

    public static String formulasEntropy() {
        StringBuilder builder = new StringBuilder();
        for (Double prob : Probabilities.getProbabilities()) {
            builder.append(prob).append("log2").append("(").append(prob).append(")").append(" + ");
        }
        return "H(X) = " + builder;
    }

}
