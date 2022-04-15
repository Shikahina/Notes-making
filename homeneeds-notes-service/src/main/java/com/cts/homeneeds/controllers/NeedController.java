package com.cts.homeneeds.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.homeneeds.models.NeedNotes;
import com.cts.homeneeds.services.NeedService;
	
@RestController
public class NeedController {
	@Autowired
	NeedService needService;
	
	@GetMapping("/getAllNotes/{ownerId}")
	public List<NeedNotes> getNotes(@PathVariable Long ownerId){
		return needService.getAllNeedsByOwnerId(ownerId);
	}
	
	@PostMapping("/addNewNote")
	public NeedNotes addNote(@RequestBody NeedNotes newNote) {
		return needService.addNewNote(newNote);
	}
	
	@PostMapping("/editNote/{noteId}")
	public NeedNotes editNote(@PathVariable Long noteId,@RequestBody NeedNotes newNote) {
		return needService.editExistingNote(noteId, newNote);
	}
	
	@GetMapping("/deleteNote/{noteId}")
	public String removeNote(@PathVariable Long noteId) {
		return needService.removeNote(noteId);
	}
	@GetMapping("/getOneNote/{noteId}")
	public NeedNotes getNote(@PathVariable Long noteId) {
		return needService.getOneNote(noteId);
	}
}
