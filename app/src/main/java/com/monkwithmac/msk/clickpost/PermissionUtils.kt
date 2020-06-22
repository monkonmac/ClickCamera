package com.monkwithmac.msk.clickpost

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat

class PermissionUtils {

    companion object{

        const val PERMISSION_ALL = 1

        //Use for core app permissions and replace the values for particular project
        private val PERMISSIONS = arrayOf(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.CAMERA
        )

        fun getPermissions(activity: Activity){
            permissionCheck(activity, PERMISSIONS, PERMISSION_ALL)
        }

        fun getPermissions(activity: Activity, permissions: Array<String>, requestCode: Int){
            permissionCheck(activity, permissions, requestCode)
        }

        private fun permissionCheck(
            activity: Activity,
            permissions: Array<String>,
            requestCode: Int
        ) {

            if (!hasPermissions(activity, PERMISSIONS)) {
                ActivityCompat.requestPermissions(activity, permissions, requestCode)
            }
        }

        private fun hasPermissions(context: Context?, permissions: Array<String>?): Boolean {
            if (context != null && permissions != null) {
                for (permission in permissions) {
                    if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                        return false
                    }
                }
                return true
            }
            return false
        }
    }
}