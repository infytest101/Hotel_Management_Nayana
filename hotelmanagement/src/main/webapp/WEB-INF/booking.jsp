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
	<h2>Booking Details</h2>
	<div  style="text-align: left; margin-left:5px;">
		<label >Room Type:</label> 
		<select class="form-control" id="roomTypes" name="roomType"  style=" width:150px; height:30px;" onchange="actionHandler(this)"> 
		<option id="roomType">All</option>
	</select>
	</div>
	<div style="text-align: right; margin-right: 5px;">
		<label>Booking Start From:</label> <input type="date"
			id="searchbookingdatestart" placeholder="Search Booking Start Date"
			style="width: 110px; height: 30px; background-color: #e6e6ff;">
		<label>To:</label> <input type="date" id="searchbookingdateEnd"
			placeholder="Search Booking End Date"
			style="width: 110px; height: 30px; background-color: #e6e6ff;">
	</div>
	<br>
	<table id="table_id">
		<thead>
			<tr>
				<th class="subj_name">Room Type</th>
				<th>Price</th>
				<th>Smoking OR Non-Smoking</th>
				<th>AC OR Non-AC</th>
				<th>WIFI/TV/Geyser</th>
				<th>Total Room Available</th>
				<th>Total Room Booked</th>
				<th>Booking Start Date</th>
				<th>Booking End Date</th>
				<th id="action">Action</th>
			</tr>

		</thead>
		<tbody></tbody>
	</table>
	<br>
	<br>
	<div style="text-align: left; margin-left: 45px;">
		<button id="bookRoom"
			style="width: 100px; height: 30px; background-color: #e6e6ff;">Book
			Room</button>
	</div>
	<div id="popup" class="hidden">Checking To Delete Room Details...
	</div>
	<div id="popupUpdtStart"
		style="position: fixed; top: 5%; left: 50%; transform: translate(-50%, -50%);">
	</div>
	<div id="popupUpdtEnd"
		style="position: fixed; top: 5%; left: 50%; transform: translate(-50%, -50%);">
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
	$.ajax({
		url : "/hotelmanagement/getrooms",
		type : "get",
		async : false,
		success : function(data) {

			$.each(data, function(key, value) {
				if(value!=roomType){
				$('#roomTypes').append(
						'<option value="'+value+'">'
								+ value + '</option>');
				}
			})

		}

	});
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
																				value.wifiTvGeyser,
																				value.totalRoomAvailable,
																				value.totalRoomBooked,
																				value.bookingDetails.bookingdatestart,
																				value.bookingDetails.bookingdateend,
																				'<select onchange="actionHandle(this)"><option selected="selected">Select</option><option value='+value.roomId+','+value.roomType.roomType+'>BOOK</option><option value='+value.roomId+'>DELETE</option></select>'])
																													})

										}

									});
							 
							$('#table_id').DataTable({
								 "aLengthMenu": [[5, 10, 15,-1], [5, 10, 15, "All"]],
							        "iDisplayLength": 5,
							        pagingType: 'full_numbers',
								data : rooms,
						        initComplete: function() {
						        	$.fn.dataTable.ext.search.push(
								        	function(settings, data, dataIndex) {
								        	var fromDate = $('#searchbookingdatestart').val().trim(); 
								        	var toDate = $('#searchbookingdateEnd').val().trim(); 
								        	var columnDataFrom = data[7]; 
								        	var columnDataTo = data[8]; 
								        	
								        	if (fromDate ==='' && toDate==='' ) {
								        	return true;
								        	}
                                            var columnDateFrom = new Date(columnDataFrom);
                                            var columnDateTo = new Date(columnDataTo);
                                            var from = new Date(fromDate);
                                            var to = new Date(toDate);
                                            
                                            if((isNaN(from) || columnDateFrom>=from) && (isNaN(to) || columnDateTo<=to)){
                                            	return true;
                                            }
								        	return false;
								        	}
								        	
								        	);

								        	$('#searchbookingdatestart').on('change', function() {
								        		var fromDate = $('#searchbookingdatestart').val().trim(); 
								        		$('#searchbookingdateEnd').attr('min',fromDate);
									        	$('#table_id').DataTable().draw();
									        });
								        	$('#searchbookingdateEnd').on('change', function() {
								        		var toDate = $('#searchbookingdateEnd').val().trim(); 
								        		$('#searchbookingdatestart').attr('max',toDate);
									        	$('#table_id').DataTable().draw();
									        });
								        	
								        	$('#roomType').on('keyup', function() {
								        		var roomType = $('#roomType').val().trim(); 
									        	$('#table_id').DataTable().column(0).search(roomType,true, false).draw();
									        });
						        	}
								
							});

						});
		$(document).ready(function() {
			$('#bookRoom').click(function() {
				const showUpdate = setTimeout(showUpdatepop, 100);
				const showUpdateLast = setTimeout(showUpdatepopLast, 4000);
				
			});

		});
		
		function actionHandler(selectedValue) {
			if($('#roomTypes').val()!='All'){
        	var roomType = $('#roomTypes').val(); 
        	$('#table_id').DataTable().column(0).search(roomType,true, false).draw();
			}
			else{
				$('#table_id').DataTable().search('').columns().search('').draw();
			}
		}
		function actionHandle(selectedValue) {
			var id = selectedValue.options[selectedValue.selectedIndex].value;
			var action = selectedValue.options[selectedValue.selectedIndex].text;
			var roomtype;
			if (action == 'BOOK') {
				const showUpdate = setTimeout(showUpdatepop, 100);
				const showUpdateLast = setTimeout(showUpdatepopLast, 4000);
				
			}
			if (action == 'DELETE') {
				const showUpdate = setTimeout(showUpdatepop, 100);
				const showUpdateLast = setTimeout(showUpdatepopLast, 4000);
				
				}
		}


		function showUpdatepop() {
			  const demoelmt= document.getElementById("popupUpdtStart");
			  demoelmt.innerHTML = "Wiil Cover in next phase"
			  demoelmt.style.fontSize="18px";
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
	</script>


</body>

</html>