package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class TriangleTest {

    @Test
    public void when00and40and04Then8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = 8;
        assertThat(result).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when00And40And08Then8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 8);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = 16;
        assertThat(result).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when14And3Minus2AndMinus31Then8() {
        Point a = new Point(1, 4);
        Point b = new Point(3, -2);
        Point c = new Point(-3, 1);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = 15;
        assertThat(result).isCloseTo(expected, offset(0.001));
    }
}