# FancyButtons

![FancyButtons Android](/resources/fancy.png)![FancyButtons Android](/resources/fancy2.png)![FancyButtons Android](/resources/fancy3.png)

#### I've always found some difficulties to make great Android buttons, since I need to override everything or make lot of drawables files to handle focus, pressed and normal states. For that reason, I made Fancy Buttons, to make this redundant task much easier.

## Overview
**FancyButtons**, helps you to easily create fancy buttons without the need of drawable files.

![FancyButtons Android](https://raw.github.com/medyo/fancybuttons/master/resources/no-drawables.png)

### Demo Application : [Download APK](https://raw.github.com/medyo/fancybuttons/master/resourcesfancybuttons_samples.apk)

## Features

* Border (stroke, radius, color)
* Background (normal, focus)
* Icon (Drawable, font icon)
	* FontAwesome
	* Custom font
* Icon (Position, size)
    * right
    * left
    * top
    * bottom  
* Icon Size
* Icon Padding


### Including in your project : Maven Central

	compile 'com.github.medyo:fancybuttons:1.5@aar'

### Usage

1 - Include FancyButtons namespace to the root element :

	xmlns:fancy="http://schemas.android.com/apk/res-auto"

2 - Add the FancyButton View with custom params :

	<mehdi.sakout.fancybuttons.FancyButton
	android:id="@+id/btn_preview"
	android:layout_width="wrap_content"
	android:layout_height="wrap_content"/>

####  Supported Attributs

| XML Attribut        | Java Attribut           | Description  |
| ------------- |:-------------:| -----:|
| fancy:fb_text      | setText(String)     | Text of the button |
| fancy:fb_textColor     | setTextColor(int)      |  Text Color of the button |
| fancy:fb_textSize | setTextSize(int)      |    Size of the text |
| fancy:fb_textFont | setCustomTextFont(String)      |    FontFamily of the text|
| fancy:fb_textGravity | setTextGravity(Int)      |    Gravity of the text|
| fancy:fb_iconResource | setIconResource(Drawable)      |    Drawable icon of the button|
| fancy:fb_iconPosition | setsetIconPosition(int)      |    Position of the icon : Left, Right, Top, Bottom|
| fancy:fb_fontIconResource | setIconResource(String)      |    font icon of the button|
| fancy:fb_fontIconSize | setFontIconSize(int)      |    Size of the icon |
| fancy:fb_iconFont | setCustomIconFont(String)      |    FontFamily of the icon|
| fancy:fb_borderWidth | setBorderWidth(int)      |    Width of the border|
| fancy:fb_borderColor | setBorderColor(int)      |    Color of the border|
| fancy:fb_defaultColor | setBackgroundColor(int)      |    Background color of the button|
| fancy:fb_focusColor | setFocusBackgroundColor(int)      |    Focus Color of border background|
| fancy:fb_radius | setRadius(int)      |    Radius of the button|
| fancy:fb_iconPaddingLeft | setIconPadding(int,int,int,int)      |    Icon Padding|
| fancy:fb_iconPaddingRight | setIconPadding(int,int,int,int)      |    Icon Padding|
| fancy:fb_iconPaddingTop | setIconPadding(int,int,int,int)      |    Icon Padding|
| fancy:fb_iconPaddingBottom | setIconPadding(int,int,int,int)      |    Icon Padding|
| fancy:fb_ghost | setGhost(boolean)      |    Ghost (Hollow)|

####  Supported Getters

| Function        | Description  |
| ------------- |:-------------:| -----:|
| getText() | Returns Text Value of the button|
| getTextViewObject() | Returns TextView Object|
| getIconFontObject() | Returns icon defined by fb_fontIconResource|
| getIconImageObject() | Returns icon defined by fb_iconResource |

#### Sample

**1 - Spotify Button**  

![FancyButton Spotify](https://raw.github.com/medyo/fancybuttons/master/resources/spotify-button.png)  

	<mehdi.sakout.fancybuttons.FancyButton
		android:id="@+id/btn_spotify"
		android:layout_width="wrap_content"
		android:layout_height="wrap_content"
		android:paddingBottom="10dp"
		android:paddingLeft="20dp"
		android:paddingRight="20dp"
		android:paddingTop="10dp"
		fancy:fb_borderColor="#FFFFFF"
		fancy:fb_borderWidth="1dp"
		fancy:fb_defaultColor="#7ab800"
		fancy:fb_focusColor="#9bd823"
		fancy:fb_fontIconResource="&#xf04b;"
		fancy:fb_iconPosition="left"
		fancy:fb_radius="30dp"
		fancy:fb_text="SHUFFLE PLAY"
		fancy:fb_textColor="#FFFFFF" />

**2 - Facebook Button**

![FancyButton Facebook](https://raw.github.com/medyo/fancybuttons/master/resources/facebook-button.png)  

	FancyButton facebookLoginBtn = new FancyButton(this);
    facebookLoginBtn.setText("Login with Facebook");
    facebookLoginBtn.setBackgroundColor(Color.parseColor("#3b5998"));
    facebookLoginBtn.setFocusBackgroundColor(Color.parseColor("#5474b8"));
    facebookLoginBtn.setTextSize(17);
    facebookLoginBtn.setRadius(5);
    facebookLoginBtn.setIconResource("\uf082");
    facebookLoginBtn.setIconPosition(FancyButton.POSITION_LEFT);
    facebookLoginBtn.setFontIconSize(30);

See the [example project](https://github.com/medyo/fancybuttons/tree/master/samples/src/main/java/mehdi/sakout/fancybuttons/samples) for more samples

### Bonus

Fancybuttons is delivered with :  

* 1 font : **RobotoRegular**
* 1 icon Font : **FontAwesome** ( cheatsheet http://fortawesome.github.io/Font-Awesome/cheatsheet/)

- - - -

### FAQ

**How to add new fonts ?**  
Just Paste your font inside `assets/fonts/` folder for Text fonts or inside `assets/iconfonts/` for icon fonts eg : entypo

## Contributions
Fancybuttons needs you to build the missing features :
* Supporting Circular buttons 
* Supporting Lollipop Ripple effect

### Licence

MIT
http://opensource.org/licenses/MIT

### Developed By

El Mehdi Sakout

Follow [@medyo80](http://twitter.com/medyo80) on Twitter for the latest news.

For contact, shoot me an email at <elmehdi.sakout@gmail.com>
