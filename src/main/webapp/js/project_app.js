

/*
 * Angular module and controller for the customer request form page and features.
 * 
 */
var createApp = angular.module('maltbiaDetailingPlusRequestApp', []);

createApp.controller('customerCtrl', function($scope, $http) {
	
	$scope.services = ['carpet','tile floor'];
	$scope.newServices = $scope.services[0];
		
	$scope.submitCustomer = function() {	
		
		$scope.submitStatus = "";
		
		if ($scope.newCustomerFirstName == undefined) {
			$scope.firstNameMessage = "name is required";
		} else if ($scope.newCustomerFirstName.length < 2) {
			$scope.firstNameMessage = "first name must be at least 4 characters";
		} else {
			$scope.firstNameMessage = "";
		}
		
		if ($scope.newCustomerLastName == undefined) {
			$scope.lastNameMessage = "last name is required";
		} else if ($scope.newCustomerLastName.length < 2) {
			$scope.lastNameMessage = "last name must be at least 4 characters";
		} else {
			$scope.lastNameMessage = "";
		}
		
		if ($scope.newCustomerPhone == undefined) {
			$scope.phoneMessage = "phone number is required";
		} else if ($scope.newCustomerPhone.length < 7) {
			$scope.phoneMessage = "phone must be 10 digits";
		} else {
			$scope.phoneMessage = "";
		}
		
		if ($scope.newCustomerStreet == undefined) {
			$scope.streetMessage = "street address is required";
		} else if ($scope.newCustomerStreet.length < 4) {
			$scope.streetMessage = "street address must be at least 4 characters";
		} else {
			$scope.streetMessage = "";
		}
		
		if ($scope.newCustomerCity == undefined) {
			$scope.cityMessage = "city is required";
		} else if ($scope.newCustomerCity.length < 4) {
			$scope.cityMessage = "city must be at least 4 characters";
		} else {
			$scope.cityMessage = "";
		}
		
		if ($scope.newCustomerState == undefined) {
			$scope.stateMessage = "state is required";
		} else if ($scope.newCustomerState.length < 2) {
			$scope.stateMessage = "state must be 2 characters";
		} else {
			$scope.stateMessage = "";
		}
		
		if ($scope.newCustomerZip == undefined) {
			$scope.zipMessage = "zip is required";
		} else if ($scope.newCustomerZip.length < 4) {
			$scope.zipMessage = "zip must be at least 4 characters";
		} else {
			$scope.zipMessage = "";
		}
		
		if ($scope.newCustomerEmail == undefined) {
			$scope.emailMessage = "email is required";
		} else if ($scope.newCustomerEmail.length < 4) {
			$scope.emailMessage = "email must be at least 4 characters";
		} else {
			$scope.emailMessage = "";
		}
			
		
		if ($scope.firstNameMessage == "" && $scope.lastNameMessage == "" && $scope.phoneMessage == "" && $scope.streetMessage == ""
				&& $scope.cityMessage == "" && $scope.stateMessage == "" && $scope.zipMessage == "" && $scope.emailMessage == "")
		{
			alert("time to submit first name: " + $scope.newCustomerFirstName +
					", last name: " + $scope.newCustomerLastName +
					", phone: " + $scope.newCustomerPhone +
					", street: " + $scope.newCustomerStreet +
					", city: " + $scope.newCustomerCity + 
					", state: " + $scope.newCustomerState +
					", zip: " + $scope.newCustomerZip +
					", email: "+ $scope.newCustomerEmail +
					", services: " + $scope.newCustomerServices +
					", monday? " + $scope.newMondayCustomer +
					", tuesday? " + $scope.newTuesdayCustomer +
					", wednesday? " + $scope.newWednesdayCustomer +
					", thursday? " + $scope.newThursdayCustomer +
					", friday? " + $scope.newFridayCustomer +
					", saturday? " + $scope.newSaturdayCustomer +
			        ", sunday? " + $scope.newSundayCustomer);

			
			var newCustomer = {firstName : $scope.newCustomerFirstName,
								lastName : $scope.newCustomerLastName,
								phone : $scope.newCustomerPhone,
								street : $scope.newCustomerStreet,
								city : $scope.newCustomerCity,
								state : $scope.newCustomerState,
								zip : $scope.newCustomerZip,
								email : $scope.newCustomerEmail,
								services : $scope.newCustomerServices,
								monday : $scope.newMondayCustomer,
								tuesday : $scope.newTuesdayCustomer,
								wednesday : $scope.newWednesdayCustomer,
								thursday : $scope.newThursdayCustomer,
								friday : $scope.newFridayCustomer,
								saturday : $scope.newSaturdayCustomer,
								sunday : $scope.newSundayCustomer};
			
			$http.post("/RestApiApp/rest/projectcustomer", newCustomer)
			.then(
					function success(response) {
						
						if (response.data == 1) {						
							alert("rows inserted: " + response.data + ", status: " + response.status);
							$scope.submitStatus = "success. press 'Clear' to enter new customer";							
						} else {
							alert("error, return status: " + response.status);
							$scope.submitStatus = "error. press 'Clear' to try again";		
						}
					},
					function error(response) {
						alert("error, return status: " + response.status);
						$scope.submitStatus = "error. press 'Clear' to try again";						
					}				
			);
			
			$scope.isSubmitCustomerDisabled = true;
			$scope.lock = true;
			
		} else {
			$scope.submitStatus = "please fix indicated errors!";
		}				
			
	};
	
	$scope.clearSubmit = function() {	
		
		//clear success or error message
		$scope.submitStatus = "";
		
		//clear the input elements
		$scope.newCustomerFirstName = "";
		$scope.newCustomerLastName = "";
		$scope.newCustomerPhone = "";
		$scope.newCustomerStreet = "";
		$scope.newCustomerCity = "";
		$scope.newCustomerState = "";
		$scope.newCustomerZip = "";
		$scope.newCustomerEmail = "";
		$scope.newCustomerServices = $scope.services[0];
		$scope.newMondayCustomer = false;
		$scope.newTuesdayCustomer = false;
		$scope.newWednesdayCustomer = false;
		$scope.newThursdayCustomer = false;
		$scope.newFridayCustomer = false;
		$scope.newSaturdayCustomer = false;
		$scope.newSundayCustomer = false;
	
		
		//clear the messages
		$scope.firstNameMessage = "";
		$scope.lastNameMessage = "";
		$scope.phoneMessage = "";
		$scope.streetMessage = "";
		$scope.cityMessage = "";
		$scope.stateMessage = "";
		$scope.zipMessage = "";
		$scope.emailMessage = "";
		
		
		//unlock input
		$scope.lock = false;
		$scope.isSubmitCustomerDisabled = false;
	}
	
		
});

//To Send Email
var emailApp = angular.module('maltbiaDetailingPlusEmailApp', []);

emailApp.controller('sendEmailCtrl', function($scope, $http) {
	
	$scope.sendEmail = function() {
	
	if ($scope.newSubject == undefined) {
		$scope.subjectMessage = "subject is required";
	} else if ($scope.newSubject.length < 2) {
		$scope.subjectMessage = "subject must be at least 2 characters";
	} else {
		$scope.subjectMessage = "";
	}
	
	if ($scope.newCompose == undefined) {
		$scope.composeMessage = "message is required";
	} else if ($scope.newCompose.length < 4) {
		$scope.composeMessage = "body of email must be at least 4 characters";
	} else {
		$scope.composeMessage = "";
	}
	
	if ($scope.subjectMessage == "" && $scope.composeMessage == "")
	{
	alert("time to send email message: " + $scope.newSubject +
			", compose: " + $scope.newCompose); 
	
	var emailMessage = {
			subjectMessage: $scope.newSubject,
			composeMessage: $scope.newCompose};
		
	$http.post("/RestApiApp/rest/projectcustomer/email", emailMessage)
	.then(
			function success(response) {
				alert("message: " + response.data  + ", status: " + response.status);
				$scope.emailStatus = "success. press 'Clear' to enter new message";
			},
			function error(response) {
				alert("error, return status: " + response.status);
				$scope.emailStatus = "error. press 'Clear' to try again";						
			}				
		);
	
		$scope.isEmailDisabled = true;
		$scope.lock = true;
	
	} else {
		$scope.emailStatus = "please fix indicated errors!";
	}	
}
	
$scope.clearSend = function() {	
		
		//clear success or error message
		$scope.emailStatus = "";
		
		//clear the input elements
		$scope.newSubject = "";
		$scope.newCompose = "";
		
		
		//clear the messages
		$scope.subjectMessage = "";
		$scope.composeMessage = "";
				
		
		//unlock input
		$scope.lock = false;
		$scope.isEmailDisabled = false;
	}
	
});


/*
 * Angular module and controller for the customer search / edit page and features.
 * 
 */
var app = angular.module('maltbiaDetailingPlusCustomerApp', []);

app.controller('customersCtrl', function($scope, $http) {
	
	$scope.resetSearch = function() {
		$scope.isGetCustomersDisabled = false;
		$scope.isClearCustomersDisabled = true;			
		$scope.hideCustomerSearchPage(false);
		$scope.hideCustomerSearchResults = true;
		$scope.hideCustomerEditDelete = true;
		$scope.nameFilter = "";
	}
			
	$scope.getCustomers = function() {
		$http.get("/RestApiApp/rest/customer").then(function(response) {
			$scope.myCustomers = response.data;
		});		
		$scope.hideCustomerSearchResults = false;
		$scope.isGetCustomersDisabled = true;
		$scope.isClearCustomersDisabled = false;		
	};	
	
	$scope.updateCustomer = function() {
		
		alert("time to update customer "+$scope.customer.customerId);
		
		$scope.jsonObject = angular.toJson($scope.customer, false);
		alert("customer json: "+$scope.jsonObject);
		
		$http.put("/RestApiApp/rest/customer", $scope.jsonObject)
		.then(
				function success(response) {
					alert("rows updated: " + response.data + ", status: " + response.status);
				},
				function error(response) {
					alert("error, return status: " + response.status)
				}
		);			
		
		$scope.updateStatus = "update successful";
		$scope.isUpdateDisabled = true;	
	};	
	
	$scope.editCustomer = function(customer) {
		alert("edit customer: " + customer.customerId + " " + customer.firstName);
		$scope.customer = customer;
		$scope.updateStatus = "";		
		$scope.hideCustomerSearchPage(true);
		$scope.hideCustomerEditDelete = false;
		$scope.isUpdateDisabled = true;			
	};	
	
	$scope.turnUpdateOn = function(firstName) {
		$scope.isUpdateDisabled = false;
		$scope.updateStatus = "";
	};
	
	$scope.hideCustomerSearchPage = function(hide) {
		$scope.hideCustomerSearch = hide;		
	};
	
	//do last to initialize search when app first loads
	$scope.resetSearch();
	
});