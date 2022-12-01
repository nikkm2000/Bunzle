rem @echo off
rem for /f "tokens=1" %%P in ('findstr "IS_SHARE" %IS_HOME%\intershop.properties') do set %%P
set START_PIPELINE=https://accbunzlkingdrdoci.eperium.nl/INTERSHOP/web/WFS/Bunzl-King-Site/nl_NL/DRDOCI/EUR/ProcessCXMLPunchOutSetup-Start
set BROWSER="C:\Program Files (x86)\Google\Chrome\Application\chrome.exe"

C:/"Program Files"/Java/jdk1.8.0_151/jre/bin/java.exe -cp F:/Cxml/core.jar;F:/Cxml/ac_cxml.jar com.intershop.adapter.cxml.capi.util.Tester %START_PIPELINE% %1 %BROWSER%

