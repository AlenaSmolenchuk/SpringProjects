package ru.hpclab.bd.module1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.hpclab.bd.module1.model.Issurance;
import ru.hpclab.bd.module1.service.IssuranceService;

import java.util.List;

/**
 * Rest controller for issurance.
 */
@RestController
public class IssuranceController {

    private final IssuranceService issuranceService;

    /**
     * Builds new IssuranceController.
     * @param issuranceService issurance service
     */
    @Autowired
    public IssuranceController(final IssuranceService issuranceService) {
        this.issuranceService = issuranceService;
    }

    /**
     * Returns all issurances.
     * @return list of issurances
     */
    @GetMapping("/issurances")
    public List<Issurance> getIssurances() {
        return issuranceService.getAllIssurances();
    }

    /**
     * Returns list of issurances by idUser.
     * @param idUser user id
     * @return list of issurances
     */
    @GetMapping("/issurances/{idUser}")
    public List<Issurance> getIssurancesByIdUser(@PathVariable final String idUser) {
        return issuranceService.getIssurancesByIdUser(idUser);
    }

    /**
     * Deletes issurance by IdIssurance.
     * @param idIssurance issurance id
     */
    @DeleteMapping("/issurances/{idIssurance}")
    public void deleteIssurance(@PathVariable final String idIssurance) {
        issuranceService.deleteIssurance(idIssurance);
    }

    /**
     * Creates or updates issurance.
     * @param issurance issurance
     * @return saved issurance
     */
    @PostMapping(value = "/issurances")
    public Issurance saveIssurance(@RequestBody final Issurance issurance) {
        return issuranceService.saveIssurance(issurance);
    }

    /**
     * Updates issurance.
     * @param idIssurance issurance idIssurance
     * @param issurance issurance's new attributes
     * @return updated issurance
     */
    @PutMapping(value = "/issurances/{idIssurance}")
    public Issurance updateIssurance(
            @PathVariable(required = false) final String idIssurance,
            @RequestBody final Issurance issurance
    ) {
        return issuranceService.updateIssurance(idIssurance, issurance);
    }
}
