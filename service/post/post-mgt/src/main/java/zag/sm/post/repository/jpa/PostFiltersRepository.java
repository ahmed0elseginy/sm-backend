package zag.sm.post.repository.jpa;

import zag.library.common.model.data.ListResultSet;
import zag.sm.post.model.filter.PostSearchFilter;


public interface PostFiltersRepository {

    ListResultSet findAllByFilters(PostSearchFilter filter);

    ListResultSet findAllByFilters2(PostSearchFilter filter);


}
