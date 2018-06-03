package com.codepolitan.sqllitecontactexample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by rudihartono on 6/2/18.
 */

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.TodoViewHolder>{

    Context context;
    ArrayList<Item> todoList;

    //constructor
    public TodoListAdapter(Context context, ArrayList<Item> todoList){

        this.context = context;
        this.todoList = todoList;
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item,
                parent, false);

        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {

        final Item todo = todoList.get(position);

        if(todo != null) {

            final MyDatabase database = new MyDatabase(context);

            holder.textViewName.setText(todo.getName());

            holder.imageViewEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, AddUpdateTodoActivity.class);

                    intent.putExtra("ID", todo.getId());
                    intent.putExtra("NAMA", todo.getName());
                    intent.putExtra("PRIO", todo.getPriority());

                    context.startActivity(intent);
                }
            });

            //on delete click
            holder.imageViewDone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //delete item ini di database
                    database.deleteItem(todo.getId());

                    //cara pertama
                    //clear todolisnya
                    //readall

                    //cara keduanya
                    todoList.remove(todo);

                    notifyDataSetChanged();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    //inner class
    public class TodoViewHolder extends RecyclerView.ViewHolder{

        TextView textViewName;
        ImageView imageViewEdit;
        ImageView imageViewDone;

        public TodoViewHolder(View itemView) {
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.todo_name);
            imageViewEdit = (ImageView) itemView.findViewById(R.id.edit_todo);
            imageViewDone = (ImageView) itemView.findViewById(R.id.done_todo);
        }
    }

}

