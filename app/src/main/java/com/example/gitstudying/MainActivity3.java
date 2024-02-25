package com.example.gitstudying;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.gitstudying.media.RtcTokenBuilder2;

import io.agora.rtc2.ChannelMediaOptions;
import io.agora.rtc2.Constants;
import io.agora.rtc2.IRtcEngineEventHandler;
import io.agora.rtc2.RtcEngine;
import io.agora.rtc2.RtcEngineConfig;
import io.agora.rtc2.video.VideoCanvas;

public class MainActivity3 extends AppCompatActivity {
    private String appCertificate = "c27860bef5b24a1bb1bcdcc8c8f0d7c9";
    private String appId = "61b6251f1ffa47c68cf62dccb782be2c";
    private String channelName = "test";
    private String token = "007eJxTYFgh5X1SLkNO7fT1v5F3GwRcyz2aVrzYseriKse1GoLath4KDGaGSWZGpoZphmlpiSbmyWYWyWlmRinJyUnmFkZJqUbJHqy3UhsCGRmqri9gZWSAQBCfhaEktbiEgQEAInYfTw==";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        if(!checkSelfPermission()){
            ActivityCompat.requestPermissions(this,REQUESTED_PERMISSIONS, PERMISSION_REQ_ID);
        }
        setupVideoSDKEngine();
    }
    private static final int PERMISSION_REQ_ID = 22;
    private static final String[] REQUESTED_PERMISSIONS =
            {
                    android.Manifest.permission.RECORD_AUDIO,
                    android.Manifest.permission.CAMERA
            };

    private boolean checkSelfPermission()
    {
        if (ContextCompat.checkSelfPermission(this, REQUESTED_PERMISSIONS[0]) !=  PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, REQUESTED_PERMISSIONS[1]) !=  PackageManager.PERMISSION_GRANTED)
        {
            return false;
        }
        return true;
    }

    void showMessage(String message){
        runOnUiThread(()-> Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show());
    }

    private int uid = 3;

    private boolean isJoined = false;

    private RtcEngine agoraEngin;
    private SurfaceView localSurfaceView;
    private SurfaceView remoteSurfaceView;

    private void setupVideoSDKEngine(){
        try {
            RtcEngineConfig config = new RtcEngineConfig();
            config.mContext = getBaseContext();
            config.mAppId =appId;
            config.mEventHandler = mRtcHandler;
            agoraEngin = RtcEngine.create(config);
            agoraEngin.enableVideo();
            agoraEngin.enableAudio();

        }catch (Exception e){
            showMessage(e.toString());
        }
    }

    private final IRtcEngineEventHandler mRtcHandler = new IRtcEngineEventHandler() {
        @Override
        public void onUserJoined(int uid, int elapsed) {
            super.onUserJoined(uid, elapsed);
            showMessage("Remote user joined "+uid);
            runOnUiThread(()->setupRemoteVideo(uid));
        }

        @Override
        public void onJoinChannelSuccess(String channel, int uid, int elapsed) {
            super.onJoinChannelSuccess(channel, uid, elapsed);
            isJoined = true;
            showMessage("Joined Channel "+channel);
        }

        @Override
        public void onUserOffline(int uid, int reason) {
            super.onUserOffline(uid, reason);

            showMessage("Remote user offline "+uid +" "+reason);
            runOnUiThread(()->remoteSurfaceView.setVisibility(View.GONE));
        }
    };

    private void setupRemoteVideo(int uid) {
        FrameLayout container = findViewById(R.id.remoteVideo);
        remoteSurfaceView = new SurfaceView(getBaseContext());
        remoteSurfaceView.setZOrderMediaOverlay(true);
        container.addView(remoteSurfaceView);
        agoraEngin.setupRemoteVideo(new VideoCanvas(remoteSurfaceView, VideoCanvas.RENDER_MODE_FIT, uid));
        remoteSurfaceView.setVisibility(View.VISIBLE);
    }

    private void setupLocalVideo(){
        FrameLayout container = findViewById(R.id.localVideo);
        localSurfaceView = new SurfaceView(getBaseContext());
        container.addView(localSurfaceView);
        agoraEngin.setupLocalVideo(new VideoCanvas(localSurfaceView, VideoCanvas.RENDER_MODE_HIDDEN, 0));
    }

    public void joinChannel(View view){
        if(checkSelfPermission()){
            ChannelMediaOptions options = new ChannelMediaOptions();
            options.channelProfile = Constants.CHANNEL_PROFILE_COMMUNICATION;
            options.clientRoleType = Constants.CLIENT_ROLE_BROADCASTER;
            setupLocalVideo();
            localSurfaceView.setVisibility(View.VISIBLE);
            agoraEngin.startPreview();
            agoraEngin.joinChannel(token,channelName,uid,options);

        }else {
            showMessage("Permission was not granted");
        }
    }

    public void leaveChannel(View view){
        if(!isJoined){
            showMessage("Join a channel first");
        }else{
            agoraEngin.leaveChannel();
            showMessage("You left channel");
            if(remoteSurfaceView != null) remoteSurfaceView.setVisibility(View.GONE);
            if(localSurfaceView != null) localSurfaceView.setVisibility(View.GONE);
        }
    }
    public void generateToken() {
        RtcTokenBuilder2 tokenBuilder = new RtcTokenBuilder2();
        long expirationTimeInSeconds = 3600;
        int timestamp = (int) (System.currentTimeMillis() / 1000 + expirationTimeInSeconds);
        System.out.println("UID token");
        String result = tokenBuilder.buildTokenWithUid(
                appId, appCertificate,
                channelName, uid, RtcTokenBuilder2.Role.ROLE_PUBLISHER, timestamp, timestamp
        );
        System.out.println("The new Token Is - " + result);
        token = result;
        joinChannel();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        agoraEngin.stopPreview();
        agoraEngin.leaveChannel();

        new Thread(()->{
            RtcEngine.destroy();
            agoraEngin = null;
        }).start();
    }
}