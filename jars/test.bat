@echo off
FOR /f "delims=" %%i IN ('type serveurs.txt') DO (
start %%i
)
FOR /f "delims=" %%i IN ('type clients.txt') DO (
echo start %%i
)
pause