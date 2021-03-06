<#import "spring.ftl" as spring/>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>lazy</title>
</head>
<body style="height: 90vh; width: 95vw; display: grid; place-items: center">
    <#if books??>
        <table border="1">
            <#list books as book>
                <tr>
                    <td>${book.getName()}</td>
                    <td>${book.getCategory()}</td>
                </tr>
            </#list>
        </table>
    </#if>
    <a href="<@spring.url "/books-add"/>">books-add</a>
</body>
</html>