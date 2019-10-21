package hive.skilltree.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Cannot enroll a student or assign a context on a term that does not exist")
public class AcademicTermDoesNotExistException extends RuntimeException{
}
