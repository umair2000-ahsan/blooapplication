package com.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="post",uniqueConstraints = @UniqueConstraint(columnNames = {"title"}) )
public class Post {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private long id;
    private String title;
    private String  content;
    private String description;
}
