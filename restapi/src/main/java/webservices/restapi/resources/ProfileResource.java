package webservices.restapi.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import webservices.restapi.model.Profile;
import webservices.restapi.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	ProfileService ms=new ProfileService();
	@GET
	
	public List<Profile> getProfiles() {
		return ms.getallProfiles();
	}	

	
	@Path("/{id}")
	@GET
	
	public Profile getProfile(@PathParam(value = "id") Long id) {
		return ms.getProfile(id);

	}
	@POST

	public Profile addProfile(Profile m) {
		return ms.addProfile(m);
	}
	@PUT
	@Path("/{id}")
	public Profile updateProfile(@PathParam(value="id") Long id,Profile m) {
		m.setId(id);
		
		return ms.updateProfile(m);
	}
	@DELETE
	@Path("/{d}")
	public void deleteProfile(@PathParam(value="d") Long d) {
		 ms.deleteProfile(d);
	}
	
	
}
