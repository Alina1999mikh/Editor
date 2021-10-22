package polynomial;

import exeption.ActionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMember {
    @Test
    public void testDeferential() throws ActionException {
        assertEquals(new Member(4, 5).deferential(), new Member(20, 4));
        assertEquals(new Member(3.8, 4.6).deferential(), new Member(17.48, 3.6));
        assertEquals(new Member(-3.8, 4.6).deferential(), new Member(-17.48, 3.6));
        assertEquals(new Member(3.8, -4.6).deferential(), new Member(-17.48, -5.6));
    }

    @Test
    public void testCalculate() throws ActionException {
        assertEquals(new Member(4, 5).calculate(2), 128);
        assertEquals(new Member(2.4, 1.6).calculate(3), 13.918910723508693);
    }
}