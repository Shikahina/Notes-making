package com.cts.homeneeds.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.homeneeds.models.NeedNotes;

@Repository
public interface NeedNotesDAO extends JpaRepository<NeedNotes, Long> {

	public List<NeedNotes> findByOwner(Long owner);
	
	
	
}
