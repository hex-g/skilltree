package hive.skilltree.controller;

import hive.skilltree.entity.Activity;
import hive.skilltree.repository.AcademicContextRepository;
import hive.skilltree.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {
  private final AcademicContextRepository academicContextRepository;
  private final ActivityRepository activityRepository;

  @Autowired
  public ActivityController(
      final AcademicContextRepository academicContextRepository,
      final ActivityRepository activityRepository){
    this.academicContextRepository = academicContextRepository;
    this.activityRepository = activityRepository;
  }

  @GetMapping("/all")
  public List<Activity> get(){
    return activityRepository.findAll();
  }

  @PostMapping
  public Activity post(
      @RequestParam(name = "subject") String subject,
      @RequestBody Activity activity){
    //TODO: think better about how to assign the context
    var context = academicContextRepository.findBySubjectId(subject);
    if(context == null){
      //TODO: implements exception;
    }else{
      activity.setAcademicContext(context);
    }
    return activityRepository.save(activity);
  }

}
