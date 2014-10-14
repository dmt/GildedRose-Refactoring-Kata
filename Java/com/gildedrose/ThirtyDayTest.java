package com.gildedrose;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ThirtyDayTest {
    @Test
    public void compareOutput() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        TexttestFixture.main(new String[]{"30"});
        out.close();
        String output = out.toString();
        String expectedOutput = new Scanner(new File("../texttests/ThirtyDays/stdout.gr")).useDelimiter("\\A").next();

        assertEquals(expectedOutput, output);
    }
}
