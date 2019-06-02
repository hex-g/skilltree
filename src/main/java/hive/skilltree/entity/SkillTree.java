package hive.skilltree.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_user_profile")
public class SkillTree {
  @Id
  @JsonIgnore
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  //is some DBMS like Oracle you should change the strategy
  private Integer lessonId;
  @JsonIgnore
  private String authenticatedUserId;

  @JsonProperty
  @Column(name = "lesson", unique = true)
  private String lesson;
  @JsonProperty
  @Column(name = "daysOfWeek")
  private String daysOfWeek;
  @JsonProperty
  @Column(name = "lastExercise")
  private String lastExercise;
  @JsonProperty
  @Column(name = "nextExamDate")
  private String nextExamDate;
  @JsonProperty
  @Column(name = "progressPercentage")
  private String progressPercentage;
  @JsonProperty
  @Column(name = "pedagogue")
  private String pedagogue;

  public Integer getLessonId() {
    return lessonId;
  }

  public void setLessonId(final Integer lessonId) {
    this.lessonId = lessonId;
  }

  public String getAuthenticatedUserId() {
    return authenticatedUserId;
  }

  public void setAuthenticatedUserId(@NotNull final String authenticatedUserId) {
    this.authenticatedUserId = authenticatedUserId;
  }

  private SkillTree() {
  }
}
