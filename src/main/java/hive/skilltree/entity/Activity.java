package hive.skilltree.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_activity")
public class Activity {

  @Id
  @JsonIgnore
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @JsonProperty
  @Column(name = "name")
  private String name;
  @JsonProperty
  @Column(name = "post_date")
  private String postDate;
  @JsonProperty
  @Column(name = "type")
  private String type;
  @JsonProperty
  @Column(name = "file_name")
  private String fileName;

  @JsonProperty
  @ManyToOne(cascade = CascadeType.ALL, optional = false)
  @JoinColumn(name = "academic_context_id")
  private AcademicContext academicContext;

  @JsonProperty
  @OneToMany(mappedBy="activity")
  List<ActivityCheck> activityChecks;
}
