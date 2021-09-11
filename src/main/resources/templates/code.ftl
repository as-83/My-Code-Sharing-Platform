<!DOCTYPE HTML>
<html lang="en">
<head>
    <title>${title}</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="/static/style.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>

</head>
<body>

<div>
   <h1>Hello</h1>
    <#list codes as code>
       <div>
           <span id="load_date">${code.date}</span>
           <pre id="code_snippet"><code>${code.code}</code></pre>
       </div>
    </#list>
</div>




</body>
</html>
