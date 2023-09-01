package global.dto.request;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CompanyRequest {
    private String name;
    private String country;
    private String address;
    private String phoneNumber;
}
