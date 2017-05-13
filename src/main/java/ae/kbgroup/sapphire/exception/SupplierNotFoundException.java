package ae.kbgroup.sapphire.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SupplierNotFoundException extends RuntimeException {
	
	public SupplierNotFoundException() {

	}

	public SupplierNotFoundException(String string) {
		super(string);
	}

}
