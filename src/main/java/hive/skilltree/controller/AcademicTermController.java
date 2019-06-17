package hive.skilltree.controller;

import hive.skilltree.entity.AcademicTerm;
import hive.skilltree.repository.AcademicTermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/term")
public class AcademicTermController {
  private final AcademicTermRepository termRepository;

  @Autowired
  public AcademicTermController(final AcademicTermRepository termRepository) {
    this.termRepository = termRepository;
  }
  @GetMapping
  public List<AcademicTerm> getAllTerms(){
    return termRepository.findAll();
  }
  @GetMapping
  public AcademicTerm getATerm(@RequestParam(name = "name") final String termName){
    return termRepository.findByTermName(termName);
  }
  @PostMapping
  public void post(@RequestBody final AcademicTerm academicTerm){
    termRepository.save(academicTerm);
  }

  @PostMapping
  public void createANewTermByName(@RequestHeader final String termName){
    var academicTerm=new AcademicTerm(termName);
    termRepository.save(academicTerm);
  }
}
