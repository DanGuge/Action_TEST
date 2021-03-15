package task1;

import java.math.BigInteger;

public class Item implements ItemOperate {
    private BigInteger coefficient;
    private BigInteger index;

    public Item(BigInteger coefficient, BigInteger index) {
        this.coefficient = coefficient;
        this.index = index;
    }

    public BigInteger getCoefficient() {
        return coefficient;
    }

    public BigInteger getIndex() {
        return index;
    }

    public void operate(BigInteger coefficient) {
        this.coefficient = this.coefficient.add(coefficient);
    }

    public void derivative() {

    }

    public String getDerivative() {
        return "";
    }

    public BigInteger getFinalCoefficient() {
        return null;
    }

    public String getDes() {
        return "";
    }
}
