package org.ave.pet.calculaion;

// use static imports to
// have direct access to these methods
import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.ave.pet.calculation.Calculator;
import org.ave.pet.calculation.NetCalculator;
import org.ave.pet.calculation.Position;
import org.junit.Before;
import org.junit.Test;

public class NetCalculatorEasyMockTest {

    private Calculator calcMethod;
    private NetCalculator netCalculator;
    private static final double NET_SALARY_MANAGER = 700000.0;
    private static final double NET_SALARY_DEVELOPER = 500000.0;
   
    
    @Before
    public void setUp() throws Exception {
        calcMethod = createNiceMock(Calculator.class);
        netCalculator = new NetCalculator();
    }

    @Test
    public void testCalcEasymockPractice() {
        // GIVEN
        expect(calcMethod.calc(Position.MANAGER)).andReturn(NET_SALARY_MANAGER).times(2);
        expect(calcMethod.calc(Position.DEVELOPER)).andReturn(NET_SALARY_DEVELOPER);
        replay(calcMethod);

        netCalculator.setCalcMethod(calcMethod);
        try {
            netCalculator.calc();
            fail("Exception did not occur");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        // WHEN
        netCalculator.setPosition(Position.MANAGER);
        assertEquals(NET_SALARY_MANAGER, netCalculator.calc(), 0);
        assertEquals(NET_SALARY_MANAGER, netCalculator.calc(), 0);
        netCalculator.setPosition(Position.DEVELOPER);
        assertEquals(NET_SALARY_DEVELOPER, netCalculator.calc(), 0);
        netCalculator.setPosition(Position.TESTER);

        // THEN
        verify(calcMethod);
    }

    @Test(expected = RuntimeException.class)
    public void testNoCalc() {
        // GIVEN
        netCalculator.setPosition(Position.TESTER);
        
        // WHEN
        netCalculator.calc();
    }

    @Test(expected = RuntimeException.class)
    public void testNoPosition() {
        //GIVEN
        expect(calcMethod.calc(Position.MANAGER)).andReturn(NET_SALARY_MANAGER);
        replay(calcMethod);
        netCalculator.setCalcMethod(calcMethod);
        
        // WHEN
        netCalculator.calc();
    }

    @Test(expected = RuntimeException.class)
    public void testTesterCalc() {
        // GIVEN
        expect(calcMethod.calc(Position.TESTER)).andThrow(new RuntimeException("Unknown type")).times(1);
        replay(calcMethod);
        netCalculator.setPosition(Position.TESTER);
        netCalculator.setCalcMethod(calcMethod);
        
        // WHEN
        netCalculator.calc();
    }

}