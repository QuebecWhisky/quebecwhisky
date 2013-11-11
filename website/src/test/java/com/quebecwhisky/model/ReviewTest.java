package com.quebecwhisky.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.text.DecimalFormatSymbols;

import org.junit.Test;

public class ReviewTest {

	private final char _decimalSeparator = new DecimalFormatSymbols()
			.getDecimalSeparator();

	@Test
	public void ctr() {
		assertThat(new Review(), notNullValue());
	}

	@Test
	public void shouldFormatRatingWithoutDecimal() {
		Double rawRating = Double.valueOf(92.0);
		Review review = new Review();
		review.setRating(rawRating);

		assertThat(review.getRating(), is(rawRating));
		assertThat(review.getFormattedRating(), is("92"));
	}

	@Test
	public void shouldFormatRatingWithDecimal() {
		Double rawRating = Double.valueOf(92.3);
		Review review = new Review();
		review.setRating(rawRating);

		assertThat(review.getRating(), is(rawRating));
		assertThat(review.getFormattedRating(), is("92" + _decimalSeparator + "3"));
	}

}
