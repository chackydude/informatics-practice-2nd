<#import "spring.ftl" as spring/>
<#import "header.ftl" as header/>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>cms</title>
    <link rel="stylesheet" href="<@spring.url '/styles/header.css' />" type="text/css">
    <link rel="stylesheet" href="<@spring.url '/styles/pages.css' />" type="text/css">
</head>
<body style="font-family: Consolas, sans-serif">
    <#if pages??>
        <@header.header pages/>
    </#if>
    <div class="page-content">
        <#if currentPageContent??>
            ${currentPageContent}
            <#else>
            <div class="placeholder">
                here will be page content
            </div>
        </#if>
    </div>
</body>
</html>