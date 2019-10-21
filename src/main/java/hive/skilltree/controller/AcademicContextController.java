package hive.skilltree.controller;

import hive.skilltree.entity.AcademicContext;
import hive.skilltree.exception.AcademicTermDoesNotExistException;
import hive.skilltree.repository.AcademicContextRepository;
import hive.skilltree.repository.AcademicTermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class AcademicContextController {
  private final AcademicContextRepository academicContextRepository;
  private final AcademicTermRepository academicTermRepository;

  @Autowired
  public AcademicContextController(
      final AcademicContextRepository academicContextRepository,
      final AcademicTermRepository academicTermRepository) {
    this.academicTermRepository = academicTermRepository;
    this.academicContextRepository = academicContextRepository;
  }
  @GetMapping("all")
  public List<AcademicContext> get(){
    return academicContextRepository.findAll();
  }

  @PostMapping
  public AcademicContext post(
      @RequestParam(name = "pedagogue") String pedagogueId,
      @RequestParam(name = "subjectId") String subjectId,
      @RequestParam(name = "daysOfWeek") String daysOfWeek,
      @RequestParam(name = "termName") String termName){
    var academicTerm = academicTermRepository.findByTermName(termName);
    if(academicTerm == null){
      throw new AcademicTermDoesNotExistException();
    }
    var academicContext= new AcademicContext(pedagogueId,subjectId,daysOfWeek,academicTerm);
    return academicContextRepository.save(academicContext);
  }
}
