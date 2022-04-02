package waa.labs.lab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import waa.labs.lab2.domain.dto.PostDto;
import waa.labs.lab2.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public PostDto getPostById(@PathVariable("id") int postId) {
        return postService.getPostById(postId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void savePost(@RequestBody PostDto newPost) {
        postService.savePost(newPost);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") int postId) {
        postService.deletePostById(postId);
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable("id") int postId, @RequestBody PostDto post) {
        postService.updatePost(postId, post);
    }
}
