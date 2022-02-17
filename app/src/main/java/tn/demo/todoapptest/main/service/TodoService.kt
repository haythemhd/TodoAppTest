package tn.demo.todoapptest.main.service

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import tn.demo.todoapptest.main.model.Todo

interface TodoService {

    @GET("/api/todos")
    suspend fun getTodoList() : Response<List<Todo>>


    @POST("/api/todos")
    suspend fun addTodo(@Body todo : Todo) : Response<Void>



}