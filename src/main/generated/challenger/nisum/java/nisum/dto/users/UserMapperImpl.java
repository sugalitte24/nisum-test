package challenger.nisum.java.nisum.dto.users;

import challenger.nisum.java.nisum.dto.phones.PhonesDto;
import challenger.nisum.java.nisum.model.Phones;
import challenger.nisum.java.nisum.model.Users;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-21T22:58:10-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UsersDto toDtoFromModel(Users users) {
        if ( users == null ) {
            return null;
        }

        UsersDto usersDto = new UsersDto();

        List<PhonesDto> list = phonesListToPhonesDtoList( users.getPhones() );
        if ( list != null ) {
            usersDto.setPhones( list );
        }
        if ( users.getName() != null ) {
            usersDto.setName( users.getName() );
        }
        if ( users.getEmail() != null ) {
            usersDto.setEmail( users.getEmail() );
        }
        if ( users.getPassword() != null ) {
            usersDto.setPassword( users.getPassword() );
        }
        if ( users.getIsActive() != null ) {
            usersDto.setIsActive( users.getIsActive() );
        }
        if ( users.getLastLogin() != null ) {
            usersDto.setLastLogin( users.getLastLogin() );
        }
        if ( users.uuid != null ) {
            usersDto.uuid = users.uuid;
        }
        if ( users.createdAt != null ) {
            usersDto.createdAt = users.createdAt;
        }
        if ( users.lastModifiedAt != null ) {
            usersDto.lastModifiedAt = users.lastModifiedAt;
        }

        return usersDto;
    }

    @Override
    public Users toModelFromRequest(UsersRequest usersRequest) {
        if ( usersRequest == null ) {
            return null;
        }

        Users users = new Users();

        if ( usersRequest.getName() != null ) {
            users.setName( usersRequest.getName() );
        }
        if ( usersRequest.getEmail() != null ) {
            users.setEmail( usersRequest.getEmail() );
        }
        if ( usersRequest.getPassword() != null ) {
            users.setPassword( usersRequest.getPassword() );
        }
        if ( usersRequest.getIsActive() != null ) {
            users.setIsActive( usersRequest.getIsActive() );
        }
        List<Phones> list = phonesDtoListToPhonesList( usersRequest.getPhones() );
        if ( list != null ) {
            users.setPhones( list );
        }

        return users;
    }

    protected PhonesDto phonesToPhonesDto(Phones phones) {
        if ( phones == null ) {
            return null;
        }

        PhonesDto phonesDto = new PhonesDto();

        if ( phones.getNumber() != null ) {
            phonesDto.setNumber( phones.getNumber() );
        }
        if ( phones.getCityCode() != null ) {
            phonesDto.setCityCode( phones.getCityCode() );
        }
        if ( phones.getCountryCode() != null ) {
            phonesDto.setCountryCode( phones.getCountryCode() );
        }

        return phonesDto;
    }

    protected List<PhonesDto> phonesListToPhonesDtoList(List<Phones> list) {
        if ( list == null ) {
            return null;
        }

        List<PhonesDto> list1 = new ArrayList<PhonesDto>( list.size() );
        for ( Phones phones : list ) {
            list1.add( phonesToPhonesDto( phones ) );
        }

        return list1;
    }

    protected Phones phonesDtoToPhones(PhonesDto phonesDto) {
        if ( phonesDto == null ) {
            return null;
        }

        Phones phones = new Phones();

        if ( phonesDto.getNumber() != null ) {
            phones.setNumber( phonesDto.getNumber() );
        }
        if ( phonesDto.getCityCode() != null ) {
            phones.setCityCode( phonesDto.getCityCode() );
        }
        if ( phonesDto.getCountryCode() != null ) {
            phones.setCountryCode( phonesDto.getCountryCode() );
        }

        return phones;
    }

    protected List<Phones> phonesDtoListToPhonesList(List<PhonesDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Phones> list1 = new ArrayList<Phones>( list.size() );
        for ( PhonesDto phonesDto : list ) {
            list1.add( phonesDtoToPhones( phonesDto ) );
        }

        return list1;
    }
}
