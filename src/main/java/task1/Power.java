package task1;

import java.math.BigInteger;

public class Power extends Item {

    private BigInteger finalCoefficient = null;
    private BigInteger finalIndex = null;
    private BigInteger minusOne = BigInteger.ZERO.subtract(BigInteger.ONE);
    private BigInteger one = BigInteger.ONE;
    private String derivative = "x";

    public Power(BigInteger coefficient, BigInteger index) {
        super(coefficient, index);
    }

    @Override
    public BigInteger getFinalCoefficient() {
        return finalCoefficient;
    }

    @Override
    public void derivative() {
        if (getIndex().compareTo(one) == 0) {
            finalCoefficient = getCoefficient();
            derivative = getFinalCoefficient().toString();
            return;
        } else {
            finalCoefficient = getCoefficient().multiply(getIndex());
            finalIndex = getIndex().subtract(BigInteger.ONE);
        }

        if (finalCoefficient.compareTo(minusOne) == 0) {
            derivative = "-x";
        } else if (finalCoefficient.compareTo(one) == 0) {
            derivative = "x";
        } else {
            derivative = finalCoefficient.toString() + "*" + derivative;
        }

        if (finalIndex.compareTo(one) != 0) {
            derivative = derivative + "**" + finalIndex.toString();
        }

    }

    @Override
    public String getDerivative() {
        return derivative;
    }

    @Override
    public String getDes() {
        return "x " + getIndex().toString();
    }
}
