package su.timoxa0.linuxswitch

import android.service.quicksettings.TileService
import com.topjohnwu.superuser.Shell

class QSTile: TileService() {
    override fun onClick() {
        super.onClick()
        Shell.getShell()

        if (Shell.isAppGrantedRoot() == true) {
            MainActivity.switch(applicationContext)
        } else {
            MainActivity.showToast("No root", applicationContext)
        }
    }
}
