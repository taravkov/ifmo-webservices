
package ru.taravkov.ifmo.webservices.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.taravkov.ifmo.webservices.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindCarResponse_QNAME = new QName("http://client.webservices.ifmo.taravkov.ru/", "findCarResponse");
    private final static QName _FindCar_QNAME = new QName("http://client.webservices.ifmo.taravkov.ru/", "findCar");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.taravkov.ifmo.webservices.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindCarResponse }
     * 
     */
    public FindCarResponse createFindCarResponse() {
        return new FindCarResponse();
    }

    /**
     * Create an instance of {@link FindCar }
     * 
     */
    public FindCar createFindCar() {
        return new FindCar();
    }

    /**
     * Create an instance of {@link Car }
     * 
     */
    public Car createCar() {
        return new Car();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.webservices.ifmo.taravkov.ru/", name = "findCarResponse")
    public JAXBElement<FindCarResponse> createFindCarResponse(FindCarResponse value) {
        return new JAXBElement<FindCarResponse>(_FindCarResponse_QNAME, FindCarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.webservices.ifmo.taravkov.ru/", name = "findCar")
    public JAXBElement<FindCar> createFindCar(FindCar value) {
        return new JAXBElement<FindCar>(_FindCar_QNAME, FindCar.class, null, value);
    }

}
