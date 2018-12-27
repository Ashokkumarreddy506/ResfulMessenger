package webservices.restapi.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import javax.xml.ws.spi.http.HttpContext;

@Path("/injectDemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	@Path("/annotations")
	@GET
	public String getparamUsingAnnotations(@MatrixParam(value = "id") String id,
			@CookieParam(value="cook") String cookie,
			@HeaderParam(value="test") String test,
			@HeaderParam(value="testing") String test1,
			@Context UriInfo uriinfo,
			@Context HttpHeaders headers) {
		return "id===="+id+test+"=="+test1+"Cookie value="+cookie+"\n"+uriinfo.getAbsolutePathBuilder()+
				headers.getHeaderString(test);

	}
	@Path("/context")
	@GET
	public String getContextParam(@Context UriInfo uriinfo) {
		return uriinfo.getQueryParameters().toString()+uriinfo.getAbsolutePathBuilder();
	}

}

