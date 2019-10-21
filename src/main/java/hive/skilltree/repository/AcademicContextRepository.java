package hive.skilltree.repository;

import hive.skilltree.entity.AcademicContext;
import hive.skilltree.entity.AcademicTerm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicContextRepository extends JpaRepository<AcademicContext, Integer> {
  //TODO: these finds should retrieve list results;
  AcademicContext findBySubjectId(final String cherryId);
  AcademicContext findByPegagogueId(final String pedagogueId);

  AcademicContext findByAcademicTerm(final AcademicTerm academicTerm);

}
