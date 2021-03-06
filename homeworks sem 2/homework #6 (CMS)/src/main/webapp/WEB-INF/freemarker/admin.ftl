<#import "spring.ftl" as spring/>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="https://cdn.tiny.cloud/1/gl0bny55tldoes0nttuipeuzgbabpvs96roe6wcrbyr2mb7d/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
    <link rel="stylesheet" href="<@spring.url '/styles/edit.css' />" type="text/css">
</head>
<body>
    <h2 class="title">here is an editing page:</h2>
    <form method="post" action="admin">
        <div class="nameInput">
            <label for="name">Enter name of your template:</label>
            <input type="text" placeholder="Name of template" name="name" id="name">
        </div>
        <textarea name="content">
            Start to create your page here...
        </textarea>
        <div class="navigation">
            <input type="submit" value="save">
            <a href="user">cancel</a>
        </div>
    </form>
    <script src="<@spring.url '/scripts/init.js' />"></script>
</body>
</html>