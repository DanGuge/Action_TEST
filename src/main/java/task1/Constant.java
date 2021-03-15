package task1;

import java.math.BigInteger;

public class Constant extends Item {
    private BigInteger zero = BigInteger.ZERO;
    private BigInteger finalCoefficient = null;

    public Constant(BigInteger coefficient, BigInteger index) {
        super(coefficient, index);
    }

    @Override
    public String getDerivative() {
        return "";
    }

    @Override
    public void derivative() {
        finalCoefficient = zero;
    }

    @Override
    public String getDes() {
        return "constant";
    }

    @Override
    public BigInteger getFinalCoefficient() {
        return finalCoefficient;
    }
}
