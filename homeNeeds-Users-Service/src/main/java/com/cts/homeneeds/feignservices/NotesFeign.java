package com.cts.homeneeds.feignservices;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.homeneeds.models.NeedNotes;


@FeignClient(name="Note-Service")
public interface NotesFeign {
	
@GetMapping("/getOneNote/{noteId}")
public NeedNotes getNote(@PathVariable Long noteId);

@GetMapping("/getAllNotes/{ownerId}")	
public List<NeedNotes> allNotesBySelf(@PathVariable Long ownerId);

@PostMapping("/addNewNote")
public NeedNotes addNote(@RequestBody NeedNotes newNote);

@PostMapping("/editNote/{noteId}")
public NeedNotes editNote(@PathVariable Long noteId,@RequestBody NeedNotes newNote);
}
