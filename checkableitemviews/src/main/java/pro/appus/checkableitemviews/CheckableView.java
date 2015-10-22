package pro.appus.checkableitemviews;

import android.widget.Checkable;

/**
 * Created by vladimiryerokhin on 10/8/15.
 */
public interface CheckableView extends Checkable {

    void setOnCheckedChangeListener(
            CheckableView.OnCheckedChangeListener widgetListener);

    void setOnCheckedChangeWidgetListener(
            CheckableView.OnCheckedChangeListener widgetListener);

    int getId();

    /**
     * Interface definition for a callback to be invoked when the checked state
     * of a compound button changed.
     */
    interface OnCheckedChangeListener {
        /**
         * Called when the checked state of a compound button has changed.
         *
         * @param buttonView The compound button view whose state has changed.
         * @param isChecked  The new checked state of buttonView.
         */
        void onCheckedChanged(CheckableView buttonView, boolean isChecked);
    }
}
