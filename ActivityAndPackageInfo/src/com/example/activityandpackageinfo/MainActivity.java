package com.example.activityandpackageinfo;

import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		final PackageManager pm = getPackageManager();

		Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
		mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);

		List<ResolveInfo> appList = pm.queryIntentActivities(mainIntent, 0);
		Collections.sort(appList, new ResolveInfo.DisplayNameComparator(pm));

		for (ResolveInfo temp : appList) {

			Log.v("my logs", "package and activity name = "
					+ temp.activityInfo.packageName + "    "
					+ temp.activityInfo.name);

		}
		
	
	}

}
