package org.mousebomb.ane.umeng;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREObject;
import com.adobe.fre.FREWrongThreadException;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by rhett on 16/5/14.
 */
public class UmengResumeFunction extends BaseFunction {


    private static final String TAG = "8d5MD1XV";

    @Override
    public FREObject call(FREContext context, FREObject[] args) {
        super.call(context, args);
        try {
            UmengExtension.context.onResume();
            return FREObject.newObject(true);
        } catch (FREWrongThreadException e) {
            Log.e(TAG, "call: FREWrong", e);
            e.printStackTrace();
            return null;
        }
    }
}
