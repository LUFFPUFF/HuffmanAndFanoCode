package logic.calculatehuffmancode.calculate;

import logic.calculatehuffmancode.config.ConfigHuffmanCode;
import config.Probabilities;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CalculateHuffmanCode {

    public static void main(String[] args) {
        System.out.println(getCodes(ConfigHuffmanCode.root));
    }

    public static class Node implements Comparable<Node> {
        public String data;
        public double frequency;
        public Node left;
        public Node right;

        public Node(String data, double frequency) {
            this.data = data;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Node other) {
            return Double.compare(this.frequency, other.frequency);
        }
    }

    public static Map<String, String> getCodes(Node root) {
        Map<String, String> codes = new HashMap<>();
        generateCodes(root, new StringBuilder(), codes);
        return codes;
    }

    public static Node buildHuffmanTree(HashMap<String, Double> frequencyMap) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        frequencyMap.forEach((key, value) -> queue.add(new Node(key, value)));

        while (queue.size() > 1) {
            Node left = queue.poll();
            Node right = queue.poll();
            Node newNode = new Node(null, left.frequency + right.frequency);
            newNode.left = left;
            newNode.right = right;
            queue.add(newNode);
        }
        return queue.poll();
    }

    private static void generateCodes(Node root, StringBuilder code, Map<String, String> codes) {
        if (root == null) return;

        if (root.data != null) {
            codes.put(root.data, code.toString());
        }

        if (root.left != null) {
            generateCodes(root.left, code.append('0'), codes);
            code.deleteCharAt(code.length() - 1);
        }

        if (root.right != null) {
            generateCodes(root.right, code.append('1'), codes);
            code.deleteCharAt(code.length() - 1);
        }
    }

    public static HashMap<String, Double> createFrequencyMap() {
        return new HashMap<>(Map.of(
                "z1", Probabilities.p_z1,
                "z2", Probabilities.p_z2,
                "z3", Probabilities.p_z3,
                "z4", Probabilities.p_z4,
                "z5", Probabilities.p_z5,
                "z6", Probabilities.p_z6,
                "z7", Probabilities.p_z7,
                "z8", Probabilities.p_z8,
                "z9", Probabilities.p_z9,
                "z10", Probabilities.p_z10
        ));
    }


}
