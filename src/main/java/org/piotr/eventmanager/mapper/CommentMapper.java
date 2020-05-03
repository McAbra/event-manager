package org.piotr.eventmanager.mapper;

import org.piotr.eventmanager.dto.CommentDTO;
import org.piotr.eventmanager.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;


public class CommentMapper {

    @Autowired
    private EventMapper eventMapper;

//    public CommentDTO mapCommentToDto(Comment comment) {
//        CommentDTO commentDTO = new CommentDTO();
//        commentDTO.setUuid(comment.getUuid());
//        commentDTO.setAuthor(mapUserToDto(comment.getAuthor()));
//        commentDTO.setText(comment.getText());
//        commentDTO.setCommentedEvent(eventMapper.mapEventToDto(comment.getCommentedEvent()));
//        return commentDTO;
//    }
//
//    public Set<CommentDTO> mapCommentSetToDto(Set<Comment> comments) {
//        Set<CommentDTO> commentDTOS = new HashSet<>();
//        for(Comment c : comments){
//            commentDTOS.add(this.mapCommentToDto(c));
//        }
//        return commentDTOS;
//    }
}
