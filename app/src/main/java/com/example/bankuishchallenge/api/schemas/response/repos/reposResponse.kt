package com.example.bankuishchallenge.api.schemas.response.repos

import com.example.bankuishchallenge.api.schemas.response.Response
import com.example.domain.entities.Author
import com.example.domain.entities.Repo

data class ReposResponse(
    var name: String,
    var owner: AuthorResponse,
    var full_name: String,
    var url: String
) : Response<Repo> {

    override fun toEntity() = Repo(
        name = name,
        author = owner.toEntity(),
        fullName = full_name,
        url = url
    )
}


data class AuthorResponse(
    var login: String,
    var type : String
) : Response<Author> {

    override fun toEntity() = Author(
        login = login,
        type = type
    )
}