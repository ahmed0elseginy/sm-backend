
@echo off

:: Change directory to the location of the .bat file
cd /d %~dp0
cd ../../post-mgt/

CALL mvn generate-sources -Pservice-swagger

pause 