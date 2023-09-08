package global.dto.request;

import global.validation.PhoneNumberValid;
import lombok.Getter;
import lombok.Setter;



public record CompanyRequest (
         String name,
         String country,
         String address,
        @PhoneNumberValid
         String phoneNumber
){
}
