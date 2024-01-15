# Linux switch для Mi Pad 5 (форк [Windows Switch](https://github.com/entaromia/mi-pad5-windows-switch))


## Отличия от Windows Switch
- Добавлена кнопка в быстрые настройки
- Добавлена возможность сохранить boot и dtbo от android
- Очищает dtbo при перезагрузке в linux


## Требования:
- Рутированный android
- Уже установленный linux


## Установка

### Android:
1) Прошейте `vbmeta_disabled.img` через fastboot
   ```console
   fastboot flash vbmeta_ab <path/to/vbmeta_disabled.img> 
   ```
> [!Warning]\
> Данное дейставие может привести к необходимости wipe data в recovery

2) Установите последнюю версию `linuxswitch.apk` с [релиза](https://github.com/timoxa0/Switch2Linux-Nabu/releases)
3) Запустите приложение и предоставьте root доступ
4) Нажмите "Dump android images"
5) Достаньте `android.boot.img` и `andoid.dtbo.img` из `/sdcard/linux/`
6) Назовите boot от linux `linux.boot.img` и положите в `/sdcard/linux/`
7) Перезагрузитесь в linux, нажав "Switch to Linux"

### Linux:
1) Скачайте последнюю версию `s2a.zip` с [релиза](https://github.com/timoxa0/Switch2Linux-Nabu/releases)
2) Распакуйте `s2a.zip` в linux
3) Положите `android.boot.img` и `andoid.dtbo.img` в папку `s2a`
4) Запустите терминал в папку с `install.sh` и выполните команду
    ```console
    sudo ./install.sh
    ```
5) Перезагрузитесь в android, запустив "Switch2Android" и меню приложений
