These demos have been built and tested using Red Hat JBoss Fuse 7.0

Prerequisites
-------------
Before building and running this example you need:

* Maven 3.0.4 or higher
* JDK 1.8
* JBoss Fuse 7.0

Building the examples
---------------------
The examples are built using Apache Maven. To build all of the examples (and install the
corresponding artifacts in your local Maven repository) enter the following command from
the top-level directory of the examples:

    $ mvn clean install

Configuring additional users
----------------------------
Edit the `$FUSE_HOME/etc/users.properties` and add a user called `admin`:

    admin=admin,admin

This will enable connecting to the embedded message broker.

--------------------------------------
The `customer-ws-osgi-bundle` deploys a simple web service listening on ServiceMix's
HTTP port (by default, this is port 8181). To install and start the bundle, just do

    karaf@root> install -s mvn:com.sahoora.cxf.camel.webinars/customer-ws-osgi-bundle/1.0-SNAPSHOT

You will now find that the server is listening on `http://localhost:8181/cxf/Customer`
- you can verify this quickly by pointing your browser at `http://localhost:8181/cxf/Customer?wsdl`.
You can test the service by using a tool such as [SoapUI](http://www.soapui.org)
