package com.bharath.mockito.scrapbook;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


class ATest {

	@Mock
	B b;
	private A a;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		a = new A(b);
	}
	
	@Test
	public void usesVoidMethodShouldCallTheVoidMethod() throws Exception {
		doNothing().when(b).voidMethod();
		a.useVoidMethod();
		assertSame(1, a.useVoidMethod());
		verify(b).voidMethod();
	}

	@Test(expected=RuntimeException.class)
	public void testConsecutiveCalls() throws Exception{
		doNothing().doThrow(Exception.class).when(b).voidMethod();
		a.useVoidMethod();
		verify(b).voidMethod();
		a.useVoidMethod();
		
	}
	
}
