package hive.skilltree.repository


import hive.skilltree.entity.AcademicTerm
import hive.skilltree.entity.SkillTree
import hive.skilltree.entity.TermStudent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import spock.lang.Shared
import spock.lang.Specification

import javax.transaction.Transactional

@DataJpaTest
@Transactional
class TermStudentRepositorySpec extends Specification {

    @Shared
    SkillTree player
    @Shared
    def existentAuthIdList = []
    @Shared
    private TermStudentRepository termStudentRepository

    @Autowired(required = true)
    def initRepo(TermStudentRepository termStudentRepository){
        this.termStudentRepository=termStudentRepository
    }

    def setupSpec(){
        initRepo(termStudentRepository)
    }

    def setup() {
    }

    def cleanup() {
    }

    def '''
        Given ,
        when ,
        then .2
        '''() {
        given:
        def termStudent = Mock(TermStudent)//Study more about how to mock
        when:
        termStudentRepository.save(termStudent)
        then:
        termStudent==termStudentRepository.findById(termStudent.getId()).get()
    }
    def '''
        Given a valid termStudent,
        when save,
        then the entity is persisted.
        '''() {
        given:
        def termStudent=new TermStudent("Germano","2019")
        when:
        termStudentRepository.save termStudent
        def persisted=termStudentRepository.findById(termStudent.id).get()
        then:
        termStudent==persisted
    }
    def '''
        Given two instances of term student with the same academic term,
        when save the entities and query by term name,
        then is returned both.
        '''() {
        given:
        def academicTerm=new AcademicTerm("2019")
        def termStudent=new TermStudent("Germano",academicTerm)
        def termStudent2=new TermStudent("Aurelio",academicTerm)
        when:
        termStudentRepository.save termStudent
        termStudentRepository.save termStudent2
        def persisted=termStudentRepository.findByAcademicTerm(academicTerm)
        println persisted
        then:
        termStudent.id==persisted.get(0).id
        and:
        termStudent2.id==persisted.get(1).id
    }
    def '''
        Given two instances of term student with the same academic term,
        when save the entities and query by term name,
        then is returned both.5
        '''() {
        given:
        def academicTerm=new AcademicTerm("2019")
        def termStudent=new TermStudent("Germano","2019")
        def termStudent2=new TermStudent("Aurelio","2018")
        when:
        termStudentRepository.save termStudent
        termStudentRepository.save termStudent2
        def persisted=termStudentRepository.findByAcademicTerm(academicTerm)
        println persisted
        then:
        termStudent.id==persisted.get(0)?.id
        and:
        termStudent2.id==persisted.get(1)?.id
    }

    def a(){
        expect:
        1==1
    }
}
