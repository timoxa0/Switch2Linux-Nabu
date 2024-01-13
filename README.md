# Linux switch for Mi Pad 5 ([Windows Switch](https://github.com/entaromia/mi-pad5-windows-switch) fork)


## Differences from original windows switch
- Added Quick Settings tile
- Added ability to dump android images
- Cleans dtbo on reboot


## Prerequirements
- Rooted android
- Already installed linux


## Intallation

### Android side:
1) Install `linuxswitch.apk` from [Releases](https://github.com/timoxa0/Switch2Linux-Nabu/releases)
2) Open installed app and grant root access
3) Place images:
   ```
   linux boot.img      -> /sdcard/linux/linux.boot.img
   vbmeta_disabled.img -> /sdcard/linux/linux.vbmeta.img
   ```
 4) Open app again and tap "Dump android images"
 5) Move `android.boot.img` and `android.dtbo.img` to PC from `/sdcard/linux/`
 6) Done

### Linux side:
1) Download `s2a.zip` from [Releases](https://github.com/timoxa0/Switch2Linux-Nabu/releases)
2) Unzip `s2a.zip` in linux
3) Put `android.boot.img` and `andoid.dtbo.img` into `s2a` folder
4) Install with command
    ```console
    sudo ./install.sh
    ```
5) Done
