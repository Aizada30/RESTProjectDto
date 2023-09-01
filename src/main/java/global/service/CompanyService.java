package global.service;

import global.dto.SimpleResponse;
import global.dto.request.CompanyRequest;
import global.dto.response.CompanyResponse;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CompanyService {
    SimpleResponse saveCompany(CompanyRequest companyRequest);
    List<CompanyResponse>getAllCompany();
    SimpleResponse updateCompany(Long companyId,CompanyRequest companyRequest);
    SimpleResponse deleteCompany(Long companyId);
    CompanyResponse getCompanyById(Long companyId);

}
