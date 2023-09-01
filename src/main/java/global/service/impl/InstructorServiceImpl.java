package global.service.impl;

import global.dto.SimpleResponse;
import global.dto.request.InstructorRequest;
import global.dto.response.InstructorResponse;
import global.entity.Company;
import global.entity.Instructor;
import global.repo.CompanyRepo;
import global.repo.InstructorRepo;
import global.service.InstructorService;
import global.service.StudentCountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepo instructorRepo;
    private final CompanyRepo companyRepo;

    @Override
    public SimpleResponse saveInstructor(InstructorRequest instructorRequest) {
        Instructor instructor=new Instructor();
        instructor.setFirstName(instructorRequest.getFirstName());
        instructor.setLastName(instructorRequest.getLastName());
        instructor.setPhoneNumber(instructorRequest.getPhoneNumber());
        instructor.setSpecialization(instructorRequest.getSpecialization());
        instructor.setCreatedAt(LocalDate.now());
        instructorRepo.save(instructor);
        return new SimpleResponse(
                HttpStatus.OK,
                String.format("Instructor with id:%s successfully saved",instructor.getId())
        );
    }

    @Override
    public List<InstructorResponse> getAllInstructors() {
        return instructorRepo.getAllInstructors();
    }


    @Override
    public SimpleResponse deleteInstructor(Long instructorId) {
        instructorRepo.deleteById(instructorId);
        return new SimpleResponse(
                HttpStatus.OK,
                String.format("Instructor with id: %s successfully deleted",instructorId)
        );
    }

    @Override
    public SimpleResponse updateInstructor(Long instructorId, InstructorRequest instructorRequest) {
        Instructor instructor = instructorRepo.getInstructorById(instructorId);
        instructor.setFirstName(instructorRequest.getFirstName());
        instructor.setLastName(instructorRequest.getLastName());
        instructor.setPhoneNumber(instructorRequest.getPhoneNumber());
        instructor.setSpecialization(instructorRequest.getSpecialization());
        return new SimpleResponse(
                HttpStatus.OK,
                String.format(
                        "Instructor with id:%s successfully updated",instructorId
                )
        );
    }

    @Override
    public InstructorResponse getInstructorById(Long instructorId) {
        InstructorResponse instructor = instructorRepo.getInstructorResponseById(instructorId);
        if(instructor==null){
            System.out.println("Not found");
        }
        return instructor;
    }

    @Override
    public SimpleResponse assignWithCompany(Long companyId, Long instructorId) {
        Company company = companyRepo.getBYId(companyId);
        Instructor instructor = instructorRepo.getInstructorById(instructorId);
      company.getInstructors().add(instructor);
      instructor.getCompanies().add(company);
      instructorRepo.save(instructor);
        return new SimpleResponse(
                HttpStatus.OK,
                String.format("Instructor with id: %s successfully assigned to company with id:%s ",instructorId,company.getId())
        );
    }

    @Override
    public StudentCountResponse getCountStudent(Long id) {
            return StudentCountResponse.builder().studentCount(instructorRepo.getAllCount(id)).build();
        
    }
}
