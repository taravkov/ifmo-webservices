package ru.taravkov.ifmo.webservices.ws.exception;

import javax.xml.ws.WebFault;


/**
 * @author vtaravkov
 * @since lab3
 */
@WebFault(faultBean = "ru.taravkov.ifmo.webservices.ws.exception.ServiceException.Detail")
public class ServiceException extends RuntimeException {
    private final Detail faultInfo;

    public ServiceException(String message, Detail faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    public ServiceException(String message, Detail faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    public Detail getFaultInfo() {
        return faultInfo;
    }

    public String getMessage() {
        return faultInfo.getDetailMessage();
    }

    public static class Detail {
        private final String detailMessage;

        public Detail(String detailMessage) {
            this.detailMessage = detailMessage;
        }

        public String getDetailMessage() {
            return detailMessage;
        }
    }
}
