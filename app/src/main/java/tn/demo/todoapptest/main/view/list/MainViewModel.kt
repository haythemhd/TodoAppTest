package tn.demo.todoapptest.main.view.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import tn.demo.todoapptest.main.model.Todo
import tn.demo.todoapptest.main.repo.TodoRepository

class MainViewModel(applicaton: Application) : AndroidViewModel(applicaton) {

    private val repository: TodoRepository = TodoRepository()
    val list: MutableLiveData<List<Todo>> = MutableLiveData<List<Todo>>()
    var job: Job? = null

    suspend fun getListTodo() {
        job = CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getTodoList()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    list.postValue(response.body())
                } else {
                    //ERROR
                }
            }
        }


    }


}