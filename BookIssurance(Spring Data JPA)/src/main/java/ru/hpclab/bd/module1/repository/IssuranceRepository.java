package ru.hpclab.bd.module1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.hpclab.bd.module1.entity.IssuranceEntity;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository to access Issurances.
 */
@Repository
public interface IssuranceRepository extends CrudRepository<IssuranceEntity, UUID> {

    /**
     * Fetches issurances by card number of user.
     * @param cardNumberOfUser card number of user
     * @return list of issurances
     */
    Optional<IssuranceEntity> findByCardNumberOfUser(UUID cardNumberOfUser);

    /**
     * Deletes issurance by idIssurance.
     * @param idIssurance issurance id
     */
    void deleteByIdIssurance(UUID idIssurance);

    /**
     * Checks if an issurance with the given id exists in the repository.
     *
     * @param idIssurance The identifier to check for existence.
     * @return {@code true} if an issurance with the id exists, {@code false} otherwise.
     */
    boolean existsByIdIssurance(UUID idIssurance);
}
