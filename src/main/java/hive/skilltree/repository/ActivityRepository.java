package hive.skilltree.repository;

import hive.skilltree.entity.AcademicContext;
import hive.skilltree.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {

  Activity findByName(final String name);
  Activity findByPostDate(final String postdate);
  Activity findByType(final String type);
  Activity findByFileName(final String fileName);

  Activity findByAcademicContext(final AcademicContext academicContext);

}
