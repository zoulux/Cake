package com.pentakill.cake.ui.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by zoulux on 2016-02-14  22:56.
 */
public class ExpandableListView extends ListView {
    public ExpandableListView(Context context) {
        super(context);
    }

    public ExpandableListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ExpandableListView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthSpec, expandSpec);
    }
}
