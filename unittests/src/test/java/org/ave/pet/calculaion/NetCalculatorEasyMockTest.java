package org.ave.pet.calculaion;

//use static imports to 
//have direct access to these methods
import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.ave.pet.calculation.ICalculator;
import org.ave.pet.calculation.NetCalculator;
import org.ave.pet.calculation.Position;
import org.junit.Before;
import org.junit.Test;

public class NetCalculatorEasyMockTest {

	private ICalculator calcMethod;
	private NetCalculator netCalculator;

	@Before
	public void setUp() throws Exception {
		calcMethod = createNiceMock(ICalculator.class);
		netCalculator = new NetCalculator();
	}

	@Test
	public void testCalc1() {
		// GIVEN
		expect(calcMethod.calc(Position.MANAGER)).andReturn(700000.0).times(2);
		expect(calcMethod.calc(Position.DEVELOPER)).andReturn(500000.0);
		replay(calcMethod);

		netCalculator.setCalcMethod(calcMethod);
		try {
			netCalculator.calc();
			fail("Exception did not occur");
		} catch (RuntimeException e) {

		}
		
		// WHEN
		netCalculator.setPosition(Position.MANAGER);
		assertEquals(700000.0, netCalculator.calc(), 0);
		assertEquals(700000.0, netCalculator.calc(), 0);
		netCalculator.setPosition(Position.DEVELOPER);
		assertEquals(500000.0, netCalculator.calc(), 0);
		netCalculator.setPosition(Position.TESTER);		
		
		//THEN		
		verify(calcMethod);
	}

	@Test(expected = RuntimeException.class)
	public void testNoCalc() {
		netCalculator.setPosition(Position.TESTER);
		netCalculator.calc();
	}

	@Test(expected = RuntimeException.class)
	public void testNoPosition() {
		expect(calcMethod.calc(Position.MANAGER)).andReturn(70000.0);
		replay(calcMethod);
		netCalculator.setCalcMethod(calcMethod);
		// WHEN
		netCalculator.calc();
	}

	@Test(expected = RuntimeException.class)
	public void testCalc2() {
		// GIVEN
		expect(calcMethod.calc(Position.TESTER)).andThrow(
				new RuntimeException("Unknown type")).times(1);
		replay(calcMethod);
		netCalculator.setPosition(Position.TESTER);
		netCalculator.setCalcMethod(calcMethod);
		// WHEN
		netCalculator.calc();
	}

}