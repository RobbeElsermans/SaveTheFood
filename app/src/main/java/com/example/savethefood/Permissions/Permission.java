package com.example.savethefood.Permissions;

import android.Manifest;
import android.app.Activity;
import android.content.Context;

import com.example.savethefood.R;

import pub.devrel.easypermissions.EasyPermissions;

public class Permission {

    private Context activity;
    public Permission(Context activity)
    {
        this.activity = activity;
    }
    public boolean hasPermissionCamera() {
        return EasyPermissions.hasPermissions(activity, Manifest.permission.CAMERA);
    }
    public boolean hasPermissionInternet() {
        return EasyPermissions.hasPermissions(activity, Manifest.permission.INTERNET);
    }
    public boolean hasPermissionWriteStorage(){
        return EasyPermissions.hasPermissions(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }
    public void requestPermission(String text, int permissionID, String type)
    {
        EasyPermissions.requestPermissions((Activity) activity, text, permissionID, type);
    }
}
