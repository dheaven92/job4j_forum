package ru.job4j.forum.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Calendar;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Table(name = "posts")
@Entity
public class Post {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    @CreationTimestamp
    private Calendar created;

    @UpdateTimestamp
    private Calendar updated;

    public static Post of(int id, String name, String description) {
        Post post = new Post();
        post.id = id;
        post.name = name;
        post.description = description;
        return post;
    }
}
