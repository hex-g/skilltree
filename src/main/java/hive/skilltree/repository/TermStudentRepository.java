package hive.skilltree.repository;

import hive.skilltree.entity.AcademicTerm;
import hive.skilltree.entity.TermStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TermStudentRepository extends JpaRepository<TermStudent, Integer> {

  TermStudent findByStudentId(final String studentId);

  List<TermStudent> findByAcademicTerm(final AcademicTerm academicTerm);

  // @Query("Select * from TermStudent where TermStudent.academicTerm.termName=?1")
  // TermStudent findByAcademicTermName(final String termName);

}
