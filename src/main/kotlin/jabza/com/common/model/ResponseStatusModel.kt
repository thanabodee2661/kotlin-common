package jabza.com.common.model;

import jabza.com.common.enumeration.ResponseStatusEnum

data class ResponseStatusModel (val code: String, val message: String, val description: String) {
    constructor(statusEnum: ResponseStatusEnum): this(statusEnum.code, statusEnum.message, statusEnum.description)
}
