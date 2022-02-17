package tn.demo.todoapptest.main.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Todo (
    @JsonProperty("id") val id: Int? = null,
    @JsonProperty("description") val description: String? = null,
    @JsonProperty("memo") val memo: String? = null ,
    @JsonProperty("priority") val priority: Int? = null,
    @JsonProperty("updated_at") val updated_at: Long? = null
)