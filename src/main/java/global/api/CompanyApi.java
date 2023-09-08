package global.api;

import global.dto.SimpleResponse;
import global.dto.request.CompanyRequest;
import global.dto.response.CompanyResponse;
import global.service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company/api")
@RequiredArgsConstructor
public class CompanyApi {
    private final CompanyService companyService ;

    @GetMapping
    public List<CompanyResponse> getAllCompany(){
       return companyService.getAllCompany();
    }

    @PostMapping
    public SimpleResponse saveCompany(@RequestBody @Valid CompanyRequest companyRequest){
        return companyService.saveCompany(companyRequest);
    }

   @GetMapping("/{companyId}")
   public CompanyResponse getCompanyById(@PathVariable Long companyId){
        return companyService.getCompanyById(companyId);
   }

   @PostMapping("/updateCom/{companyId}")
    public SimpleResponse updateCompany(@PathVariable Long companyId ,@RequestBody CompanyRequest companyRequest){
        return companyService.updateCompany(companyId,companyRequest);
   }

   @GetMapping("/deleteCom/{companyId}")
    public SimpleResponse deleteCompany(@PathVariable Long companyId){
        return companyService.deleteCompany(companyId);
   }
}
