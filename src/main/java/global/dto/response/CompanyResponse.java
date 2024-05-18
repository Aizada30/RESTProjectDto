package global.dto.response;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
public class CompanyResponse {
    private Long id;
    @Column(unique = true)
    private String name;
    private String country;
    private String address;
    private String phoneNumber;
    private LocalDate createdAt;

    public CompanyResponse(Long id, String name, String country, String address, String phoneNumber, LocalDate createdAt) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
    }
}