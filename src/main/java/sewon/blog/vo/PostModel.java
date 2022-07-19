package sewon.blog.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostModel {
    private Long id;
    private String title;
    private String content;
    private String author;
}
