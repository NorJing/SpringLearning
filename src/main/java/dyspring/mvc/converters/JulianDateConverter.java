package dyspring.mvc.converters;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import org.springframework.core.convert.converter.Converter;

public class JulianDateConverter implements Converter<String, Date> {

	/* (non-Javadoc)
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	@Override
	public Date convert(String strDate) {
		Date tmpDate = null;
		try {
			System.out.println("Converting Julian date.");
			tmpDate = new SimpleDateFormat("YYYYDDDD").parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return tmpDate;
	}

	public JulianDateConverter() {
		// TODO Auto-generated constructor stub
	}

}
