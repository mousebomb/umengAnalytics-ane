//////////////////////////////////////////////////////////////////////////////////////
//
//  Copyright 2012 Freshplanet (http://freshplanet.com | opensource@freshplanet.com)
//  
//  Licensed under the Apache License, Version 2.0 (the "License");
//  you may not use this file except in compliance with the License.
//  You may obtain a copy of the License at
//  
//    http://www.apache.org/licenses/LICENSE-2.0
//  
//  Unless required by applicable law or agreed to in writing, software
//  distributed under the License is distributed on an "AS IS" BASIS,
//  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//  See the License for the specific language governing permissions and
//  limitations under the License.
//  
//////////////////////////////////////////////////////////////////////////////////////

package org.mousebomb.ane.umeng;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;
import com.umeng.analytics.MobclickAgent;

public class UmengExtension implements FREExtension
{
	
	public static String TAG = "8d5MD1XV";
	private static Boolean PRINT_LOG = true;
	
	public static UmengExtensionContext context;

	public FREContext createContext(String extId)
	{
		Log.d(TAG, "createContext: "+extId);
		return context = new UmengExtensionContext();
	}

	public void dispose()
	{
		context = null;
	}
	
	public void initialize() {
		Log.d(TAG,"initialize");
	}
	
	public static void log(String message)
	{
		if (PRINT_LOG) Log.d(TAG, message);
		if (context != null && message != null) context.dispatchStatusEventAsync("LOGGING", message);
	}
}
