<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Create Issued Book</title>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">Home</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/gui/book/all">Book</a>
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

<h1>Creation</h1>

<form name="issuedBook" action="" method="POST">
    <div class="mb-3" style="width: 50%">
        <label for="exampleInputEmail1" class="form-label">Book</label>
        <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" <@spring.formInput "form.book" "" "text"/>
    </div>
    <div class="mb-3" style="width: 50%">
        <label for="exampleInputEmail1" class="form-label">Reader</label>
        <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" <@spring.formInput "form.reader" "" "text"/>
    </div>
    <div class="mb-3" style="width: 50%">
        <label for="exampleInputEmail1" class="form-label">Issue Date</label>
        <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" <@spring.formInput "form.issueDate" "" "text"/>
    </div>
    <div class="mb-3" style="width: 50%">
        <label for="exampleInputEmail1" class="form-label">Return Date</label>
        <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" <@spring.formInput "form.returnDate" "" "text"/>
    </div>
    <div class="mb-3" style="width: 50%">
        <label for="exampleInputEmail1" class="form-label">Discount</label>
        <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" <@spring.formInput "form.discount" "" "text"/>
    </div>
    <div class="mb-3" style="width: 50%">
        <label for="exampleInputPassword1" class="form-label">Description</label>
        <input type="text" class="form-control" id="exampleInputPassword1" <@spring.formInput "form.desc" "" "text"/>
    </div>
    <button type="submit" class="btn btn-primary">Create</button>
</form>



</body>
</html>