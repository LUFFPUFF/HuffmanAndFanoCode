package config;

import java.util.ArrayList;
import java.util.List;

public class Probabilities {

    public static final double p_z1 = 0.049;
    public static final double p_z2 = 0.26;
    public static final double p_z3 = 0.055;
    public static final double p_z4 = 0.025;
    public static final double p_z5 = 0.13;
    public static final double p_z6 = 0.145;
    public static final double p_z7 = 0.028;
    public static final double p_z8 = 0.046;
    public static final double p_z9 = 0.11;
    public static final double p_z10 = 0.152;

    public static List<Double> getProbabilities() {
        return new ArrayList<>(List.of(
                p_z1, p_z2, p_z3, p_z4, p_z5, p_z6, p_z7, p_z8, p_z9, p_z10
        ));
    }

}
