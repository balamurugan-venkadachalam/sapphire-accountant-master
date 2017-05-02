package ae.kbgroup.sapphire.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;


@Component(value="customAccessDeniedHandler")
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);		
		PrintWriter writer = response.getWriter();
		writer.println("HTTP Status 401 : " + accessDeniedException.getMessage());
		
	}

}
