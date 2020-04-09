

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="resources/front/myItemsStyle.css">
    <title>My Items</title>
</head>

<body>
    <header>
        <div class="logo">
            <div class="circle"><img src="resources/front/commas.png" alt="logo"></div>
            <h1>Online Marketplace</h1>
        </div>
        <div class="navbar">
            <ul>
                <li>You are logged in as ${sessionScope.userName} </li>
                <li><a href="logoutservlet">Logout</a></li>
            </ul>
        </div>
    </header>


    <section class="settings">
        <div class = "showAllItems"><a href="itemsservlet"> Show All Items</a></div>
        <a href="additemsservlet">
            <input type="submit" name="" value="Add Item">
        </a>
       <!-- <input type="submit" name="" value="Change Item"> -->
    </section>

    <section class="mainTable">
        <table class="items-table">
            <thead class = "main-head">
                <tr>
                    <th>My Items</th>
                </tr>
            </thead>
            <thead class = "second-head">
                <tr>
                    <th>Item ID</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Start Price</th>
                    <th>Best Offer</th>
                    <th>Bidder ID</>
                    <th>Stop Date</th>
                    <th>Delete</>
                </tr>
            </thead>
            <tbody>

                <c:forEach var="item" items="${requestScope.items}">
                <tr class="editable">
                      <tr>
                         <td>${item.id}</td>
                         <td>${item.title}</td>
                         <td>${item.description}</td>
                         <td>${item.startPrice}</td>
                         <td>${item.bestOffer}</td>
                         <td>${item.bidderId}</td>
                         <td contenteditable="false" type="text">
                            ${item.endDate}
                         </td>
                         <td>
                          <form class="itemInfo" action="myitemsservlet" method="POST">
                            <input type="hidden" name="it" value=${item.id}>
                            <input type="submit" value="delete" name="dt">
                          </form>
                         </td>
                </tr>
                </c:forEach>
                <tr class="notEditable">
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>
        </table>
    </section>



</body>

</html>