@echo off
echo.
echo [信息] 使用Jar命令运行Monitor工程。
echo.

cd %~dp0
cd ../witos-visual/witos-monitor/target

set JAVA_OPTS=-Xms256m -Xmx512m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=256m

java -Dfile.encoding=utf-8 %JAVA_OPTS% -jar witos-visual-monitor.jar

cd bin
pause
