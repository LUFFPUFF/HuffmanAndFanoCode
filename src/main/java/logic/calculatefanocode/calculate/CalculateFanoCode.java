package logic.calculatefanocode.calculate;

import config.Probabilities;

import java.util.*;

public class CalculateFanoCode {

    private static class Node {
        String sym;
        double pro;
        List<Integer> arr = new ArrayList<>();
    }

    public static Map<String, String> getCodes() {
        Node[] nodes = new Node[createFrequencyMap().size()];
        int index = 0;
        for (Map.Entry<String, Double> entry : createFrequencyMap().entrySet()) {
            CalculateFanoCode.Node node = new CalculateFanoCode.Node();
            node.sym = entry.getKey();
            node.pro = entry.getValue();
            nodes[index++] = node;
        }

        CalculateFanoCode.sortByProbability(nodes);

        CalculateFanoCode.shannon(0, nodes.length - 1, nodes);

        return CalculateFanoCode.getCodeMap(nodes);
    }

    private static Map<String, Double> createFrequencyMap() {
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


    private static void shannon(int l, int h, Node[] p) {
        double pack1 = 0, pack2 = 0, diff1 = 0, diff2 = 0;
        int i, d, k = 0, j;
        if ((l + 1) == h || l == h || l > h) {
            if (l == h || l > h) return;
            p[h].arr.add(0);
            p[l].arr.add(1);
        } else {
            for (i = l; i <= h - 1; i++) pack1 += p[i].pro;
            pack2 += p[h].pro;
            diff1 = Math.abs(pack1 - pack2);
            j = 2;
            while (j != h - l + 1) {
                k = h - j;
                pack1 = pack2 = 0;
                for (i = l; i <= k; i++) pack1 += p[i].pro;
                for (i = h; i > k; i--) pack2 += p[i].pro;
                diff2 = Math.abs(pack1 - pack2);
                if (diff2 >= diff1) break;
                diff1 = diff2;
                j++;
            }
            k++;
            for (i = l; i <= k; i++) p[i].arr.add(1);
            for (i = k + 1; i <= h; i++) p[i].arr.add(0);
            shannon(l, k, p);
            shannon(k + 1, h, p);
        }
    }

    private static void sortByProbability(Node[] p) {
        for (int j = 1; j < p.length; j++) {
            for (int i = 0; i < p.length - j; i++) {
                if (p[i].pro > p[i + 1].pro) {
                    Node temp = p[i];
                    p[i] = p[i + 1];
                    p[i + 1] = temp;
                }
            }
        }
    }

    private static Map<String, String> getCodeMap(Node[] p) {
        Map<String, String> codeMap = new HashMap<>();
        for (Node node : p) {
            StringBuilder code = new StringBuilder();
            for (int bit : node.arr) {
                code.append(bit);
            }
            codeMap.put(node.sym, code.toString());
        }
        return codeMap;
    }
}
