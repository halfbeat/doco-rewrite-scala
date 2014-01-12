package doco

import javax.ws.rs.{Produces, GET, Path}
import scala.reflect._
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
class Cosa {
    @BeanProperty var name: String = ""

    def this(name: String) {
        this()
        this.name = name;
    }
}

@Path("test")
class TestService {
    @Path("/test1")
    @GET
    @Produces(Array("application/xml"))
    def test1(): Cosa = {
        val c = new Cosa
        c.setName("Angeloso")
        c
    }

    @Path("/test2")
    @GET
    @Produces(Array("application/xml"))
    def test2(): Array[Cosa] = {
        Array("Angel","Oso","Poco","Loco").map(new Cosa(_))
    }
}
