package com.todo;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    public List<TodoItem> getTodoItemList() {
        return todoItemList;
    }

    private List<TodoItem> todoItemList=new ArrayList<>();
    public void addTodoItem(TodoItem todoItem){
        if(todoItem!=null){
            todoItemList.add(todoItem);
        }

    }

    public void updateTodoItem(TodoItem updatedItem) {
        for (int i = 0; i < todoItemList.size(); i++) {
            if (todoItemList.get(i).getId() == updatedItem.getId()) {
                todoItemList.set(i, updatedItem);
                return;
            }
        }
        System.out.println("Item with ID " + updatedItem.getId() + " not found.");
    }

    public void deleteTodoItem(TodoItem deletedItem){
        for (int i = 0; i < todoItemList.size(); i++) {
            if(todoItemList.get(i).getId()==deletedItem.getId()){
                todoItemList.remove(deletedItem);
            }
            System.out.println("Item with ID " + deletedItem.getId() + " not found.");
        }
    }


}
