package global.service.impl;

import global.dto.SimpleResponse;
import global.dto.request.CompanyRequest;
import global.dto.response.CompanyResponse;
import global.dto.response.InstructorResponse;
import global.entity.Company;
import global.entity.Instructor;
import global.repo.CompanyRepo;
import global.repo.InstructorRepo;
import global.service.CompanyService;
import global.service.InstructorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepo companyRepo;

    @Override
    public SimpleResponse saveCompany(CompanyRequest companyRequest) {
        Company company = new Company();
        company.setName(companyRequest.getName());
        company.setAddress(companyRequest.getCountry());
        company.setCountry(companyRequest.getAddress());
        company.setPhoneNumber(companyRequest.getPhoneNumber());
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
        company.setName(companyRequest.getName());
        company.setAddress(companyRequest.getAddress());
        company.setCountry(companyRequest.getCountry());
        company.setPhoneNumber(companyRequest.getPhoneNumber());
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
