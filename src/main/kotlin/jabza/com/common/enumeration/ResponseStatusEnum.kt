package jabza.com.common.enumeration

import org.springframework.http.HttpStatus

enum class ResponseStatusEnum(val httpStatus: HttpStatus, val code: String, val message: String, val description: String) {
    JABZA5000(HttpStatus.INTERNAL_SERVER_ERROR, "JZ5000", "Internal Server Error", "Internal server error"),
    JABZA4000(HttpStatus.BAD_REQUEST, "JZ4000", "Bad Request", ""),
    JABZA4040(HttpStatus.NOT_FOUND, "JZ4040", "Not Found", "Data not found"),
}