package com.blog.controller;

import com.blog.playload.PostDto;
import com.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {


    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity <PostDto>createPost(@RequestBody PostDto postDto){
        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);


    }

    @GetMapping
    public List<PostDto> getAll(){
    return postService.getAllPost();

    }
 //http:localhost:8080/api/posts/1
    @GetMapping("/{id}")

    public ResponseEntity<PostDto> getPostById(@PathVariable("id") long id){
      return ResponseEntity.ok(postService.getPostById(id))  ;

    }
@PutMapping("/{id}")
    public ResponseEntity<PostDto>updatePost(@RequestBody PostDto postDto,@PathVariable("id") long id){
    PostDto postDto1 = postService.updatePost(postDto, id);
 return   new ResponseEntity<>(postDto1,HttpStatus.OK);
}

    @DeleteMapping("/{id}")
    public ResponseEntity <String> deletePost(@PathVariable("id") long id){


        postService.deleteById(id);
        return  new ResponseEntity<>("Post is deleted ..", HttpStatus.OK);
    }







    }
