package ru.hpclab.bd.module1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.hpclab.bd.module1.entity.IssuranceEntity;

import java.util.Optional;

/**
 * Repository to access Issurances.
 */
@Repository
public interface IssuranceRepository extends CrudRepository<IssuranceEntity, Long> {

    /**
     * Fetches issurances by card number of user.
     * @param cardNumberOfUser card number of user
     * @return list of issurances
     */
    Optional<IssuranceEntity> findByCardNumberOfUser(Long cardNumberOfUser);

    /**
     * Deletes issurance by idIssurance.
     * @param idIssurance issurance id
     */
    void deleteByIdIssurance(Long idIssurance);

    /**
     * Checks if an issurance with the given id exists in the repository.
     *
     * @param idIssurance The identifier to check for existence.
     * @return {@code true} if an issurance with the id exists, {@code false} otherwise.
     */
    boolean existsByIdIssurance(Long idIssurance);
}
