@echo off
chcp 65001 >nul & cls
echo.
echo [信息] 复制文件到Docker目录
echo.

%~d0
cd %~dp0

cd ..
echo 编译后端
start /wait cmd /c "mvn clean package -P prod -Dmaven.test.skip=true"
echo 编译前端
cd witos-ui
start /wait cmd /c "npm install"
start /wait cmd /c "npm run build:prod"
cd ..\docker

echo 复制 sql
xcopy ..\sql\witos_platform.sql .\mysql\db  /y
xcopy ..\sql\witos_config.sql .\mysql\db  /y

echo 复制 html
xcopy ..\witos-ui\dist .\nginx\html\dist  /s /e /y

echo 复制 witos-nacos
xcopy ..\witos-register\target\witos-register.jar .\nacos\jar  /y

echo 复制 witos-gateway
xcopy ..\witos-gateway\target\witos-gateway.jar .\witos\gateway\jar  /y

echo 复制 witos-auth
xcopy ..\witos-auth\target\witos-auth.jar .\witos\auth\jar  /y

echo 复制 witos-demo
xcopy ..\witos-demo\target\witos-demo.jar .\witos\demo\jar  /y

echo 复制 witos-monitor
xcopy ..\witos-visual\witos-monitor\target\witos-monitor.jar  .\witos\visual\monitor\jar  /y

echo 复制 witos-system
xcopy ..\witos-modules\witos-system\target\witos-system.jar .\witos\modules\system\jar  /y

echo 复制 witos-file
xcopy ..\witos-modules\witos-file\target\witos-file.jar .\witos\modules\file\jar  /y

echo 复制 witos-gen
xcopy ..\witos-modules\witos-gen\target\witos-gen.jar .\witos\modules\gen\jar  /y

echo 复制 witos-job
xcopy ..\witos-modules\witos-job\target\witos-job.jar .\witos\modules\job\jar  /y

pause
