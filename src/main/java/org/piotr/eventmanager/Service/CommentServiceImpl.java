package org.piotr.eventmanager.service;

import org.piotr.eventmanager.entity.Comment;
import org.piotr.eventmanager.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public Comment getCommentByUuid(String uuid) {
        return commentRepository.findByUuid(uuid);

    }

    @Override
    public Set<Comment> getAllCommentsByUuid(Set<String> uuids) {
        Set<Comment> comments = new HashSet<>();
        for (String uuid : uuids
        ) {
            comments.add(commentRepository.findByUuid(uuid));
        }
        return comments;
    }
}
