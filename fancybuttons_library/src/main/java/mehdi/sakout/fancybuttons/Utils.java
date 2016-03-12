package mehdi.sakout.fancybuttons;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;

import java.util.Arrays;

public class Utils {

	public static int pxToSp(final Context context, final float px) {
		return Math.round(px / context.getResources().getDisplayMetrics().scaledDensity);
	}

	public static int spToPx(final Context context, final float sp) {
		return Math.round(sp * context.getResources().getDisplayMetrics().scaledDensity);
	}

	public static Typeface findFont(Context context, String fontName, String defaultFont){
		try{
			AssetManager assets = context.getResources().getAssets();
			if (Arrays.asList(assets.list("")).contains(fontName)){
				return Typeface.createFromAsset(context.getAssets(), String.format("%s",fontName));
			}else if (Arrays.asList(assets.list("fonts")).contains(fontName)){
				return Typeface.createFromAsset(context.getAssets(), String.format("fonts/%s",fontName));
			}else if (Arrays.asList(assets.list("iconfonts")).contains(fontName)){
				return Typeface.createFromAsset(context.getAssets(), String.format("iconfonts/%s",fontName));
			}else{
				return Typeface.createFromAsset(context.getAssets(), String.format("%s", defaultFont));
			}
		}catch (Exception e){
			return Typeface.createFromAsset(context.getAssets(), String.format("%s", defaultFont));
		}
	}

}