package logic.calculatehuffmancode.calculateHuffmanlength;

import logic.calculatehuffmancode.calculate.CalculateHuffmanCode;
import logic.calculatehuffmancode.config.ConfigHuffmanCode;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class CalculateLengthHuffman {

    public static void main(String[] args) {
        System.out.println(calculate());
    }

    public static double calculate() {
        Map<String, Integer> codeLengths = calculateCodeLengths(ConfigHuffmanCode.root);

        double totalLength = 0;

        for (Map.Entry<String, Double> entry : ConfigHuffmanCode.frequencyMap.entrySet()) {
            String symbol = entry.getKey();
            double frequency = entry.getValue();
            int codeLength = codeLengths.getOrDefault(symbol, 0);
            totalLength += frequency * codeLength;
        }

        return new BigDecimal(totalLength).setScale(4, RoundingMode.HALF_UP).doubleValue();
    }

    public static Map<String, Integer> calculateCodeLengths(CalculateHuffmanCode.Node root) {
        Map<String, Integer> codeLengths = new HashMap<>();
        calculateCodeLengthsRecursive(root, 0, codeLengths);
        return codeLengths;
    }

    private static void calculateCodeLengthsRecursive(CalculateHuffmanCode.Node node, int length, Map<String, Integer> codeLengths) {
        if (node == null) return;

        if (node.data != null) {
            codeLengths.put(node.data, length);
        }

        calculateCodeLengthsRecursive(node.left, length + 1, codeLengths);
        calculateCodeLengthsRecursive(node.right, length + 1, codeLengths);
    }
}
