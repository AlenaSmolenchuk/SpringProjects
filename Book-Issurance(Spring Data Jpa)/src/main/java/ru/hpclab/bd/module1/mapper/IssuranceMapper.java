package ru.hpclab.bd.module1.mapper;

import ru.hpclab.bd.module1.entity.IssuranceEntity;
import ru.hpclab.bd.module1.model.Issurance;

import java.util.UUID;

/**
 * Mapper for issurance.
 */
public final class IssuranceMapper {

    /**
     * Empty contructor.
     */
    private IssuranceMapper() {

    }

    /**
     * Converts an Issurance object to an IssuranceEntity object.
     *
     * @param issurance The Issurance object to be converted.
     * @return The corresponding IssuranceEntity object.
     */
    public static IssuranceEntity issurance2Entity(final Issurance issurance) {
            IssuranceEntity issuranceEntity = new IssuranceEntity();

            issuranceEntity.setIdIssurance(Long.valueOf(String.valueOf(issurance.getIdIssurance())));
            issuranceEntity.setCardNumberOfUser(Long.valueOf(String.valueOf(issurance.getCardNumberOfUser())));
            issuranceEntity.setIsbnOfBook(Long.valueOf(String.valueOf(issurance.getIsbnOfBook())));
            issuranceEntity.setPeriodOfUsage(issurance.getPeriodOfUsage());
            issuranceEntity.setDateOfIssurance(issurance.getDateOfIssurance());
            issuranceEntity.setUserEntity(UserMapper.user2Entity(issurance.getUser()));
            issuranceEntity.setBookEntity(BookMapper.book2Entity(issurance.getBook()));

            return issuranceEntity;
    }

    /**
     * Converts a IssuranceEntity object to an Issurance object.
     *
     * @param issuranceEntity The IssuranceEntity object to be converted.
     * @return The corresponding Issurance object.
     */
    public static Issurance entity2Issurance(final IssuranceEntity issuranceEntity) {
        Issurance issurance = new Issurance();
        issurance.setIdIssurance(UUID.fromString(String.valueOf(issuranceEntity.getIdIssurance())));
        issurance.setIsbnOfBook(UUID.fromString(String.valueOf(issuranceEntity.getIsbnOfBook())));
        issurance.setDateOfIssurance(issuranceEntity.getDateOfIssurance());
        issurance.setPeriodOfUsage(issuranceEntity.getPeriodOfUsage());
        issurance.setUser(UserMapper.entity2User(issuranceEntity.getUserEntity()));
        issurance.setBook(BookMapper.entity2Book(issuranceEntity.getBookEntity()));

        return issurance;
    }
}
