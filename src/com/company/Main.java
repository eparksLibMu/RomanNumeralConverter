package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Character[] backwardResult = new Character[9]; // longest is: MMMCMXCIX

    static int backwardResultIndex = 0;

    private static Map<String, Integer> symbolValueMap = new HashMap<String, Integer>();
    static {
        symbolValueMap.put("M",1000);
        symbolValueMap.put("D",500);
        symbolValueMap.put("C",100);
        symbolValueMap.put("L",50);
        symbolValueMap.put("X",10);
        symbolValueMap.put("V",5);
        symbolValueMap.put("I",1);
    }

    private static Map<Integer, Character> valueSymbolMap = new HashMap<Integer, Character>();
    static {
        valueSymbolMap.put(1000, 'M');
        valueSymbolMap.put(500, 'D');
        valueSymbolMap.put(100, 'C');
        valueSymbolMap.put(50, 'L');
        valueSymbolMap.put(10, 'X');
        valueSymbolMap.put(5, 'V');
        valueSymbolMap.put(1, 'I');
    }
    public static void main(String[] args) {
	// write your code here
    }

    public static int convertSingleRomanToDecimal(String m) throws InvalidInputException
    {
        if(!symbolValueMap.containsKey(m.toUpperCase())) {
            throw new InvalidInputException();
        }
        if (m.length() == 1) {
            return symbolValueMap.get(m.toUpperCase());
        }

        return 9999999;
    }

    static String convert(int input)  throws InvalidInputException {

        StringBuilder result = new StringBuilder();
        if(input > 4000 || input < 1) {
            throw new InvalidInputException();
        }
        while (input / 1000 > 0) {
            input -= 1000;
            result.append("M");
        }
        while (input / 500 > 0) {
            input -= 500;
            result.append("D");
        }
        while (input / 100 > 0) {
            input -= 100;
            result.append("C");
        }
        while (input / 50 > 0) {
            input -= 50;
            result.append("L");
        }
        while (input / 10 > 0) {
            input -= 10;
            result.append("X");
        }
        while (input / 5 > 0) {
            input -= 5;
            result.append("V");
        }
        while (input > 0) {
            input -= 1;
            result.append("I");
        }
        return resolveRomanString(result.toString());
    }

    private static String resolveRomanString(String input) {

        String retVal = input;

        for (int i = 0; i < lookup.length; i++)
        {
            retVal = retVal.replace(lookup[i], lookupResult[i]);

        }

        return retVal;
    }

    /*
    Order matters here!
     */
    static String[] lookup = {"DCCCC", "LXXXX", "VIIII", "CCCC", "XXXX", "IIII"};
    static String[] lookupResult = {"CM", "XC", "IX", "CD", "XL", "IV"};

    static class InvalidInputException extends Exception
    {
        public InvalidInputException()
        {
            super("input is not valid");
        }
    }
}
