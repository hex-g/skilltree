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
  @ManyToOne(cascade = CascadeType.ALL, optional = false)
  @JoinColumn(name = "academic_term_id")
  private AcademicTerm academicTerm;

  @JsonProperty
  @OneToMany(mappedBy="academicContext")
  List<Activity> activities;
}
