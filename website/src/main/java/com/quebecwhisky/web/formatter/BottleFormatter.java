/**
 * 
 */
package com.quebecwhisky.web.formatter;

import java.text.ParseException;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.format.Formatter;

import com.quebecwhisky.model.Bottle;
import com.quebecwhisky.service.IBottleService;

/**
 * @author Jean-Philippe
 * 
 */
public final class BottleFormatter implements Formatter<Bottle> {

	@Inject
	private IBottleService _bottleSrv;

	@Override
	public String print(Bottle bottle, Locale locale) {
		return bottle.getId().toString();
	}

	@Override
	public Bottle parse(String id, Locale locale) throws ParseException {
		return _bottleSrv.findById(Long.valueOf(id));
	}

}
