package hive.skilltree.repository;

import hive.skilltree.entity.Activity;
import hive.skilltree.entity.ActivityCheck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityCheckRepository extends JpaRepository<ActivityCheck, Integer> {

  ActivityCheck findByStudentId(final String studentId);
  ActivityCheck findByCheckedDate(final String checkedDate);
  ActivityCheck findByChecked(final Boolean checked);

  ActivityCheck findByActivity(final Activity activity);

}
