package com.bharath.mockito.scrapbook;

public class A {
	
	private B b;

	public A(B b) {
		this.b = b;
	}
	
	public int useVoidMethod() {
		try {
			b.voidMethod();
		} catch (Exception e) {
			new RuntimeException(e);
		}
		
		return 1;
	}

}
