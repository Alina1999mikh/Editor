package polynomial;

import exeption.ActionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestMember {
    @Test
    public void testDeferential() {
        assertEquals(new Member(4, 5).deferential(), new Member(20, 4));
    }

    @Test
    public void testCalculate() {
        assertEquals(new Member(4, 5).calculate(2), 128);
    }

    @Test
    public void testMathOperations() throws ActionException {
        assertEquals(new Member(4, 5).summarize(new Member(2, 5)), new Member(6, 5));
        assertEquals(new Member(4, 5).subscription(new Member(3, 5)), new Member(1, 5));
        assertEquals(new Member(3, 2).multiplication(new Member(4, 3)), new Member(12, 5));
        assertThrows(ActionException.class, () -> new Member(4, 5).summarize(new Member(2, 3)));
    }
}