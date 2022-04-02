package waa.labs.lab2.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import waa.labs.lab2.domain.Post;
import waa.labs.lab2.domain.dto.PostDto;
import waa.labs.lab2.domain.dto.UserDto;
import waa.labs.lab2.helper.ListMapper;
import waa.labs.lab2.repo.PostRepo;
import waa.labs.lab2.service.PostService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;

    private final ModelMapper modelMapper;

    private final ListMapper<Post, PostDto> listMapperPostToDto;

    @Autowired
    PostServiceImpl(PostRepo postRepo, ModelMapper modelMapper, ListMapper<Post, PostDto> listMapper) {
        this.postRepo = postRepo;
        this.modelMapper = modelMapper;
        this.listMapperPostToDto = listMapper;
    }

    @Override
    public void savePost(PostDto postDto) {
        Post newPost = new Post();
        newPost.setTitle(postDto.getTitle());
        newPost.setContent(postDto.getContent());
        postRepo.save(newPost);
    }

    @Override
    public void updatePost(long postId, PostDto postDto) {
        var postToUpdate = postRepo.findById(postId).orElse(null);

        if (postToUpdate != null) {
            postToUpdate.setTitle(postDto.getTitle());
            postToUpdate.setContent(postDto.getContent());
            postRepo.save(postToUpdate);
        }
    }

    @Override
    public void deletePostById(long postId) {
        postRepo.deleteById(postId);
    }

    @Override
    public List<PostDto> getAllPosts() {
        return (List<PostDto>) listMapperPostToDto.mapList(postRepo.findAll(), new PostDto()) ;
    }

    @Override
    public PostDto getPostById(long postId) {
        return modelMapper.map(postRepo.getById(postId), PostDto.class);
    }
}
