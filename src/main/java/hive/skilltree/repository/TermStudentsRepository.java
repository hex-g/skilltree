package hive.skilltree.repository;

import hive.skilltree.entity.TermStudents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TermStudentsRepository extends JpaRepository<TermStudents, Integer> {

  TermStudents findByStudentId(final String studentId);

}
