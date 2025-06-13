package zag.sm.point.mapper;

import org.mapstruct.Builder;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
@MapperConfig(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public abstract class PointMapper {

}
