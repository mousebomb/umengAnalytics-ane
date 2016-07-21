package org.mousebomb.ane.umeng;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;

/**
 * Created by rhett on 16/5/14.
 */
public class UmengSetDebugModeFunction extends BaseFunction {


    private static final String TAG = "UmengSetDebugModeFunction";

    @Override
    public FREObject call(FREContext context, FREObject[] args) {
        super.call(context, args);
        Boolean isDebug;
        try {
            isDebug = args[0].getAsBool();
            UmengExtension.context.setDebugMode(isDebug);
            return FREObject.newObject(true);
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }
}
