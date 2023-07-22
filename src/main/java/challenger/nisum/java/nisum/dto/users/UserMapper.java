package challenger.nisum.java.nisum.dto.users;

import challenger.nisum.java.nisum.model.Users;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface UserMapper {
    @Mapping(source = "phones", target = "phones")
    UsersDto toDtoFromModel( Users users );

    Users toModelFromRequest( UsersRequest usersRequest );
}
