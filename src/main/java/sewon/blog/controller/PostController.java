package sewon.blog.controller;

import org.springframework.stereotype.Controller;
import sewon.blog.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sewon.blog.service.PostService;
import sewon.blog.vo.postModel;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @GetMapping("/new")
    public String getPostForm() {
        return "post/form";
    }

    @PostMapping("")
    public String createPost(postModel postModel) {
        Long id = postService.savePost(postModel);
        return "redirect:/post/" + id;
    }

    @GetMapping("/{postId}")
    public String getPost(@PathVariable("postId") Long postId, Model model) {
        Post post = postService.findPostById(postId);
        model.addAttribute("post", post);
        return "post/detail";
    }

    @GetMapping("/list")
    public String getPostList(Model model) {
        List<Post> postList = postService.findAll();
        model.addAttribute("posts", postList);
        return "post/list";
    }
}
