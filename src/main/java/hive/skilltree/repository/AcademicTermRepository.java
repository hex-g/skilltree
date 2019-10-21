package hive.skilltree.repository;

import hive.skilltree.entity.AcademicTerm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicTermRepository extends JpaRepository<AcademicTerm, Integer> {
  AcademicTerm findByTermName(String termName);
}
