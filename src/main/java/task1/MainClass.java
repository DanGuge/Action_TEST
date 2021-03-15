package task1;/*
    Date:2020/02/25
    Description:Project 1
 */

import java.math.BigInteger;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainClass {
    private static final HashMap<String, Item> itemHashMap = new HashMap<>();
    private static final TreeSet<Item> itemTreeSet =
            new TreeSet<Item>(new Comparator<Item>() {
                public int compare(Item s1, Item s2) {
                    if (s1.getFinalCoefficient()
                            .compareTo(s2.getFinalCoefficient()) < 0) {
                        return 1;
                    }
                    return -1;
                }
            });
    private static final BigInteger zero = BigInteger.ZERO;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();

        text = text.replaceAll("[ \t]", "");

        divideText(text);
        derivative();
        print();
    }

    private static void derivative() {
        for (String string : itemHashMap.keySet()) {
            itemHashMap.get(string).derivative();
            if (itemHashMap.get(string)
                    .getFinalCoefficient().compareTo(zero) != 0) {
                itemTreeSet.add(itemHashMap.get(string));
            }
        }
    }

    private static void print() {
        int flag = 0;

        for (Item item : itemTreeSet) {
            if (item.getFinalCoefficient().compareTo(zero) > 0 && flag > 0) {
                System.out.print("+");
            }

            System.out.print(item.getDerivative());
            if (flag == 0) {
                flag = 1;
            }
        }

        if (itemTreeSet.size() == 0) {
            System.out.println("0");
        }

    }

    private static void divideText(String text) {
        String regex = "([+-]?)([+-]?)(\\d*)"
                + "((?:\\*)?(x)((?:\\*\\*)([+-]?\\d+))?)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {

            if (matcher.group(0).equals("")) {
                break;
            }

            // when testing totally 8 group
            if (matcher.group(1).equals(matcher.group(2)) ||
                    matcher.group(1).equals("+")
                            && matcher.group(2).equals("") ||
                    matcher.group(1).equals("")
                            && matcher.group(2).equals("+")) {
                addItem("+", matcher.group(3),
                        matcher.group(5), matcher.group(7));
            } else {
                addItem("-", matcher.group(3),
                        matcher.group(5), matcher.group(7));
            }
        }
    }

    private static void addItem(String operation, String coefficient,
                                String type, String index) {
        BigInteger bigInteger1;
        BigInteger bigInteger2;
        Item item = null;

        if (coefficient.equals("")) {
            bigInteger1 = new BigInteger(operation + "1");
        } else {
            bigInteger1 = new BigInteger(operation + coefficient);
        }

        if (type == null) {
            item = new Constant(bigInteger1, zero);
        } else if (type.equals("x")) {
            if (index == null) {
                bigInteger2 = new BigInteger("1");
            } else {
                bigInteger2 = new BigInteger(index);
            }
            item = new Power(bigInteger1, bigInteger2);
        }

        if (item == null) {
            throw new AssertionError();
        }
        if (itemHashMap.containsKey(item.getDes())) {
            itemHashMap.get(item.getDes()).operate(bigInteger1);
        } else {
            itemHashMap.put(item.getDes(), item);
        }
    }

}
