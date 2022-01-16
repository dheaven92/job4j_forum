package ru.job4j.forum.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getAll() {
        return (List<Post>) postRepository.findAll();
    }

    public Post findById(int id) {
        return postRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Post post, int id) {
        if (id != 0) {
            Post postInDb = postRepository.findById(id).orElse(null);
            if (postInDb != null) {
                postInDb.setName(post.getName());
                postInDb.setDescription(post.getDescription());
            }
            return;
        }
        postRepository.save(post);
    }
}
