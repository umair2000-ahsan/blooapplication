package com.blog.service.impl;

import com.blog.entity.Post;
import com.blog.exception.ResourceNotFound;
import com.blog.playload.PostDto;
import com.blog.repository.PostRepository;
import com.blog.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service



public class PostServiceImpl implements PostService {



    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
       Post post= mapToEntity(postDto);
        Post newPost = postRepository.save(post);
        PostDto newPostDto = mapToDto(newPost);
        return  newPostDto;


    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts = postRepository.findAll();

        return posts.stream().map(post->mapToDto(post)).collect(Collectors.toList());

    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Post", "id", id));



        return mapToDto(post);

    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("post", "id", id)
        );
       post.setTitle(postDto.getTitle());
       post.setContent(postDto.getContent());
       post.setDescription(postDto.getDescription());
        Post updatedPost = postRepository.save(post);
        return  mapToDto(updatedPost);



    }

    @Override
    public void deleteById(long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Post", "id", id)
        );
        postRepository.delete(post);
    }

    Post mapToEntity(PostDto postDto) {
        Post post=new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        return  post;

    }
    PostDto mapToDto(Post post){
        PostDto postDto=new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setDescription(post.getDescription());
        return postDto;
    }


}
