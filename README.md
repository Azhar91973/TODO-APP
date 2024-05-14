<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TODO APP</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 20px;
        }
        h1 {
            color: #333;
        }
        h2 {
            color: #555;
        }
        ul {
            list-style-type: none;
        }
        ul li {
            background: #f4f4f4;
            margin: 5px 0;
            padding: 10px;
            border: 1px solid #ddd;
        }
    </style>
</head>
<body>
    <h1>TODO APP</h1>
    <p>TODO APP is an Android application designed to help you manage your tasks efficiently. With features to add, delete, and update your to-dos, this app makes sure you stay organized and on top of your tasks.</p>
    <h2>Features</h2>
    <ul>
        <li><strong>Add ToDO:</strong> Easily add new tasks to your list.</li>
        <li><strong>Delete ToDO:</strong> Remove tasks that are no longer needed.</li>
        <li><strong>Update ToDO:</strong> Edit tasks to keep your list up-to-date.</li>
    </ul>
    <h2>Architecture</h2>
    <p>TODO APP uses the <strong>MVVM (Model-View-ViewModel)</strong> architecture to ensure a clean separation of concerns and promote a testable and maintainable codebase.</p>
    <h2>Database</h2>
    <p>TODO APP uses <strong>Room Database</strong> for storing and manipulating the to-dos. Room provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite.</p>
</body>
</html>
 
