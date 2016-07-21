/**
 * Created by rhett on 16/5/14.
 */
package org.mousebomb.ane.umeng
{

	import flash.desktop.NativeApplication;
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	import flash.events.InvokeEvent;
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;
	import flash.system.Capabilities;

	public class Umeng extends EventDispatcher
	{
		private static const EXTENSION_ID : String = "org.mousebomb.ane.umengAndroid";

		private static var _instance : Umeng;

		private var _context : ExtensionContext;

		public static function get isSupported() : Boolean
		{
			return  Capabilities.manufacturer.indexOf("Android") > -1;
		}
		private function log( message : String ) : void
		{
			if (_logEnabled) trace("[umeng] " + message);
		}
		private var _logEnabled : Boolean = false;
		public function Umeng()
		{
			if (!_instance)
			{
				_context = ExtensionContext.createExtensionContext(EXTENSION_ID, null);
				if (!_context)
				{
					throw Error("ERROR - Extension context is null. Please check if extension.xml is setup correctly.");
					return;
				}

				_instance = this;
			}
			else
			{
				throw Error("This is a singleton, use getInstance(), do not call the constructor directly.");
			}
		}

		public static function getInstance() : Umeng
		{
			return _instance ? _instance : new Umeng();
		}

		/**
		 * If <code>true</code>, logs will be displayed at the Actionscript level.
		 * If <code>false</code>, logs will be displayed only at the native level.
		 */
		public function get logEnabled() : Boolean
		{
			return _logEnabled;
		}

		public function set logEnabled( value : Boolean ) : void
		{
			_logEnabled = value;
		}

		public function setDebugMode( b:Boolean ):Boolean
		{
			return _context.call("setDebugMode",b) as Boolean;
		}
		public function onResume() : Boolean
		{
			return _context.call('onResume') as Boolean;
		}
		public function onPause() : Boolean
		{
			return _context.call('onPause') as Boolean;
		}


	}
}
