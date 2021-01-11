package jukebox.assignment.jukebox.controller.exceptions;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

import jukebox.assignment.jukebox.model.ErrorResponse;

//THIS CAN BE FURTHER IMPROVED

@ControllerAdvice
public class RestErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestErrorHandler.class);

    private MessageSource messageSource;

    @Autowired
    public RestErrorHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse processValidationError(Exception ex) {
        LOGGER.debug("Handling form validation error");
        ErrorResponse dto = new ErrorResponse();
        dto.setMessage("Sorry!! Something went wrong please try correct request");
        return dto;
    }
    
    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse processHttpException(HttpClientErrorException ex) {
        LOGGER.error("RestErrorHandler::processHttpException",ex);
        ErrorResponse dto = new ErrorResponse();
        dto.setMessage("Sorry!! External server is taking more than required time");
        return dto;
    }
    
}
