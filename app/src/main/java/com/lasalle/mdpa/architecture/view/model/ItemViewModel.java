package com.lasalle.mdpa.architecture.view.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.lasalle.mdpa.architecture.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemViewModel extends ViewModel {

    private List<Item> itemList;
    private MutableLiveData<List<Item>> itemListObserver;

    public ItemViewModel() {
        super();
        itemListObserver = new MutableLiveData<>();
        itemList = new ArrayList<>();
        itemListObserver.setValue(itemList);
    }

    public LiveData<List<Item>> getItemList() {
        return itemListObserver;
    }

    public void addItem(String firstText, String secondText) {
        itemList.add(new Item(firstText, secondText));
        itemListObserver.setValue(itemList);
    }
}
