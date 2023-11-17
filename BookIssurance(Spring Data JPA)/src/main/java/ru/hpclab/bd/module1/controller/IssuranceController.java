package ru.hpclab.bd.module1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.hpclab.bd.module1.entity.IssuranceEntity;
import ru.hpclab.bd.module1.mapper.IssuranceMapper;
import ru.hpclab.bd.module1.model.Issurance;
import ru.hpclab.bd.module1.service.IssuranceService;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
        return issuranceService.getAllIssurances().stream()
                .map(IssuranceMapper::entity2Issurance).collect(Collectors.toList());
    }

    /**
     * Returns list of issurances by cardNumberOfUser.
     * @param cardNumberOfUser user card number
     * @return list of issurances
     */
    @GetMapping("/issurances/{cardNumberOfUser}")
    public List<Issurance> getIssurancesByIdUser(@PathVariable final UUID cardNumberOfUser) {
        return Collections.singletonList(IssuranceMapper.entity2Issurance((IssuranceEntity) issuranceService
                .getIssurancesByIdUser(cardNumberOfUser)));
    }

    /**
     * Deletes issurance by IdIssurance.
     * @param idIssurance issurance id
     */
    @DeleteMapping("/issurances/{idIssurance}")
    public void deleteIssurance(@PathVariable final UUID idIssurance) {
        issuranceService.deleteIssurance(idIssurance);
    }

    /**
     * Creates or updates issurance.
     * @param issurance issurance
     * @return saved issurance
     */
    @PostMapping(value = "/issurances")
    public Issurance saveIssurance(@RequestBody final Issurance issurance) {
        return IssuranceMapper.entity2Issurance(issuranceService
                .saveIssurance(IssuranceMapper.issurance2Entity(issurance)));
    }

    /**
     * Updates issurance.
     * @param idIssurance issurance idIssurance
     * @param issurance issurance's new attributes
     * @return updated issurance
     */
    @PutMapping(value = "/issurances/{idIssurance}")
    public Issurance updateIssurance(
            @PathVariable(required = false) final UUID idIssurance,
            @RequestBody final Issurance issurance
    ) {
        return IssuranceMapper.entity2Issurance(issuranceService
                .updateIssurance(idIssurance, IssuranceMapper.issurance2Entity(issurance)));
    }
}
