package pe.com.softhy.anewfrontier.ui;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.IntegerRes;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by Sebastian on 24/06/2017.
 */

public class ItemOffsetDecoration extends RecyclerView.ItemDecoration {
    //  La medida en pixeles del espaciado
    private int mItenOffset;

    public ItemOffsetDecoration(Context context, @IntegerRes int integerRestId){
        int itemOffsetDp = context.getResources().getInteger(integerRestId);
        mItenOffset = convertToPixel(itemOffsetDp, context.getResources().getDisplayMetrics());
    }

    public int convertToPixel(int offSetDp, DisplayMetrics metrics){
        return offSetDp * (metrics.densityDpi / 160);  // Formula para convertir dps a pixeles
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(mItenOffset, mItenOffset, mItenOffset, mItenOffset);
    }
}
