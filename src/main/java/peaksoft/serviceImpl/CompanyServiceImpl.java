package peaksoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.dao.CompanyDAO;
import peaksoft.model.Company;
import peaksoft.service.CompanyService;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CompanyServiceImpl implements CompanyService {
    private final CompanyDAO companyDAO;

    @Autowired
    public CompanyServiceImpl(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    @Override
    public void saveCompany(Company company) {
        companyDAO.saveCompany(company);
    }

    @Override
    public void updateCompany(Company company) {
        companyDAO.updateCompany(company);
    }

    @Override
    public void deleteCompany(Long id) {
        companyDAO.deleteCompany(id);
    }

    @Override
    public List<Company> getAllCompanies(Long id) {
        return companyDAO.getAllCompanies();
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyDAO.getCompanyById(id);
    }
}
