package fr.vergne.meritis;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

class OperatorTest {

	@Test
	void test() {
		OperatorConf conf = mock(OperatorConf.class);
		doReturn(42.0).when(conf).bias();
		assertEquals(42.0, new Operator(conf).linear(0));
		
		doReturn(0.0).when(conf).bias();
		doReturn(12.0).when(conf).slope();
		assertEquals(12.0, new Operator(conf).linear(1));
		
		doReturn(1.0).when(conf).bias();
		doReturn(2.0).when(conf).slope();
		assertEquals(21.0, new Operator(conf).linear(10));
	}

}
