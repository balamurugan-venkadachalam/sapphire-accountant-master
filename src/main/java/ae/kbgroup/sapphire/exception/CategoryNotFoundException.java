package ae.kbgroup.sapphire.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends RuntimeException {
	
	public CategoryNotFoundException() {

	}

	public CategoryNotFoundException(String string) {
		super(string);
	}

}
