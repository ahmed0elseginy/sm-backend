package zag.sm.post.model.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import zag.library.filter.SearchFilter;

import java.util.Date;

@Data
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
public class PostSearchFilter extends SearchFilter {
    private String title;
    private Long createdById;
    private Date createdOnFrom;
    private Date createdOnTo;



}
