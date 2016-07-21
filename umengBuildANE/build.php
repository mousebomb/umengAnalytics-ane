<?php 
define("C",dirname(__FILE__));
define("T",C."/temp");
define("F",dirname(dirname(__FILE__)));
define("AAR_PATH",F."/umengJava/umeng/app/build/outputs/aar/app-debug.aar");
define("SWF_PATH",F."/umengAS/out/umengAS.swc");
function delDirAndFile( $dirName )
{
    if ( $handle = opendir( "$dirName" ) ) {
        while ( false !== ( $item = readdir( $handle ) ) ) {
            if ( $item != "." && $item != ".." ) {
                if ( is_dir( "$dirName/$item" ) ) {
                    delDirAndFile( "$dirName/$item" );
                } else {
                    unlink( "$dirName/$item" ) ;
                }
            }
        }
        closedir( $handle );
        rmdir( $dirName );
    }
}

if(file_exists(T))
{
delDirAndFile(T);
}
mkdir(T);
@mkdir(T."/android");
@mkdir(T."/default");
@mkdir(T."/android/res");
@mkdir(T."/android/res/values");
@mkdir(T."/default/res");
copy(C."/sb.xml", T."/android/res/values/sb.xml");
copy(AAR_PATH, T."/lib.aar");
copy(SWF_PATH, T."/lib.swc");

// jar
exec ( sprintf("unzip -o %s -d %s" , T."/lib.aar" , T."/"));
rename(T."/classes.jar",T."/android/libUmeng.jar");
copy(C."/umeng-analytics-v6.0.1.jar",T."/android/umeng-analytics-v6.0.1.jar");
copy(C."/utdid4all-1.0.4.jar",T."/android/utdid4all-1.0.4.jar");
copy(C."/android-support-v4.jar",T."/android/android-support-v4.jar");
// swf 
exec ( sprintf("unzip -o %s -d %s" , T."/lib.swc" , T."/"));
copy(T."/library.swf",T."/android/library.swf");
rename(T."/library.swf",T."/default/library.swf");

$cmd = sprintf("/Users/rhett/MyWork/sdks/FlexSDK/4.6.0_AIR17/bin/adt -package -target ane %s.ane extension.xml -swc %s -platform Android-ARM -platformoptions platform-android.xml -C %s . -platform default -C %s .", "Umeng", T."/lib.swc",T."/android/",T."/default/");
#$cmd = sprintf("/Users/rhett/MyWork/sdks/FlexSDK/4.6.0_AIR17/bin/adt -package -target ane %s.ane extension.xml -swc %s -platform Android-ARM -platformoptions platform-android.xml %s %s %s -C %s . -platform default -C %s .", "Umeng", T."/lib.swc",C."/umeng-analytics-v6.0.1.jar",C."/android-support-v4.jar",C."/utdid4all-1.0.4.jar",T."/android/",T."/default/");
//$cmd = sprintf("/Users/rhett/MyWork/sdks/FlexSDK/4.6.0_AIR17/bin/adt -package -target ane %s.ane extension.xml -swc %s -platform Android-ARM   -C %s . -platform default -C %s .", "Umeng", T."/lib.swc",T."/android/",T."/default/");
echo $cmd."\n";
exec($cmd);
copy(C."/Umeng.ane", F."/umengTest/Umeng.ane");
echo "已经拷贝到" . F."/umengTest/Umeng.ane \n";



?>