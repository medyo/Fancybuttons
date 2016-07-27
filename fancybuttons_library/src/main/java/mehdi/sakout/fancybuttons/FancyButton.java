package mehdi.sakout.fancybuttons;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class FancyButton  extends LinearLayout{

    private Context mContext;

    // # Background Attributes
    private int mDefaultBackgroundColor 		= Color.BLACK;
    private int mFocusBackgroundColor 			= 0;

    // # Text Attributes
    private int mDefaultTextColor 				= Color.WHITE;
    private int mDefaultIconColor               = Color.WHITE;
    private int mTextPosition 					= 1;
    private int mDefaultTextSize 				= Utils.spToPx(getContext(), 15);
    private int mDefaultTextGravity             = 0x11; // Gravity.CENTER
    private String mText 						= null;

    // # Icon Attributes
    private Drawable mIconResource 				= null;
    private int  mFontIconSize 					= Utils.spToPx(getContext(), 15);
    private String mFontIcon 					= null;
    private int mIconPosition 					= 1;

    private int mIconPaddingLeft                = 10;
    private int mIconPaddingRight               = 10;
    private int mIconPaddingTop                 = 0;
    private int mIconPaddingBottom              = 0;


    private int mBorderColor 					= Color.TRANSPARENT;
    private int mBorderWidth 					= 0;

    private int mRadius 						= 0;

    private boolean mTextAllCaps                = false;

    private Typeface mTextTypeFace = null;
    private Typeface mIconTypeFace = null;

    /**
     * Tags to identify icon position
     */
    public static final int POSITION_LEFT  		= 1;
    public static final int POSITION_RIGHT  	= 2;
    public static final int POSITION_TOP  		= 3;
    public static final int POSITION_BOTTOM  	= 4;

    private String mDefaultIconFont = "fontawesome.ttf";
    private String mDefaultTextFont = "robotoregular.ttf";

    private ImageView mIconView;
    private TextView mFontIconView;
    private TextView mTextView;

    private boolean mGhost = false ; // Default is a solid button !
    private boolean mUseSystemFont = false; // Default is using robotoregular.ttf

    /**
     * Default constructor
     * @param context : Context
     */
    public FancyButton(Context context){
        super(context);
        this.mContext   = context;

        mTextTypeFace   = Utils.findFont(mContext, mDefaultTextFont, null);
        mIconTypeFace   = Utils.findFont(mContext, mDefaultIconFont, null);
        initializeFancyButton();
    }



    /**
     * Default constructor called from Layouts
     * @param context : Context
     * @param attrs : Attributes Array
     */
    public FancyButton(Context context, AttributeSet attrs){
        super(context, attrs);
        this.mContext = context;

        TypedArray attrsArray 	= context.obtainStyledAttributes(attrs,R.styleable.FancyButtonsAttrs, 0, 0);
        initAttributesArray(attrsArray);
        attrsArray.recycle();

        initializeFancyButton();

    }
    /**
     * Initialize Button dependencies
     *  - Initialize Button Container : The LinearLayout
     *  - Initialize Button TextView
     *  - Initialize Button Icon
     *  - Initialize Button Font Icon
     */
    private void initializeFancyButton(){

        initializeButtonContainer();

        mTextView 		= setupTextView();
        mIconView 		= setupIconView();
        mFontIconView 	= setupFontIconView();

        int iconIndex,textIndex;
        View view1,view2;

        if(mIconView == null && mFontIconView == null && mTextView == null){
            Button tempTextView = new Button(mContext);
            tempTextView.setText("Fancy Button");
            this.addView(tempTextView);

        }else{
            this.removeAllViews();
            setupBackground();

            ArrayList<View> views = new ArrayList<>();

            if(mIconPosition == POSITION_LEFT || mIconPosition == POSITION_TOP){

                if(mIconView != null){
                    views.add(mIconView);
                }

                if(mFontIconView != null){
                    views.add(mFontIconView);
                }
                if(mTextView != null){
                    views.add(mTextView);
                }

            }else{
                if(mTextView != null){
                    views.add(mTextView);
                }

                if(mIconView != null){
                    views.add(mIconView);
                }

                if(mFontIconView != null){
                    views.add(mFontIconView);
                }

            }

            for(View view : views){
                this.addView(view);
            }
        }
    }

    /**
     * Setup Text View
     * @return : TextView
     */
    private TextView setupTextView(){
        if (mText != null) {
            TextView textView = new TextView(mContext);
            textView.setText(mText);
            textView.setGravity(mDefaultTextGravity);
            textView.setTextColor(mDefaultTextColor);
            textView.setTextSize(Utils.pxToSp(getContext(), mDefaultTextSize));

            textView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            if (!isInEditMode() && mTextTypeFace!=null && !mUseSystemFont) {
                textView.setTypeface(mTextTypeFace);
            }
            return textView;
        }
        return null;
    }

    /**
     * Setup Font Icon View
     * @return : TextView
     */
    private TextView setupFontIconView(){

        if(mFontIcon!=null){
            TextView fontIconView = new TextView(mContext);
            fontIconView.setTextColor(mDefaultIconColor);

            LayoutParams iconTextViewParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
            iconTextViewParams.rightMargin = mIconPaddingRight;
            iconTextViewParams.leftMargin = mIconPaddingLeft;
            iconTextViewParams.topMargin = mIconPaddingTop;
            iconTextViewParams.bottomMargin = mIconPaddingBottom;

            if(mTextView != null){

                if(mIconPosition==POSITION_TOP || mIconPosition==POSITION_BOTTOM){
                    iconTextViewParams.gravity = Gravity.CENTER;
                    fontIconView.setGravity(Gravity.CENTER);
                }
                else{
                    fontIconView.setGravity(Gravity.CENTER_VERTICAL);
                    iconTextViewParams.gravity = Gravity.CENTER_VERTICAL;
                }
            }else{
                iconTextViewParams.gravity = Gravity.CENTER;
                fontIconView.setGravity(Gravity.CENTER_VERTICAL);
            }


            fontIconView.setLayoutParams(iconTextViewParams);
            if(!isInEditMode()){
                fontIconView.setTextSize(Utils.pxToSp(getContext(), mFontIconSize));
                fontIconView.setText(mFontIcon);
                fontIconView.setTypeface(mIconTypeFace);
            }else{
                fontIconView.setTextSize(Utils.pxToSp(getContext(), mFontIconSize));
                fontIconView.setText("O");
            }
            return fontIconView;
        }
        return null;
    }

    /**
     * Text Icon resource view
     * @return : ImageView
     */
    private ImageView setupIconView(){
        if (mIconResource != null){
            ImageView iconView = new ImageView(mContext);
            iconView.setImageDrawable(mIconResource);
            iconView.setPadding(mIconPaddingLeft, mIconPaddingTop, mIconPaddingRight, mIconPaddingBottom);

            LayoutParams iconViewParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
            if(mTextView!=null){
                if(mIconPosition==POSITION_TOP || mIconPosition==POSITION_BOTTOM)
                    iconViewParams.gravity = Gravity.CENTER;
                else
                    iconViewParams.gravity = Gravity.START;

                iconViewParams.rightMargin = 10;
                iconViewParams.leftMargin = 10;
            }else{
                iconViewParams.gravity = Gravity.CENTER_VERTICAL;
            }
            iconView.setLayoutParams(iconViewParams);

            return iconView;
        }
        return null;
    }

    /**
     * Initialize Attributes arrays
     * @param attrsArray : Attributes array
     */
    private void initAttributesArray(TypedArray attrsArray){

        mDefaultBackgroundColor 		= attrsArray.getColor(R.styleable.FancyButtonsAttrs_fb_defaultColor,mDefaultBackgroundColor);
        mFocusBackgroundColor 			= attrsArray.getColor(R.styleable.FancyButtonsAttrs_fb_focusColor,mFocusBackgroundColor);

        mDefaultTextColor 				= attrsArray.getColor(R.styleable.FancyButtonsAttrs_fb_textColor,mDefaultTextColor);
        // if default color is set then the icon's color is the same (the default for icon's color)
        mDefaultIconColor               = attrsArray.getColor(R.styleable.FancyButtonsAttrs_fb_iconColor,mDefaultTextColor);
        mDefaultTextSize				= (int) attrsArray.getDimension(R.styleable.FancyButtonsAttrs_fb_textSize, mDefaultTextSize);
        mDefaultTextGravity             = attrsArray.getInt(R.styleable.FancyButtonsAttrs_fb_textGravity, mDefaultTextGravity);

        mBorderColor 					= attrsArray.getColor(R.styleable.FancyButtonsAttrs_fb_borderColor, mBorderColor);
        mBorderWidth					= (int) attrsArray.getDimension(R.styleable.FancyButtonsAttrs_fb_borderWidth,mBorderWidth);

        mRadius 						= (int)attrsArray.getDimension(R.styleable.FancyButtonsAttrs_fb_radius,mRadius);
        mFontIconSize 					= (int)attrsArray.getDimension(R.styleable.FancyButtonsAttrs_fb_fontIconSize, mFontIconSize);

        mIconPaddingLeft                = (int)attrsArray.getDimension(R.styleable.FancyButtonsAttrs_fb_iconPaddingLeft,mIconPaddingLeft);
        mIconPaddingRight               = (int)attrsArray.getDimension(R.styleable.FancyButtonsAttrs_fb_iconPaddingRight,mIconPaddingRight);
        mIconPaddingTop                 = (int)attrsArray.getDimension(R.styleable.FancyButtonsAttrs_fb_iconPaddingTop,mIconPaddingTop);
        mIconPaddingBottom              = (int)attrsArray.getDimension(R.styleable.FancyButtonsAttrs_fb_iconPaddingBottom,mIconPaddingBottom);

        mTextAllCaps                    = attrsArray.getBoolean(R.styleable.FancyButtonsAttrs_fb_textAllCaps, false);

        mGhost                          = attrsArray.getBoolean(R.styleable.FancyButtonsAttrs_fb_ghost, mGhost);
        mUseSystemFont                  = attrsArray.getBoolean(R.styleable.FancyButtonsAttrs_fb_useSystemFont, mUseSystemFont);

        String text 					= attrsArray.getString(R.styleable.FancyButtonsAttrs_fb_text);
        mIconPosition 					= attrsArray.getInt(R.styleable.FancyButtonsAttrs_fb_iconPosition,mIconPosition);

        String fontIcon 				= attrsArray.getString(R.styleable.FancyButtonsAttrs_fb_fontIconResource);

        String iconFontFamily 			= attrsArray.getString(R.styleable.FancyButtonsAttrs_fb_iconFont);
        String textFontFamily 			= attrsArray.getString(R.styleable.FancyButtonsAttrs_fb_textFont);

        Drawable icon = null;
        try{
            mIconResource 				= attrsArray.getDrawable(R.styleable.FancyButtonsAttrs_fb_iconResource);

        }catch(Exception e){
            mIconResource = null;
        }

        if(fontIcon!=null)
            mFontIcon = fontIcon;

        if(text!=null)
            mText = mTextAllCaps ? text.toUpperCase():text;

        if(!isInEditMode()){
            if(iconFontFamily!=null){
                mIconTypeFace = Utils.findFont(mContext, iconFontFamily, mDefaultIconFont);
            }else{
                mIconTypeFace = Utils.findFont(mContext, mDefaultIconFont, null);
            }

            if(textFontFamily!=null){
                mTextTypeFace = Utils.findFont(mContext, textFontFamily, mDefaultTextFont);
            }else{
                mTextTypeFace = Utils.findFont(mContext, mDefaultTextFont, null);
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private Drawable getRippleDrawable(Drawable defaultDrawable, Drawable focusDrawable){
        return new RippleDrawable(ColorStateList.valueOf(mFocusBackgroundColor), defaultDrawable, focusDrawable);
    }


    @SuppressLint("NewApi")
    private void setupBackground(){


        // Default Drawable
        GradientDrawable defaultDrawable = new GradientDrawable();
        defaultDrawable.setCornerRadius(mRadius);
        if (mGhost){
            defaultDrawable.setColor(getResources().getColor(android.R.color.transparent)); // Hollow Background
        } else {
            defaultDrawable.setColor(mDefaultBackgroundColor);
        }

        //Focus Drawable
        GradientDrawable focusDrawable = new GradientDrawable();
        focusDrawable.setCornerRadius(mRadius);
        focusDrawable.setColor(mFocusBackgroundColor);

        // Handle Border
        if (mBorderColor != 0) {
            defaultDrawable.setStroke(mBorderWidth, mBorderColor);
        }


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            this.setBackground(getRippleDrawable(defaultDrawable, focusDrawable));

        } else {

            StateListDrawable states = new StateListDrawable();

            // Focus/Pressed Drawable
            GradientDrawable drawable2 = new GradientDrawable();
            drawable2.setCornerRadius(mRadius);
            if (mGhost){
                drawable2.setColor(getResources().getColor(android.R.color.transparent)); // No focus color
            } else {
                drawable2.setColor(mFocusBackgroundColor);
            }

            // Handle Button Border
            if (mBorderColor != 0) {
                if (mGhost) {
                    drawable2.setStroke(mBorderWidth, mFocusBackgroundColor); // Border is the main part of button now
                }
                else {
                    drawable2.setStroke(mBorderWidth, mBorderColor);
                }
            }

            if(mFocusBackgroundColor != 0){
                states.addState(new int[] { android.R.attr.state_pressed }, drawable2);
                states.addState(new int[] { android.R.attr.state_focused }, drawable2);
            }
            states.addState(new int[]{}, defaultDrawable);

            if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                this.setBackgroundDrawable(states);
            } else {
                this.setBackground(states);
            }

        }



    }


    /**
     * Initialize button container
     */
    private void initializeButtonContainer(){

        if(mIconPosition == POSITION_TOP || mIconPosition == POSITION_BOTTOM){
            this.setOrientation(LinearLayout.VERTICAL);
        }else{
            this.setOrientation(LinearLayout.HORIZONTAL);
        }
        LayoutParams containerParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        this.setLayoutParams(containerParams);
        this.setGravity(Gravity.CENTER);
        this.setClickable(true);
        this.setFocusable(true);
        if(mIconResource==null && mFontIcon==null && getPaddingLeft()==0 && getPaddingRight()==0 && getPaddingTop()==0 && getPaddingBottom()==0){
            this.setPadding(20, 20, 20, 20);
        }
    }

    /**
     * Set Text of the button
     * @param text : Text
     */
    public void setText(String text){
        text = mTextAllCaps ? text.toUpperCase() : text;
        this.mText = text;
        if(mTextView == null)
            initializeFancyButton();
        else
            mTextView.setText(text);
    }

    /** Set the capitalization of text
     *
     * @param textAllCaps : is text to be capitalized
     */
    public void setTextAllCaps(boolean textAllCaps){
        this.mTextAllCaps = textAllCaps;
        setText(mText);
    }

    /**
     * Set the color of text
     * @param color : Color
     * use Color.parse('#code')
     */
    public void setTextColor(int color){
        this.mDefaultTextColor = color;
        if(mTextView == null)
            initializeFancyButton();
        else
            mTextView.setTextColor(color);

    }

    /**
     * Setting the icon's color independent of the text color
     * @param color : Color
     */
    public void setIconColor(int color){
        if(mFontIconView != null) {
            mFontIconView.setTextColor(color);
        }
    }

    /**
     * Set Background color of the button
     * @param color : use Color.parse('#code')
     */
    public void setBackgroundColor(int color){
        this.mDefaultBackgroundColor = color;
        if(mIconView != null || mFontIconView != null || mTextView != null){
            this.setupBackground();
        }
    }

    /**
     * Set Focus color of the button
     * @param color : use Color.parse('#code')
     */
    public void setFocusBackgroundColor(int color){
        this.mFocusBackgroundColor = color;
        if(mIconView != null || mFontIconView != null || mTextView != null)
            this.setupBackground();

    }

    /**
     * Set the size of Text in sp
     * @param textSize : Text Size
     */
    public void setTextSize(int textSize){
        this.mDefaultTextSize = Utils.spToPx(getContext(), textSize);
        if(mTextView != null)
            mTextView.setTextSize(textSize);
    }

    /**
     * Set the gravity of Text
     * @param gravity : Text Gravity
     */

    public void setTextGravity(int gravity) {
        this.mDefaultTextGravity = gravity;
        if (mTextView != null) {
            mTextView.setGravity(gravity);
        }
    }

    /**
     * Set Padding for mIconView and mFontIconSize
     * @param paddingLeft : Padding Left
     * @param paddingTop : Padding Top
     * @param paddingRight : Padding Right
     * @param paddingBottom : Padding Bottom
     */
    public void setIconPadding(int paddingLeft, int paddingTop, int paddingRight, int paddingBottom){
        this.mIconPaddingLeft = paddingLeft;
        this.mIconPaddingTop = paddingTop;
        this.mIconPaddingRight = paddingRight;
        this.mIconPaddingBottom = paddingBottom;
        if(mIconView != null){
            mIconView.setPadding(this.mIconPaddingLeft, this.mIconPaddingTop, this.mIconPaddingRight, this.mIconPaddingBottom);
        }
        if(mFontIconView != null){
            mFontIconView.setPadding(this.mIconPaddingLeft, this.mIconPaddingTop, this.mIconPaddingRight, this.mIconPaddingBottom);
        }
    }

    /**
     * Set an icon from resources to the button
     * @param drawable : Int resource
     */
    public void setIconResource(int drawable){
        this.mIconResource = mContext.getResources().getDrawable(drawable);
        if(mIconView == null || mFontIconView != null) {
            mFontIconView= null;
            initializeFancyButton();
        }
        else
            mIconView.setImageDrawable(mIconResource);
    }

    /**
     * Set a drawable to the button
     * @param drawable : Drawable resource
     */
    public void setIconResource(Drawable drawable){
        this.mIconResource = drawable;
        if(mIconView == null || mFontIconView != null) {
            mFontIconView= null;
            initializeFancyButton();
        }
        else
            mIconView.setImageDrawable(mIconResource);
    }

    /**
     * Set a font icon to the button (eg FFontAwesome or Entypo...)
     * @param icon : Icon value eg : \uf082
     */
    public void setIconResource(String icon){
        this.mFontIcon = icon;
        if(mFontIconView == null) {
            mIconView=null;
            initializeFancyButton();
        }
        else
            mFontIconView.setText(icon);
    }

    /**
     * Set Icon size of the button (for only font icons) in sp
     * @param iconSize : Icon Size
     */
    public void setFontIconSize(int iconSize){
        this.mFontIconSize = Utils.spToPx(getContext(), iconSize);
        if(mFontIconView!=null)
            mFontIconView.setTextSize(iconSize);
    }

    /**
     * Set Icon Position
     * Use the global variables (FancyButton.POSITION_LEFT, FancyButton.POSITION_RIGHT, FancyButton.POSITION_TOP, FancyButton.POSITION_BOTTOM)
     * @param position : Position
     */
    public void setIconPosition(int position){
        if(position>0 && position<5)
            mIconPosition = position;
        else
            mIconPosition = POSITION_LEFT;

        initializeFancyButton();
    }

    /**
     * Set color of the button border
     * @param color : Color
     * use Color.parse('#code')
     */
    public void setBorderColor(int color){
        this.mBorderColor = color;
        if(mIconView!=null || mFontIconView!=null || mTextView!=null){
            this.setupBackground();
        }
    }

    /**
     * Set Width of the button
     * @param width : Width
     */
    public void setBorderWidth(int width){
        this.mBorderWidth = width;
        if(mIconView != null || mFontIconView != null || mTextView != null){
            this.setupBackground();
        }
    }

    /**
     * Set Border Radius of the button
     * @param radius : Radius
     */
    public void setRadius(int radius){
        this.mRadius = radius;
        if(mIconView != null || mFontIconView != null || mTextView != null){
            this.setupBackground();
        }
    }

    /**
     * Set custom font for button Text
     * @param fontName : Font Name
     * Place your text fonts in assets
     */
    public void setCustomTextFont(String fontName){
        mTextTypeFace = Utils.findFont(mContext, fontName, mDefaultTextFont);

        if(mTextView==null)
            initializeFancyButton();
        else
            mTextView.setTypeface(mTextTypeFace);

    }

    /**
     * Set Custom font for button icon
     * @param fontName : Font Name
     * Place your icon fonts in assets
     */
    public void setCustomIconFont(String fontName){

        mIconTypeFace = Utils.findFont(mContext, fontName, mDefaultIconFont);

        if(mFontIconView == null)
            initializeFancyButton();
        else
            mFontIconView.setTypeface(mIconTypeFace);

    }

    /**
     * Setting the button to have hollow or solid shape
     * @param ghost
     */
    public void setGhost(boolean ghost) {
        this.mGhost = ghost;

        if(mIconView != null || mFontIconView != null || mTextView != null){
            this.setupBackground();
        }

    }

    /**
     * Setting the button use system font
     *
     * @param use
     */
    public void setUsingSystemFont(boolean use) {
        this.mUseSystemFont = use;
    }

    /**
     * Return Text of the button
     * @return Text
     */
    public CharSequence getText(){
        if (mTextView != null)
            return mTextView.getText();
        else
            return "";
    }

    /**
     * Return TextView Object of the FancyButton
     * @return TextView Object
     */
    public TextView getTextViewObject(){
        return mTextView;
    }

    /**
     * Return Icon Font of the FancyButton
     * @return TextView Object
     */
    public TextView getIconFontObject(){
        return mFontIconView;
    }

    /**
     * Return Icon of the FancyButton
     * @return ImageView Object
     */
    public ImageView getIconImageObject(){
        return mIconView;
    }

}
