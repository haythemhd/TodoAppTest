package tn.demo.todoapptest.main.view.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import tn.demo.todoapptest.main.model.Todo
import tn.demo.todoapptest.main.repo.TodoRepository

class AddViewModel(applicaton: Application) : AndroidViewModel(applicaton) {

    private val repository: TodoRepository = TodoRepository()
    val result: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    var job: Job? = null

    suspend fun addTodo(todo: Todo) {
        job = CoroutineScope(Dispatchers.IO).launch {
            val response = repository.addTodo(todo)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    result.postValue(true)
                } else {
                    //ERROR
                    result.postValue(false)
                }
            }
        }
    }

}