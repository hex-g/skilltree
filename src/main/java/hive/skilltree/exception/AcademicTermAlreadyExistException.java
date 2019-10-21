package hive.skilltree.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "An academic term already exists with this name")
public class AcademicTermAlreadyExistException extends RuntimeException{
}
