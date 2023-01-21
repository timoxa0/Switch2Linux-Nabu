package me.entaromia.windowsswitch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.topjohnwu.superuser.Shell

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonWindows = findViewById<Button>(R.id.buttonwindows)

        Shell.getShell()

        if (Shell.isAppGrantedRoot() == true) {
            buttonWindows.isEnabled = true
        } else {
            finish()
        }


        buttonWindows.setOnClickListener {
            Log.e("WindowsSwitch","switching to windows")

            if (Shell.cmd("getprop ro.boot.slot_suffix").exec().out.contains("_a")) {
                Log.e("WindowsSwitch", "slot a")
                Shell.cmd("dd if=/sdcard/windows/boot.img of=/dev/block/sde14 bs=16M", "sleep 1", "svc power reboot").exec()
            } else if (Shell.cmd("getprop ro.boot.slot_suffix").exec().out.contains("_b")) {
                Log.e("WindowsSwitch", "slot b")
                Shell.cmd("dd if=/sdcard/windows/boot.img of=/dev/block/sde37 bs=16M", "sleep 1", "svc power reboot").exec()
            }
        }
    }
}