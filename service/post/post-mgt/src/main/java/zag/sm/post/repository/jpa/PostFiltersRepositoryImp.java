package zag.sm.post.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import zag.library.common.model.data.ListResultSet;
import zag.sm.post.model.filter.PostSearchFilter;
import zag.sm.post.model.generated.GetAllPostsOrderByAttributes;
import zag.sm.post.repository.entity.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class PostFiltersRepositoryImp implements PostFiltersRepository {

    private final EntityManager entityManager;

    @Override
    public ListResultSet findAllByFilters2(PostSearchFilter filter) {
        String hql = "SELECT p FROM Post p WHERE p.isDeleted IS false ";
        String countHql = "SELECT COUNT(p) FROM Post p WHERE p.isDeleted IS false ";
        List<String> conditions = new ArrayList<>();
        Map<String, Object> params = new HashMap<>();

        if (filter.getTitle() != null) {
            conditions.add("p.title LIKE :title");
            params.put("title", "%" + filter.getTitle() + "%");
        }
        if (filter.getCreatedById() != null) {
            conditions.add("p.createdById = :createdById");
            params.put("createdById", filter.getCreatedById());
        }
        if (filter.getCreatedOnFrom() != null) {
            conditions.add("p.createdOn >= :createdOnFrom");
            params.put("createdOnFrom", filter.getCreatedOnFrom());
        }
        if (filter.getCreatedOnTo() != null) {
            conditions.add("p.createdOn <= :createdOnTo");
            params.put("createdOnTo", filter.getCreatedOnTo());
        }

        if (!conditions.isEmpty()) {
            String whereClause = " AND " + String.join(" AND ", conditions );
            hql += whereClause;
            countHql += whereClause;
        }

        if (filter.getSorting().getOrderBy() != null && filter.getSorting().getOrderDir() != null) {
            hql += " ORDER BY ";
            GetAllPostsOrderByAttributes orderBy = GetAllPostsOrderByAttributes.valueOf(filter.getSorting().getOrderBy());
            switch (orderBy){
                case CREATION_DATE:
                    hql +="p.createdOn";
                    break;
                case TITLE:
                    hql +="p.title";
                    break;
                case POST_OWNER:
                    hql +="p.createdById";
                    break;
            }
            hql +=" "+ filter.getSorting().getOrderDir();
        }else{
            hql+=" ORDER BY p.createdOn DESC ";
        }

        TypedQuery<Post> query = entityManager.createQuery(hql, Post.class);
        TypedQuery<Long> countQuery = entityManager.createQuery(countHql, Long.class);

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
            countQuery.setParameter(entry.getKey(), entry.getValue());
        }

        query.setFirstResult(filter.getPagination().getPageOffset())
                .setMaxResults(filter.getPagination().getPageSize());

        List<Post> resultList = query.getResultList();
        Long totalCount = countQuery.getSingleResult();

        return new ListResultSet<>(resultList, totalCount);
    }

    @Override
    public ListResultSet findAllByFilters(PostSearchFilter filter) {
        String hql = "SELECT p FROM Post p ";

        String countHql = "SELECT COUNT(p) FROM Post p ";

        List<String> conditions = new ArrayList<>();

        if (filter.getTitle() != null) {
            conditions.add("p.title LIKE :title");
        }
        if (filter.getCreatedById() != null) {
            conditions.add("p.createdById = :createdById");
        }
        if (filter.getCreatedOnFrom() != null) {
            conditions.add("p.createdOn >= :createdOnFrom");
        }
        if (filter.getCreatedOnTo() != null) {
            conditions.add("p.createdOn <= :createdOnTo");
        }

        if (!conditions.isEmpty()) {
            String whereClause = " WHERE " + String.join(" AND ", conditions);
            hql += whereClause;

            countHql += whereClause;

        }
        if (filter.getSorting().getOrderBy() != null && filter.getSorting().getOrderDir() != null) {
            hql += " ORDER BY ";
            GetAllPostsOrderByAttributes orderBy = GetAllPostsOrderByAttributes.valueOf(filter.getSorting().getOrderBy());
            switch (orderBy){
                case CREATION_DATE:
                    hql +="p.createdon";
                    break;
                case TITLE:
                    hql +="p.title";
                    break;
                case POST_OWNER:
                    hql +="p.createdById";
                    break;
            }
            hql +=" "+ filter.getSorting().getOrderDir();
        }

        TypedQuery<Post> query = entityManager.createQuery(hql, Post.class);
        TypedQuery<Long> countQuery = entityManager.createQuery(countHql, Long.class);

        if (!conditions.isEmpty()) {
            if (filter.getTitle() != null) {
                System.out.println("Filter: " + filter.getTitle());
                query.setParameter("title", "%" + filter.getTitle() + "%");

//                countQuery.setParameter("title", "%" + filter.getTitle() + "%");

//                query.setParameter("title", filter.getTitle());
            }
            if (filter.getCreatedById() != null) {
                query.setParameter("createdById", filter.getCreatedById());
            }
            if (filter.getCreatedOnFrom() != null) {
                query.setParameter("createdOnFrom", filter.getCreatedOnFrom());
            }
            if (filter.getCreatedOnTo() != null) {
                query.setParameter("createdOnTo", filter.getCreatedOnTo());
            }
        }

        query.setFirstResult(filter.getPagination().getPageOffset()).
                setMaxResults(filter.getPagination().getPageSize());
        List<Post> resultList = query.getResultList();
        Long totalCount = countQuery.getSingleResult();

        return new ListResultSet<>(resultList, totalCount);
    }


}
