<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Create Reader</title>
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
                        <a class="nav-link active" href="/gui/reader/all">Reader</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/gui/issuedBook/all">Issued Book</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</head>
<body>

<h1>Creation</h1>

<form name="reader" action="" method="POST">
    <div class="mb-3" style="width: 50%">
        <label for="exampleInputEmail1" class="form-label">Name</label>
        <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" <@spring.formInput "form.name" "" "text"/>
    </div>
    <div class="mb-3" style="width: 50%">
        <label for="exampleInputEmail1" class="form-label">Surname</label>
        <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" <@spring.formInput "form.surname" "" "text"/>
    </div>
    <div class="mb-3" style="width: 50%">
        <label for="exampleInputEmail1" class="form-label">Patronymic</label>
        <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" <@spring.formInput "form.patronymic" "" "text"/>
    </div>
    <div class="mb-3" style="width: 50%">
        <label for="exampleInputEmail1" class="form-label">Address</label>
        <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" <@spring.formInput "form.address" "" "text"/>
    </div>
    <div class="mb-3" style="width: 50%">
        <label for="exampleInputEmail1" class="form-label">Phone</label>
        <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" <@spring.formInput "form.phone" "" "text"/>
    </div>
    <div class="mb-3" style="width: 50%">
        <label for="exampleInputEmail1" class="form-label">Type</label>
        <select class="form-select" <@spring.formInput "form.type" "" "text"/>
            <option selected></option>
            <option value="student">Student</option>
            <option value="pensioner">Pensioner</option>
            <option value="common">Common</option>
        </select>
    </div>
    <div class="mb-3" style="width: 50%">
        <label for="exampleInputPassword1" class="form-label">Description</label>
        <input type="text" class="form-control" id="exampleInputPassword1" <@spring.formInput "form.desc" "" "text"/>
    </div>
    <button type="submit" class="btn btn-primary">Create</button>
</form>



</body>
</html>