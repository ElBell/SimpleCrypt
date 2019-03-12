

import main.java.ROT;
import main.java.ROT13;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ROTTest {

    @Test
    public void rotateStringTest0() {
        // Given
        String s1 = "ABCDEF";
        String s2 = "ABCDEF";

        // When
        ROT cipher = new ROT('a', 'b');
        String actual = cipher.rotate(s1, 'A');

        // Then
        assertEquals(actual, s2);
    }

    @Test
    public void rotateStringTest1() {
        // Given
        String s1 = "ABCDEF";
        String s2 = "DEFABC";

        // When
        ROT cipher = new ROT('a', 'r');
        String actual = cipher.rotate(s1, 'D');

        // Then
        assertEquals(actual, s2);
    }

    @Test
    public void rotateStringTest2() {
        // Given
        String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s2 = "NOPQRSTUVWXYZABCDEFGHIJKLM";

        // When
        ROT cipher = new ROT('a', 'h');
        String actual = cipher.rotate(s1, 'N');
        System.out.println(s1);
        System.out.println(actual);
        // Then
        assertEquals(actual, s2);
    }

    @Test
    public void cryptTest1() {
        // Given
        ROT cipher = new ROT('a', 't');

        String Q1 = "Why did the chicken cross the road?";
        String A1 = "Par wbw max vabvdxg vkhll max khtw?";

        String Q2 = "Mh zxm mh max hmaxk lbwx!";
        String A2 = "To get to the other side!";

        // When
        String actual = cipher.encrypt(Q1);
        // Then
        Assert.assertEquals(A1, actual);
        // When
        String actual2 = cipher.decrypt(Q2);
        // Then
        assertEquals(A2, actual2);
    }

    @Test
    public void cryptTwiceTestWithShiftNot13() {
        // Given
        ROT cipher = new ROT('a', 'k');

        String Q1 = "Why did the chicken cross the road?";

        // When
        String actual = cipher.crypt(cipher.crypt(Q1, true), true);
        // Then
        assertNotEquals(Q1, actual);
    }

}