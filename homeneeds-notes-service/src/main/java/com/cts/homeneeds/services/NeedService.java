package com.cts.homeneeds.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.homeneeds.models.NeedNotes;
import com.cts.homeneeds.repo.NeedNotesDAO;

@Service
public class NeedService {

	@Autowired
	NeedNotesDAO needRepo;
	
	public List<NeedNotes> getAllNeedsByOwnerId(Long ownerId){
		List<NeedNotes> allNotes= needRepo.findByOwner(ownerId);
		return allNotes;
	}
	
	public NeedNotes addNewNote(NeedNotes newNeed) {
		NeedNotes newNote=needRepo.save(newNeed);
		return newNote;
	}
	
	public NeedNotes editExistingNote(Long noteId,NeedNotes editedNote) {
	   return needRepo.save(editedNote);
	}
	
	public NeedNotes getOneNote(Long noteId) {
		return needRepo.findById(noteId).get();
	}
	
	
	public String removeNote(Long noteId) {
		
		try {
			needRepo.deleteById(noteId);
			return "Successfully deleted";
		} catch (Exception e) {
			return e.getMessage();
		}
		
		
	}
	
}
