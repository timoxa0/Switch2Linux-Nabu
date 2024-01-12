# Linux switch for Mi Pad 5 ([Windows Switch](https://github.com/entaromia/mi-pad5-windows-switch) fork)

## Differences from original windows switch
- Added Quick Settings tile
- Added ability to dump android images
- Flashes dtbo with boot

## Installation
1) Install app from [Releases](https://github.com/timoxa0/Switch2Linux-Nabu/releases)
2) Open app and grant root access
3) Tap "Dump android images"
4) Move `android.boot.img` and `android.dtbo.img` to PC from `/sdcard/linux/`
5) Place images:
   ```
   linux boot.img      -> /sdcard/linux/linux.boot.img
   vbmeta_disabled.img -> /sdcard/linux/linux.vbmeta.img
   ```
6) Tap "Switch to Linux"
7) Download s2a.zip from [Releases](https://github.com/timoxa0/Switch2Linux-Nabu/releases)
8) Unzip s2a.zip in linux
9) Place `android.boot.img` and `andoid.dtbo.img` to `s2a` folder
10) Install switcher
    ```console
    sudo ./install.sh
    ```
11) Run Switch2Android and enter your password

![Screenshot](./assets/screenshot.jpg "screenshot")
