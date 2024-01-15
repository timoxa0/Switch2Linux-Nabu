# Linux switch for Mi Pad 5 ([Windows Switch](https://github.com/entaromia/mi-pad5-windows-switch) fork) ([RU](./README-RU.md))


## Differences from original windows switch
- Added quick settings tile
- Added ability to dump android images
- Cleans dtbo on reboot


## Pre-requirements
- Rooted android
- Already installed linux


## Installation

### Android side:
1) Flash `vbmeta_disabled.img` via fastboot
   ```console
   fastboot flash vbmeta_ab <path/to/vbmeta_disabled.img> 
   ```
   > [!Warning]\
   > This may result in the need to wipe data in recovery.

2) Install `linuxswitch.apk` from [Releases](https://github.com/timoxa0/Switch2Linux-Nabu/releases)
3) Open installed app and grant root access
4) Open app again and tap "Dump android images"
5) Move `android.boot.img` and `andoid.dtbo.img` to PC from `/sdcard/linux/`
6) Rename linux boot to `linux.boot.img` and put it to `/sdcard/linux/`
7) Now you can tap "Switch to Linux" to boot linux

### Linux side:
1) Download `s2a.zip` from [Releases](https://github.com/timoxa0/Switch2Linux-Nabu/releases)
2) Unzip `s2a.zip` in linux
3) Put `android.boot.img` and `andoid.dtbo.img` into `s2a` folder
4) Install with command
    ```console
    sudo ./install.sh
    ```
5) Now you can reboot to android with Switch2Android app
