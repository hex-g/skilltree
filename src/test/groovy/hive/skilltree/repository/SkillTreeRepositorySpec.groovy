package hive.skilltree.repository


import hive.skilltree.entity.SkillTree
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

import spock.lang.Shared
import spock.lang.Specification

@DataJpaTest
class SkillTreeRepositorySpec extends Specification {

    @Shared
    SkillTree player
    @Shared
    def existentAuthIdList = []
    @Shared
    private SkillTreeRepository skillTreeRepository

    @Autowired(required = true)
    def initRepo(SkillTreeRepository playerRepository){
        this.skillTreeRepository=playerRepository
    }

    def setupSpec(){
        initRepo(skillTreeRepository)
    }

    def setup() {
    }

    def cleanup() {
    }

    def '''
        Given ,
        when ,
        then .
        '''() {

    }

}
