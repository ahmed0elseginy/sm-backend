package zag.sm.user.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import zag.sm.user.model.filter.UserSearchFilter;
import zag.sm.user.repository.entity.User;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements  UserRepository {

    private final EntityManager entityManager;;

    @Override
    public List<User> findUsersByFilter(UserSearchFilter filter) {


        String hql="SELECT user FROM User user ";

        List<String> conditions = new ArrayList<>();

        if(filter.getIds() != null){
            conditions.add("user.id IN :ids");
        }
        if(filter.getFullName() != null){
            conditions.add("LOWER(CONCAT(user.firstName,' ',user.lastName)) LIKE :fullName");
        }


        if(!conditions.isEmpty()) {

            hql += "WHERE " + String.join(" AND ", conditions);

            TypedQuery<User> query = entityManager.createQuery(hql,User.class);

            if(filter.getIds() != null){
                query.setParameter("ids",filter.getIds());
            }
            if(filter.getFullName() != null){
                query.setParameter("fullName","%"+filter.getFullName().toLowerCase()+"%");
            }

            query.setFirstResult(filter.getPagination().getPageOffset()).setMaxResults(filter.getPagination().getPageSize());

            return query.getResultList();

        }else{
            return  new ArrayList<>();
        }
    }
}
