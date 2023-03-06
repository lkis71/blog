package toy.blog.post.dto.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SavePostRequest {

    @NotEmpty
    private String title;
    private String content;
}
