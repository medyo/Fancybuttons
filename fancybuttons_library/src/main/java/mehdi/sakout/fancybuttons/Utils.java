package mehdi.sakout.fancybuttons;

import android.content.Context;

public class Utils {

	public static int PxToDp(Context context, float px) {
		return Math.round(px / context.getResources().getDisplayMetrics().density);
	}

	public static int DpToPx(Context context, float dp) {
		return Math.round(dp * context.getResources().getDisplayMetrics().density);
	}
}
