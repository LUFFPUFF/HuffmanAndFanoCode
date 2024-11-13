package logic.calculatehuffmancode.calculate;

import config.Probabilities;

import java.util.*;

public class CalculateHuffmanCode {

    public static void main(String[] args) {
        HashMap<String, Double> frequencyMap = createFrequencyMap();
        checkProbabilities(frequencyMap);

        Node root = buildHuffmanTree(frequencyMap);
        Map<String, String> codes = getCodes(root);

        codes.forEach((k, v) -> System.out.println("Код для " + k + ": " + v));
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
            int freqComparison = Double.compare(this.frequency, other.frequency);
            return (freqComparison != 0) ? freqComparison : this.data.compareTo(other.data);
        }

        public boolean isLeaf() {
            return this.left == null && this.right == null;
        }
    }

    public static Node buildHuffmanTree(HashMap<String, Double> frequencyMap) {
        // Создаем список узлов и сортируем по убыванию вероятности
        List<Node> nodes = new ArrayList<>();
        frequencyMap.forEach((key, value) -> nodes.add(new Node(key, value)));
        nodes.sort(Collections.reverseOrder());

        while (nodes.size() > 1) {
            // Получаем два узла с наименьшими вероятностями
            Node right = nodes.remove(nodes.size() - 1);
            Node left = nodes.remove(nodes.size() - 1);

            // Проверка на внутренние узлы
            if (left.data.length() > right.data.length() ||
                    (left.data.length() == right.data.length() && left.frequency > right.frequency)) {
                Node temp = left;
                left = right;
                right = temp;
            }

            // Проверка для листовых узлов
            if (left.isLeaf() && right.isLeaf() && left.frequency < right.frequency) {
                Node temp = left;
                left = right;
                right = temp;
            }

            // Создаем новый родительский узел
            Node newNode = new Node(left.data + right.data, left.frequency + right.frequency);
            newNode.left = left;
            newNode.right = right;
            nodes.add(newNode);
            nodes.sort(Collections.reverseOrder()); // Снова сортируем по убыванию
        }

        return nodes.get(0);
    }

    public static Map<String, String> getCodes(Node root) {
        Map<String, String> codes = new HashMap<>();
        assignCodes(root, "", codes);
        return codes;
    }

    private static void assignCodes(Node node, String code, Map<String, String> codes) {
        if (node == null) return;

        if (node.isLeaf()) {
            codes.put(node.data, code);
        } else {
            assignCodes(node.left, code + "0", codes);
            assignCodes(node.right, code + "1", codes);
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

    public static void checkProbabilities(Map<String, Double> frequencyMap) {
        double total = frequencyMap.values().stream().mapToDouble(Double::doubleValue).sum();
        if (Math.abs(total - 1.0) > 1e-9) {
            throw new IllegalArgumentException("Сумма вероятностей должна быть равна 1.");
        }
    }

}
