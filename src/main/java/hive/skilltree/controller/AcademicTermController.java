package hive.skilltree.controller;

import hive.skilltree.entity.AcademicTerm;
import hive.skilltree.exception.AcademicTermAlreadyExistException;
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

  @GetMapping("/all")
  public List<AcademicTerm> getAllTerms(){
    return termRepository.findAll();
  }

  @GetMapping
  public AcademicTerm getATerm(@RequestParam(name = "name") final String termName){
    return termRepository.findByTermName(termName);
  }

  @PostMapping
  public AcademicTerm post(@RequestParam(name = "name") final String termName){
    var academicTerm = termRepository.findByTermName(termName);
    if(academicTerm == null){
      academicTerm = new AcademicTerm(termName);
    }else{
      throw new AcademicTermAlreadyExistException();
    }
    return termRepository.save(academicTerm);
  }
/*
  @PostMapping
  public void createANewTermByName(@RequestHeader final String termName){
    var academicTerm=new AcademicTerm(termName);
    termRepository.save(academicTerm);
  }*/
}
