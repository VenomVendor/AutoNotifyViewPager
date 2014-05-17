# Android AutoNotifyViewPager

This project is an upgraded version of [ViewPager][1]. AutoNotifies your adapter when data get's changed.

##Prerequisites
 - [android-support-v4.jar](#prerequisites)


## Why?
 - By default **ViewPager's** `adapter` should be notified using <kbd>mAdapter.notifyDataSetChanged()</kbd> if *data* get's changed after [setting adapter][2] to avoid *[IllegalStateException][6]*
 - It get's difficult to update your adapter when `PagerAdapter` is in other class, typically different <kbd>*.java</kbd>
 - <u>**Example**</u>  :
   - In [this app][3], `ListView's adapter` & `ViewPager's adapter` share's **same content**.
   - When scrolled down to bottom of the page in ListView, `GetMoreData` is *triggered, fetched, parsed & updated* to ListView's adapter.
   - Seems easy, but when the user clicks & navigates to `ViewPager` after **triggered** and before **updated**, you end up in `IllegalStateException` as the data got changed but not notified.
   - This can be avoided having complex `eventListeners`, instead simply use ***[AutoNotifyViewPager](#)***


### When?
 - Notifies your `adapter` <u>***when view get's changed***</u>

### Not When!
 - `adapter` get's content.

## Usage

Import [library][4]  or add any one [*.jar][5] into `/libs`

In `layout.xml`

	<vee.android.lib.AutoNotifyViewPager 
		android:id="@+id/pager"
		android:layout_width="match_parent"
		android:layout_height="match_parent" />


Instead of <s>`ViewPager mPager`</s> use <kbd>AutoNotifyViewPager mPager</kbd>

	AutoNotifyViewPager mPager = (AutoNotifyViewPager) findViewById(R.id.pager);
	mPager.setAdapter(adapter);

### imports
	import vee.android.lib.AutoNotifyViewPager.*;

### *<u>imports not to have</u>*
	import android.support.v4.view.ViewPager.*

### ProGuard
	-dontwarn vee.android.lib.**
	-keep public class vee.android.lib.** { *; }

###### Author : [VenomVendor](https://www.google.com/#newwindow=1&q=VenomVendor "Find me on Google")

#License
	Copyright (C) 2014 VenomVendor <info@VenomVendor.com>
	Copyright (C) 2011 The Android Open Source Project.

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

		http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
	
	
 [1]: http://developer.android.com/reference/android/support/v4/view/ViewPager.html "android.support.v4.view.ViewPager"
 [2]: http://developer.android.com/reference/android/support/v4/view/ViewPager.html#setAdapter%28android.support.v4.view.PagerAdapter%29
 [3]: https://play.google.com/store/apps/details?id=com.MobiGyaan "MobiGyaan"
 [4]: https://github.com/VenomVendor/AutoNotifyViewPager/tree/master/library "Import"
 [5]: https://github.com/VenomVendor/AutoNotifyViewPager/tree/master/library/bin "any one"
 [6]: https://www.google.com/search?q=the+application's+pageradapter+changed "IllegalStateException"
