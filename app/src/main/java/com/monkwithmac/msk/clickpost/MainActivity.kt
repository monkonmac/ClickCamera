package com.monkwithmac.msk.clickpost

import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.speech.SpeechRecognizer
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PermissionUtils.getPermissions(this)
        supportFragmentManager.beginTransaction()
            .add(R.id.container, CameraFragment.newInstance())
            .commit()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if(requestCode == PermissionUtils.PERMISSION_ALL) {
            for (result in grantResults) {
                if (result == PackageManager.PERMISSION_DENIED) {
                    //TODO Replace with callback handling
                    finish()
                }
            }
        }
    }
}
