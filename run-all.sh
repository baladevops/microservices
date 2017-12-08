@echo off
echo "Building All projects"
cd EServerTest
mvn clean package
cd ../ZuulServer
mvn clean package
cd ../HystrixDashboard
mvn clean package
cd ../NetflixTurbineServer
mvn clean package
cd ../ForecastMicroService
mvn clean package
cd ../WeatherMicroService
mvn clean package
cd ../WeatherMCompositeService
mvn clean package
echo "\n\nCleaned and repackaged ALL"
