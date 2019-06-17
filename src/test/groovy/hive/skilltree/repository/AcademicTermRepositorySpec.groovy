package hive.skilltree.repository


import hive.skilltree.entity.AcademicTerm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.dao.DataIntegrityViolationException
import spock.lang.Shared
import spock.lang.Specification

import javax.transaction.Transactional

@DataJpaTest
@Transactional
class AcademicTermRepositorySpec extends Specification {

    @Shared
    def existentAuthIdList = []
    @Shared
    private AcademicTermRepository academicTermRepository

    @Autowired(required = true)
    def initRepo(AcademicTermRepository academicTermRepository){
        this.academicTermRepository=academicTermRepository
    }

    def setupSpec(){
        initRepo(academicTermRepository)
    }

    def setup() {
    }

    def cleanup() {
    }

    def '''
        Given a valid academic Term,
        when save,
        then the entity is persisted with the correct id
        and can be selected by the term name.
        '''() {
        given:
        def academicTerm=new AcademicTerm("2019")

        when:
        academicTermRepository.save(academicTerm)

        then:
        academicTerm==academicTermRepository.findById(academicTerm.getId()).get()
        and:
        academicTerm==academicTermRepository.findByTermName("2019")
    }

    def '''
        Given two academic terms with the same term name,
        when save,
        then exception is thrown by violating unique key.
        '''() {
        given:
        def academicTerm=new AcademicTerm("2019")
        def academicTerm2=new AcademicTerm("2019")

        when:
        academicTermRepository.save(academicTerm)
        academicTermRepository.save(academicTerm2)

        then:
        thrown DataIntegrityViolationException
    }

    def '''
        Given two entities with the different term names,
        when save the two entities with same id
        and query an academic term by the old entity's id,
        then the persisted entity is updated.
        '''() {
        given:
        def academicTermOld=new AcademicTerm("2017")
        def academicTermNew=new AcademicTerm("2019A")

        when:
        academicTermRepository.save academicTermOld
        academicTermNew.id = academicTermOld.id
        academicTermRepository.save academicTermNew

        then:
        def persistedTerm=academicTermRepository.findById(academicTermOld.id).get()
        academicTermNew.termName==persistedTerm.termName
        and:
        academicTermNew.getId()==persistedTerm.getId()
    }

    def '''
        Given a valid academic term,
        when save twice
        and retrieved the persisted entity,
        then the creation date and modification date is filled.
        '''() {
        given:
        def academicTerm=new AcademicTerm("2020")

        when:
        academicTermRepository.save academicTerm
        academicTermRepository.save academicTerm
        and:
        def persistedTerm=academicTermRepository.findById(academicTerm.id).get()

        then:
        persistedTerm.creationDate != null
        and:
        persistedTerm.modifyDate != null
    }

}
