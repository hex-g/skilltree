package hive.skilltree.controller;

import hive.pandora.constant.HiveInternalHeaders;
import hive.skilltree.entity.TermStudent;
import hive.skilltree.exception.AcademicTermDoesNotExistException;
import hive.skilltree.repository.AcademicTermRepository;
import hive.skilltree.repository.TermStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/term/students")
public class TermStudentController {

  private final TermStudentRepository termStudentRepository;
  private final AcademicTermRepository academicTermRepository;

  @Autowired
  public TermStudentController(
      final TermStudentRepository termStudentRepository,
      final AcademicTermRepository academicTermRepository) {
    this.academicTermRepository = academicTermRepository;
    this.termStudentRepository = termStudentRepository;
  }

  @GetMapping("/all")
  public List<TermStudent> getAllStudentsEnrolledInAcademicTerms(){
    return termStudentRepository.findAll();
  }

  @GetMapping("myself")
  public List<TermStudent> getTheUserAcademicTerms(
      @RequestHeader(name = HiveInternalHeaders.AUTHENTICATED_USER_ID) final String authUserId){
    return termStudentRepository.findByStudentId(authUserId);
  }

  // @GetMapping
  // public  List<TermStudent> getSpecificTermStudents(
  //     @RequestParam(name = "term") final String termName){
  //   var academicTerm=new AcademicTerm(termName);
  //   return termStudentRepository.findByAcademicTermName(termName);
  // }

  @PostMapping
  public TermStudent enrollStudentToTerm(@RequestParam(name = "studentId") final String studentId,
                                  @RequestParam(name = "termName") final String termName){
    TermStudent savedStudentInTerm;
    var academicTerm = academicTermRepository.findByTermName(termName);
    if(academicTerm != null){
      var termStudent=new TermStudent(studentId,academicTerm);
      savedStudentInTerm = termStudentRepository.saveAndFlush(termStudent);
    }else{
      throw new AcademicTermDoesNotExistException();
    }
    return savedStudentInTerm;
  }

}
