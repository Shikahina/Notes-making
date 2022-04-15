package com.cts.homeneeds.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.homeneeds.models.NeedNotes;
import com.cts.homeneeds.models.TempChildIdHolder;
import com.cts.homeneeds.models.User;
import com.cts.homeneeds.services.UserService;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	UserService userServ;
	
	@PostMapping("/boughtStuff/{userId}")
	public NeedNotes boughtUpdate(@PathVariable Long userId,@RequestBody NeedNotes needNoMore) {
		needNoMore.setBuyerId(userId);
		return userServ.updateOnBuying(needNoMore);
	}

	
	@GetMapping("/userDetails/{userId}")
	public User getUserDetails(@PathVariable Long userId) {
		return userServ.getUser(userId);
	}
	
	@GetMapping("/addchild/{userId}")
	public String addParentToSomeUser(@PathVariable Long userId,@RequestBody TempChildIdHolder childId){
		return	userServ.addparents(childId.getId(), userId);
	}
	
	@GetMapping("/addNote/{userId}")
	public NeedNotes addNote(@RequestBody NeedNotes need,@PathVariable Long userId) {
		need.setOwner(userId);
		return userServ.addNewNote(need);
	}
	
	@GetMapping("/editNote/{userId}")
	public NeedNotes editNote(@PathVariable Long userId,@RequestBody NeedNotes editedNeed) {
		editedNeed.setOwner(userId);
		return userServ.editNote(editedNeed);
	}
	
	@GetMapping("/viewParentNeeds/{userId}")
	public Map<String,List<NeedNotes>> getParentNotes(@PathVariable Long userId){
		return userServ.getParentsNeeds(userId);
	}
	@GetMapping("/showAllNeeds/{userId}")
	public Map<String ,List<NeedNotes>> getAllNotes(@PathVariable Long userId){
		return userServ.getAllNeeds(userId);
	}
	@GetMapping(value = "/showSelfNeeds/{userId}")
	public List<NeedNotes> getNotes(@PathVariable Long userId){
		return userServ.notesOfUserSelf(userId);
	}
	
	
}
