package hive.skilltree.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_academic_term",
uniqueConstraints = {@UniqueConstraint(name = "UNIQUE_TERM",columnNames = "term_name")})
public class AcademicTerm {

  @Id
  @JsonProperty
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @JsonProperty
  @Column(name = "term_name",nullable = false)
  private String termName;

  @CreationTimestamp
  @JsonProperty
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "creation_date")
  private Date creationDate;

  @UpdateTimestamp
  @JsonProperty
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "modify_date")
  private Date modifyDate;

  @JsonProperty
  @OneToMany(mappedBy="academicTerm")
  private List<AcademicContext> academicContexts;
  @JsonProperty
  @OneToMany(mappedBy="academicTerm")
  private List<TermStudent> termStudents;

  public String getTermName() {
    return termName;
  }

  public void setTermName(final String termName) {
    this.termName = termName;
  }

  public Integer getId() {
    return id;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public Date getModifyDate() {
    return modifyDate;
  }

  public void setAcademicContexts(final List<AcademicContext> academicContexts) {
    this.academicContexts = academicContexts;
  }

  public void setTermStudents(final List<TermStudent> termStudents) {
    this.termStudents = termStudents;
  }
  public AcademicTerm(final String termName) {
    this.termName = termName;
  }
}
