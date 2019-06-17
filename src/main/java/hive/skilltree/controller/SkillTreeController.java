package hive.skilltree.controller;

import hive.pandora.constant.HiveInternalHeaders;
import hive.skilltree.repository.SkillTreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class SkillTreeController {
  private final SkillTreeRepository skillTreeRepository;

  @Autowired
  public SkillTreeController(final SkillTreeRepository skillTreeRepository) {
    this.skillTreeRepository = skillTreeRepository;
  }

  @GetMapping
  public void getAcademicContext(
      @RequestHeader(name = HiveInternalHeaders.AUTHENTICATED_USER_ID) final String studentId){

  }
  @GetMapping
  public void get(){

  }
  @GetMapping
  public void getAnalytics(){

  }
  @PostMapping
  public void post(){

  }
  @PostMapping
  public void enrollStudentToATerm(
      @RequestHeader(name = HiveInternalHeaders.AUTHENTICATED_USER_ID) final String studentId,
      final String termName){

  }
  @DeleteMapping
  public void unrollStudentFromATerm(
      @RequestHeader(name = HiveInternalHeaders.AUTHENTICATED_USER_ID) final String studentId,
      final String termName){

  }
  @PostMapping
  public void checkActivity(
      @RequestHeader(name = HiveInternalHeaders.AUTHENTICATED_USER_ID) final String studentId,
      final Integer ActivityId){

  }
  //POST/DELETE (un)associate pedagogue & subject with context
  //POST/DELETE new context
  //POST/DELETE new activities
  //POST/DELETE new Terms
}
