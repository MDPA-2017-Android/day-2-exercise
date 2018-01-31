package com.lasalle.mdpa.architecture.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lasalle.mdpa.architecture.R;
import com.lasalle.mdpa.architecture.view.adapter.ItemRecyclerAdapter;
import com.lasalle.mdpa.architecture.view.model.ItemViewModel;

public class MainActivity extends AppCompatActivity {

    private ItemViewModel itemViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Recycler view setup
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        ItemRecyclerAdapter itemAdapter = new ItemRecyclerAdapter(this);
        recyclerView.setAdapter(itemAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Retrieve viewModel
        itemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);
        itemViewModel.getItemList().observe(this, itemList -> {
           itemAdapter.setItemList(itemList);
           itemAdapter.notifyDataSetChanged();
        });

        // Set event to receive information
        EditText firstTextValue = (EditText) findViewById(R.id.first_text);
        EditText secondTextValue = (EditText) findViewById(R.id.second_text);

        Button saveButton = (Button) findViewById(R.id.send_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemViewModel.addItem(firstTextValue.getText().toString(), secondTextValue.getText().toString());
            }
        });
    }

}
