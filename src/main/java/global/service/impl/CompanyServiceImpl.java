package global.service.impl;

import global.dto.SimpleResponse;
import global.dto.request.CompanyRequest;
import global.dto.response.CompanyResponse;
import global.entity.Company;
import global.repo.CompanyRepo;
import global.service.CompanyService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepo companyRepo;

    @Override
    public SimpleResponse saveCompany(CompanyRequest companyRequest) {
        Company company = new Company();
        company.setName(companyRequest.name());
        company.setAddress(companyRequest.country());
        company.setCountry(companyRequest.address());
        company.setPhoneNumber(companyRequest.phoneNumber());
        company.setCreatedAt(LocalDate.now());
        companyRepo.save(company);
        return new SimpleResponse(
                HttpStatus.OK,
                String.format("Company with id %s successfully saved", company.getId())
        );
    }

    @Override
    public List<CompanyResponse> getAllCompany() {
        return companyRepo.getAllCompany();
    }


    @Override
    public SimpleResponse updateCompany(Long companyId, CompanyRequest companyRequest) {
        Company company = companyRepo.getBYId(companyId);
        company.setName(companyRequest.name());
        company.setAddress(companyRequest.address());
        company.setCountry(companyRequest.country());
        company.setPhoneNumber(companyRequest.phoneNumber());
        return new SimpleResponse(
                HttpStatus.OK,
                String.format("Company with id: %s successfully updated", company.getId())
        );
    }

    @Override
    public SimpleResponse deleteCompany(Long companyId) {
        companyRepo.deleteById(companyId);
        return new SimpleResponse(
                HttpStatus.OK,
                String.format(
                        "Company with id: %s successfully deleted ", companyId
                )
        );
    }

    @Override
    public CompanyResponse getCompanyById(Long companyId) {
        return companyRepo.getCompanyById(companyId).orElseThrow(
                () -> new NoSuchElementException(
                        "company not found"
                )
        );
    }
}
