package itboard_comments.controller;

import itboard_comments.model.AuthToken;
import itboard_comments.model.Comment;
import itboard_comments.model.Post;
import itboard_comments.repository.AuthTokenRepository;
import itboard_comments.repository.CommentRepository;
import itboard_comments.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private AuthTokenRepository authTokenRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("")
    public Iterable<Comment> index() {
        return commentRepository.findAll();
    }

    @GetMapping("/post/{postId}")
    public Iterable<Comment> commentsByPost(
            @PathVariable("postId") long postId
    ) {
        return commentRepository.findByPostId(postId);
    }

    @PostMapping("")
    public ResponseEntity createComment(
            @RequestParam("postId") long postId,
            @RequestParam("text") String text,
            @RequestHeader("authorization") String authorization
    ) {
        String[] splittedToken = authorization.split(" ");
        if (splittedToken.length < 2) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        String key = splittedToken[1];
        Optional<AuthToken> token = authTokenRepository.findByKey(key);
        if (!token.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        Optional<Post> post = postRepository.findById(postId);
        if (!post.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        Comment comment = new Comment();
        comment.setPost(post.get());
        comment.setText(text);
        comment.setUser(token.get().getUser());
        commentRepository.save(comment);

        return ResponseEntity.ok().body(null);
    }

}
