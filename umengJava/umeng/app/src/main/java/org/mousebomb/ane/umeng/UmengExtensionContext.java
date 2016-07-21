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
import com.adobe.fre.FREFunction;
import com.umeng.analytics.MobclickAgent;

import java.util.HashMap;
import java.util.Map;

public class UmengExtensionContext extends FREContext
{
	private static final String TAG ="8d5MD1XV" ;

	public UmengExtensionContext() {
		super();
	}

	@Override
	public void dispose()
	{
		UmengExtension.context = null;
	}

	@Override
	public Map<String, FREFunction> getFunctions()
	{
		Map<String, FREFunction> functions = new HashMap<String, FREFunction>();
		
		functions.put("onResume", new UmengResumeFunction());
		functions.put("onPause", new UmengPauseFunction());
		functions.put("setDebugMode", new UmengSetDebugModeFunction());

		return functions;
	}

	public void setDebugMode(Boolean b)
	{
		MobclickAgent.setDebugMode(b);
	}

	public void onResume()
	{
//		Log.d(TAG, "onResume() called with: " + "");
		try {
			MobclickAgent.onResume(getActivity());
		}catch (Throwable e)
		{
			Log.e(TAG, "onResume: ", e);
		}
	}

	public void onPause()
	{
		MobclickAgent.onPause(getActivity());
	}

}
