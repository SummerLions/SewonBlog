package sewon.blog.service;

import sewon.blog.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sewon.blog.repository.PostRepository;
import sewon.blog.vo.postModel;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Long savePost(postModel postModel) {
        Post post = new Post();
        post.setTitle(postModel.getTitle());
        post.setContent(postModel.getContent());
        post.setAuthor(postModel.getAuthor());
        postRepository.save(post);
        return post.getId();
    }

    public Post findPostById(Long id){
        return postRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
