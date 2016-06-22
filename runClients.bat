@echo off
FOR /f "delims=" %%i IN ('type jars\clients.txt') DO (
start %%i
)
pause