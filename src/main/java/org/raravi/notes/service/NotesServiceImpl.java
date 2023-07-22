package org.raravi.notes.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.raravi.notes.repository.NotesRepository;
import org.raravi.notes.repository.entity.Note;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class NotesServiceImpl implements NotesService {

	@Inject
	NotesRepository notesRepository;

	@Override
	public List<Note> getAllNotesForUser(final String userId) {
		return notesRepository.getByUserId(userId);
	}

	@Override
	public void deleteNote(final ObjectId id) {
		notesRepository.delete(id);
	}

	@Override
	public void saveNote(Note note) {
		notesRepository.save(note);
	}
}
