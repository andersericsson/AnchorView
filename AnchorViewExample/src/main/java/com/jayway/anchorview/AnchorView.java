package com.jayway.anchorview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

public class AnchorView extends View {

    private final float mRelativeWidth;
    private final float mRelativeHeight;

    public AnchorView(final Context context, final AttributeSet attrs) {
        super(context, attrs);

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.AnchorView);
        mRelativeWidth = clamp(attributes.getFloat(R.styleable.AnchorView_relativeWidth, 1));
        mRelativeHeight = clamp(attributes.getFloat(R.styleable.AnchorView_relativeHeight, 1));
        attributes.recycle();
    }

    @Override
    protected void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension((int) (mRelativeWidth * getMeasuredWidth()), (int) (mRelativeHeight * getMeasuredHeight()));
    }

    private float clamp(float value) {
        if (value > 1) {return 1;}
        if (value < 0) {return 0;}
        return value;
    }
}
