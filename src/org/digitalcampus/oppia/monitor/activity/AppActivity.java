/* 
 * This file is part of OppiaMobile - http://oppia-mobile.org/
 * 
 * OppiaMobile is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * OppiaMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with OppiaMobile. If not, see <http://www.gnu.org/licenses/>.
 */

package org.digitalcampus.oppia.monitor.activity;

import org.digitalcampus.oppia.monitor.R;
import org.digitalcampus.oppia.monitor.application.Header;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;

public class AppActivity extends Activity implements OnSharedPreferenceChangeListener {
	
	public static final String TAG = AppActivity.class.getSimpleName();
	
	private Header header;
	

	public void drawHeader() {
		try {
			header = (Header) findViewById(R.id.header);
			header.initHeader(this);
		} catch (NullPointerException npe) {
			// do nothing
		}
	}
	
	
	/**
	 * @param title
	 */
	public void drawHeader(String title) {
		try {
			header = (Header) findViewById(R.id.header);
			header.initHeader(this,title);
		} catch (NullPointerException npe) {
			// do nothing
		}
	}
	
	public Header getHeader(){
		return this.header;
	}
	
	public void updateHeader(){
		try {
			header.updateHeader(this);
		} catch (Exception npe) {
			// do nothing
		}
	}



	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
		if(key.equalsIgnoreCase(getString(R.string.prefs_points)) || key.equalsIgnoreCase(getString(R.string.prefs_points))){
			this.updateHeader();
		}
		
	}

}
