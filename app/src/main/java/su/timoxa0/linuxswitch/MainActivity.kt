package su.timoxa0.linuxswitch

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.topjohnwu.superuser.Shell

class MainActivity : AppCompatActivity() {
    companion object {
        fun showToast(text: String, applicationContext: Context) {
            Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).show()
        }

        fun switch(applicationContext: Context) {
            Log.i("SwitchToLinux", "switching to linux")

            val suffix: String = Shell.cmd("getprop ro.boot.slot_suffix").exec().out[0].toString()

            showToast("Switching!", applicationContext)

            Shell.cmd(
                "dd if=/dev/zero of=/dev/block/bootdevice/by-name/dtbo$suffix",
                "dd if=/sdcard/linux/linux.boot.img of=/dev/block/bootdevice/by-name/boot$suffix",
                "dd if=/sdcard/linux/linux.vbmeta.img of=/dev/block/bootdevice/by-name/vbmeta$suffix",
                "sleep 1",
                "svc power reboot"
            ).exec()
        }
    }
    private fun isFileExist(path: String): Boolean {
        return if (path.endsWith("/")) {
            Shell.cmd("test -d %s".format(path)).exec().isSuccess
        } else {
            Shell.cmd("test -f %s".format(path)).exec().isSuccess
        }
    }

    @SuppressLint("SdCardPath", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonS2L = findViewById<Button>(R.id.button_switch)
        val buttonDump = findViewById<Button>(R.id.button_dump)
        val textSlot = findViewById<TextView>(R.id.text_slot)

        Shell.getShell()

        if (Shell.isAppGrantedRoot() == true) {

            val suffix: String = Shell.cmd("getprop ro.boot.slot_suffix").exec().out[0].toString()

            if (!isFileExist("/sdcard/linux/")) {
                Shell.cmd("mkdir /sdcard/linux/").exec()
            }
            if (!isFileExist("/sdcard/linux/linux.boot.img")) {
                showToast("linux.boot.img not found", applicationContext)
            } else {
                buttonS2L.isEnabled = true
            }

            textSlot.text = this.resources.getString(R.string.slot_text).format(suffix[1])

        } else {
            finish()
        }


        buttonS2L.setOnClickListener {
            switch(applicationContext)
            finish()
        }

        buttonDump.setOnClickListener {
            Log.i("SwitchToLinux","dumping images")
            val suffix: String = Shell.cmd("getprop ro.boot.slot_suffix").exec().out[0].toString()

            Shell.cmd(
                "dd if=/dev/block/bootdevice/by-name/dtbo$suffix of=/sdcard/linux/android.dtbo.img ",
                "dd if=/dev/block/bootdevice/by-name/boot$suffix of=/sdcard/linux/android.boot.img",
            ).exec()

            showToast("Android images dumped to /sdcard/linux/", applicationContext)
        }
    }
}