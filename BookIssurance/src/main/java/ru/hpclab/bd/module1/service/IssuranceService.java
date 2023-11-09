package ru.hpclab.bd.module1.service;

import org.springframework.stereotype.Service;
import ru.hpclab.bd.module1.model.Issurance;
import ru.hpclab.bd.module1.repository.IssuranceRepository;

import java.util.List;
import java.util.UUID;

/**
 * Service to control issurances.
 */
public class IssuranceService {
    
    private final IssuranceRepository issuranceRepository;

    /**
     * Builds new IssuranceService.
     * @param issuranceRepository issurance repository
     */
    public IssuranceService(final IssuranceRepository issuranceRepository) {
        this.issuranceRepository = issuranceRepository;
    }

    /**
     * Fetches all issurances.
     * @return list of issurances
     */
    public List<Issurance> getAllIssurances() {
        return issuranceRepository.findAll();
    }

    /**
     * Fetches issurances by card number of user.
     * @param cardNumberOfUser user card in library
     * @return list of issurances
     */
    public List<Issurance> getIssurancesByIdUser(final String cardNumberOfUser) {
        return issuranceRepository.findByCardNumberOfUser(UUID.fromString(cardNumberOfUser));
    }

    /**
     * Creates or updates issurances.
     * @param issurance issurance to save
     * @return saved issurance
     */
    public Issurance saveIssurance(final Issurance issurance) {
        return issuranceRepository.save(issurance);
    }

    /**
     * Updates issurance.
     * @param idIssuranse issurance id to update
     * @param issurance issurance with new attributes
     * @return updated issurance
     */
    public Issurance updateIssurance(final String idIssuranse, final Issurance issurance) {
        issurance.setIdIssurance(UUID.fromString(idIssuranse));
        return issuranceRepository.put(issurance);
    }

    /**
     * Deletes issurance by id.
     * @param idIssurance issurance id
     */
    public void deleteIssurance(final String idIssurance) {
        issuranceRepository.delete(UUID.fromString(idIssurance));
    }
}
