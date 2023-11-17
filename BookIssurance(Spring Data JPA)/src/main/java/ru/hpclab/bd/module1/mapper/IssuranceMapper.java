package ru.hpclab.bd.module1.mapper;

import ru.hpclab.bd.module1.entity.IssuranceEntity;
import ru.hpclab.bd.module1.model.Issurance;

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

            issuranceEntity.setIdIssurance(issurance.getIdIssurance());
            issuranceEntity.setCardNumberOfUser(issurance.getCardNumberOfUser());
            issuranceEntity.setIsbnOfBook(issurance.getIsbnOfBook());
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
        issurance.setIdIssurance(issuranceEntity.getIdIssurance());
        issurance.setIsbnOfBook(issuranceEntity.getIsbnOfBook());
        issurance.setDateOfIssurance(issuranceEntity.getDateOfIssurance());
        issurance.setPeriodOfUsage(issuranceEntity.getPeriodOfUsage());
        issurance.setUser(UserMapper.entity2User(issuranceEntity.getUserEntity()));
        issurance.setBook(BookMapper.entity2Book(issuranceEntity.getBookEntity()));

        return issurance;
    }
}
