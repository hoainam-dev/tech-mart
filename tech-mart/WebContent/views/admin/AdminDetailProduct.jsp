<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
   <link href="./static/css/detailCard.css" rel="stylesheet" type="text/css">
  <style>
    #myImg {
      border-radius: 5px;
      cursor: pointer;
      transition: 0.3s;
    }

    #myImg:hover {opacity: 0.7;}

    /* The Modal (background) */
    .modal {
      display: none; /* Hidden by default */
      position: fixed; /* Stay in place */
      z-index: 1; /* Sit on top */
      padding-top: 100px; /* Location of the box */
      left: 0;
      top: 0;
      width: 100%; /* Full width */
      height: 100%; /* Full height */
      overflow: auto; /* Enable scroll if needed */
      background-color: rgb(0,0,0); /* Fallback color */
      background-color: rgba(0,0,0,0.9); /* Black w/ opacity */
    }

    /* Modal Content (image) */
    .modal-content {
      margin: auto;
      display: block;
      width: 80%;
      max-width: 700px;
    }

    /* Caption of Modal Image */
    #caption {
      margin: auto;
      display: block;
      width: 80%;
      max-width: 700px;
      text-align: center;
      color: #ccc;
      padding: 10px 0;
      height: 150px;
    }

    /* Add Animation */
    .modal-content, #caption {
      animation-name: zoom;
      animation-duration: 0.6s;
    }

    @keyframes zoom {
      from {transform: scale(0.1)}
      to {transform: scale(1)}
    }

    /* The Close Button */
    .close {
      position: absolute;
      top: 15px;
      right: 35px;
      color: #f1f1f1;
      font-size: 40px;
      font-weight: bold;
      transition: 0.3s;
    }

    .close:hover,
    .close:focus {
      color: #bbb;
      text-decoration: none;
      cursor: pointer;
    }

    /* 100% Image Width on Smaller Screens */
    @media only screen and (max-width: 700px){
      .modal-content {
        width: 100%;
      }
    }
  </style>
</head>
<body>
      <div class="myModalView" style="padding:10px;">
        <a href="product">
          <button class="btn btn-success" data-toggle="modal" data-target="#myModalAdd">Back To Home</button></a>
      </div>
<div class="product-card">
  <div class="badge">Hot</div>
  <div class="product-tumb">
    <img id="myImg" src="static/img/${product.image}" alt="Northern Lights, Norway" width="300" height="200">

    <!-- The Modal -->
  </div>
  <div class="product-details">
    <span class="product-catagory">${product.category}</span>
    <h4><a href="">${product.name}</a></h4>
    <p>${product.description}</p>
    <div class="product-bottom-details">
      <div class="product-price"><small>$96.00</small>${product.price}</div>
      <div class="product-links">
        <a href=""><i class="fa fa-heart"></i></a>
        <a href=""><i class="fa fa-shopping-cart"></i></a>
      </div>
    </div>
  </div>
</div>
<div id="myModal" class="modal">
  <span class="close">&times;</span>
  <img class="modal-content" id="img01">
  <div id="caption"></div>
</div>



<script>
  // Get the modal
  var modal = document.getElementById('myModal');

  // Get the image and insert it inside the modal - use its "alt" text as a caption
  var img = document.getElementById('myImg');
  var modalImg = document.getElementById("img01");
  var captionText = document.getElementById("caption");
  img.onclick = function(){
    modal.style.display = "block";
    modalImg.src = this.src;
    captionText.innerHTML = this.alt;
  }

  // Get the <span> element that closes the modal
  var span = document.getElementsByClassName("close")[0];

  // When the user clicks on <span> (x), close the modal
  span.onclick = function() {
    modal.style.display = "none";
  }
</script>

</body>
</html>


