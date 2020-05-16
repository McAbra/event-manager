package org.piotr.eventmanager.service;

import org.piotr.eventmanager.entity.Comment;

import java.util.Set;

public interface CommentService {

    Comment getCommentByUuid(String uuid);

    Set<Comment> getAllCommentsByUuid(Set<String> uuids);
}
