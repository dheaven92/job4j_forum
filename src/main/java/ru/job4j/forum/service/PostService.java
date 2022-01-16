package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PostService {

    private final Map<Integer, Post> posts = new HashMap<>();
    private final AtomicInteger id = new AtomicInteger(0);

    public PostService() {
        posts.put(1, Post.of(1, "Продаю машину ладу 01",
                "По своей сути рыбатекст является альтернативой традиционному lorem ipsum, "
                         + "который вызывает у некторых людей недоумение при попытках прочитать рыбу текст."));
        id.set(1);
    }

    public List<Post> getAll() {
        return new ArrayList<>(posts.values());
    }

    public Post findById(int id) {
        return posts.get(id);
    }

    public void save(Post post) {
        if (post.getId() == 0) {
            post.setId(id.incrementAndGet());
        }
        posts.put(post.getId(), post);
    }
}
