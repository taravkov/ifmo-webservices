# jaxws

This module contains code for labs ``lab1`` to ``lab3`` (both inclusive), i.e. the ``JAX-WS`` labs.

There are ``server`` and ``client`` submodules.

* ``server`` module provides standalone web service application which is bootstrapped from the ``App`` class.
* ``client`` module generates WSDL and web service client code using ``jaxws-maven-plugin`` plugin.

Client module also contains unit tests to check the lab's requirements.

### Testing Web Service

Web Service tests are located [here](client/src/test/java/ru/taravkov/ifmo/webservices/client/CarWebServiceTest.java)


Test Example:

```java
    /**
     * @since lab1
     */
    @Test
    public void testFindByMake() throws MalformedURLException {
        final CarService carService = new CarService(new URL("http://localhost:8080/CarService?wsdl"));
        final CarWebService webService = carService.getCarWebServicePort();

        final List<Car> result = webService.findCar("Ford", null, null, null, null);
        assertEquals(1, result.size());
        assertEquals("Ford", result.get(0).getMake());
    }
```

### WSDL

### XSD

