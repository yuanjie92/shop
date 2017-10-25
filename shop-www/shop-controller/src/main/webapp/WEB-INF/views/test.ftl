<html>
    <head>
        <title>test</title>
    </head>
    <body>
        ${test}
        [@hello_world name="${name}" title="${hello}"]
            ${helloworld.userName}--${helloworld.test}
        [/@hello_world]

        <br>单个标签使用body为空：</br>
        [@hello_world name="${name}" title = "${hello}" /]
    </body>
</html>