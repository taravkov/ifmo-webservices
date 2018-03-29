
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

    private final static QName _UpdateCar_QNAME = new QName("http://service.webservices.ifmo.taravkov.ru/", "updateCar");
    private final static QName _DeleteCarResponse_QNAME = new QName("http://service.webservices.ifmo.taravkov.ru/", "deleteCarResponse");
    private final static QName _UpdateCarResponse_QNAME = new QName("http://service.webservices.ifmo.taravkov.ru/", "updateCarResponse");
    private final static QName _FindCar_QNAME = new QName("http://service.webservices.ifmo.taravkov.ru/", "findCar");
    private final static QName _CreateCar_QNAME = new QName("http://service.webservices.ifmo.taravkov.ru/", "createCar");
    private final static QName _FindCarResponse_QNAME = new QName("http://service.webservices.ifmo.taravkov.ru/", "findCarResponse");
    private final static QName _CreateCarResponse_QNAME = new QName("http://service.webservices.ifmo.taravkov.ru/", "createCarResponse");
    private final static QName _DeleteCar_QNAME = new QName("http://service.webservices.ifmo.taravkov.ru/", "deleteCar");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.taravkov.ifmo.webservices.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateCar }
     * 
     */
    public CreateCar createCreateCar() {
        return new CreateCar();
    }

    /**
     * Create an instance of {@link FindCarResponse }
     * 
     */
    public FindCarResponse createFindCarResponse() {
        return new FindCarResponse();
    }

    /**
     * Create an instance of {@link CreateCarResponse }
     * 
     */
    public CreateCarResponse createCreateCarResponse() {
        return new CreateCarResponse();
    }

    /**
     * Create an instance of {@link DeleteCar }
     * 
     */
    public DeleteCar createDeleteCar() {
        return new DeleteCar();
    }

    /**
     * Create an instance of {@link UpdateCar }
     * 
     */
    public UpdateCar createUpdateCar() {
        return new UpdateCar();
    }

    /**
     * Create an instance of {@link DeleteCarResponse }
     * 
     */
    public DeleteCarResponse createDeleteCarResponse() {
        return new DeleteCarResponse();
    }

    /**
     * Create an instance of {@link UpdateCarResponse }
     * 
     */
    public UpdateCarResponse createUpdateCarResponse() {
        return new UpdateCarResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservices.ifmo.taravkov.ru/", name = "updateCar")
    public JAXBElement<UpdateCar> createUpdateCar(UpdateCar value) {
        return new JAXBElement<UpdateCar>(_UpdateCar_QNAME, UpdateCar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservices.ifmo.taravkov.ru/", name = "deleteCarResponse")
    public JAXBElement<DeleteCarResponse> createDeleteCarResponse(DeleteCarResponse value) {
        return new JAXBElement<DeleteCarResponse>(_DeleteCarResponse_QNAME, DeleteCarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservices.ifmo.taravkov.ru/", name = "updateCarResponse")
    public JAXBElement<UpdateCarResponse> createUpdateCarResponse(UpdateCarResponse value) {
        return new JAXBElement<UpdateCarResponse>(_UpdateCarResponse_QNAME, UpdateCarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservices.ifmo.taravkov.ru/", name = "findCar")
    public JAXBElement<FindCar> createFindCar(FindCar value) {
        return new JAXBElement<FindCar>(_FindCar_QNAME, FindCar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservices.ifmo.taravkov.ru/", name = "createCar")
    public JAXBElement<CreateCar> createCreateCar(CreateCar value) {
        return new JAXBElement<CreateCar>(_CreateCar_QNAME, CreateCar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservices.ifmo.taravkov.ru/", name = "findCarResponse")
    public JAXBElement<FindCarResponse> createFindCarResponse(FindCarResponse value) {
        return new JAXBElement<FindCarResponse>(_FindCarResponse_QNAME, FindCarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservices.ifmo.taravkov.ru/", name = "createCarResponse")
    public JAXBElement<CreateCarResponse> createCreateCarResponse(CreateCarResponse value) {
        return new JAXBElement<CreateCarResponse>(_CreateCarResponse_QNAME, CreateCarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservices.ifmo.taravkov.ru/", name = "deleteCar")
    public JAXBElement<DeleteCar> createDeleteCar(DeleteCar value) {
        return new JAXBElement<DeleteCar>(_DeleteCar_QNAME, DeleteCar.class, null, value);
    }

}
