<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css" />
<title>Update Room</title>

<style>

table{
   width: 60%;
   margin-left :35px;
   
    background-color:#e6e6ff;
}
th,td{
padding :10px;
font-weight:bold;
}

td:not(:last-child){
padding-right:90px;
}
#table_two{
 margin-left :70px;
 
}
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
<h2>Update Room Details</h2>
<form id="roomForm">
	<table>
	<tr>
	<td>
	<label for="roomType">Room Type</label> 
	</td>
	<td>
	<label>:</label> 
	</td>
	<td>
	<select class="form-control" id="roomType" name="roomType"  style=" width:150px; height:30px;">
		<option id="roomype"></option>
	</select>
	</td>
	</tr>
	<tr>
	<td>
	<label>Price</label> 
	</td>
	<td>
	<label>:</label> 
	</td>
	<td>
	<input type="number" min="0" class="form-control" id="price" name="price" style=" width:138px; height:25px;" required>
	</td>
	</tr>
	<tr>
	<td>
	<label>Amenities</label> 
	<table id=table_two >
	<tr>
	<td>
	<label for="ac/non-ac">AC/Non-AC</label>
	</td>
	<td>
	<label></label> 
	</td>
	</tr>
	<tr>
	<td>
	<label for="smoking/non-smoking">Smoking/Non-Smoking</label>
	</td>
	<td>
	<label></label> 
	</td>
	</tr>
	<tr>
	<td>
	<label for="wi-fi/tv/geyser">WI-FI/TV/Geyser</label>
	</td>
	<td>
	<label></label> 
	</td>
	</tr>
	</table>
	</td>
	<td>
	<br>
	<label>:</label>
	<br> 
	<br> 
	<br> 
	<label>:</label> 
	<br> 
	<br> 
	<br> 
	<label>:</label> 
	<br> 
	<br> 
	</td>
	<td>
	          <br>
	          <br>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" id="ac" name="acNonAc"
						value="AC" required> <label class="form-check-label"
						for="ac">AC</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" id="non-ac"
						name="acNonAc" value="Non-AC" required> <label
						class="form-check-label" for="non-ac">Non-AC</label>
				</div>
				<br>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" id="smoking"
						name="smokingNonSmoking" value="Smoking" required> <label
						class="form-check-label" for="smoking">Smoking</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" id="non-smoking"
						name="smokingNonSmoking" value="Non-Smoking" required> <label
						class="form-check-label" for="non-smoking">Non-Smoking</label>
				</div>
				<br>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" id="wifi"
						name="wi-fi/tv/geyser" value="WI-FI"> <label
						class="form-check-label" for="wifi">WI-FI</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" id="tv"
						name="wi-fi/tv/geyser" value="TV"> <label
						class="form-check-label" for="tv">TV</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" id="geyser"
						name="wi-fi/tv/geyser" value="Geyser"> <label
						class="form-check-label" for="geyser">Geyser</label>
				</div>
	</td>
	
	</tr>	
	<tr>
	<td>
	<label>Total Room Available</label> 
	</td>
	<td>
	<label>:</label> 
	</td>
	<td>
	<input type="number" min="0"  id="totalRoomAvailable" name="totalRoomAvailable" style=" width:138px; height:25px;" > 
	</td>
	</tr>
	<tr>
	<td>
	<label>Total Booked Room</label> 
	</td>
	<td>
	<label>:</label> 
	</td>
	<td>
	<input type="number" min="0"  id="totalRoomBooked" name="totalRoomBooked" style=" width:138px; height:25px;" > 
	</td>
	</tr>
	</table>
	<br>
	<div style= "text-align :left; margin-left:45px;">
	 <input type="submit" value="Update Room" style=" width:100px; height:30px; background-color:#e6e6ff;">
	 </div>
	 
	 </form>
	 <div id = "popupUpdtStart" style="position:fixed; top:5%; left:50%; transform:translate(-50%,-50%);">
     </div>
     <div id = "popupUpdtEnd" style="position:fixed; top:5%; left:50%; transform:translate(-50%,-50%);">
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
	
	var roomId;
	var roomtypeid;
	var bookingdetailsid;
	var bookingdatestart;
	var bookingdateend;
		$(document).ready(function() {
			$('#roomForm').submit(function(event){
				event.preventDefault();
				var roomType=$('#roomType').val();
				var price=$('#price').val();
				var acOrNonAC;
				var smokingOrNonSmoking;
				let wifiTvGeyser;
				if($('#ac').is(':checked')==true){
					acOrNonAC="AC";
				}
				else{
					acOrNonAC="Non AC";
				}
				if($('#smoking').is(':checked')==true){
					smokingOrNonSmoking ="Smoking";
				}
				else{
					smokingOrNonSmoking ="Non Smoking";
				}
				
				if($('#wifi').is(':checked')==true){
					wifiTvGeyser="WIFI";
				}
				if($('#tv').is(':checked')==true){
					if(wifiTvGeyser!=null){
						wifiTvGeyser=wifiTvGeyser+","+"Tv";
					}
					else{
						wifiTvGeyser="Tv";
					}
					
				}
				if($('#geyser').is(':checked')==true){
					if(wifiTvGeyser!=null){
						wifiTvGeyser=wifiTvGeyser+","+"Geyser";
					}
					else{
						wifiTvGeyser="Geyser";
					}
				}
				var totalRoomAvailable =$('#totalRoomAvailable').val();
				var totalRoomBooked	= $('#totalRoomBooked').val();
				var payload = {
				    	"roomId":roomId,
				        "price": price,
				        "roomtypeid": roomtypeid,
				        "roomType": {
				        	"roomTypeId": roomtypeid,
				            "roomType": roomType
				            },
				        "smokingOrNonSmoking": smokingOrNonSmoking,
				        "acOrNonAC": acOrNonAC,
				        "editOrDelete":"edit",
				        "wifiTvGeyser":wifiTvGeyser,
				        "bookingDetails":{
				        	"bookingdetailsid":bookingdetailsid,
				        	"bookingdatestart":bookingdatestart,
				        	"bookingdateend":bookingdateend
				        	
				        },
				        "totalRoomAvailable":totalRoomAvailable,
				        "totalRoomBooked":totalRoomBooked
				        
				        	
				    };
				$.ajax({
					url : '/hotelmanagement/addOrUpdate',
					type : 'POST',
					data : JSON.stringify(payload),
					contentType:'application/json',
					success : function(res) {
						const showUpdate = setTimeout(showUpdatepop, 100);
						const showUpdateLast = setTimeout(showUpdatepopLast, 2000);
						console.log(res);
						if(res=='Edited Successfully'){
							const showUpdateEnd = setTimeout(showUpdatepopEnd, 2100);
							const showUpdateEndLast = setTimeout(showUpdatepopEndLast, 6000);
						} else {
							const showUpdateEnd = setTimeout(showUpdatepopError("Can't able to update room details"), 2100);
							const showUpdateEndLast = setTimeout(showUpdatepopErrorLast, 6000);
						}
					},
					error: function(xhr){
						const showUpdateEnd = setTimeout(showUpdatepopError("Can't able to update room details"), 2100);
						const showUpdateEndLast = setTimeout(showUpdatepopErrorLast, 6000);
				    }
				
				});
				
				
			});
							var roomType = getParameterByName('roomType');
							roomId = getParameterByName('roomId');
							$('#roomType').append(
									'<option selected="selected" value="'+roomType+'">'
											+ roomType + '</option>');
							$.ajax({
								url : "/hotelmanagement/getrooms",
								type : "get",
								async : false,
								success : function(data) {

									$.each(data, function(key, value) {
										if(value!=roomType){
										$('#roomType').append(
												'<option value="'+value+'">'
														+ value + '</option>');
										}
									})

								},
								error: function(xhr){
									const showUpdateEnd = setTimeout(showUpdatepopError("Can't able to fetch Room Types"), 2100);
									const showUpdateEndLast = setTimeout(showUpdatepopErrorLast, 6000);
							    }

							});
							$.ajax({
								
								url : "/hotelmanagement/getroomdetails?id="+roomId ,
								type : "get",
								async : false,
								success : function(data) {

									$.each(data, function(key, value) {
										roomtypeid=data[0].roomtypeid;
										bookingdetailsid= data[0].bookingDetails.bookingdetailsid;
										var acOrNonAC =data[0].acOrNonAC;
										var smokingOrNonSmoking =data[0].smokingOrNonSmoking;
										bookingdatestart=data[0].bookingDetails.bookingdatestart;
										bookingdateend=data[0].bookingDetails.bookingdateend;
										if (acOrNonAC == "ac"|| acOrNonAC == "AC") {
											$('#ac').prop('checked', true);
										} else {
											$('#non-ac').prop('checked', true);
										}
										
										if (smokingOrNonSmoking == "Smoking"||smokingOrNonSmoking == "smoking") {
											$('#smoking').prop('checked', true);
										} else {
											$('#non-smoking').prop('checked', true);
										}
										
										$('#price').val(data[0].price);
										$('#totalRoomAvailable').val(data[0].totalRoomAvailable);
										$('#totalRoomBooked').val(data[0].totalRoomBooked);
										
										var p = data[0].amenties.split('\n');
										for (var i = 0; i < p.length; i++) {
											var pair = p[i].split(':');
											if (pair[0].indexOf("WifiTvGeyser") != -1) {
												wifiTvGeyserCheck(pair[1]);
											} 
											
										}
									})
								},
								error: function(xhr){
									const showUpdateEnd = setTimeout(showUpdatepopError("Can't able to fetch Room Details"), 2100);
									const showUpdateEndLast = setTimeout(showUpdatepopErrorLast, 6000);
							    }

							});
							
							
		});
		function getParameterByName(name) {
			var qs = location.search.substring(1);
			var p = qs.split('&');
			for (var i = 0; i < p.length; i++) {
				var pair = p[i].split('=');
				if (decodeURIComponent(pair[0]) == name) {
					return decodeURIComponent(pair[1]);
				}
			}
			return null;
		}
		function wifiTvGeyserCheck(name) {
			if (name.indexOf("WIFI") != -1) {
				$('#wifi').prop('checked', true);
			}
			if (name.indexOf("Tv") != -1) {
				$('#tv').prop('checked', true);
			}
			if (name.indexOf("Geyser") != -1) {
				$('#geyser').prop('checked', true);
			}
		}
		
		function showUpdatepop() {
			  const demoelmt= document.getElementById("popupUpdtStart");
			  demoelmt.innerHTML = "Updating Room Details...."
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
			  demoelmt.innerHTML = "Room Details has been updated successfully"
			  demoelmt.style.fontSize="18px";
			  demoelmt.style.backgroundColor="#b3b3ff"
			  demoelmt.style.padding="12px";
			}
		function showUpdatepopEndLast() {
			$("#popupUpdtEnd").hide();
			}
		function showUpdatepopError(message) {
			  const demoelmt= document.getElementById("popupUpdtError");
			  demoelmt.innerHTML = message;
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