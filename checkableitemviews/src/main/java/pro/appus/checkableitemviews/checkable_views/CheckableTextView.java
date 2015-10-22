package pro.appus.checkableitemviews.checkable_views;

import android.content.Context;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.SoundEffectConstants;
import android.view.ViewParent;
import android.widget.TextView;

import pro.appus.checkableitemviews.CheckableItemGroup;
import pro.appus.checkableitemviews.CheckableView;
import pro.appus.checkableitemviews.R;

/**
 * Created by vladimiryerokhin on 10/9/15.
 */
public class CheckableTextView extends TextView implements CheckableView {

    private boolean mChecked = false;
    private OnCheckedChangeListener mOnCheckedChangeListener;
    private OnCheckedChangeListener mOnCheckedChangeWidgetListener;

    public CheckableTextView(Context context) {
        super(context);
        setClickable(true);
    }

    public CheckableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setClickable(true);
    }

    public CheckableTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setClickable(true);
    }

    @Override
    public boolean isChecked() {
        return mChecked;
    }

    @Override
    public void toggle() {
        setChecked(!mChecked);
    }

    @Override
    public void setChecked(boolean checked) {
        mChecked = checked;
        if (mOnCheckedChangeListener != null) {
            mOnCheckedChangeListener.onCheckedChanged(this, mChecked);
        }
        if (mOnCheckedChangeWidgetListener != null) {
            mOnCheckedChangeWidgetListener.onCheckedChanged(this, mChecked);
        }

        refreshDrawableState();
        invalidate();

    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        StateListDrawable stateListDrawable = (StateListDrawable) getBackground();
        if (stateListDrawable == null) {
            stateListDrawable = (StateListDrawable) getResources().getDrawable(R.drawable.background_selector);
            setBackground(stateListDrawable);
        }
        int[] state;
        if (mChecked) {
            state = new int[]{android.R.attr.state_checked};
        } else {
            state = new int[]{android.R.attr.state_empty};
        }
        stateListDrawable.setState(state);
        //redraw
        invalidate();
    }

    @Override
    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        mOnCheckedChangeListener = listener;
    }

    @Override
    public void setOnCheckedChangeWidgetListener(OnCheckedChangeListener widgetListener) {
        mOnCheckedChangeWidgetListener = widgetListener;
    }

    @Override
    public boolean performClick() {
        ViewParent parent = getParent();
        if (parent != null && parent instanceof CheckableItemGroup && ((CheckableItemGroup) parent).isRadioGroupMode()) {
            setChecked(true);
        } else {
            setChecked(!mChecked);
        }
        final boolean handled = super.performClick();
        if (!handled) {
            // View only makes a sound effect if the onClickListener was
            // called, so we'll need to make one here instead.
            playSoundEffect(SoundEffectConstants.CLICK);
        }

        return handled;
    }

    @Override
    public boolean isClickable() {
        return true;
    }

    @Override
    public boolean isContextClickable() {
        return true;
    }
}