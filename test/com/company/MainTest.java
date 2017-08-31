package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class MainTest
{

    @Test
    public void testSimple() throws Main.InvalidInputException
        {
        assertEquals(1000, Main.convertSingleRomanToDecimal("M"));
        assertEquals(500, Main.convertSingleRomanToDecimal("D"));
        assertEquals(100, Main.convertSingleRomanToDecimal("C"));
        assertEquals(50, Main.convertSingleRomanToDecimal("L"));
        assertEquals(5, Main.convertSingleRomanToDecimal("V"));
        assertEquals(1, Main.convertSingleRomanToDecimal("I"));

        assertEquals(1000, Main.convertSingleRomanToDecimal("m"));
        assertEquals(500, Main.convertSingleRomanToDecimal("d"));
        assertEquals(100, Main.convertSingleRomanToDecimal("c"));
        assertEquals(50, Main.convertSingleRomanToDecimal("l"));
        assertEquals(5, Main.convertSingleRomanToDecimal("v"));
        assertEquals(1, Main.convertSingleRomanToDecimal("i"));

        try
        {
            assertEquals(1, Main.convertSingleRomanToDecimal("p"));
            fail("Was expecting invalid input exception");
        } catch (Main.InvalidInputException e)
        {
            // expected to get here
        }

    }

    @Test
    public void testTooBigOrTooSmallInput() throws Main.InvalidInputException {

        int[] inputs = {23399, -2};

        for (int i = 0; i < inputs.length; i++)
        {
            try {
                Main.convert(inputs[i]);
                fail("Was expecting invalid input exception");
            } catch (Main.InvalidInputException e) {
                // should get here
            }
        }
    }

    @Test
    public void testBiggest() throws Main.InvalidInputException
    {
        int input = 4000;

        assertEquals("MMMM", Main.convert(4000));
    }

    @Test
    public void testSimples() throws Main.InvalidInputException
    {
        int[] inputs = {400, 20, 3, 1};
        String[] expected = {"CD", "XX", "III", "I"};

        for (int i = 0; i < expected.length; i++)
        {
            assertEquals(expected[i], Main.convert(inputs[i]));
        }
    }

    @Test
    public void testCompound() throws Main.InvalidInputException
    {
        int[] inputs = {3311, 532, 375};
        String[] expected = {"MMMCCCXI", "DXXXII", "CCCLXXV"};

        for (int i = 0; i < expected.length; i++)
        {
            assertEquals(expected[i], Main.convert(inputs[i]));
        }
    }

    @Test
    public void testPreSubstraction() throws Main.InvalidInputException
    {
        int[] inputs = {490, 1900, 400, 4, 240, 2883};
        String[] expected = {"CDXC", "MCM", "CD", "IV", "CCXL", "MMDCCCLXXXIII"};

        for (int i = 0; i < expected.length; i++)
        {
            assertEquals(expected[i], Main.convert(inputs[i]));
        }
    }
}