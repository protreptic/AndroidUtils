/**
 * 
 */
package org.javaprotrepticon.android.androidutils;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.graphics.Typeface;

/**
 * @author petr_bu
 *
 */
public class Fonts {
	
	private static Fonts sInstance;
	
	private Context mContext;
	private Map<String, Typeface> mTypefaces = new HashMap<String, Typeface>();
	private Typeface mDefaultTypeface;
	
	public interface Roboto {}
	
	public interface RobotoCondensed {}
	
	private Fonts(Context context) {
		mContext = context;
	}
	
	public static Fonts get(Context context) {
		if (sInstance == null) {
			sInstance = new Fonts(context);
		}
		
		return sInstance;
	}
	
	public Typeface getTypeface(String typeface) {
		Typeface result = mTypefaces.get(typeface);
		
		if (result == null) {
			result = Typeface.createFromAsset(mContext.getAssets(), "font/" + typeface + ".ttf");
			if (result == null) {
				result = Typeface.DEFAULT;
			} else {
				mTypefaces.put(typeface, result);
			}
		}
		
		return result;
	}
	
	public Typeface getDefaultTypeface () {
		return mDefaultTypeface;
	}
}
