package global.api;

import global.dto.SimpleResponse;
import global.dto.request.CompanyRequest;
import global.dto.response.CompanyResponse;
import global.service.CompanyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/company/api")
@RequiredArgsConstructor
@Tag(name = "Company API")
public class CompanyApi {
    private final CompanyService companyService ;

    @PermitAll
    @GetMapping
    public List<CompanyResponse> getAllCompany(){
       return companyService.getAllCompany();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public SimpleResponse saveCompany(@RequestBody @Valid CompanyRequest companyRequest){
        return companyService.saveCompany(companyRequest);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','INSTRUCTOR')")
   @GetMapping("/{companyId}")
   public CompanyResponse getCompanyById(@PathVariable Long companyId){
        return companyService.getCompanyById(companyId);
   }

    @PreAuthorize("hasAuthority('ADMIN')")
   @PostMapping("/updateCom/{companyId}")
    public SimpleResponse updateCompany(@PathVariable Long companyId ,@RequestBody CompanyRequest companyRequest){
        return companyService.updateCompany(companyId,companyRequest);
   }

    @PreAuthorize("hasAuthority('ADMIN')")
   @GetMapping("/deleteCom/{companyId}")
    public SimpleResponse deleteCompany(@PathVariable Long companyId){
        return companyService.deleteCompany(companyId);
   }
}