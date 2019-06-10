package hive.skilltree.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "tb_term_students")
public class TermStudents {

  @Id
  @JsonProperty
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @JsonProperty
  @Column(name = "student_id", unique = true)
  private String studentId;

  @JsonProperty
  @ManyToOne(cascade = CascadeType.ALL, optional = false)
  @JoinColumn(name = "academic_term_id", unique = true)
  private AcademicTerm academicTerm;

}
