package com.quebecwhisky.model;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.quebecwhisky.model.Bottle;

public class BottleTest {

	@Test
	public void ctr() {
		assertThat(new Bottle(), notNullValue());
	}
	
}
