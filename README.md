# Africa Bus System (Maven WAR + Nexus + SonarQube)
See README in chat for full instructions. Build: `mvn clean verify`. Deploy WAR to Tomcat `webapps/`. Run Sonar with `mvn -P sonar clean verify sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=TOKEN`.
