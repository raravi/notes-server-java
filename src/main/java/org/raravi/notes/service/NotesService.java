package org.raravi.notes.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.raravi.notes.repository.entity.Note;

public interface NotesService {
	List<Note> getAllNotesForUser(final String userId);

	void deleteNote(final ObjectId id);

	void saveNote(Note note);
}
