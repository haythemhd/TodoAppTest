package tn.demo.todoapptest.main.repo

import tn.demo.todoapptest.main.model.Todo
import tn.demo.todoapptest.main.service.APIClient
import tn.demo.todoapptest.main.service.TodoService

class TodoRepository {
    var client : TodoService = APIClient.getClient()

    suspend fun getTodoList() = client.getTodoList()

    suspend fun addTodo(todo : Todo) = client.addTodo(todo)
}