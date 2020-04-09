
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="resources/front/addItemsStyle.css">
      <!-- Font Awesome -->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
  <!-- Bootstrap core CSS -->
  <link href="resources/front/MDB/css/bootstrap.min.css" rel="stylesheet">
  <!-- Material Design Bootstrap -->
  <link href="resources/front/MDB/css/mdb.min.css" rel="stylesheet">
  <!-- Your custom styles (optional) -->
  <link href="resources/front/MDB/css/style.css" rel="stylesheet">
    <title>My Items</title>
</head>


<body>


    <header>
             <div class="circle"> <img src="resources/front/commas.png" alt="logo"></div>
            <div style="float: left"><a href = "itemsservlet"><h1>Online Marketplace</h1></a></div>
            <div><a href="logoutservlet">Logout</a></div>
    </header>





<div class="card">
    <h3 class="card-header text-center font-weight-bold text-uppercase py-4">Add My Items</h3>
    <!--
    <div class="card-body">
      <div id="table" class="table-editable">
        <span class="table-add float-right mb-3 mr-2"><a href="#!" class="text-success"><i
              class="fas fa-plus fa-2x" aria-hidden="true"></i></a></span>
        <table class="table table-bordered table-responsive-md table-striped text-center">
        -->
        <!--
          <thead>
            <tr>
              <th class="text-center">Title</th>
              <th class="text-center">Description</th>
              <th class="text-center">Start Price</th>
              <th class="text-center">Start date</th>
              <th class="text-center">End date</th>
              <th class="text-center">Confirm</th>
              <th class="text-center">Remove</th>
            </tr>
          </thead>
          -->
          <tbody>
            <form class="itemInfo" action="additemsservlet" method="POST">

            <input type="text" name="tl" placeholder="Title" required>
            <input type="text" name="des" placeholder="Description" required>
            <input type="number" name="sp" placeholder="Start price" required>
            <input type="text" name="sd" pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])" placeholder="Start date" required>
            <input type="text" name="ed" pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])" placeholder="End date" required>
            <input type="submit" value="confirm" name="cf">
            </form>
            <!--
            <%--
              <td class="pt-3-half" contenteditable="true" input type="title" name="tl"></td>
              <td class="pt-3-half" contenteditable="true" input type="description" name="des"></td>
              <td class="pt-3-half" contenteditable="true" input type="startPrice" name="sp"></td>
              <td class="pt-3-half" contenteditable="true" input type="startDate" name="sd"></td>
              <td class="pt-3-half" contenteditable="true" input type="endDate" name="ed"></td>
              --%>
              <%--<td>
                <span class="table-confirm">--%>


                <%-- </span>--%>
              </td>
              <td>
                <span class="table-remove"><button type="button"
                    class="btn btn-danger btn-rounded btn-sm my-0">Remove</button></span>
              </td>
            </tr>

            -->

            <!-- This is our clonable table line -->

          </tbody>
        </table>
      </div>
    </div>
  </div>




    <!-- SCRIPTS -->
  <!-- JQuery -->
  <script type="text/javascript" src="resources/front/MDB/js/jquery.min.js"></script>
  <!-- Bootstrap tooltips -->
  <script type="text/javascript" src="resources/front/MDB/js/popper.min.js"></script>
  <!-- Bootstrap core JavaScript -->
  <script type="text/javascript" src="resources/front/MDB/js/bootstrap.min.js"></script>
  <!-- MDB core JavaScript -->
  <script type="text/javascript" src="resources/front/MDB/js/mdb.min.js"></script>
  <script src="resources/front/addItemsScript.js"></script>
</body>

</html>