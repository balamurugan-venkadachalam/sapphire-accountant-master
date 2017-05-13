package ae.kbgroup.sapphire.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {
	
	public CustomerNotFoundException() {

	}

	public CustomerNotFoundException(String string) {
		super(string);
	}

}
