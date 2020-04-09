
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="resources/front/showItemsStyle.css">
    <title>Items</title>
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

<!--
    <section class="search">
        <div class="searchHeader">
            <p>Search parameters</p>
            <p>Keyword:</p>
         </div>
        <div class="searchFields">
            <input type="text" name="" placeholder="">
                <select class="arrows">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                 </select>
            <input type="submit" name="" value="Search">
        </div>
    </section>
    -->

    <section class="sorting">

        <div><a href="myitemsservlet"> Show My Items</a></div>
        <!-- <div><a href="#"> Sell</a></div> -->
    </section>


    <section class="mainTable">
        <table class="items-table">
            <thead class = "main-head">
                <tr>
                    <th>Items</th>
                </tr>
            </thead>
            <thead class = "second-head">
                <tr>
                    <th>Item ID</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Seller ID</th>
                    <th>Start Price</th>
                    <th>Best Offer</th>
                    <th>Bidder ID</th>
                    <th>Stop Date</th>
                    <th>Start Date</th>
                    <c:if test="${sessionScope.userName != 'Guest'}">
                    <th>Bidding</th>
                    </c:if>
                </tr>
            </thead>
            <tbody>

            <c:forEach var="item" items="${requestScope.items}">
            <tr>
                <td>${item.id}</td>
                <td>${item.title}</td>
                <td>${item.description}</td>
                <td>${item.sellerId}</td>
                <td>${item.startPrice}</td>
                <td>${item.bestOffer}</td>
                <td>${item.bidderId}</td>
                <td>${item.endDate}</td>
                <td>${item.startDate}</td>

               <c:if test="${sessionScope.userName != 'Guest'}">
               <td>
                  <form class="class" action="itemsservlet" method="POST">
                    <input type="hidden" name="it" value="${item.id}">
                    <input type="text" required name="bd" placeholder="Your bid">
                    <input type="submit" name="bdb" value="Bid">
                  </form>
               </td>
               </c:if>
               </tr>
             </c:forEach>


            </tbody>
        </table>
    </section>




</body>
</html>