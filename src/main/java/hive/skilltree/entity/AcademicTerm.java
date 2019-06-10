package hive.skilltree.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_academic_term")
public class AcademicTerm {

  @Id
  @JsonProperty
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @JsonProperty
  @OneToMany(mappedBy="academicTerm")
  private List<AcademicContext> academicContexts;
  @JsonProperty
  @OneToMany(mappedBy="academicTerm")
  private List<TermStudents> termStudents;
}
