package fr.vergne.meritis;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.function.BiFunction;
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
				arguments(mockConf(42.0, 0.0), named(Operator::linear), 0.0, 42.0), //
				arguments(mockConf(0.0, 12.0), named(Operator::linear), 1.0, 12.0), //
				arguments(mockConf(1.0, 2.0), named(Operator::linear), 10.0, 21.0), //
				arguments(mockSomeConf(), named(Operator::square), 1.0, 1.0), //
				arguments(mockSomeConf(), named(Operator::square), 10.0, 100.0), //
				arguments(mockSomeConf(), named(Operator::log), 1.0, 0.0), //
				arguments(mockSomeConf(), named(Operator::log), Math.E, 1.0)//
		);
	}

	@ParameterizedTest(name = "With {0}, {1}({2}) = {3}")
	@MethodSource("testCases")
	void testCalculation(OperatorConf conf, BiFunction<Operator, Double, Double> func, double x, double result) {
		assertThat(func.apply(new Operator(conf), x), is(result));
	}

	static private BiFunction<Operator, Double, Double> named(BiFunction<Operator, Double, Double> func) {
		String methodName = retrieveMethodName(func);
		return new BiFunction<Operator, Double, Double>() {

			@Override
			public Double apply(Operator operator, Double x) {
				return func.apply(operator, x);
			}

			@Override
			public String toString() {
				return methodName;
			}
		};
	}

	private static String retrieveMethodName(BiFunction<Operator, Double, Double> biFunction) {
		var ctx = new Object() {
			String methodName;
		};
		Operator operator = mock(Operator.class, invocation -> {
			ctx.methodName = invocation.getMethod().getName();
			return null;
		});
		biFunction.apply(operator, 0.0);
		return ctx.methodName;
	}

	static private OperatorConf mockConf(double bias, double slope) {
		OperatorConf conf = mock(OperatorConf.class);
		doReturn(bias).when(conf).bias();
		doReturn(slope).when(conf).slope();
		doReturn("(bias, slope)=(" + bias + ", " + slope + ")").when(conf).toString();
		return conf;
	}

	private static OperatorConf mockSomeConf() {
		OperatorConf conf = mockConf(0.0, 0.0);
		doReturn("some conf").when(conf).toString();
		return conf;
	}

}
