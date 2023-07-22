package org.raravi.notes.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.raravi.notes.repository.entity.Note;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class MongoRepositoryImpl implements NotesRepository, PanacheMongoRepository<Note> {

	@Override
	public List<Note> getByUserId(final String userId) {
		return list("userId = :userId", Parameters.with("userId", userId));
	}

	@Override
	public void delete(ObjectId id) {
		final var status = deleteById(id);
		if (!status) {
			throw new NotFoundException("Note Not Found");
		}
	}

	@Override
	public void save(final Note note) {
		persist(note);
	}
}
