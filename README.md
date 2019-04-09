# ClaudioRemote
Simple android App to show Claudio remote configuration capabilities

## Setup
Once the .apk file has been generated with Android Studio and installed on the Android device an icon launcher like the one below should appear on the screen.

![Claudio Remote Icon Launcher](https://raw.githubusercontent.com/pangodream/ClaudioRemote/master/screenshots/ClaudioRemoteLauncherIcon.jpg)

Open the app and it will try to connect to the remote Claudio system though it is imposible as there's no information about the host IP address and port.

Every time the connection doesn't succeed, the Host Configuration screen is automatically opened.

![Claudio Remote Host Configuration](https://raw.githubusercontent.com/pangodream/ClaudioRemote/master/screenshots/ClaudioRemoteConfiguration.jpg)

Simply specify the IP address and port of the Claudio Remote system and press on 'Aceptar'

The app will try now to reconnect, and if it reaches out the Claudio system it wil load the main screen, otherwise the Host Configuration screen will be reloaded.

## Main screen
The app is just a POC of Claudio remote configuration capabilities, so the design it is not sophisticated at all.

![Claudio Remote Main Screen](https://raw.githubusercontent.com/pangodream/ClaudioRemote/master/screenshots/ClaudioRemoteMainActivity.jpg)

Try to change values and as soon as you leave the textbox you are changing, the value should be sent to Claudio.

For instance, try to change the alarm hour box and get focus on minutes box. The hour you typed should be now in Claudio system.

Detailed configuration for each of the values will be provided, but taking a look to the Arduino .ino source files it is easy to imagine the purpose of each parameter.

Claudio Arduino code: https://github.com/pangodream/Claudio
