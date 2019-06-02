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
    private SkillTreeRepository playerRepository

    def createEmptyPlayers(int quantity){
        quantity.times {
            playerRepository.save new SkillTree(it.toString())
            existentAuthIdList+=it.toString()
        }
    }
    @Autowired(required = true)
    def initRepo(SkillTreeRepository playerRepository){
        this.playerRepository=playerRepository
    }

    def setupSpec(){
        initRepo(playerRepository)
    }

    def setup() {
        createEmptyPlayers 1
    }

    def cleanup() {
        playerRepository.deleteAll()
    }

    def '''
        Given ,
        when ,
        then .
        '''() {

        given:
        def playerToPersist = createAnCompletePlayer()
        def authenticatedId = playerToPersist.getAuthenticatedUserId()

        when:
        playerRepository.save playerToPersist
        def persistedPlayer = playerRepository.findByAuthenticatedUserId authenticatedId

        then:
        player == persistedPlayer
    }

}
