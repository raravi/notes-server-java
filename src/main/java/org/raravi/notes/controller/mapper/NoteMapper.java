package org.raravi.notes.controller.mapper;

import java.util.Optional;

import org.raravi.notes.controller.dto.NoteDTO;
import org.raravi.notes.repository.entity.Note;

public class NoteMapper {
	public static Note toEntity(final NoteDTO noteDTO) {
		return Optional.ofNullable(noteDTO)
				.map(dto -> Note.builder()
						.userId(noteDTO.getUserId())
						.note(noteDTO.getNote())
						.build())
				.orElse(null);
	}
}
