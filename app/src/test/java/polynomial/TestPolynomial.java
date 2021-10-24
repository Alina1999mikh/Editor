package polynomial;

import exeption.ActionException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPolynomial {
    @Test
    public void testDegree() {
        TPoly t = new TPoly(new Member(1, 4));
        t.add(new Member(2, 5));
        t.add(new Member(1, 6));
        assertEquals(t.degree(), 6);
    }

    @Test
    public void testFactor() {
        TPoly t = new TPoly(new Member(1, 3));
        t.add(new Member(2, 5));
        assertEquals(t.factor(6), 0);
        assertEquals(t.factor(3), 1);
        assertEquals(t.factor(4), 0);
    }

    @Test
    public void testAdd() {
        TPoly t = new TPoly(new Member(1, 3));
        t.add(new Member(2, 5));
        System.out.println(t);
        t.add(new Member(4, 5));
        System.out.println(t);
        t.add(new Member(4, 6));
        System.out.println(t);
    }

    @Test
    public void testSummarize() throws ActionException {
        TPoly t = new TPoly(new Member(1, 3));
        t.add(new Member(3, 5));
        t.add(new Member(4, 5));
        t.add(new Member(5, 6));

        TPoly t2 = new TPoly(new Member(1, 3));
        t2.add(new Member(4, 5));
        t2.add(new Member(2, 5));
        t2.add(new Member(4, 6));
        ArrayList<Member> rez = new ArrayList<>();
        rez.add(new Member(2, 3));
        rez.add(new Member(9, 6));
        rez.add(new Member(13, 5));
        assertEquals(t.summarize(t2), new TPoly(rez));
    }

    @Test
    public void testSubscription() throws ActionException {
        TPoly t = new TPoly(new Member(1, 3));
        t.add(new Member(3, 5));
        t.add(new Member(5, 6));
        t.add(new Member(4, 7));

        TPoly t2 = new TPoly(new Member(2, 3));
        t2.add(new Member(4, 5));
        t2.add(new Member(4, 6));

        ArrayList<Member> rez = new ArrayList<>();
        rez.add(new Member(1, 3));
        rez.add(new Member(1, 5));
        rez.add(new Member(-1, 6));
        rez.add(new Member(-4, 7));

        assertEquals(t2.subscription(t), new TPoly(rez));
    }


    @Test
    public void testMultiplication() throws ActionException {
        TPoly t = new TPoly(new Member(1, 3));
        t.add(new Member(2, 2));
        t.add(new Member(3, 1));

        TPoly t2 = new TPoly(new Member(2, 2));
        t2.add(new Member(3, 1));

        ArrayList<Member> rez = new ArrayList<>();
        rez.add(new Member(9, 2));
        rez.add(new Member(12, 3));
        rez.add(new Member(7, 4));
        rez.add(new Member(2, 5));

        assertEquals(t2.multiplication(t), new TPoly(rez));
    }

    @Test
    public void testDifferential() {
        TPoly t = new TPoly(new Member(1, 3));
        t.add(new Member(2, 2));
        t.add(new Member(3, 1));


        ArrayList<Member> rez = new ArrayList<>();
        rez.add(new Member(3, 0));
        rez.add(new Member(4, 1));
        rez.add(new Member(3, 2));

        assertEquals(t.deferential(), new TPoly(rez));
    }

    @Test
    public void testCalculate() {
        TPoly t = new TPoly(new Member(1, 3));
        t.add(new Member(2, 2));
        t.add(new Member(3, 1));

        assertEquals(t.calculate(2), 22);
    }
}