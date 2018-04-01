package ru.taravkov.ifmo.webservices.rs.exception;

/**
 * @author vtaravkov
 * @since lab6
 */
public class ServiceException extends RuntimeException {
    private final String detail;

    public ServiceException(String message, String detail) {
        super(message);
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }
}
