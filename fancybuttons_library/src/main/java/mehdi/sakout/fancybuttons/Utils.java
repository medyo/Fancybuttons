package mehdi.sakout.fancybuttons;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.TextUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Utils {

	private static Map<String, Typeface> cachedFontMap = new HashMap<String, Typeface>();

	public static int pxToSp(final Context context, final float px) {
		return Math.round(px / context.getResources().getDisplayMetrics().scaledDensity);
	}

	public static int spToPx(final Context context, final float sp) {
		return Math.round(sp * context.getResources().getDisplayMetrics().scaledDensity);
	}

	public static Typeface findFont(Context context, String fontName, String defaultFont){
		if (cachedFontMap.containsKey(fontName)){
			return cachedFontMap.get(fontName);
		}else{
			try{
				AssetManager assets = context.getResources().getAssets();
				if (Arrays.asList(assets.list("")).contains(fontName)){
					Typeface typeface = Typeface.createFromAsset(context.getAssets(), String.format("%s",fontName));
					cachedFontMap.put(fontName, typeface);
					return typeface;
				}else if (Arrays.asList(assets.list("fonts")).contains(fontName)){
					Typeface typeface = Typeface.createFromAsset(context.getAssets(), String.format("fonts/%s",fontName));
					cachedFontMap.put(fontName, typeface);
					return typeface;
				}else if (Arrays.asList(assets.list("iconfonts")).contains(fontName)){
					Typeface typeface = Typeface.createFromAsset(context.getAssets(), String.format("iconfonts/%s",fontName));
					cachedFontMap.put(fontName, typeface);
					return typeface;
				}else{
					throw new Exception("Font not Found");

				}
			}catch (Exception e){
				if (!TextUtils.isEmpty(defaultFont)){
					Typeface typeface = Typeface.createFromAsset(context.getAssets(), String.format("%s", defaultFont));
					cachedFontMap.put(fontName, typeface);
					return typeface;
				}else{
					return Typeface.DEFAULT;
				}
			}
		}

	}

}