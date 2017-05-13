package ae.kbgroup.sapphire.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PackNotFoundException extends RuntimeException {
	
	public PackNotFoundException() {

	}

	public PackNotFoundException(String string) {
		super(string);
	}

}
