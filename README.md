# tapestry-fat-jar

This is an exploratory project where I tested out running
Tapestry 5 using an embedded in a fat jar style packaging.  The
advantages of this approach are that you can package your jar and
then just execute it on your server to get a working web application.
There is no need to install a servlet container on the system.

This was heavily inspired by Dropwizard. I recommend checking out anyone looking to
do REST services check out Dropwizard immediately.

I may turn this into an archetype or library if I feel like it.

I don't think that this setup is production ready at all.

## Packaging and running

Running and testing is pretty easy. On the command line here is what you do:

```
mvn package
java -jar target/tapestry-fat-jar-0.0.1-SNAPSHOT.jar
```

In Eclipse you can just create a Java application runner that points to the Server class.


