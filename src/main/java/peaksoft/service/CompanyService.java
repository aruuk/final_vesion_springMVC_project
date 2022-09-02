package peaksoft.service;

import peaksoft.model.Company;

import java.util.List;

public interface CompanyService {
    void saveCompany(Company company);
    void updateCompany(Company company);
    void deleteCompany(Long id);
    List<Company> getAllCompanies(Long id);
    Company getCompanyById(Long id);
}
