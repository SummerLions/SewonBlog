package sewon.blog.service;

import sewon.blog.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sewon.blog.repository.PostRepository;
import sewon.blog.vo.PostModel;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Post savePost(PostModel postModel) {
        Post post;
        if (postModel.getId() == null) {
            post = new Post();
        } else {
            post = findPostById(postModel.getId());
        }
        post.setTitle(postModel.getTitle());
        post.setContent(postModel.getContent());
        post.setAuthor(postModel.getAuthor());
        postRepository.save(post);
        return post;
    }

    public Post findPostById(Long id){
        return postRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
