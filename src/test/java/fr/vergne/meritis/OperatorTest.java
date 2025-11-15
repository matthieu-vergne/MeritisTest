package fr.vergne.meritis;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

class OperatorTest {

	@Test
	void testOperatorCanBeInstantiated() {
		OperatorConf conf = mockConf(42.0, 1.0);
		assertDoesNotThrow(() -> new Operator(conf));
	}

	@Test
	void testLinearReturnsBiasAtZero() {
		OperatorConf conf = mockConf(42.0, 0.0);
		assertThat(new Operator(conf).linear(0), is(42.0));
	}

	@Test
	void testLinearWithNoBiasReturnsSlopeAtOne() {
		OperatorConf conf = mockConf(0.0, 12.0);
		assertThat(new Operator(conf).linear(1), is(12.0));
	}

	@Test
	void testLinearWithBiasAndSlope() {
		OperatorConf conf = mockConf(1.0, 2.0);
		assertThat(new Operator(conf).linear(10), is(21.0));
	}

	static private OperatorConf mockConf(double bias, double slope) {
		OperatorConf conf = mock(OperatorConf.class);
		doReturn(bias).when(conf).bias();
		doReturn(slope).when(conf).slope();
		return conf;
	}

}
