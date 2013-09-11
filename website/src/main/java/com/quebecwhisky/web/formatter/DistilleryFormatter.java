/**
 * 
 */
package com.quebecwhisky.web.formatter;

import java.text.ParseException;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.format.Formatter;

import com.quebecwhisky.model.Distillery;
import com.quebecwhisky.service.IDistilleryService;

/**
 * @author Jean-Philippe
 * 
 */
public final class DistilleryFormatter implements Formatter<Distillery> {

	@Inject
	private IDistilleryService _distillerySrv;
	
	@Override
	public String print(Distillery distillery, Locale locale) {
		return distillery.getId().toString();
	}

	@Override
	public Distillery parse(String id, Locale locale) throws ParseException {
		return _distillerySrv.findById(Long.valueOf(id));
	}

}
