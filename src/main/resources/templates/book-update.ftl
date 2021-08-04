<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Update Book</title>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">Home</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/gui/book/all">Book</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/gui/reader/all">Reader</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Pricing</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</head>
<body>

<h1>Update book</h1>
<div>
    <form name="book" action="" method="POST">
        <div class="mb-3" style="width: 50%">
            <label for="exampleInputEmail1" class="form-label">ID</label>
            <input class="form-control" type="text" id="exampleInputEmail1" disabled
                   readonly <@spring.formInput "form.id" "" "text"/>

        </div>
        <div class="mb-3" style="width: 50%">
            <label for="exampleInputEmail1" class="form-label">Title</label>
            <input type="text" class="form-control" id="exampleInputEmail1"
                   aria-describedby="emailHelp" <@spring.formInput "form.title" "" "text"/>
        </div>

        <div class="mb-3" style="width: 50%">
            <label for="exampleInputEmail1" class="form-label">Author</label>
            <input type="text" class="form-control" id="exampleInputEmail1"
                   aria-describedby="emailHelp" <@spring.formInput "form.author" "" "text"/>
        </div>
        <div class="mb-3" style="width: 50%">
            <label for="exampleInputEmail1" class="form-label">Genre</label>
            <input type="text" class="form-control" id="exampleInputEmail1"
                   aria-describedby="emailHelp" <@spring.formInput "form.genre" "" "text"/>
        </div>
        <div class="mb-3" style="width: 50%">
            <label for="exampleInputEmail1" class="form-label">Rental price</label>
            <input type="text" class="form-control" id="exampleInputEmail1"
                   aria-describedby="emailHelp" <@spring.formInput "form.rentalPrice" "" "text"/>
        </div>
        <div class="mb-3" style="width: 50%">
            <label for="exampleInputEmail1" class="form-label">Bail</label>
            <input type="text" class="form-control" id="exampleInputEmail1"
                   aria-describedby="emailHelp" <@spring.formInput "form.bail" "" "text"/>
        </div>
        <div class="mb-3" style="width: 50%">
            <label for="exampleInputPassword1" class="form-label">Description</label>
            <input type="text" class="form-control"
                   id="exampleInputPassword1" <@spring.formInput "form.desc" "" "text"/>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</div>


</body>
</html>