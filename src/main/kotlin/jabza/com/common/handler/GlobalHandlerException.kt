package jabza.com.common.handler

import jabza.com.common.enumeration.ResponseStatusEnum
import jabza.com.common.exception.InvalidException
import jabza.com.common.exception.NotFoundException
import jabza.com.common.model.ResponseModel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest


@ControllerAdvice
class GlobalHandlerException {
    @ExceptionHandler(value = [Exception::class])
    fun <T> handleExceptionInternal(
        ex: RuntimeException?, request: WebRequest?
    ): ResponseEntity<ResponseModel<T>> {
        return ResponseEntity
            .status(ResponseStatusEnum.JABZA5000.httpStatus)
            .body(ResponseModel(ResponseStatusEnum.JABZA5000))
    }

    @ExceptionHandler(value = [NotFoundException::class])
    fun <T> handleExceptionNotFound(
        ex: RuntimeException?, request: WebRequest?
    ): ResponseEntity<ResponseModel<T>> {
        return ResponseEntity
            .status(ResponseStatusEnum.JABZA4040.httpStatus)
            .body(ResponseModel(ResponseStatusEnum.JABZA4040))
    }

    @ExceptionHandler(value = [InvalidException::class])
    fun <T> handleExceptionInvalid(
        ex: RuntimeException?, request: WebRequest?
    ): ResponseEntity<ResponseModel<T>> {
        return ResponseEntity
            .status(ResponseStatusEnum.JABZA4000.httpStatus)
            .body(ResponseModel(ResponseStatusEnum.JABZA4000))
    }
}