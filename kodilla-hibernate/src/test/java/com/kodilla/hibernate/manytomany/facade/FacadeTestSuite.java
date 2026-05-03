package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FacadeTestSuite {

    @Autowired
    private StringSearchEngineFacade facade;

    @Autowired
    private CompanyDao companyDao;

    @Test
    @Transactional
    void testSearchFacade() {
        // Given
        Employee jozin = new Employee("Jozin", "Zbazin");
        Company swamp = new Company("Swamp Software");
        swamp.getEmployees().add(jozin);
        jozin.getCompanies().add(swamp);

        companyDao.save(swamp);

        // When
        List<Company> companies = facade.searchCompany("soft");
        List<Employee> employees = facade.searchEmployee("zin");

        // Then
        assertEquals(1, companies.size());
        assertEquals(1, employees.size());

        // CleanUp
        companyDao.deleteById(swamp.getId());
    }
}
