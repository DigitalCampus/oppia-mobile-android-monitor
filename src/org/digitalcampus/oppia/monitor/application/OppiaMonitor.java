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

package org.digitalcampus.oppia.monitor.application;

import org.digitalcampus.oppia.monitor.R;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class OppiaMonitor extends Application {

	public static final String TAG = OppiaMonitor.class.getSimpleName();
	public static final String BUGSENSE_API_KEY = "9622b59e";
	
	public static final String USER_AGENT = "OppiaMobile Monitor Android: ";

	public static final String OPPIAMOBILE_API = "api/v1/";
	public static final String LOGIN_PATH = OPPIAMOBILE_API + "user/";
	
	public static boolean isLoggedIn(Activity act) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(act.getBaseContext());
		String username = prefs.getString(act.getString(R.string.prefs_username), "");
		String apiKey = prefs.getString(act.getString(R.string.prefs_api_key), "");
		if (username.trim().equals("") || apiKey.trim().equals("")) {
			return false;
		} else {
			return true;
		}
	}
}
