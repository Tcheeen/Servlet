<%@ page import='etu2063.framework.servlet.*' %>
    <% String url=(String) request.getAttribute("url"); %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="utf-8">
            <title>Document</title>
        </head>

        <body>
            <h1> L'url est: <%= url %>
            </h1>
        </body>

        </html>