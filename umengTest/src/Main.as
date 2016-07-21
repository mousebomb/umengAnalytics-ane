package {


    import flash.desktop.NativeApplication;
    import flash.display.Sprite;
    import flash.events.Event;
    import flash.text.TextField;
    import flash.text.TextFieldAutoSize;
    import flash.text.TextFormat;

    import org.mousebomb.ane.umeng.Umeng;

    public class Main extends Sprite
    {
        private var tf:TextField;

        public function Main()
        {
            super();

            tf = new TextField();
            var dtf:TextFormat = new TextFormat( "Tahoma", 80, 0xff0000 );
            tf.defaultTextFormat = dtf;
            tf.autoSize = TextFieldAutoSize.LEFT;
            addChild( tf );
//            var sign = GetSign.getInstance().getSign();
//            if( sign == 0 )
//            {
//                tf.text = "NULL";
//            } else
//            {
//                tf.text = sign.toString();
//            }
            NativeApplication.nativeApplication.addEventListener(Event.ACTIVATE, onActivate);
            NativeApplication.nativeApplication.addEventListener(Event.DEACTIVATE, onDeActivate);
            Umeng.getInstance().setDebugMode(false);
            tf.text = Umeng.getInstance().onResume()?"OK":"fail";
            trace("Main/Main() onResume");
        }

        private function onActivate( event:Event ):void
        {
            tf.text = Umeng.getInstance().onResume()?"OK":"fail";
trace("Main/onActivate()");
        }

        private function onDeActivate( event:Event ):void
        {
            tf.text = Umeng.getInstance().onPause()?"OK":"fail";
trace("Main/onDeActivate()");
        }


    }
}
