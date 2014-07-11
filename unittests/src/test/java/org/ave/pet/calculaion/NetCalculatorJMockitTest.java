package org.ave.pet.calculaion;

import static org.junit.Assert.assertEquals;
import mockit.Mock;
import mockit.MockUp;

import org.ave.pet.calculation.ICalculator;
import org.ave.pet.calculation.NetCalculator;
import org.ave.pet.calculation.Position;
import org.junit.Before;
import org.junit.Test;

public class NetCalculatorJMockitTest {

	private ICalculator mockedCalcMethod;
	private NetCalculator netCalculator;

	@Before
	public void setUp() throws Exception {
		mockedCalcMethod = new MockUp<ICalculator>() {
			@Mock
			public double calc(Position position) {
				switch (position) {
				case MANAGER:
					return 700000.0;
				case DEVELOPER:
					return 500000.0;
				default:
					return 1 / 0;
				}
			}
		}.getMockInstance();

		netCalculator = new NetCalculator();
	}

	@Test
	public void testCalc1() {
		// GIVEN
		netCalculator.setCalcMethod(mockedCalcMethod);
		netCalculator.setPosition(Position.MANAGER);
		// THEN
		assertEquals(700000.0, netCalculator.calc(), 0);
		assertEquals(700000.0, netCalculator.calc(), 0);
		// WHEN
		netCalculator.setPosition(Position.DEVELOPER);
		// THEN
		assertEquals(500000.0, netCalculator.calc(), 0);
		netCalculator.setPosition(Position.TESTER);
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
		// GIVEN
		netCalculator.setCalcMethod(mockedCalcMethod);
		// WHEN
		netCalculator.calc();
	}

	@Test(expected = RuntimeException.class)
	public void testCalc2() {
		// GIVEN
		netCalculator.setPosition(Position.TESTER);
		netCalculator.setCalcMethod(mockedCalcMethod);
		// WHEN
		netCalculator.calc();
	}
}
