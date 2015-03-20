# FancyButtons

![FancyButtons Android](https://raw.github.com/medyo/fancybuttons/master/screenshots/fancy.png)![FancyButtons Android](/screenshots/fancy2.png)

#### I always found some difficulties to make great Android buttons, since i need to override everything or make lot of drawables files to handle focus, pressed and normal state. For that reason, i made Fancy Buttons, to make this task much easier.

## Overview
**FancyButtons**, helps you to easily create fancy buttons without the need of drawable files.

![FancyButtons Android](https://raw.github.com/medyo/fancybuttons/master/screenshots/no-drawables.png)

## Features

* Border (stroke, radius, color)
* Background (normal, focus)
* Icon (Drawable, font icon)
	* FontAwsome
	* Custom font
* Icon (Position, size)
    * right
    * left
    * top
    * bottom  
* Icon Size

### Including in your project : Maven Central

	compile 'com.github.medyo:fancybuttons:1.1@aar'

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
| fancy:text      | setText(String)     | Text of the button |
| fancy:textColor     | setTextColor(int)      |  Text Color of the button |
| fancy:textSize | setTextSize(int)      |    Size of the text |
| fancy:textFont | setCustomTextFont(String)      |    FontFamily of the text|
| fancy:iconResource | setIconResource(Drawable)      |    Drawable icon of the button|
| fancy:iconPosition | setsetIconPosition(int)      |    Position of the icon : Left, Right, Top, Bottom|
| fancy:fontIconResource | setIconResource(String)      |    font icon of the button|
| fancy:fontIconSize | setFontIconSize(int)      |    Size of the icon |
| fancy:iconFont | setCustomIconFont(String)      |    FontFamily of the icon|
| fancy:borderWidth | setBorderWidth(int)      |    Width of the border|
| fancy:borderColor | setBorderColor(int)      |    Color of the border|
| fancy:defaultColor | setBackgroundColor(int)      |    Background color of the button|
| fancy:focusColor | setFocusBackgroundColor(int)      |    Focus Color of border background|
| fancy:radius | setRadius(int)      |    Radius of the button|
| fancy:iconPaddingLeft | setIconPadding(int,int,int,int)      |    Icon Padding|
| fancy:iconPaddingRight | setIconPadding(int,int,int,int)      |    Icon Padding|
| fancy:iconPaddingTop | setIconPadding(int,int,int,int)      |    Icon Padding|
| fancy:iconPaddingBottom | setIconPadding(int,int,int,int)      |    Icon Padding|

#### Sample

**1 - Spotify Button**  
  
![FancyButton Spotify](https://raw.github.com/medyo/fancybuttons/master/screenshots/spotify-button.png)  

	<mehdi.sakout.fancybuttons.FancyButton
	android:id="@+id/btn_spotify"
	android:layout_width="wrap_content"
	android:layout_height="wrap_content"
	android:paddingBottom="10dp"
	android:paddingLeft="20dp"
	android:paddingRight="20dp"
	android:paddingTop="10dp"
	fancy:borderColor="#FFFFFF"
	fancy:borderWidth="1dp"
	fancy:defaultColor="#7ab800"
	fancy:focusColor="#9bd823"
	fancy:fontIconResource="&#xf04b;"
	fancy:iconPosition="left"
	fancy:radius="30dp"
	fancy:text="SHUFFLE PLAY"
	fancy:textColor="#FFFFFF" />
	
**3 - Facebook Button **  
  
![FancyButton Facebook](https://raw.github.com/medyo/fancybuttons/master/screenshots/facebook-button.png)  

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


### Licence

MIT
http://opensource.org/licenses/MIT

### Developed By

El Mehdi Sakout

Follow [@medyo80](http://twitter.com/medyo80) on Twitter for the latest news.

For contact, shoot me an email at <elmehdi.sakout@gmail.com>
