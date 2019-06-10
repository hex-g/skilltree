package hive.skilltree.controller;

import hive.skilltree.entity.AcademicContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AcademicContextController {
  private final AcademicContext academicContext;

  @Autowired
  public AcademicContextController(final AcademicContext academicContext) {
    this.academicContext = academicContext;
  }
  @GetMapping
  public void get(){

  }
  @PostMapping
  public void post(){

  }
}
