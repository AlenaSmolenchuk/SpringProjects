package ru.hpclab.bd.module1.mapper;

import ru.hpclab.bd.module1.entity.IssuranceEntity;
import ru.hpclab.bd.module1.entity.UserEntity;
import ru.hpclab.bd.module1.model.Issurance;
import ru.hpclab.bd.module1.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Mapper for user.
 */
public final class UserMapper {

    /**
     * Empty contructor.
     */
    private UserMapper() {

    }

    /**
     * Converts a User object to a UserEntity object.
     *
     * @param user The User object to be converted.
     * @return The corresponding UserEntity object.
     */
    public static UserEntity user2Entity(final User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setIdUser(user.getIdUser().getMostSignificantBits());
        userEntity.setFio(user.getFio());
        userEntity.setDateOfBirth(user.getDateOfBirth());
        userEntity.setLibraryCardNumber(user.getLibraryCardNumber().getMostSignificantBits());

        List<IssuranceEntity> issuranceEntityList = new ArrayList<>();
        for (Issurance issurance : user.getIssurancesWithUser()) {
            IssuranceEntity issuranceEntity = IssuranceMapper.issurance2Entity(issurance);
            issuranceEntityList.add(issuranceEntity);
        }
        userEntity.setIssurancesWithUser(issuranceEntityList);

        return userEntity;
    }

    /**
     * Converts a UserEntity object to a User object.
     *
     * @param userEntity The UserEntity object to be converted.
     * @return The corresponding User object.
     */
    public static User entity2User(final UserEntity userEntity) {
        User user = new User();
        user.setIdUser(UUID.fromString(userEntity.getIdUser().toString()));
        user.setFio(userEntity.getFio());
        user.setDateOfBirth(userEntity.getDateOfBirth());
        user.setLibraryCardNumber(UUID.fromString(userEntity.getLibraryCardNumber().toString()));

        List<Issurance> issuranceList = new ArrayList<>();
        for (IssuranceEntity issuranceEntity : userEntity.getIssurancesWithUser()) {
            Issurance issurance = IssuranceMapper.entity2Issurance(issuranceEntity);
            issuranceList.add(issurance);
        }
        user.setIssurancesWithUser(issuranceList);

        return user;
    }
}
