package config;

import java.util.ArrayList;
import java.util.List;

public class Probabilities {

    public static final double p_z1 = 0.147;
    public static final double p_z2 = 0.27;
    public static final double p_z3 = 0.025;
    public static final double p_z4 = 0.1;
    public static final double p_z5 = 0.16;
    public static final double p_z6 = 0.024;
    public static final double p_z7 = 0.028;
    public static final double p_z8 = 0.146;
    public static final double p_z9 = 0.038;
    public static final double p_z10 = 0.062;

    public static List<Double> getProbabilities() {
        return new ArrayList<>(List.of(
                p_z1, p_z2, p_z3, p_z4, p_z5, p_z6, p_z7, p_z8, p_z9, p_z10
        ));
    }

}
