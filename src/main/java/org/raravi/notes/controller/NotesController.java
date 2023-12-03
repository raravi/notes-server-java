package org.raravi.notes.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.raravi.notes.controller.dto.NoteDTO;
import org.raravi.notes.controller.mapper.NoteMapper;
import org.raravi.notes.repository.entity.Note;
import org.raravi.notes.service.NotesService;

import io.smallrye.common.constraint.NotNull;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("v1/notes")
public class NotesController {

	@Inject
	NotesService notesService;

	@GET
	public List<Note> getNotesForUser(@QueryParam("user-id") String userId) throws NotFoundException {
		if (userId == null || userId.isEmpty()) {
			throw new NotFoundException("User not found");
		}
		return notesService.getAllNotesForUser(userId);
	}

	@POST
	public void saveNote(@NotNull NoteDTO noteDTO) {
		notesService.saveNote(NoteMapper.toEntity(noteDTO));
	}

	@DELETE
	@Path("{id}")
	public void deleteNote(String id) {
		notesService.deleteNote(new ObjectId(id));
	}
}
