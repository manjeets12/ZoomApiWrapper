
package com.reactlibrary;

import android.util.Log;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import us.zoom.sdk.MeetingError;
import us.zoom.sdk.MeetingEvent;
import us.zoom.sdk.MeetingService;
import us.zoom.sdk.MeetingServiceListener;
import us.zoom.sdk.StartMeetingOptions;
import us.zoom.sdk.ZoomError;
import us.zoom.sdk.ZoomSDK;
import us.zoom.sdk.ZoomSDKInitializeListener;

public class RNZoomApiWrapperModule extends ReactContextBaseJavaModule implements ZoomSDKInitializeListener, MeetingServiceListener {

  private final ReactApplicationContext reactContext;
  private ZoomSDK sdk;
  private MeetingService meetingService;
  private final static int STYPE = MeetingService.USER_TYPE_API_USER;
  private final static String TAG = "Zoom SDK Example";

  public RNZoomApiWrapperModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNZoomApiWrapper";
  }
  @ReactMethod
  public void initZoomSdk(String APP_KEY, String APP_SECRET, String WEB_DOMAIN) {
    initSdk(APP_KEY, APP_SECRET, WEB_DOMAIN);
  }

  @ReactMethod
  public void starMeeting(String USER_ID, String ZOOM_TOKEN, String MEETING_ID){
    //MeetingOptions options = new MeetingOptions();
    StartMeetingOptions options = new StartMeetingOptions();
    //options.no_driving_mode = true;
    //options.no_meeting_end_message = true;
    //options.no_titlebar = true;
    //options.no_bottom_toolbar = true;
    //options.no_invite = true;
    //int ret = meetingService.startMeeting(this, "3604510500", options);
    int ret = meetingService.startMeeting(this.getCurrentActivity(), USER_ID, ZOOM_TOKEN, STYPE, MEETING_ID, "Manjeet Testing", options);
    Log.i("meeting start response", "onClickBtnStartMeeting, ret=" + ret);
  }

  private void initSdk(String APP_KEY, String APP_SECRET, String WEB_DOMAIN) {
    sdk= ZoomSDK.getInstance();
    if(!sdk.isInitialized()){
      sdk.initialize(this.getCurrentActivity(),APP_KEY, APP_SECRET, WEB_DOMAIN, this);
    }else {
      startMeetingService();
    }
  }

  private void startMeetingService() {
    meetingService = sdk.getMeetingService();
    if(meetingService !=null) meetingService.addListener(this);
  }

  @Override
  public void onZoomSDKInitializeResult(int errorCode, int internalErrorCode) {
    if(errorCode != ZoomError.ZOOM_ERROR_SUCCESS){
      Toast.makeText(getCurrentActivity(),"Failed to load zoom sdk Error:- "+errorCode +
              ", internalErrorCode = "+internalErrorCode, Toast.LENGTH_LONG).show();
    }else {
      Toast.makeText(getCurrentActivity(), "Initialized zoom sdk successfully.", Toast.LENGTH_LONG).show();
      sdk= ZoomSDK.getInstance();
      startMeetingService();
    }
  }

  @Override
  public void onMeetingEvent(int meetingEvent, int errorCode, int internalErrorCode) {
    Log.i(TAG, "onMeetingEvent, meetingEvent=" + meetingEvent + ", errorCode=" + errorCode
            + ", internalErrorCode=" + internalErrorCode);

    if(meetingEvent == MeetingEvent.MEETING_CONNECT_FAILED && errorCode == MeetingError.MEETING_ERROR_CLIENT_INCOMPATIBLE) {
      Toast.makeText(getCurrentActivity(), "Version of ZoomSDK is too low!", Toast.LENGTH_LONG).show();
    }
  }
}