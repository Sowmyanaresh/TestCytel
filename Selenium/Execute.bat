cd %~dp0

cd screenshots
del *.png
cd %~dp0

Echo ***********************   Setting Up Environment   **********************

IF EXIST "target\surefire-reports\" GOTO Exist
mkdir "target\surefire-reports\"
:Exist

call mvn test