package fr.vergne.meritis;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OperatorTest {

	@Test
	void testOperatorCanBeInstantiated() {
		OperatorConf conf = mockConf(42.0, 1.0);
		assertDoesNotThrow(() -> new Operator(conf));
	}

	static Stream<Arguments> testCases() {
		return Stream.of(//
				arguments(42.0, 0.0, 0.0, 42.0), //
				arguments(0.0, 12.0, 1.0, 12.0), //
				arguments(1.0, 2.0, 10.0, 21.0)//
		);
	}

	@ParameterizedTest(name = "{0} + {1} x {2} = {3}")
	@MethodSource("testCases")
	void testLinear(double bias, double slope, double x, double result) {
		OperatorConf conf = mockConf(bias, slope);
		assertThat(new Operator(conf).linear(x), is(result));
	}

	static private OperatorConf mockConf(double bias, double slope) {
		OperatorConf conf = mock(OperatorConf.class);
		doReturn(bias).when(conf).bias();
		doReturn(slope).when(conf).slope();
		return conf;
	}

}
