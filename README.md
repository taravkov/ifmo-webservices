# Web Service Technology Labs (ifmo-webservices)

[![Build Status](https://travis-ci.org/taravkov/ifmo-webservices.svg?branch=master)](https://travis-ci.org/taravkov/ifmo-webservices)

This project contains labs for **Web Service Technology** discipline.

``commons`` module contains common labs codebase, i.e. entities, DAOs, database access utilities, and also sample DB schema and data records.

``jaxws`` module contains code for labs ``lab1`` to ``lab3`` (both inclusive), i.e. the ``JAX-WS`` labs.

``jaxrs`` module contains code for labs ``lab4`` to ``lab6`` (both inclusive), i.e. the ``JAX-RS`` labs.

**Note:** see submodule's ``README`` for detailed lab description & reports.

##### General project info:

* Each module contains ``JUnit 5`` unit tests to check the lab's requirements.
* ``Travis CI`` is used to run builds.
* ``jaxws-maven-plugin`` plugin is used to generate WSDL and web service client code (using ``wsgen`` and ``wsimport``).
* ``H2`` in-memory database instance is used to store data.
* ``Jetty`` is used as a Servlet Container and HTTP server to serve REST resources.
* ``Jersey`` is used for ``jax-rs``.

