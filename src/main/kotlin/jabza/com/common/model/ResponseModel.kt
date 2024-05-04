package jabza.com.common.model;

import jabza.com.common.enumeration.ResponseStatusEnum;

data class ResponseModel<T> (val status: ResponseStatusModel, val data: T?) {
    constructor(statusEnum: ResponseStatusEnum): this(ResponseStatusModel(statusEnum), null)
}
