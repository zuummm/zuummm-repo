package org.ave.pet.calculaion;

import static org.junit.Assert.assertEquals;
import mockit.Mock;
import mockit.MockUp;

import org.ave.pet.calculation.Calculator;
import org.ave.pet.calculation.NetCalculator;
import org.ave.pet.calculation.Position;
import org.junit.Before;
import org.junit.Test;

public class NetCalculatorJMockitTest {

    private Calculator mockedCalcMethod;
    private NetCalculator netCalculator;
    private static final double NET_SALARY_MANAGER = 700000.0;
    private static final double NET_SALARY_DEVELOPER = 500000.0;

    @Before
    public void setUp() throws Exception {
        mockedCalcMethod = new MockUp<Calculator>() {
            @Mock
            public double calc(Position position) {
                switch (position) {
                case MANAGER:
                    return NET_SALARY_MANAGER;
                case DEVELOPER:
                    return NET_SALARY_DEVELOPER;
                default:
                    return 1 / 0;
                }
            }
        }.getMockInstance();

        netCalculator = new NetCalculator();
    }

    @Test
    public void testCalcMockitPractice() {
        // GIVEN
        netCalculator.setCalcMethod(mockedCalcMethod);
        // WHEN
        netCalculator.setPosition(Position.MANAGER);
        
        // THEN
        assertEquals(NET_SALARY_MANAGER, netCalculator.calc(), 0);
        assertEquals(NET_SALARY_MANAGER, netCalculator.calc(), 0);
        
        // WHEN
        netCalculator.setPosition(Position.DEVELOPER);
        
        // THEN
        assertEquals(NET_SALARY_DEVELOPER, netCalculator.calc(), 0);
        // unnecessary to call
        // netCalculator.setPosition(Position.TESTER);
    }

    @Test(expected = RuntimeException.class)
    public void testNoCalc() {
        // GIVEN
        netCalculator.setPosition(Position.TESTER);
        
        // WHEN - THEN
        netCalculator.calc();
    }

    @Test(expected = RuntimeException.class)
    public void testNoPosition() {
        // GIVEN
        netCalculator.setCalcMethod(mockedCalcMethod);
        
        // WHEN - THEN
        netCalculator.calc();
    }

    @Test(expected = RuntimeException.class)
    public void testCalc2() {
        // GIVEN
        netCalculator.setPosition(Position.TESTER);
        netCalculator.setCalcMethod(mockedCalcMethod);
        
        // WHEN - THEN
        netCalculator.calc();
    }
}
