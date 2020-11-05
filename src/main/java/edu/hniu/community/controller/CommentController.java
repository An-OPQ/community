package edu.hniu.community.controller;

import edu.hniu.community.domain.Comment;
import edu.hniu.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author jerry
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/getAllComment")
    public Object getAllComment(@RequestParam long id) {
        return commentService.getAllComment(id);
    }

    @PostMapping("/publishComment")
    public Object publishComment(@RequestBody Comment comment) {
        return commentService.publishComment(comment);
    }

    @GetMapping("/getAllCommentByQuestion")
    public Object getAllCommentByQuestion(@RequestParam long questionId ) {
        return commentService.getAllCommentByQuestion(questionId);
    }
}
