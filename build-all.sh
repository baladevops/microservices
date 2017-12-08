@echo off
echo "Building All projects"
lxterminal -t "Eureka Server"  -e "mvn -f EServerTest spring-boot:run  " &
lxterminal -t "Zuul Server"  -e "mvn -f ZuulServer spring-boot:run " &
lxterminal  -t "Hystrix Dashboard"  -e "mvn -f HystrixDashboard spring-boot:run " &
lxterminal  -t "Netflix Turbine"	-e "mvn -f NetflixTurbineServer  spring-boot:run " &
lxterminal  -t "Forecast Microservice"	-e "mvn -f ForecastMicroService spring-boot:run " &
lxterminal -t "Weather Microservice"	-e "mvn -f WeatherMicroService spring-boot:run " &
lxterminal -t "Weather Composite Microservice"	-e "mvn -f WeatherMCompositeService spring-boot:run " &

echo -e "\n\nCleaned and repackaged ALL"
