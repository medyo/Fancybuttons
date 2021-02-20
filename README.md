:warning: This library was made years ago when it wasn't that easy to customize Android buttons like today.
I highly recommend you to use [Material Design button](https://material.io/components/buttons/android) as it offers the same features 
and most importantly it's backed by the Android Team.
____

# Fancybuttons
Icons, Borders, Radius ... for Android buttons
[ ![jCenter](https://api.bintray.com/packages/medyo/maven/fancybuttons/images/download.svg) ](https://bintray.com/medyo/maven/fancybuttons/_latestVersion)  [![jitPack](https://jitpack.io/v/medyo/Fancybuttons.svg)](https://jitpack.io/#medyo/Fancybuttons)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-FancyButtons-lightgrey.svg?style=flat)](http://android-arsenal.com/details/1/681)

<img src="/resources/cover.png" width="80%" alt="Android About Page Cover"/>

## Overview
![FancyButtons Android](https://raw.github.com/medyo/fancybuttons/master/resources/no-drawables.png)

### Demo Application : [Download APK](https://raw.github.com/medyo/fancybuttons/master/resources/fancybuttons_samples.apk)

## Features

* Border (stroke, radius, color)
* Background (normal, focus)
* Icon (Drawable, font Icon)
* Icon (Position, size)
* Icon Size
* Icon Padding

### Changelog

- 1.9.1
    - Fix getting the font

- 1.9.0
    - Add support for font resources (For text font only)
    - Increase min API level to 14
    - Now you can use these to set text font (res/font/roboto_slab_bold.ttf):
        android:fontFamily="@font/roboto_slab_bold"
        fancy:fb_textFontRes="@font/roboto_slab_bold"
    - Add dependency on support library used only when using font resources.

- 1.8.4
    - Fix Text Gravity
    - Add Ability to define custom radius value for each corner

- 1.8.3
    - Fixed long searching of font
    - Added ability to use android:text, android:textSize, android:testAllCaps attributes
    - Fixed preview issues with android:* attrs
    - Added opportunity to use android:* attrs in styles
    - Added ability to use custom LayoutParams instead of the default one
    - Force refreshing the view when `setEnabled(boolean)` is called
    - Minor optimization & refactoring

- 1.8.2
    - Added ability to disable button
    - Added ability to use system font

- 1.8.1
    - Fix Bug related to loading custom fonts

- 1.8
    - Add setIconResource(Drawable)
    - Cache fonts

- 1.7
    - Fix ripple effect when background is transparent
    - Add capitalization of text

- 1.6
    - Add ripple effect
    - Upgrade Font Awesome to 4.5.0

### Installation

	implementation 'com.github.medyo:fancybuttons:1.9.1'

### To use font resources add support library to your dependencies:

	implementation "com.android.support:appcompat-v7:$support_lib_version"

### Usage

1 - Include FancyButtons namespace to the root element :

	xmlns:fancy="http://schemas.android.com/apk/res-auto"

2 - Add the FancyButton View with custom params :

	<mehdi.sakout.fancybuttons.FancyButton
	android:id="@+id/btn_preview"
	android:layout_width="wrap_content"
	android:layout_height="wrap_content"/>

####  Supported Attributes

| XML Attribute        | Java Attribute           | Description  |
| ------------- |:-------------:| -----:|
| fancy:fb_text      | setText(String)     | Text of the button |
| fancy:fb_textColor     | setTextColor(int)      |  Text Color of the button |
| fancy:fb_textSize | setTextSize(int)      |    Size of the text |
| fancy:fb_textFont | setCustomTextFont(String)      |    FontFamily of the text|
| fancy:fb_textFontRes | setCustomTextFont(int)      |    FontFamily of the text using font resource. REQUIRES support library|
| fancy:fb_textGravity | setTextGravity(Int)      |    Gravity of the text|
| fancy:fb_iconResource | setIconResource(Drawable)      |    Drawable icon of the button|
| fancy:fb_iconPosition | setIconPosition(int)      |    Position of the icon : Left, Right, Top, Bottom|
| fancy:fb_fontIconResource | setIconResource(String)      |    font icon of the button|
| fancy:fb_fontIconSize | setFontIconSize(int)      |    Size of the icon |
| fancy:fb_iconFont | setCustomIconFont(String)      |    FontFamily of the icon|
| fancy:fb_borderWidth | setBorderWidth(int)      |    Width of the border|
| fancy:fb_borderColor | setBorderColor(int)      |    Color of the border|
| fancy:fb_defaultColor | setBackgroundColor(int)      |    Background color of the button|
| fancy:fb_focusColor | setFocusBackgroundColor(int)      |    Focus Color of button background|
| fancy:fb_disabledColor | setDisableBackgroundColor(int)      |    Disabled Color of button background|
| fancy:fb_disabledTextColor | setDisableTextColor(int)      |    Disabled Color of button text|
| fancy:fb_disabledBorderColor | setDisableBorderColor(int)      |    Disabled Color of button border|
| fancy:fb_radius | setRadius(int)      |    Radius of the button|
| fancy:fb_radius(TopLeft, TopRight,BottomLeft,BottomRight) | setRadius(int[] radius)      |    Custom Radius for each button corner|
| fancy:fb_iconPaddingLeft | setIconPadding(int,int,int,int)      |    Icon Padding|
| fancy:fb_iconPaddingRight | setIconPadding(int,int,int,int)      |    Icon Padding|
| fancy:fb_iconPaddingTop | setIconPadding(int,int,int,int)      |    Icon Padding|
| fancy:fb_iconPaddingBottom | setIconPadding(int,int,int,int)      |    Icon Padding|
| fancy:fb_ghost | setGhost(boolean)      |    Ghost (Hollow)|
| fancy:fb_useSystemFont | setUsingSystemFont(boolean) | If enabled, the button title will ignore its custom font and use the default system font |

Also you can use Attributes with default prefix (android:) which makes migrating of your project more fast.
Default Attributes have more priority than Attributes with prefix fancy.

#### Supported default Attributes
| XML Attribute    |
| ------------- |
| android:enabled |
| android:text |
| android:textSize |
| android:textAllCaps |
| android:fontFamily |

#### Supported Getters
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

![FancyButtons Android](/resources/fancy.png)![FancyButtons Android](/resources/fancy2.png)![FancyButtons Android](/resources/fancy3.png)

### FAQ

**How to add new fonts ?**
Just Paste your font inside `assets/fonts/` folder for Text fonts or inside `assets/iconfonts/` for icon fonts eg : entypo
OR for text fonts add it to res/font/ and use android:fontFamily or fancy:fb_textFontRes to use it.

## Contributions
Fancybuttons needs you to build the missing features :
* Supporting Circular buttons
* Add elevation (Material Design)

### Licence

MIT
http://opensource.org/licenses/MIT

### Developed By

El Mehdi Sakout

Follow [@medyo80](http://twitter.com/medyo80) on Twitter for the latest news.

For contact, shoot me an email at <elmehdi.sakout@gmail.com>
