package ae.kbgroup.sapphire.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PurchaseOrderException extends RuntimeException {
	
	public PurchaseOrderException() {

	}

	public PurchaseOrderException(String string) {
		super(string);
	}

}
