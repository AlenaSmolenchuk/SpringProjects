package ru.hpclab.bd.module1.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.hpclab.bd.module1.entity.BookEntity;
import ru.hpclab.bd.module1.entity.IssuranceEntity;
import ru.hpclab.bd.module1.entity.UserEntity;
import ru.hpclab.bd.module1.repository.IssuranceRepository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {IssuranceServiceTest.IssuranceServiceTestConfiguration.class})
public class IssuranceServiceTest {

    @Autowired
    private IssuranceService issuranceService;

    @Autowired
    private IssuranceRepository issuranceRepository;


    @Test
    public void testCreateAndGet() {
        //create
        IssuranceEntity issuranceEntity = new IssuranceEntity(
                UUID.randomUUID(),
                UUID.randomUUID(),
                UUID.randomUUID(),
                "10-10-2000",
                "2",
                new UserEntity(),
                new BookEntity());

        IssuranceEntity savedIssurance = issuranceService.saveIssurance(issuranceEntity);

        Assertions.assertEquals(issuranceEntity.getDateOfIssurance(), savedIssurance.getDateOfIssurance());
        Mockito.verify(issuranceRepository, Mockito.times(1)).save(issuranceEntity);

        //getAll
        List<IssuranceEntity> issuranceList = issuranceService.getAllIssurances();

        Assertions.assertEquals("11-10-2000", issuranceList.get(0).getDateOfIssurance());
        Assertions.assertEquals("12-10-2000", issuranceList.get(1).getDateOfIssurance());
        Mockito.verify(issuranceRepository, Mockito.times(1)).findAll();

    }

    @Configuration
    static class IssuranceServiceTestConfiguration {

        @Bean
        IssuranceRepository issuranceRepository() {
            IssuranceRepository issuranceRepository = mock(IssuranceRepository.class);
            when(issuranceRepository.save(any())).thenReturn(new IssuranceEntity(
                    UUID.randomUUID(),
                    UUID.randomUUID(),
                    UUID.randomUUID(),
                    "10-10-2000",
                    "2",
                    new UserEntity(),
                    new BookEntity()));
            when(issuranceRepository.findAll())
                    .thenReturn(Arrays.asList(new IssuranceEntity(
                                    UUID.randomUUID(),
                                    UUID.randomUUID(),
                                    UUID.randomUUID(),
                                    "11-10-2000",
                                    "2",
                                    new UserEntity(),
                                    new BookEntity()),
                            new IssuranceEntity(UUID.randomUUID(),
                                    UUID.randomUUID(),
                                    UUID.randomUUID(),
                                    "12-10-2000",
                                    "2",
                                    new UserEntity(),
                                    new BookEntity())));
            return issuranceRepository;
        }

        @Bean
        IssuranceService IssuranceService(final IssuranceRepository issuranceRepository) {
            return new IssuranceService(issuranceRepository);
        }
    }
}
