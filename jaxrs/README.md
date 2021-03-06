# jaxrs

This module contains code for labs ``lab4`` to ``lab6`` (both inclusive), i.e. the ``JAX-RS`` labs.

There are ``server`` and ``client`` submodules.

* ``server`` module provides standalone web service application which is bootstrapped from the ``App`` class.
* ``client`` module provides web service client code utilising ``Jersey Client``.

Client module also contains unit tests to check the lab's requirements.

### Testing Web Service

Web Service tests are located [here](client/src/test/java/ru/taravkov/ifmo/webservices/rs/CarResourceTest.java).

##### Test Example:

```java
/**
* @since lab4
*/
@Test
public void testFindAll() {
    final List<Car> result = client.findAll();
    assertEquals(2, result.size());
    assertEquals("Ford", result.get(0).getMake());
    assertEquals("BMW", result.get(1).getMake());
}
```

##### Error Handling Test Example:

```java
/**
* @since lab6
*/
@Test
public void testDeleteCarError() throws MalformedURLException {
    WebResource resource = client.getClient().resource("http://localhost:8080/cars");

    ClientResponse response = resource
            .accept(MediaType.APPLICATION_JSON_TYPE)
            .delete(ClientResponse.class);

    assertEquals(ClientResponse.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    String entity = response.getEntity(String.class);
    assertEquals("Unable to delete car record: Id can not be null", entity);
}
```