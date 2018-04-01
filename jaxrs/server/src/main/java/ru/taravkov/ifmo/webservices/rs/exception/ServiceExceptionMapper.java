package ru.taravkov.ifmo.webservices.rs.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


/**
 * @author vtaravkov
 * @since lab6
 */
@Provider
public class ServiceExceptionMapper implements ExceptionMapper<ServiceException> {
    @Override
    public Response toResponse(ServiceException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(e.getMessage() + ": " + e.getDetail())
                .build();
    }
}
