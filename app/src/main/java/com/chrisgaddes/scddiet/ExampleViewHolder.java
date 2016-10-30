package com.chrisgaddes.scddiet;


import com.chrisgaddes.scddiet.databinding.ItemExampleBinding;
import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter;

public class ExampleViewHolder extends SortedListAdapter.ViewHolder<ExampleModel> {

    private final ItemExampleBinding mBinding;

    public ExampleViewHolder(ItemExampleBinding binding, ExampleAdapter.Listener listener) {
        super(binding.getRoot());
        binding.setListener(listener);

        mBinding = binding;
    }

    @Override
    protected void performBind(ExampleModel item) {
        mBinding.setModel(item);
    }
}