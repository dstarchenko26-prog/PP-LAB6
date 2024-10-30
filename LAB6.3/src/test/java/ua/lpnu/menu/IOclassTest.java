package ua.lpnu.menu;

import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class IOclassTest extends TestCase {
    IOclass io = new IOclass();


    public void testInputInt() {
        io.scanner = new Scanner("1");
        assertEquals(1, io.InputInt());
    }

    public void testInput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        io.printer = new PrintStream(out);
        io.scanner = new Scanner("1");
        assertEquals(1, io.Input(0, 2));
        io.scanner = new Scanner("3\n1");
        assertEquals(1, io.Input(0, 2));
        io.scanner = new Scanner("-1\n1");
        assertEquals(1, io.Input(0, 2));
    }

    public void testInputStr() {
        io.scanner = new Scanner("String");
        assertEquals("String", io.InputStr());
    }

    public void testPrint() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        io.printer = new PrintStream(out);
        String[] strs = new String[1];
        strs[0] = "String";
        io.print(strs);
        assertEquals("String\r\n", out.toString());
    }

    public void testTestPrint() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        io.printer = new PrintStream(out);
        io.print("String");
        assertEquals("String", out.toString());
    }

    public void testTestPrint1() {
        assertNull(io.print());
    }
}