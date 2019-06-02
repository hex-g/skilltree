package hive.skilltree.controller;

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
  public void get(){

  }
  @PostMapping
  public void post(){

  }
}
