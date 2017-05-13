package ae.kbgroup.sapphire.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CountryOriginNotFoundException extends RuntimeException {
	
	public CountryOriginNotFoundException() {
	}
	
	public CountryOriginNotFoundException(String string) {
		super(string);
	}

}
