package hive.skilltree.repository

import hive.skilltree.entity.AcademicContext
import hive.skilltree.entity.AcademicTerm
import hive.skilltree.entity.SkillTree
import hive.skilltree.entity.TermStudent
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
    private SkillTreeRepository skillTureeRepository

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
    def '''
        Given ,
        when ,
        then .2
        '''() {
        given:
        def academicContexts=new ArrayList<AcademicContext>()
        def academicTerm=new AcademicTerm("2019")
        academicContexts.add(
                new AcademicContext(
                        "Celia",
                        "BD",
                        "mondays",
                        academicTerm))
        def termStudents = new ArrayList<TermStudent>()
        termStudents.add(
                new TermStudent("GERMANO",academicTerm))
        academicTerm.academicContexts = academicContexts
        academicTerm.termStudents = termStudents
        when:
        academicTermRepository.save(academicTerm)
        println "AAAAAAAAAAAAAAAAAAAAAAAAA"
        println "A:"+academicTerm
        println "B:"+academicTermRepository.findAll()
        println "C:"+academicTermRepository.findById(academicTerm.getId())
        println "AAAAAAAAAAAAAAAAAAAAAAAAA"
        then:
        academicTerm==academicTermRepository.findById(academicTerm.getId()).get()
        and:
        academicTerm==academicTermRepository.findByTermName("2019").get(0)
    }

}
