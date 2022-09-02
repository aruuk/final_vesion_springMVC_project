package peaksoft.daoImpl;

import peaksoft.dao.CompanyDAO;
import peaksoft.model.Company;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CompanyDAOImpl implements CompanyDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveCompany(Company company) {
        entityManager.persist(company);
    }

    @Override
    public void updateCompany(Company company) {
//        Company company1 = entityManager.find(Company.class, id);
//        company1.setCompanyName(company.getCompanyName());
//        company1.setLocatedCountry(company.getLocatedCountry());

        entityManager.merge(company);

    }

    @Override
    public void deleteCompany(Long id) {
        entityManager.remove(entityManager.find(Company.class, id));
    }

    @Override
    public List<Company> getAllCompanies() {
        return entityManager.createQuery("select c from Company c",
                Company.class).getResultList();

    }

    @Override
    public Company getCompanyById(Long id) {
        return entityManager.createQuery("select c from Company c where " +
                "c.id =: id",Company.class).setParameter("id",id).getSingleResult();
    }
}
