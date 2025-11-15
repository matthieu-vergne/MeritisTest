package fr.vergne.meritis;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

class OperatorTest {

	@Test
	void test() {
		OperatorConf conf = mock(OperatorConf.class);
		doReturn(42.0).when(conf).bias();
		assertThat(new Operator(conf).linear(0), is(42.0));
		
		doReturn(0.0).when(conf).bias();
		doReturn(12.0).when(conf).slope();
		assertThat(new Operator(conf).linear(1), is(12.0));
		
		doReturn(1.0).when(conf).bias();
		doReturn(2.0).when(conf).slope();
		assertThat(new Operator(conf).linear(10), is(21.0));
	}

}
