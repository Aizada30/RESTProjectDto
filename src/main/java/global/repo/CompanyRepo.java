package global.repo;

import global.dto.response.CompanyResponse;
import global.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CompanyRepo extends JpaRepository<Company, Long> {

    @Query("SELECT NEW global.dto.response.CompanyResponse(c.id,c.name,c.country,c.address,c.phoneNumber,c.createdAt) FROM Company c")
    List<CompanyResponse> getAllCompany();

    @Query("SELECT NEW global.dto.response.CompanyResponse(c.id,c.name,c.country,c.address,c.phoneNumber,c.createdAt) FROM Company c WHERE c.id=:companyId")
    Optional<CompanyResponse> getCompanyById(Long companyId);

    @Query("SELECT c FROM Company c WHERE c.id=:companyId")
    Company getBYId(Long companyId);
}
