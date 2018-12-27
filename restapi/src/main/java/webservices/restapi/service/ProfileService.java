package webservices.restapi.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import webservices.restapi.database.DatabaseClass;
import webservices.restapi.model.Profile;

public class ProfileService {

	private  Map<Long,Profile> profiles=DatabaseClass.getProfiles();
	public ProfileService(){
		profiles.put(1L, new Profile(1L,"Chinthlapalli","HelloWorld","Ashok"));
		profiles.put(2L, new Profile(2L,"HelloWorld Restful"," Reddy","Jagad"));

	}
	public List<Profile> getallProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	public Profile getProfile(long i) {

		return profiles.get(i);

	}
	public Profile addProfile(Profile mg) {
		mg.setId((long) (profiles.size()+1));
		profiles.put(mg.getId(), mg);
		return mg;
	}
	public Profile updateProfile(Profile m) {
		if(m.getId()<=0) return null;
		else
			 profiles.put(m.getId(), m); 
		return m;
	}
	public void deleteProfile(long id) {
		profiles.remove(id);

	}

}
