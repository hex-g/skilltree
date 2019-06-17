package hive.skilltree.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "tb_activity_check")
public class ActivityCheck {

  @Id
  @JsonIgnore
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @JsonProperty
  @Column(name = "student_id")
  private String studentId;

  @JsonProperty
  @Column(name = "checked_date")
  private String checkedDate;

  @JsonProperty
  @Column(name = "checked")
  private Boolean checked;

  @JsonProperty
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "activity_id", unique = true)
  private Activity activity;
}
