package com.chrisgaddes.scddiet;

import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter;

public class ExampleModel implements SortedListAdapter.ViewModel {

    private final long mId;

    private final String mText;
    private final Boolean mBool;

    public ExampleModel(long id, String text, Boolean bool) {
        mId = id;
        mText = text;
        mBool = bool;
    }

    public long getId() {
        return mId;
    }

    public String getText() {
        return mText;
    }

    public Boolean getBool() {
        return mBool;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExampleModel model = (ExampleModel) o;

        if (mId != model.mId) return false;
        return mText != null ? mText.equals(model.mText) : model.mText == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (mId ^ (mId >>> 32));
        result = 31 * result + (mText != null ? mText.hashCode() : 0);
        return result;
    }
}