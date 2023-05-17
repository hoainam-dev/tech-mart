<%--
  Created by IntelliJ IDEA.
  User: PV
  Date: 5/16/2023
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="/static/css/AdminNavbar.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css" integrity="sha256-mmgLkCYLUQbXn0B1SRqzHar6dCnv9oZFPEC1g1cwlkk=" crossorigin="anonymous" />
</head>
<body>

<div class="col-md-10 ">
  <div class="row ">
    <div class="col-xl-3 col-lg-6">
      <div class="card l-bg-cherry">
        <div class="card-statistic-3 p-4">
          <div class="card-icon card-icon-large"><i class="fas fa-shopping-cart"></i></div>
          <div class="mb-4">
            <h5 class="card-title mb-0">New Orders</h5>
          </div>
          <div class="row align-items-center mb-2 d-flex">
            <div class="col-8">
              <h2 class="d-flex align-items-center mb-0">
                3,243
              </h2>
            </div>
            <div class="col-4 text-right">
              <span>12.5% <i class="fa fa-arrow-up"></i></span>
            </div>
          </div>
          <div class="progress mt-1 " data-height="8" style="height: 8px;">
            <div class="progress-bar l-bg-cyan" role="progressbar" data-width="25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100" style="width: 25%;"></div>
          </div>
        </div>
      </div>
    </div>
    <div class="col-xl-3 col-lg-6">
      <div class="card l-bg-blue-dark">
        <div class="card-statistic-3 p-4">
          <div class="card-icon card-icon-large"><i class="fas fa-users"></i></div>
          <div class="mb-4">
            <h5 class="card-title mb-0">Customers</h5>
          </div>
          <div class="row align-items-center mb-2 d-flex">
            <div class="col-8">
              <h2 class="d-flex align-items-center mb-0">
                15.07k
              </h2>
            </div>
            <div class="col-4 text-right">
              <span>9.23% <i class="fa fa-arrow-up"></i></span>
            </div>
          </div>
          <div class="progress mt-1 " data-height="8" style="height: 8px;">
            <div class="progress-bar l-bg-green" role="progressbar" data-width="25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100" style="width: 25%;"></div>
          </div>
        </div>
      </div>
    </div>
    <div class="col-xl-3 col-lg-6">
      <div class="card l-bg-green-dark">
        <div class="card-statistic-3 p-4">
          <div class="card-icon card-icon-large"><i class="fas fa-ticket-alt"></i></div>
          <div class="mb-4">
            <h5 class="card-title mb-0">Products</h5>
          </div>
          <div class="row align-items-center mb-2 d-flex">
            <div class="col-8">
              <h2 class="d-flex align-items-center mb-0">
                ${total}
              </h2>
            </div>
            <div class="col-4 text-right">
              <span>10% <i class="fa fa-arrow-up"></i></span>
            </div>
          </div>
          <div class="progress mt-1 " data-height="8" style="height: 8px;">
            <div class="progress-bar l-bg-orange" role="progressbar" data-width="25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100" style="width: 25%;"></div>
          </div>
        </div>
      </div>
    </div>
    <div class="col-xl-3 col-lg-6">
      <div class="card l-bg-orange-dark">
        <div class="card-statistic-3 p-4">
          <div class="card-icon card-icon-large"><i class="fas fa-dollar-sign"></i></div>
          <div class="mb-4">
            <h5 class="card-title mb-0">Revenue Today</h5>
          </div>
          <div class="row align-items-center mb-2 d-flex">
            <div class="col-8">
              <h2 class="d-flex align-items-center mb-0">
                $11.61k
              </h2>
            </div>
            <div class="col-4 text-right">
              <span>2.5% <i class="fa fa-arrow-up"></i></span>
            </div>
          </div>
          <div class="progress mt-1 " data-height="8" style="height: 8px;">
            <div class="progress-bar l-bg-cyan" role="progressbar" data-width="25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100" style="width: 25%;"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
  
  </body>
</html>
