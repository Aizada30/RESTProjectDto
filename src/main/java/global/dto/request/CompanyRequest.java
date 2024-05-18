package global.dto.request;

import global.validation.PhoneNumberValid;

public record CompanyRequest (
         String name,
         String country,
         String address,
        @PhoneNumberValid
         String phoneNumber
){
}