package org.raravi.notes.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.raravi.notes.repository.entity.Note;

public interface NotesRepository {

	List<Note> getByUserId(String userId);

	void delete(ObjectId id);

	void save(final Note note);
}
