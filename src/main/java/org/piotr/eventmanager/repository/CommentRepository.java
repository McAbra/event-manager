package org.piotr.eventmanager.repository;

import org.piotr.eventmanager.entity.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {

    Comment findByUuid(String uuid);
}
