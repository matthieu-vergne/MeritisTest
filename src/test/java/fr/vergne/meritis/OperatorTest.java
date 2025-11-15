package fr.vergne.meritis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OperatorTest {

	@Test
	void test() {
		assertEquals(7, new Operator(new OperatorConf()).linear(0));
		assertEquals(13, new Operator(new OperatorConf()).linear(1));
		assertEquals(57, new Operator(new OperatorConf()).linear(10));
	}

}
