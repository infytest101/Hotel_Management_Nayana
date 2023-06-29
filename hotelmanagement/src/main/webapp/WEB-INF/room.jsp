<html>

<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css" />
<style>
#popup {
	display: inline-block;
	opacity: 0;
	position: fixed;
	top: 5%;
	left: 50%;
	padding: 1em;
	transform: translateX(-50%);
	background: #ffe6e6;
	border: 1px solid #888;
	box-shadow: 1px 1px .5em 0 rgba(0, 0, 0, .5);
	transition: opacity .3s ease-in-out;
}

#popup.hidden {
	display: none;
}

#popup.fade-in {
	opacity: 1;
}
</style>
</head>
<body>
	<h1>Hotel Management System</h1>
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/hotelmanagement/">Manage Room</a>
    </div>
    <div class="navbar-header">
      <a class="navbar-brand" href="/hotelmanagement/bookingListing">Manage Booking</a>
    </div>
  </div>
</nav>
	<h2>Room Details</h2>
	<table id="table_id">
		<thead>
			<tr>
				<th class="subj_name">Room Type</th>
				<th>Price</th>
				<th>Smoking OR Non-Smoking</th>
				<th>AC OR Non-AC</th>
				<th>Amenities</th>
				<th>Total Room Available</th>
				<th>Total Room Booked</th>
				<th id="action">Action</th>
			</tr>

		</thead>
		<tbody></tbody>
	</table>
	<br>
	<br>
	<div style="text-align: left; margin-left: 45px;">
		<button id="addRoom"
			style="width: 100px; height: 30px; background-color: #e6e6ff;">Add
			Room</button>
	</div>
	<div id="popup" class="hidden">Checking To Delete Room Details...
	</div>
	<div id="popupUpdtStart"
		style="position: fixed; top: 5%; left: 50%; transform: translate(-50%, -50%);">
	</div>
	<div id="popupUpdtEnd"
		style="position: fixed; top: 7%; left: 55%; transform: translate(-50%, -50%);">
	</div>
	<div id = "popupUpdtError" style="position:fixed; top:5%; left:50%; transform:translate(-50%,-50%);">
     </div>
	<script type="text/javascript" charset="utf8"
		src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>

	<script type="text/javascript" charset="utf8"
		src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>

	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
	<script type="text/css"
		src="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css"></script>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							var rooms = [];
							$
									.ajax({
										url : "/hotelmanagement/getroomdetails?id=0",
										type : "get",
										async : false,
										success : function(data) {
											console.log(data);
											$
													.each(
															data,
															function(key, value) {

																rooms
																		.push([
																				value.roomType.roomType,
																				value.price,
																				value.smokingOrNonSmoking,
																				value.acOrNonAC,
																				value.amenties.replaceAll("\n", "<br>"),
																				value.totalRoomAvailable,
																				value.totalRoomBooked,
																				'<select onchange="actionHandle(this)"><option selected="selected">Select</option><option value='+value.roomId+','+value.roomType.roomType+'>EDIT</option><option value='+value.roomId+'>DELETE</option></select>'])
																													})

										},
										error: function(xhr){
											const showUpdateEnd = setTimeout(showUpdatepopError("Can't able to fetch Room Details"), 2100);
											const showUpdateEndLast = setTimeout(showUpdatepopErrorLast, 6000);
									    }


									});
							$('#table_id').DataTable({
								 "aLengthMenu": [[5, 10, 15,-1], [5, 10, 15, "All"]],
							        "iDisplayLength": 5,
							        pagingType: 'full_numbers',
								data : rooms
							});

						});
		

		function actionHandle(selectedValue) {
			var id = selectedValue.options[selectedValue.selectedIndex].value;
			var action = selectedValue.options[selectedValue.selectedIndex].text;
			var roomtype;
			if (action == 'EDIT') {
				roomId= id.split(',')[0];
				roomtype=id.split(',')[1];
				location.href = '/hotelmanagement/editRoom?roomType='
						+ encodeURIComponent(roomtype) + '&roomId='
						+ roomId;
			}
			if (action == 'DELETE') {
				var flag=confirm("Are you sure you want to delete");
				if(flag==true){
				$.ajax({
					url : "/hotelmanagement/deleteRoom?roomId="
							+ id,
					type : "delete",
					async : false,
					success : function(res) {
						console.log(res);
						
						if (res == "Deleted Successfully") {
							const showUpdate = setTimeout(showUpdatepop, 100);
							const showUpdateLast = setTimeout(showUpdatepopLast, 4000);
							
						} else {
							const showUpdateEnd = setTimeout(showUpdatepopEnd, 100);
							const showUpdateEndLast = setTimeout(showUpdatepopEndLast, 4000);
						}
					},
					error: function(xhr){
						const showUpdateEnd = setTimeout(showUpdatepopError("Can't able delete now"), 2100);
						const showUpdateEndLast = setTimeout(showUpdatepopErrorLast, 6000);
				    }

				});
				}
			}
		}


		$(document).ready(function() {
			$('#addRoom').click(function() {
				location.href = '/hotelmanagement/addRoom';
			});

		});
		
		function popup(){
			  var popup = document.getElementById("popup");
			  popup.classList.remove("hidden");
			  setTimeout(()=>popup.classList.add("fade-in"));
			  setTimeout(()=>popup.classList.add("hidden"), 5000);
		}
		function showUpdatepop() {
			  const demoelmt= document.getElementById("popupUpdtStart");
			  demoelmt.innerHTML = "Room Details has been deleted successfully"
			  demoelmt.style.fontSize="18px";
			  //demoelmt.style.color="red";
			  demoelmt.style.backgroundColor="#b3b3ff"
			  demoelmt.style.padding="12px";
			}
		function showUpdatepopLast() {
			$("#popupUpdtStart").hide();
			}
		function showUpdatepopEnd() {
			  const demoelmt= document.getElementById("popupUpdtEnd");
			  demoelmt.innerHTML = "Can't able to delete Room Details,Because booking exists."
			  demoelmt.style.fontSize="18px";
			  demoelmt.style.backgroundColor="#b3b3ff"
			  demoelmt.style.padding="12px";
			}
		function showUpdatepopEndLast() {
			$("#popupUpdtEnd").hide();
			}
		function showUpdatepopError(message) {
			  const demoelmt= document.getElementById("popupUpdtError");
			  demoelmt.innerHTML =message;
			  demoelmt.style.fontSize="18px";
			  demoelmt.style.backgroundColor="#b3b3ff"
			  demoelmt.style.padding="12px";
			}
		function showUpdatepopErrorLast() {
			$("#popupUpdtError").hide();
			}
	</script>


</body>

</html>