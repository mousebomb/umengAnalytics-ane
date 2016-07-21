package org.mousebomb.ane.umeng;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREObject;
import com.adobe.fre.FREWrongThreadException;

/**
 * Created by rhett on 16/5/14.
 */
public class UmengPauseFunction extends BaseFunction {


    private static final String TAG = "UmengPauseFunction";

    @Override
    public FREObject call(FREContext context, FREObject[] args) {
        super.call(context, args);
        try {
            UmengExtension.context.onPause();
            return FREObject.newObject(true);
        } catch (FREWrongThreadException e) {
            e.printStackTrace();
            return null;
        }
    }
}
