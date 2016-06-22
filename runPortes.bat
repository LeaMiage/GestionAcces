@echo off
FOR /f "delims=" %%i IN ('type jars\portes.txt') DO (
start %%i
)
pause