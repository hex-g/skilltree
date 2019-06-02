package hive.skilltree.repository;

import hive.skilltree.entity.SkillTree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillTreeRepository extends JpaRepository<SkillTree,Integer> {

   SkillTree findByAuthenticatedUserId(final String authenticatedUserId);

}
