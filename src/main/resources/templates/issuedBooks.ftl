<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
    <title>IssuedBooks</title>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">Home</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link " aria-current="page" href="/gui/book/all">Book</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/gui/reader/all">Reader</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="/gui/issuedBook/all">Issued Book</a>
                    </li>

                </ul>
            </div>
        </div>
    </nav>
</head>
<body>
<h1>Table of Issued Book</h1>
<hr>
<a href="/gui/issuedBook/create"><input type="button" class="btn btn-success" value="Create" ></a>
<hr>
<div style="width: 70%">
    <table class="table table-striped">
        <tr>
            <th>ID</th>
            <th>Book</th>
            <th>Reader</th>
            <th>Issue Date</th>
            <th>Return Date</th>
            <th>Discount</th>
            <th>Description</th>
            <th>Created</th>
            <th>Updated</th>
            <th>Edit</th>
            <th>Delete</th>

        </tr>
        <#list issuedBooks as issuedBook>
            <tr>
                <td>${issuedBook.id}</td>
                <td>${issuedBook.book}</td>
                <td>${issuedBook.reader}</td>
                <td>${issuedBook.issueDate}</td>
                <td>${issuedBook.returnDate}</td>
                <td>${issuedBook.discount}</td>
                <td>${issuedBook.desc}</td>
                <td>${issuedBook.createdAt}</td>
                <td>${issuedBook.updatedAt}</td>
                <td><a href="/gui/issuedBook/update/${issuedBook.id}"><input type="button" class="btn btn-dark" value="Edit"></a></td>
                <td><a href="/gui/issuedBook/delete/${issuedBook.id}"><input type="button" class="btn btn-danger" value="Delete"></a></td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>