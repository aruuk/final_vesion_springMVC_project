package peaksoft.dao;

import org.springframework.stereotype.Repository;
import peaksoft.model.Company;

import java.util.List;

@Repository
public interface CompanyDAO {
    void saveCompany(Company company);
    void updateCompany(Company company);
    void deleteCompany(Long id);
    List<Company> getAllCompanies();
    Company getCompanyById(Long id);
}
