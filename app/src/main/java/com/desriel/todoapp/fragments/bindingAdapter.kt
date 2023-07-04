package com.desriel.todoapp.fragments

import android.view.View
import android.widget.RelativeLayout
import android.widget.Spinner
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import com.desriel.todoapp.R
import com.desriel.todoapp.data.models.Priority
import com.desriel.todoapp.data.models.ToDoData
import com.desriel.todoapp.fragments.list.ListFragmentDirections
import com.google.android.material.floatingactionbutton.FloatingActionButton

class bindingAdapter {

    companion object{

        @BindingAdapter("android:navigateToAddFragment")
        @JvmStatic
        fun navigateToAddFragment(view: FloatingActionButton, navigate: Boolean){
            view.setOnClickListener{
                if (navigate){
                    view.findNavController().navigate(R.id.action_listFragment_to_addFragment)
                }
            }
        }
        @BindingAdapter("android:emptyDatabase")
        @JvmStatic
        fun emptyDatabase(view: View, emptyDatabase: MutableLiveData<Boolean>){
            when(emptyDatabase.value){
                true -> view.visibility = View.VISIBLE
                else -> view.visibility = View.INVISIBLE
            }
        }
        @BindingAdapter("android:parsePriorityToInt")
        @JvmStatic
        fun parsePriorityToInt(view: Spinner, priority: Priority){
            when(priority){
                Priority.High ->  {view.setSelection(0)}
                Priority.Medium ->  {view.setSelection(1)}
                Priority.Low ->  {view.setSelection(2)}
            }
        }
        @BindingAdapter("android:parsePriorityCOlor")
        @JvmStatic
        fun parsePriorityColor(view: View, priority: Priority){
            when(priority){
                Priority.High -> {view.setBackgroundColor(view.context.getColor(R.color.red_glamour))}
                Priority.Medium -> {view.setBackgroundColor(view.context.getColor(R.color.yellow_banana))}
                Priority.Low -> {view.setBackgroundColor(view.context.getColor(R.color.green_flora))}
            }
        }
        @BindingAdapter("android:sendDataToUpdateFragment")
        @JvmStatic
        fun sendDataToUpdateFragment(view: RelativeLayout, currentItem: ToDoData){
            view.setOnClickListener {
                val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
                view.findNavController().navigate(action)
            }

        }
    }
}