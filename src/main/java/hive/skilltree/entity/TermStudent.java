package hive.skilltree.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_term_students")
//make the combination studentId+academicTerm unique
public class TermStudent {

  @Id
  @JsonProperty
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @JsonProperty
  @Column(name = "student_id")
  private String studentId;

  @CreationTimestamp
  @JsonProperty
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "create_date")
  private Date enrollDate;

  @UpdateTimestamp
  @JsonProperty
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "modify_date")
  private Date modifyDate;

  @JsonProperty
  @ManyToOne(cascade = CascadeType.ALL, optional = false)
  @JoinColumn(name = "academic_term_id")
  private AcademicTerm academicTerm;

  public Integer getId() {
    return id;
  }

  public TermStudent(){}

  public TermStudent(final String studentId, final AcademicTerm term) {
    this.studentId = studentId;
    //association Code
    this.academicTerm = term;
  }

}
