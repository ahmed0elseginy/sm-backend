package zag.sm.user.model.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import zag.library.filter.SearchFilter;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserSearchFilter extends SearchFilter {

    private List<Long>ids;
    private String fullName;


}
