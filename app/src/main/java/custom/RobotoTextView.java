package custom;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class RobotoTextView extends AppCompatTextView {
    public RobotoTextView(Context context) {
        super(context);
        setCustomFont();
    }

    public RobotoTextView(Context context, AttributeSet attrs){
        super(context, attrs);
        setCustomFont();
    }

    private void setCustomFont() {
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/Roboto-Regular.ttf");
        setTypeface(typeface);
    }

}
