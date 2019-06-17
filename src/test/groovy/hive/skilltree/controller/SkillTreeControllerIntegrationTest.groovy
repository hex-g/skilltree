package hive.skilltree.controller

import groovyx.net.http.ContentType
import groovyx.net.http.RESTClient
import spock.lang.Shared
import spock.lang.Specification

import static hive.pandora.constant.HiveInternalHeaders.AUTHENTICATED_USER_ID

/*Integration test. only work with the system up*/
class SkillTreeControllerIntegrationTest extends Specification {

    @Shared
    def integrationTestHeaderValue="INTEGRATION"
    @Shared
    RESTClient client

    def setup(){
        client = new RESTClient("${urlBase}", ContentType.JSON)
        client.handler.failure = { resp, data -> resp.setData(data); return resp }
    }

    def urlBase = 'http://localhost:9600/'

    def validProfileDataJson = '''
        {
          "Lesson":"string",
          "DaysOfWeek":"string",
          "LastExercise":"string",
          "NextExamDate":"Date",
          "ProgressPercentage":"0-100",
          "Teacher":"String<userId>"
        }
                        '''

    def cleanupSpec(){
        //should have some delete method in the original application
    }

    def '''
        Given StudentId that is enrolled in one course,
        when perform GET to a academicContext,
        then status 200 is received
        and the response json contains an array of activities.
        '''() {

        given:
        def response = client.get(
                headers: ["$AUTHENTICATED_USER_ID": "${integrationTestHeaderValue}"])

        expect:
        response.status == 200
    }


}
