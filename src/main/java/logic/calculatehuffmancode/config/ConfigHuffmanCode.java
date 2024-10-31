package logic.calculatehuffmancode.config;

import logic.calculatehuffmancode.calculate.CalculateHuffmanCode;

import java.util.HashMap;

public class ConfigHuffmanCode {

    public static final HashMap<String, Double> frequencyMap = CalculateHuffmanCode.createFrequencyMap();
    public static CalculateHuffmanCode.Node root = CalculateHuffmanCode.buildHuffmanTree(frequencyMap);
}
