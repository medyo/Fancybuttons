package mehdi.sakout.fancybuttons;

import android.content.Context;

public class FancyButtonUtils {

	public static int convertPxToDp(final Context context, final float px) {
		return Math.round(px / context.getResources().getDisplayMetrics().density);
	}

	public static int convertDpToPx(final Context context, final float dp) {
		return Math.round(dp * context.getResources().getDisplayMetrics().density);
	}
}
