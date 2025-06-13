package zag.sm.report.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import zag.sm.report.model.dto.LightJpaReport;
import zag.sm.report.model.filter.ReportSearchFilter;
import zag.sm.report.repository.entity.Report;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class ReportRepositoryImpl implements ReportRepository{

    private final EntityManager entityManager;
    @Override
    public LightJpaReport getAllReport(ReportSearchFilter filter) {

        String hql="SELECT r FROM Report r ";
        String countHql = "SELECT COUNT(r) FROM Report r ";

        List<String> conditions=new ArrayList<>();

        if(filter.getCategoryId() !=null)
            conditions.add("r.category.id = :categoryId");
        if(filter.getStatusId() !=null)
            conditions.add("r.status.id = :statusId");
        if(filter.getCreateOnTo() !=null)
            conditions.add("r.createdOn <= :createdOnTo");
        if(filter.getCreatedOnFrom() !=null)
            conditions.add("r.createdOn >= :createdOnFrom");

        if(!conditions.isEmpty()){
            String conditionStatement="WHERE "+String.join(" AND ",conditions);
            hql+=conditionStatement;
            countHql+=conditionStatement;
        }

        if(filter.getSorting().getOrderBy() !=null && filter.getSorting().getOrderDir() !=null){

            hql+="ORDER BY ";

            switch (filter.getSorting().getOrderBy()){
                case "REPORT_CATEGORY":
                    hql+="r.category ";
                    break;
                case "REPORT_STATUS":
                    hql+="r.status ";
                    break;
                case "CREATION_DATE":
                    hql+="r.createdOn ";
                    break;
            }
            hql+=filter.getSorting().getOrderDir();
        }else {
            hql+=" ORDER BY r.createdOn DESC ";
        }

        TypedQuery<Report> query= entityManager.createQuery(hql, Report.class);
        TypedQuery<Long> countQuery= entityManager.createQuery(countHql,Long.class);

        if(filter.getCategoryId() !=null) {
            query.setParameter("categoryId", filter.getCategoryId());
            countQuery.setParameter("categoryId", filter.getCategoryId());
        }
        if(filter.getStatusId() !=null) {
            query.setParameter("statusId", filter.getStatusId());
            countQuery.setParameter("statusId", filter.getStatusId());
        }
        if(filter.getCreateOnTo() !=null) {
            query.setParameter("createdOnTo", filter.getCreateOnTo());
            countQuery.setParameter("createdOnTo", filter.getCreateOnTo());
        }
        if(filter.getCreatedOnFrom() !=null) {
            query.setParameter("createdOnFrom", filter.getCreatedOnFrom());
            countQuery.setParameter("createdOnFrom", filter.getCreatedOnFrom());
        }
        query.setFirstResult(filter.getPagination().getPageOffset())
                .setMaxResults(filter.getPagination().getPageSize());

        List<Report> reports=query.getResultList();
        Long totalCount=countQuery.getSingleResult();

        return LightJpaReport.builder()
                .reports(reports)
                .totalCount(totalCount)
                .build();
    }
}