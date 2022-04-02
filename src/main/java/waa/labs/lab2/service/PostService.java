package waa.labs.lab2.service;

import waa.labs.lab2.domain.dto.PostDto;
import waa.labs.lab2.domain.dto.UserDto;

import java.util.List;

public interface PostService {
    public void savePost(PostDto post);

    public void updatePost(long postId, PostDto post);

    public void deletePostById(long postId);

    public List<PostDto> getAllPosts();

    public PostDto getPostById(long postId);
}
