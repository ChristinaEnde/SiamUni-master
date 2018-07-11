package android.siamuni.siamuni;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.GridView;

public class MyGridView extends GridView {
    private Bitmap background = BitmapFactory.decodeResource(this.getResources(),R.drawable.bookshelf_layer_center);

    public MyGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected void dispatchDraw(Canvas canvas) {
        int count = this.getChildCount();
        int top = count > 0?this.getChildAt(0).getTop():0;
        int backgroundWidth = this.background.getWidth();
        int backgroundHeight = this.background.getHeight();
        int width = this.getWidth();
        int height = this.getHeight();
        for(int y = top; y < height; y += backgroundHeight) {
            for(int x = 0; x < width; x += backgroundWidth) {
                canvas.drawBitmap(this.background, (float)x, (float)y, (Paint)null);
            }
        }
        super.dispatchDraw(canvas);
    }

}
