package hive.skilltree.controller

import spock.lang.Specification

class TaskStudentCheckSpec extends Specification {
    def '''
        Given AuthenticatedUserId in correct context,
        when perform GET,
        then Map<Context,Percentage> is Returned
        and Status OK.
        '''() {

    }
    def '''
        Given AuthenticatedUserId in without context,
        when perform GET,
        then Not Found is Returned
        and error description as "Student not enrolled in any context".
        '''() {

    }
}
