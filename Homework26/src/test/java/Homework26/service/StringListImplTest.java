package Homework26.service;

import Homework26.exception.ArrayIsFullException;
import Homework26.exception.ElementNullException;
import Homework26.exception.ExitForBorderArrayException;
import Homework26.exception.NotFoundElementException;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {
    private final StringListImpl stringList = new StringListImpl();

    @Test
    void addOneTest() {
        assertThat(stringList.add("санки")).isEqualTo("санки");
        System.out.println(stringList);
    }

    @Test
    void addOne_ArrayIsFullException_Test() {
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");
        stringList.add("i");
        stringList.add("f");
        stringList.add("j");
        stringList.add("h");
        stringList.add("k");
        stringList.add("l");
        System.out.println(stringList);
        assertThatExceptionOfType(ArrayIsFullException.class).isThrownBy(() -> stringList.add("RRR"));
    }

    @Test
    void addOne_ElementNullException_Test() {
        String d = null;
        assertThatExceptionOfType(ElementNullException.class).isThrownBy(() -> stringList.add(d));
    }

    @Test
    void AddTwoTest() {
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");
        stringList.add("i");
        System.out.println(stringList);
        assertThat(stringList.add(2, "санки")).isEqualTo("санки");
        System.out.println(stringList);
    }

    @Test
    void AddTwo_ArrayIsFullException_Test() {
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");
        stringList.add("i");
        stringList.add("f");
        stringList.add("j");
        stringList.add("h");
        stringList.add("k");
        stringList.add("k");
        assertThatExceptionOfType(ArrayIsFullException.class).isThrownBy(() -> stringList.add(4, "RRR"));
    }

    @Test
    void AddTwo_ExitForBorderArrayException_Test() {
        assertThatExceptionOfType(ExitForBorderArrayException.class).isThrownBy(() -> stringList.add(9, "RRR"));
    }

    @Test
    void AddTwo_ElementNullException_Test() {
        String d = null;
        assertThatExceptionOfType(ElementNullException.class).isThrownBy(() -> stringList.add(d));
    }

    @Test
    void setTest() {
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        assertThat(stringList.set(2, "санки")).isEqualTo("санки");
    }

    @Test
    void set_ExitForBorderArrayException_Test() {
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        assertThatExceptionOfType(ExitForBorderArrayException.class).isThrownBy(() -> stringList.set(4, "RRR"));
    }

    @Test
    void set_ElementNullException_Test() {
        String d = null;
        assertThatExceptionOfType(ElementNullException.class).isThrownBy(() -> stringList.set(3, d));
    }

    @Test
    void removeTest() {
        stringList.add("c");
        System.out.println(stringList);
        assertThat(stringList.remove("c")).isEqualTo("c");
        System.out.println(stringList);
    }

    @Test
    void remove_NotFoundElementException_Test() {
        stringList.add("c");
        assertThatExceptionOfType(NotFoundElementException.class).isThrownBy(() -> stringList.remove("RRR"));
    }

    @Test
    void remove_ElementNullException_Test() {
        String d = null;
        assertThatExceptionOfType(ElementNullException.class).isThrownBy(() -> stringList.remove(d));
    }

    @Test
    void removeTwoTest() {
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        assertThat(stringList.remove(1)).isEqualTo("b");
    }

    @Test
    void removeTwo_NotFoundElementException_Test() {
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        assertThatExceptionOfType(NotFoundElementException.class).isThrownBy(() -> stringList.remove(4));
    }

    @Test
    void removeTwo_ExitForBorderArrayException_Test() {
        assertThatExceptionOfType(ExitForBorderArrayException.class).isThrownBy(() -> stringList.remove(10));
    }

    @Test
    void containsTest() {
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        assertThat(stringList.contains("b")).isEqualTo(true);
    }

    @Test
    void containsNegativeTest() {
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        assertThat(stringList.contains("k")).isEqualTo(false);
    }

    @Test
    void contains_ElementNullException_Test() {
        String d = null;
        assertThatExceptionOfType(ElementNullException.class).isThrownBy(() -> stringList.contains(d));
    }

    @Test
    void indexOfTest() {
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        assertEquals(1, stringList.indexOf("b"));
    }

    @Test
    void indexOfNegativeTest() {
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        assertEquals(-1, stringList.indexOf("k"));
    }

    @Test
    void indexOf_ElementNullException_Test() {
        String d = null;
        assertThatExceptionOfType(ElementNullException.class).isThrownBy(() -> stringList.indexOf(d));
    }

    @Test
    void lastIndexOfTest() {
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        assertEquals(1, stringList.lastIndexOf("b"));
    }

    @Test
    void lastIndexOfNegativeTest() {
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        assertEquals(-1, stringList.lastIndexOf("k"));
    }

    @Test
    void lastIndexOf_ElementNullException_Test() {
        String d = null;
        assertThatExceptionOfType(ElementNullException.class).isThrownBy(() -> stringList.lastIndexOf(d));
    }

    @Test
    void getTest() {
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        assertThat(stringList.get(1)).isEqualTo("b");
    }

    @Test
    void get_ExitForBorderArrayException_Test() {
        assertThatExceptionOfType(ExitForBorderArrayException.class).isThrownBy(() -> stringList.get(10));
    }

    @Test
    void getTwo_ExitForBorderArrayException_Test() {
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        assertThatExceptionOfType(ExitForBorderArrayException.class).isThrownBy(() -> stringList.get(3));
    }

    @Test
    void EqualsTest() {
        String[] expected = new String[10];
        expected[0]="a";
        expected[1]="b";
        expected[2]="c";
        expected[3]="c";
        expected[4]="c";
        expected[5]="c";
        expected[6]="c";
        expected[7]="c";
        expected[8]="c";
        expected[9]="c";
        assertThat(stringList.size()).isEqualTo(0);
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("c");
        stringList.add("c");
        stringList.add("c");
        stringList.add("c");
        stringList.add("c");
        stringList.add("c");
        stringList.add("c");
        assertThat(stringList.size()).isEqualTo(10);
        assertThat(Arrays.equals(stringList.toArray(),expected)).isEqualTo(true);
    }
    @Test
    void EqualsNegativeTest() {
        String[] expected = new String[10];
        expected[0]="k";
        expected[1]="b";
        expected[2]="c";
        expected[3]="c";
        expected[4]="c";
        expected[5]="c";
        expected[6]="c";
        expected[7]="c";
        expected[8]="c";
        expected[9]="c";
        assertThat(stringList.size()).isEqualTo(0);
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("c");
        stringList.add("c");
        stringList.add("c");
        stringList.add("c");
        stringList.add("c");
        stringList.add("c");
        stringList.add("c");
        assertThat(stringList.size()).isEqualTo(10);
        assertThat(Arrays.equals(stringList.toArray(),expected)).isEqualTo(false);
    }

    @Test
    void Equals_ElementNullException_Test() {
        String[] expected = new String[10];
        expected[0]="a";
        expected[1]="b";
        expected[2]="c";
        System.out.println(Arrays.toString(expected));
        System.out.println(Arrays.toString(stringList.toArray()));
        assertThatExceptionOfType(ElementNullException.class).isThrownBy(() -> stringList.equals(expected));
    }

    @Test
    void size() {
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        assertThat(stringList.size()).isEqualTo(3);
    }

    @Test
    void isEmptyTest() {
        assertThat(stringList.isEmpty()).isEqualTo(true);
    }

    @Test
    void isEmptyNegativeTest() {
        stringList.add("a");
        assertThat(stringList.isEmpty()).isEqualTo(false);
    }

    @Test
    void clear() {
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        assertThat(stringList.isEmpty()).isEqualTo(false);
        stringList.clear();
        assertThat(stringList.isEmpty()).isEqualTo(true);
    }

    @Test
    void toArrayTest() {
        String[] expected = new String[10];
        expected[0]="a";
        expected[1]="b";
        expected[2]="c";
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        assertThat(stringList.toArray()).isEqualTo(expected);
    }
}