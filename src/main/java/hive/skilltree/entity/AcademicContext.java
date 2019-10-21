package hive.skilltree.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_academic_context")
public class AcademicContext {

  @Id
  @JsonIgnore
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @JsonProperty
  @Column(name = "pedagogue_id")
  private String pegagogueId;
  @JsonProperty
  @Column(name = "subject_id")
  private String subjectId;
  @JsonProperty
  @Column(name = "days_of_week")
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

  @JsonProperty
  @ManyToOne(cascade = CascadeType.ALL, optional = false)
  @JoinColumn(name = "academic_term_id")
  private AcademicTerm academicTerm;

  @JsonProperty
  @OneToMany(mappedBy="academicContext")
  List<Activity> activities;

  public void setActivities(final List<Activity> activities) {
    this.activities = activities;
  }
  public AcademicContext(){}

  public AcademicContext(
      final String pegagogueId,
      final String subjectId,
      final String daysOfWeek,
      final AcademicTerm academicTerm
  ) {
    this.pegagogueId = pegagogueId;
    this.subjectId = subjectId;
    this.daysOfWeek = daysOfWeek;
    this.academicTerm = academicTerm;
  }

}
