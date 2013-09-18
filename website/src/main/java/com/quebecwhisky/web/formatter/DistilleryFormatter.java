/**
 * 
 */
package com.quebecwhisky.web.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.quebecwhisky.model.Distillery;

/**
 * @author Jean-Philippe
 * 
 */
public final class DistilleryFormatter implements Formatter<Distillery> {

	// @Inject
	// private IDistilleryService _distillerySrv;

	@Override
	public String print(Distillery distillery, Locale locale) {
		return distillery.getId().toString();
	}

	@Override
	public Distillery parse(String id, Locale locale) throws ParseException {
		// return _distillerySrv.findById(Long.valueOf(id));
		Distillery distillery = new Distillery();
		distillery.setId(Long.valueOf(id));
		return distillery;
	}

}
