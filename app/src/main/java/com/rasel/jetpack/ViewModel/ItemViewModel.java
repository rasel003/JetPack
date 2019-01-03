package com.rasel.jetpack.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PageKeyedDataSource;
import android.arch.paging.PagedList;

import com.rasel.jetpack.ItemDataSource;
import com.rasel.jetpack.ItemDataSourceFactory;
import com.rasel.jetpack.Model.Item;

public class ItemViewModel extends ViewModel {

    public LiveData<PagedList<Item>> itemPagedList;
    private LiveData<PageKeyedDataSource<Integer, Item>> liveDataSource;

    public ItemViewModel() {

        ItemDataSourceFactory itemDataSourceFactory = new ItemDataSourceFactory();
        liveDataSource = itemDataSourceFactory.getItemLiveDataSource();

        PagedList.Config config = (new PagedList.Config.Builder()).setEnablePlaceholders(false).setPageSize(ItemDataSource.PAGE_SIZE).build();

        itemPagedList = (new LivePagedListBuilder(itemDataSourceFactory, config)).build();

    }
}
