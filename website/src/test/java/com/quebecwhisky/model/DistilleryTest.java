package com.quebecwhisky.model;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.quebecwhisky.model.Distillery;

public class DistilleryTest {

	@Test
	public void ctr() {
		assertThat(new Distillery(), notNullValue());
	}
	
}
