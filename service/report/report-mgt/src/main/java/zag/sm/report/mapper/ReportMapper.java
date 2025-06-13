package zag.sm.report.mapper;

import org.mapstruct.*;
import zag.sm.report.model.ReportEventData;
import zag.sm.report.model.generated.*;
import zag.sm.report.repository.entity.Category;
import zag.sm.report.repository.entity.Report;


import zag.sm.report.model.vto.PostVTO;
import zag.sm.report.repository.entity.Status;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
@MapperConfig(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public abstract class ReportMapper {


    public abstract Report toReport(ReportRequestDTO reportRequest , Long createdById, Long postId , Category category);
    public abstract ReportDetails toReportDetails(Report report);
    @Mapping(source = "user.id", target = "id")
    public abstract LightUserVTO mapUserIdToLightUser(LightUserVTO user);


    @Mapping(target = "createdBy",source = "user")
    @Mapping(target = "id",source ="report.id")
    public abstract PostReportListItem toPostReportListItems(Report report,LightUserVTO user);


    @Mapping(target = "reason",source = "reportRequest.reason")
    @Mapping(target = "postId",source = "postId")
    public abstract Report toReport(ReportRequestDTO reportRequest , Long createdById, Long postId);

    public abstract LightPostVTO toPostDetails(PostVTO post);

    @Mapping(target = "id",source = "post.id")
    @Mapping(target = "title",source = "post.title")
    @Mapping(target = "content",source = "post.content")
    @Mapping(target = "createdOn",source = "post.createdOn")
    @Mapping(target = "createdBy",source = "post.createdBy")
    public abstract PostDetailsVTO toFullPostDetails(PostVTO post);

    @Mapping(target = "id",source = "report.id")
    @Mapping(target = "post",source = "postLight")
    @Mapping(target = "createdBy",source = "user")
    @Mapping(target = "category.titleEn",source = "report.category.title")
    @Mapping(target = "status.titleEn",source = "report.status.title")
    @Mapping(target = "lastModifiedOn",source = "report.lastModifiedOn")
    public abstract LightReportListItem toLightListItem(Report report, LightPostVTO postLight, LightUserVTO user);

    @Mapping(target = "titleEn",source = "category.title")
    public abstract LookupVTO toLookupVTO(Category category);

    @Mapping(target = "titleEn",source = "status.title")
    public abstract LookupVTO toLookupVTO(Status status);

    @Mapping(target = "postOwnerId",source = "postOwnerId")
    @Mapping(target = "id",source = "report.id")
    @Mapping(target = "postId",source = "report.postId")
    @Mapping(target = "createdOn",source = "report.createdOn")
    @Mapping(target = "lastModifiedOn",source = "report.lastModifiedOn")
    @Mapping(target = "lastModifiedById",source = "report.lastModifiedById")
    @Mapping(target = "createdById",source = "report.createdById")
    @Mapping(target = "rejectReason",source = "report.rejectReason")
    public abstract ReportEventData toReportEventData(Report report,Long postOwnerId);

    public abstract List<ReportEventData> toListReportEventData(List<Report> report);

}
