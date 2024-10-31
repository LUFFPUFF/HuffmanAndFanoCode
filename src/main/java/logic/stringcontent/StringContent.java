package logic.stringcontent;

import logic.calculatefanocode.calculatelength.CalculateLengthFano;
import logic.calculatefanocode.calculater.CalculateRFano;
import logic.calculatefanocode.code.FanoCode;
import logic.calculatehuffmancode.calculateHuffmanlength.CalculateLengthHuffman;
import logic.calculatehuffmancode.calculater.CalculateRHuffman;
import logic.calculatehuffmancode.code.HuffmanCode;
import config.Probabilities;
import logic.entropy.CalculateEntropy;
import logic.formulas.Formulas;

public class StringContent {

    public static void main(String[] args) {
        System.out.println(getContent());
    }


    public static String getContent() {
        return "Данные вероятности: \n" +
                probabilities() +
                "\nПостроение дерева Хаффмана (Смотреть фото huffman.png)\n\n" +
                "Вычисленный код: \n" +
                huffmanCode() +
                "\nВычисленная средняя длина кода: \n" +
                Formulas.getFormulasAvgLengthHuffman() + " = " + CalculateLengthHuffman.calculate() +
                "\n\nВычисленная энтропия: \n" +
                Formulas.formulasEntropy() + " = " + CalculateEntropy.calculate() +
                "\n\nВычисленная R: \n" +
                Formulas.formulasR + CalculateRHuffman.calculate() +
                "\n\nПостроение дерева Шеннона-Фано (смотреть фото fano.png)" +
                "\n\nВычисленный код: \n" +
                fanoCode() +
                "\nВычисленная средняя длина кода: \n" +
                Formulas.getFormulasAvgLengthFano() + " = " + CalculateLengthFano.calculate() +
                "\n\nВычисленная энтропия: \n" +
                Formulas.formulasEntropy() + " = " + CalculateEntropy.calculate() +
                "\n\nВычисленная R: \n" +
                Formulas.formulasR + CalculateRFano.calculate();
    }

    private static String probabilities() {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (Double prob : Probabilities.getProbabilities()) {
            builder.append("p(z").append(i+1).append(")").append(" = ").append(prob).append("\n");
            i++;
        }

        return builder.toString();
    }

    private static String huffmanCode() {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (String code : HuffmanCode.getHuffmanCode()) {
            builder.append("z").append(i+1).append(" = ").append(code).append("\n");
            i++;
        }

        return builder.toString();
    }

    private static String fanoCode() {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (String code : FanoCode.getFanoCode()) {
            builder.append("z").append(i+1).append(" = ").append(code).append("\n");
            i++;
        }

        return builder.toString();
    }

    private static String entropyValues() {
        StringBuilder builder = new StringBuilder();
        for (Double prob : Probabilities.getProbabilities()) {
            builder.append(prob).append("log2").append("(").append(prob).append(")").append(" + ");
        }
        return builder.toString();
    }
}
