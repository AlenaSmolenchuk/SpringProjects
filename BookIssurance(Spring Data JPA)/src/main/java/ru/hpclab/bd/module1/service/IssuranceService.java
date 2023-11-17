package ru.hpclab.bd.module1.service;

import org.springframework.stereotype.Service;
import ru.hpclab.bd.module1.controller.exeption.IssuranceException;
import ru.hpclab.bd.module1.entity.IssuranceEntity;
import ru.hpclab.bd.module1.repository.IssuranceRepository;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static java.lang.String.format;

/**
 * Service to control issurances.
 */
@Service
public class IssuranceService {
    private final IssuranceRepository issuranceRepository;

    /**
     * A constant string representing the error message when an issurance with a specific ID is not found.
     *
     * @see java.lang.String#format(String, Object...)
     *
     * @param %s The placeholder for the ID in the error message.
     * @return The formatted error message indicating that an issurance with the specified ID was not found.
     */
    public static final String ISSURANCE_NOT_FOUND_MSG = "Issurance with ID %s not found";

    /**
     * Builds new IssuranceService.
     * @param issuranceRepository issurance repository
     */
    public IssuranceService(final IssuranceRepository issuranceRepository) {
        this.issuranceRepository = issuranceRepository;
    }

    /**
     * Fetches all issurances entity.
     * @return list of issurances entity
     */
    public List<IssuranceEntity> getAllIssurances() {
        return (List<IssuranceEntity>) issuranceRepository.findAll();
    }

    /**
     * Fetches issurances entity by card number of user.
     * @param cardNumberOfUser user entity card in library
     * @return list of issurances entity
     */
    public List<IssuranceEntity> getIssurancesByIdUser(final UUID cardNumberOfUser) {
        return Collections.singletonList(issuranceRepository.findByCardNumberOfUser(cardNumberOfUser)
                .orElseThrow(() -> new IssuranceException(format(ISSURANCE_NOT_FOUND_MSG, cardNumberOfUser))));
    }

    /**
     * Creates or updates issurances entity.
     * @param issuranceEntity issurance entity to save
     * @return saved issurance entity
     */
    public IssuranceEntity saveIssurance(final IssuranceEntity issuranceEntity) {
        return issuranceRepository.save(issuranceEntity);
    }

    /**
     * Updates issurance entity.
     * @param idIssuranse issurance entity id to update
     * @param issuranceEntity issurance entity with new attributes
     * @return updated issurance entity
     */
    public IssuranceEntity updateIssurance(final UUID idIssuranse, final IssuranceEntity issuranceEntity) {
        issuranceEntity.setIdIssurance(idIssuranse);
        return issuranceRepository.save(issuranceEntity);
    }

    /**
     * Deletes issurance entity by id.
     * @param idIssurance issurance entity id
     */
    public void deleteIssurance(final UUID idIssurance) {
        issuranceRepository.deleteByIdIssurance(idIssurance);
    }

    /**
     * Checks exist an issurance entity with a given idIssurance or not.
     * @param idIssurance issurance entity id to check
     * @return true if an issurance entity with given idIssurance exists; otherwise, false
     */
    public boolean existsIssurance(final UUID idIssurance) {
        return issuranceRepository.existsByIdIssurance(idIssurance);
    }
}
