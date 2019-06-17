package hive.skilltree.controller;

import hive.pandora.constant.HiveInternalHeaders;
import hive.skilltree.entity.TermStudent;
import hive.skilltree.repository.TermStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/term/students")
public class TermStudentController {

  private final TermStudentRepository termStudentRepository;

  @Autowired
  public TermStudentController(final TermStudentRepository termStudentRepository) {
    this.termStudentRepository = termStudentRepository;
  }
  @GetMapping//verify if it is valid
  public List<TermStudent> getAllStudentsEnrolledInAcademicTerms(){
    return termStudentRepository.findAll();
  }

  @GetMapping
  public TermStudent getTheUserAcademicTerms(
      @RequestHeader(name = HiveInternalHeaders.AUTHENTICATED_USER_ID) final String authUserId){
    return termStudentRepository.findByStudentId(authUserId);
  }

  @GetMapping//see how to query by term name
  public TermStudent getSpecificTermStudents(
      @RequestParam(name = "term") final String termName){
    // return termStudentRepository.findByAcademicTermName(termName);
    return null;
  }

  @PostMapping//it would be interesting if i have a subclass
  public void enrollStudentToTerm(@RequestHeader(name = "studentId") final String studentId,
                                  @RequestHeader(name = "termName") final String termName){
    var termStudent=new TermStudent(studentId,termName);
    termStudentRepository.save(termStudent);
  }
}
