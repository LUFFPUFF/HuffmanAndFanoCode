package config;

import java.util.ArrayList;
import java.util.List;

public class Probabilities {

    public static final double p_z1 = 0.274;
    public static final double p_z2 = 0.09;
    public static final double p_z3 = 0.1;
    public static final double p_z4 = 0.115;
    public static final double p_z5 = 0.19;
    public static final double p_z6 = 0.09;
    public static final double p_z7 = 0.034;
    public static final double p_z8 = 0.022;
    public static final double p_z9 = 0.025;
    public static final double p_z10 = 0.06;

    public static List<Double> getProbabilities() {
        return new ArrayList<>(List.of(
                p_z1, p_z2, p_z3, p_z4, p_z5, p_z6, p_z7, p_z8, p_z9, p_z10
        ));
    }

}
