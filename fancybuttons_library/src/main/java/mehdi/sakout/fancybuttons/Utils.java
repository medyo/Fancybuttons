package mehdi.sakout.fancybuttons;

import android.content.Context;

public class Utils {

	public static int PxToSp(final Context context, final float px) {
		return Math.round(px / context.getResources().getDisplayMetrics().scaledDensity);
	}

	public static int SptoPx(final Context context, final float sp) {
		return Math.round(sp * context.getResources().getDisplayMetrics().scaledDensity);
	}

	public static int PxToDp(final Context context, final float px) {
		return Math.round(px / context.getResources().getDisplayMetrics().density);
	}

	public static int DptoPx(final Context context, final float dp) {
		return Math.round(dp * context.getResources().getDisplayMetrics().density);
	}
}
