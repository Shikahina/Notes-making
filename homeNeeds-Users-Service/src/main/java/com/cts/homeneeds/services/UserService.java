package com.cts.homeneeds.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.homeneeds.feignservices.NotesFeign;
import com.cts.homeneeds.models.NeedNotes;
import com.cts.homeneeds.models.User;
import com.cts.homeneeds.repos.UserRepo;

@Service
public class UserService {
@Autowired
UserRepo userRepo;

@Autowired
NotesFeign noteServFeign;
public List<NeedNotes> notesOfUserSelf(Long id){
	Optional<User> userOpt=userRepo.findById(id);
	User user=userOpt.get();
	return noteServFeign.allNotesBySelf(user.getId());
	
}

public String addparents(Long childId,Long currentUserId ){
	try {
		User child=userRepo.findById(childId).get();
		Set<User> parentSet=child.getParents();
		User currentUser =userRepo.findById(currentUserId).get();
		parentSet.add(currentUser);
		child.setParents(parentSet);
		userRepo.save(child);
		return "child Added successfully";
	} catch (Exception e) {
		e.printStackTrace();
		return e.getMessage();
		
	}
}

public Set<User> getParentsOfUser(Long currentUserId){
	User currentUser=userRepo.findById(currentUserId).get();
	return currentUser.getParents();
}

public User getUser(Long userId) {
	Optional<User> opt=userRepo.findById(userId);
	System.out.println(userId);
	User user=opt.get();
	return user;
}

public NeedNotes addNewNote(NeedNotes newNote) {
	return noteServFeign.addNote(newNote);
}

public NeedNotes editNote(NeedNotes editedNote) {
	
	return noteServFeign.editNote(editedNote.getId(), editedNote);
}

public Map<String,List<NeedNotes>> getParentsNeeds(Long userId){
	Set<User> parents=getParentsOfUser(userId);
	Map<String, List<NeedNotes>> parentsNeeds=new HashMap<String, List<NeedNotes>>();
	for (User user : parents) {
		parentsNeeds.put(user.getUsername(), noteServFeign.allNotesBySelf(user.getId()));
	}
	return parentsNeeds;
}

public Map<String,List<NeedNotes>> getAllNeeds(Long userId){
	Set<User> parents=getParentsOfUser(userId);
	Map<String, List<NeedNotes>> allNeeds=new HashMap<String, List<NeedNotes>>();
	
	for (User user : parents) {
		allNeeds.put(user.getUsername(), noteServFeign.allNotesBySelf(user.getId()));
	}
	allNeeds.put("self needs", noteServFeign.allNotesBySelf(userId));
	return allNeeds;
}

public NeedNotes updateOnBuying(NeedNotes needNoMore) {
	Long noteId=needNoMore.getId();
	needNoMore.setPurchaseStatus("purchased");
	NeedNotes tempNote=noteServFeign.getNote(noteId);
	needNoMore.setNeed(tempNote.getNeed());
	needNoMore.setPrefStore(tempNote.getPrefStore());
	needNoMore.setOwner(tempNote.getOwner());
	return noteServFeign.editNote(noteId, needNoMore);
}

}
