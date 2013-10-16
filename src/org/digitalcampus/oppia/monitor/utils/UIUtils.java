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

package org.digitalcampus.oppia.monitor.utils;

import java.util.concurrent.Callable;

import org.digitalcampus.oppia.monitor.R;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;

public class UIUtils {

	public final static String TAG = UIUtils.class.getSimpleName();
	private SharedPreferences prefs;
	private Context ctx;
	

	/**
	 * @param ctx
	 * @param title
	 * @param msg
	 * @return
	 */
	public static AlertDialog showAlert(Context ctx, int title, int msg) {
		return UIUtils.showAlert(ctx, ctx.getString(title), ctx.getString(msg));
	}

	/**
	 * @param ctx
	 * @param R
	 * @param msg
	 * @return
	 */
	public static AlertDialog showAlert(Context ctx, int R, String msg) {
		return UIUtils.showAlert(ctx, ctx.getString(R), msg);
	}

	/**
	 * @param ctx
	 * @param title
	 * @param msg
	 * @return
	 */
	public static AlertDialog showAlert(Context ctx, String title, String msg) {
		AlertDialog alertDialog = new AlertDialog.Builder(ctx).create();
		alertDialog.setTitle(title);
		alertDialog.setMessage(msg);
		alertDialog.setButton(ctx.getString(R.string.close), new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				dialog.cancel();
			}
		});
		alertDialog.show();
		return alertDialog;
	}

	/**
	 * @param ctx
	 * @param title
	 * @param msg
	 * @param funct
	 * @return
	 */
	public static AlertDialog showAlert(Context ctx, int title, int msg, Callable<Boolean> funct) {
		return UIUtils.showAlert(ctx, ctx.getString(title), ctx.getString(msg), funct);
	}

	/**
	 * @param ctx
	 * @param R
	 * @param msg
	 * @param funct
	 * @return
	 */
	public static AlertDialog showAlert(Context ctx, int R, CharSequence msg, Callable<Boolean> funct) {
		return UIUtils.showAlert(ctx, ctx.getString(R), msg, funct);
	}

	/**
	 * @param ctx
	 * @param title
	 * @param msg
	 * @param funct
	 * @return
	 */
	public static AlertDialog showAlert(Context ctx, String title, CharSequence msg, final Callable<Boolean> funct) {
		AlertDialog alertDialog = new AlertDialog.Builder(ctx).create();
		alertDialog.setTitle(title);
		alertDialog.setMessage(msg);
		alertDialog.setCancelable(true);
		alertDialog.setButton(ctx.getString(R.string.close), new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				dialog.cancel();
			}
		});
		alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
			public void onCancel(DialogInterface dialog) {
				try {
					funct.call();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		alertDialog.show();
		return alertDialog;
	}
	
}
