package com.chrisgaddes.scddiet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.chrisgaddes.scddiet.databinding.ItemExampleBinding;

import com.chrisgaddes.scddiet.ExampleViewHolder;
import com.chrisgaddes.scddiet.databinding.ItemExampleBinding;
import com.chrisgaddes.scddiet.ExampleModel;
import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter;

import java.util.Comparator;


public class ExampleAdapter extends SortedListAdapter<ExampleModel> {

    public interface Listener {
        void onExampleModelClicked(ExampleModel model);
    }

    private final Listener mListener;

    public ExampleAdapter(Context context, Comparator<ExampleModel> comparator, Listener listener) {
        super(context, ExampleModel.class, comparator);
        mListener = listener;
    }

    @Override
    protected ViewHolder<? extends ExampleModel> onCreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        final ItemExampleBinding binding = ItemExampleBinding.inflate(inflater, parent, false);
        return new ExampleViewHolder(binding, mListener);
    }

    @Override
    protected boolean areItemsTheSame(ExampleModel item1, ExampleModel item2) {
        return item1.getId() == item2.getId();
    }

    @Override
    protected boolean areItemContentsTheSame(ExampleModel oldItem, ExampleModel newItem) {
        return oldItem.equals(newItem);
    }
}