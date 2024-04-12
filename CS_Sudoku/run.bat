@echo off
for %%i in (*.jar) do (
    java -jar "%%i"
)
