package task1;

import java.math.BigInteger;

public interface ItemOperate {
    //获得系数
    BigInteger getCoefficient();

    //获得指数
    BigInteger getIndex();

    //添加相同项
    void operate(BigInteger coefficient);

    //求导
    void derivative();

    //获得求导结果
    String getDerivative();

    //获得求导后的系数
    BigInteger getFinalCoefficient();

    //HashMap 的 Key
    String getDes();
}
