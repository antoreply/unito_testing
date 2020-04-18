package it.reply.iriscube.unito.datasource.api

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by Reply.
 */
data class ListUsersApiResponse(
    @JsonProperty("page")
    val page: Long,
    @JsonProperty("per_page")
    val usersPerPage: Long,
    @JsonProperty("total")
    val total: Long,
    @JsonProperty("total_pages")
    val totalPages: Long,
    @JsonProperty("data")
    val data: List<Person>,
    @JsonProperty("ad")
    val ad: Ad
)

data class Person(
    @JsonProperty("id")
    val id: Long,
    @JsonProperty("email")
    val email: String,
    @JsonProperty("first_name")
    val name: String,
    @JsonProperty("last_name")
    val lastName: String,
    @JsonProperty("avatar")
    val avatar: String
)

data class Ad(
    @JsonProperty("company")
    val company: String,
    @JsonProperty("url")
    val url: String,
    @JsonProperty("text")
    val text: String
)