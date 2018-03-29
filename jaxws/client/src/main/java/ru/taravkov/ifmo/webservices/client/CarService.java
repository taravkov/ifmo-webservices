
package ru.taravkov.ifmo.webservices.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CarService", targetNamespace = "http://client.webservices.ifmo.taravkov.ru/", wsdlLocation = "file:/Users/vtaravkov/Documents/itmo/sem10/webservices/jaxws/client/src/main/resources/wsdl/CarService.wsdl")
public class CarService
    extends Service
{

    private final static URL CARSERVICE_WSDL_LOCATION;
    private final static WebServiceException CARSERVICE_EXCEPTION;
    private final static QName CARSERVICE_QNAME = new QName("http://client.webservices.ifmo.taravkov.ru/", "CarService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/Users/vtaravkov/Documents/itmo/sem10/webservices/jaxws/client/src/main/resources/wsdl/CarService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CARSERVICE_WSDL_LOCATION = url;
        CARSERVICE_EXCEPTION = e;
    }

    public CarService() {
        super(__getWsdlLocation(), CARSERVICE_QNAME);
    }

    public CarService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CARSERVICE_QNAME, features);
    }

    public CarService(URL wsdlLocation) {
        super(wsdlLocation, CARSERVICE_QNAME);
    }

    public CarService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CARSERVICE_QNAME, features);
    }

    public CarService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CarService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CarWebService
     */
    @WebEndpoint(name = "CarWebServicePort")
    public CarWebService getCarWebServicePort() {
        return super.getPort(new QName("http://client.webservices.ifmo.taravkov.ru/", "CarWebServicePort"), CarWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CarWebService
     */
    @WebEndpoint(name = "CarWebServicePort")
    public CarWebService getCarWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://client.webservices.ifmo.taravkov.ru/", "CarWebServicePort"), CarWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CARSERVICE_EXCEPTION!= null) {
            throw CARSERVICE_EXCEPTION;
        }
        return CARSERVICE_WSDL_LOCATION;
    }

}
