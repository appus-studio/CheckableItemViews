CheckableItemViews
=====================


Made in [![Appus Studio](https://github.com/appus-studio/Appus-Splash/blob/master/image/logo.png)](http://appus.pro)

CheckableItemViews is a library that allows you to use any views as RadioButtons. 
You can combine ImageViews, TextViews and any views you need in one radiogroup and make them checkable. 
It's very usefull to create custom tab widgets, menus and etc.

* [Customization](#customization)
* [Demo](#demo)
* [Getting Started](#getting-started)
* [Info](#info)



# Customization

orientation - LinearLayout parameter that allows you to place elements in direction you need (integer).
    
checked_item - default checked item @id (integer).

radiogroup_mode - Switch between standart / radiogroup mode (boolean).

## RadioGroup mode

If you will select this mode, one of views always will be checked. You cannot uncheck view in radiogroup mode and one of them will be checked automatically on view creation. 
If set to false, there can be no views checked. Also, child can be unchecked. Very usefull when creating menus.


# Demo

##Usage in RadioGroup and non-RadioGroup mode:

![](https://github.com/appus-studio/CheckableItemViews/blob/master/image/radiobutton_mode.gif)     ![](https://github.com/appus-studio/CheckableItemViews/blob/master/image/checkbox_mode.gif)

# Getting Started

##Setup:

   If you use JCenter repository in your project, just add dependence to main build.gradle:

        dependencies {
                compile 'pro.appus:checkable-item-views:1.0.0'
        }
   
   Else add repository to the same build.gradle:
   
        repositories {
                maven {
                        url 'https://dl.bintray.com/roman-voronoy/maven/'
                }
        }
        

##Usage example:

Just add views into your layout's .xml file and that is all.

        <pro.appus.checkableitemviews.CheckableItemGroup
            android:id="@+id/group"
            android:layout_width="match_parent"
            android:layout_height="100dp"
            android:orientation="horizontal">
    
            <pro.appus.checkableitemviews.checkable_views.CheckableImageView
                android:id="@+id/item1"
                android:layout_width="84dp"
                android:layout_height="84dp"
                android:background="@drawable/background_selector"
                android:src="@drawable/icon" />
    
            <pro.appus.checkableitemviews.checkable_views.CheckableTextView
                android:id="@+id/item2"
                android:layout_width="84dp"
                android:layout_height="84dp"
                android:gravity="center"
                android:text="Item 2" />
    
            ...
    
        </pro.appus.checkableitemviews.CheckableItemGroup>

Example app contains checkable ImageView and TextView's. 

If you want to implement your own views - it's very simple! Just implement CheckableView interface and add some code, as shown on project examples. 

# Info

Developed By
------------

* Vladimir Yerokhin, Appus Studio


* Roman Voronoy, Appus Studio

License
--------

    Copyright 2015 Appus Studio.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
