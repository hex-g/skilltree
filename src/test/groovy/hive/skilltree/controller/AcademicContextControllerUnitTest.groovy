package hive.skilltree.controller

import spock.lang.Specification

class AcademicContextControllerUnitTest extends Specification {
    def '''
        Given PedagogueId in correct context,
        when perform GET,
        then Status OK.
        '''() {

    }
    def '''
        Given PedagogueId in without context,
        when perform GET,
        then Not Found is Returned
        and error description as "Pedagogue not enrolled in any context".
        '''() {

    }
}
