package org.raravi.notes.repository.entity;

import java.time.LocalDateTime;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@MongoEntity(collection="notes", database="db")
public class Note {

	public ObjectId id;

	@BsonProperty("userid")
	public String userId;

	public String note;

	@BsonProperty("createddate")
	@Builder.Default
	public LocalDateTime createdDate = LocalDateTime.now();

	@BsonProperty("modifieddate")
	@Builder.Default
	public LocalDateTime updatedDate = LocalDateTime.now();

	@BsonProperty("modifiedsession")
	public String updatedBySession;
}
