#!/bin/sh

# 复制项目的文件到对应docker路径，便于一键生成镜像。
usage() {
	echo "Usage: sh copy.sh"
	exit 1
}

echo "begin package "
#打包开始
cd ..
mvn clean install -Dmaven.test.skip=true
#前端
cd ./witos-ui
npm install --registry=https://registry.npmmirror.com
npm run build:prod
cd ../docker
# copy sql
echo "begin copy sql "
cp ../sql/witos_platform.sql ./mysql/db
cp ../sql/witos_config.sql ./mysql/db

# copy html
echo "begin copy html "
rm -rf ./nginx/html/dist
cp -rp ../witos-ui/dist/** ./nginx/html/dist


# copy jar
echo "begin copy witos-register "
cp ../witos-register/target/witos-gateway.jar ./nacos/jar

echo "begin copy witos-gateway "
cp ../witos-gateway/target/witos-gateway.jar ./witos/gateway/jar

echo "begin copy witos-auth "
cp ../witos-auth/target/witos-auth.jar ./witos/auth/jar

echo "begin copy witos-demo "
cp ../witos-demo/target/witos-demo.jar ./witos/demo/jar

echo "begin copy witos-monitor "
cp ../witos-visual/witos-monitor/target/witos-monitor.jar  ./witos/visual/monitor/jar

echo "begin copy witos-system "
cp ../witos-modules/witos-system/target/witos-system.jar ./witos/modules/system/jar

echo "begin copy witos-file "
cp ../witos-modules/witos-file/target/witos-file.jar ./witos/modules/file/jar

echo "begin copy witos-gen "
cp ../witos-modules/witos-gen/target/witos-gen.jar ./witos/modules/gen/jar

echo "begin copy witos-job "
cp ../witos-modules/witos-job/target/witos-job.jar ./witos/modules/job/jar

