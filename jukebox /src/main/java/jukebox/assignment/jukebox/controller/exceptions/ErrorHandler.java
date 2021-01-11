package jukebox.assignment.jukebox.controller.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import jukebox.assignment.jukebox.controller.exceptions.model.ErrorResponse;
import jukebox.assignment.jukebox.controller.exceptions.model.RestTemplateException;

//THIS CAN BE FURTHER IMPROVED

@ControllerAdvice
public class ErrorHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandler.class);

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse processException(Exception ex) {
		LOGGER.error("An error happened in processException", ex);
		return new ErrorResponse(ex, "Sorry!! Something went wrong please try contacting API author");
	}

	@ExceptionHandler(value = RestTemplateException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse handleMyRestTemplateException(RestTemplateException ex, HttpServletRequest request) {
		LOGGER.error("An error happened while calling {} Downstream API: {}", ex.getApi(), ex.toString());
		return new ErrorResponse(ex, request.getRequestURI());
	}
}
