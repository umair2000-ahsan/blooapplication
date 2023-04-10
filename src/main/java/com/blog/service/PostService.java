package com.blog.service;

import com.blog.playload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);


     List<PostDto> getAllPost();


    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deleteById(long id);
}
