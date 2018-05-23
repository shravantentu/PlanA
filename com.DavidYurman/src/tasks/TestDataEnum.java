package tasks;


public enum TestDataEnum {
	car ("car"),
	motorcycle ("motorcycle"),
	trailer ("trailer"),
	boat ("boat"),
	//individualsignupurl("individualsignupurl"),
	
	permitstartdate ("permitstartdate"),
	
	C1rego ("C1rego"),
	C1lastname ("C1lastname"),
	C1customernum ("C1customernum"),
	C1dob ("C1dob"),
	C1address ("C1address"),
	C1email ("C1email"),
	C1activation ("C1activation"),
	
	C2licence ("C2licence"),
	C2address ("C2address"),
	C2rego ("C2rego"),
	C2lastname ("C2lastname"),
	C2dob ("C2dob"),
	C2email ("C2email"),
	C2activation ("C2activation"),

	C3licence ("C3licence"),
	C3address ("C3address"),
	C3lastname("C3lastname"),
	C3dob("C3dob"),
	C3email("C3email"),
	C3activation ("C3activation"),

	C2regoconfirm("C2regoconfirm"),

	indvnewemail("indvnewemail"),
	
	HRP1Dealer("HRP1Dealer"),
	HRP1Admin1("HRP1Admin1"),
	HRP1Admin2("HRP1Admin2"),
	HRP1Dealeractivation("HRP1Dealeractivation"),
	HRP1Admin1activation("HRP1Admin1activation"),
	HRP1Admin2activation("HRP1Admin2activation"),

	HRP2Dealer("HRP2Dealer"),
	HRP2Admin1("HRP2Admin1"),
	HRP2Admin2("HRP2Admin2"),
	HRP2Admin3("HRP2Admin3"),

	LRP1Admin1("LRP1Admin1"),
	LRP1Admin2("LRP1Admin2"),
	LRP1Admin3("LRP1Admin3"),
	LRP1Admin2activation("LRP1Admin2activation"),
	LRP1Admin3activation("LRP1Admin3activation"),
	LRP1Admin1activation("LRP1Admin1activation"),

	quickhrp1("quickhrp1"),

	quicklrp1("quicklrp1"),
	quicklrp1activationaccount("quicklrp1activationaccount"),

	acquisitiondate("acquisitiondate"),
	rwcissuedate("rwcissuedate"),
	rwcreceivedate("rwcreceivedate"),

	svnonescrego("svnonescrego"),
	svnonescvin("svnonescvin"),

	svescrego("svescrego"),
	svescvin("svescvin"),

	mvrego("mvrego"),
	mvvin("mvvin"),

	mvlamsrego("mvlamsrego"),
	mvlamsvin("mvlamsvin"),

	hvrego("hvrego"),
	hvvin("hvvin"),

	hvfirsrego("hvfirsrego"),
	hvfirscheckdigit("hvfirscheckdigit"),
	hvfirsvin("hvfirsvin"),

	htrego("htrego"),
	htvin("htvin"),

	htfirsrego("htfirsrego"),
	htfirsvin("htfirsvin"),

	newemail("newemail"),

	addHRPUser("addHRPUser"),
	addHRPAdmin("addHRPAdmin"),
	addLRPUser("addLRPUser"),
	addLRPAdmin("addLRPAdmin"),

	incidentdate("incidentdate"),
	writeoffdate("writeoffdate"),
	
	
	uvpurl("uvpurl"),
	rrurl("rrurl"),
	vreurl("vreurl"),
	loginurl("loginurl"),
	transferurl("transferurl"),
	nvrurl("nvrurl"),
	partnersignupurl("partnersignupurl"),
	uploadurl("uploadurl"),
	uploadurlfordownload("uploadurlfordownload"),
	activationurl1("activationurl1"),
	activationurl2("activationurl2"),
	creditcard("creditcard"),
	bankaccount("bankaccount"),
	nvrmotorcycleurl("nvrmotorcycleurl"),
	nvrstandardurl("nvrstandardurl"),
	nvrheavyvehicleurl("nvrheavyvehicleurl"),
	nvrheavytrailerurl("nvrheavytrailerurl"),
	nvrlighttrailerurl("nvrlighttrailerurl"),
	partnerdashboard("partnerdashboard"),
	individualccurl("individualccurl"),
	individualsignupurl("individualsignupurl"),
	wovrurl("wovrurl"),
	portalappssearchpartner("portalappssearchpartner"),
	vrourl("vrourl"),
	partnerrejection("partnerrejection"),
	partnerinvalidactivationaccount("partnerinvalidactivationaccount"),
	partnerinvalidactivation("partnerinvalidactivation"),
	quickhrp1activationaccount("quickhrp1activationaccount"),
	eiacustomernum("eiacustomernum"),
	eiadob("eiadob"),
	eiaemail("eiaemail"),
	coaurl("coaurl"),
	indivPSurl("indivPSurl"),
	nvrsaveurl("nvrsaveurl"),
	EIAactivation("EIAactivation"),
	COAlastname("COAlastname"),
	COAbirthday("COAbirthday"),
	COAbirthmonth("COAbirthmonth"),
	COAbirthyear("COAbirthyear"),
	COAlicencenum("COAlicencenum"),
	COAaddress("COAaddress"),
	COARaddress("COARaddress"),
	COAPaddress("COAPaddress"),
	dateregistered("dateregistered"),
	paymentpreferenceurl("paymentpreferenceurl"), CVV("cvv");
	
	private final String name;

	public String toString() {
		return name;
	}

	TestDataEnum(String name) {
		this.name = name;
	}


	public static TestDataEnum getTestDataEnum(String testdata) {
		TestDataEnum returnValue = null;
		if (testdata.equalsIgnoreCase(car.toString())) {
			returnValue = car;
		} else if(testdata.equalsIgnoreCase(CVV.toString())) {
			returnValue = CVV;			
		} else if(testdata.equalsIgnoreCase(motorcycle.toString())) {
			returnValue = motorcycle;
		}else if(testdata.equalsIgnoreCase(trailer.toString())) {
			returnValue = trailer;
		}else if(testdata.equalsIgnoreCase(boat.toString())) {
			returnValue = boat;
		}else if(testdata.equalsIgnoreCase(permitstartdate.toString())) {
			returnValue = permitstartdate;
		}else if(testdata.equalsIgnoreCase(C1rego.toString())) {
			returnValue = C1rego;
		}else if(testdata.equalsIgnoreCase(C1lastname.toString())) {
			returnValue = C1lastname;
		}else if(testdata.equalsIgnoreCase(C1customernum.toString())) {
			returnValue = C1customernum;
		}else if(testdata.equalsIgnoreCase(C1dob.toString())) {
			returnValue = C1dob;
		}else if(testdata.equalsIgnoreCase(C1address.toString())) {
			returnValue = C1address;
		}else if(testdata.equalsIgnoreCase(C1email.toString())) {
			returnValue = C1email;
		}else if(testdata.equalsIgnoreCase(C1activation.toString())) {
			returnValue = C1activation;
		}else if(testdata.equalsIgnoreCase(C2licence.toString())) {
			returnValue = C2licence;
		}else if(testdata.equalsIgnoreCase(C2address.toString())) {
			returnValue = C2address;
		}else if(testdata.equalsIgnoreCase(C2rego.toString())) {
			returnValue = C2rego;
		}else if(testdata.equalsIgnoreCase(C2lastname.toString())) {
			returnValue = C2lastname;
		}else if(testdata.equalsIgnoreCase(C2dob.toString())) {
			returnValue = C2dob;
		}else if(testdata.equalsIgnoreCase(C2email.toString())) {
			returnValue = C2email;
		}else if(testdata.equalsIgnoreCase(C2activation.toString())) {
			returnValue = C2activation;
		}else if(testdata.equalsIgnoreCase(C3licence.toString())) {
			returnValue = C3licence;
		}else if(testdata.equalsIgnoreCase(C3address.toString())) {
			returnValue = C3address;
		}else if(testdata.equalsIgnoreCase(C3lastname.toString())) {
			returnValue = C3lastname;
		}else if(testdata.equalsIgnoreCase(C3dob.toString())) {
			returnValue = C3dob;
		}else if(testdata.equalsIgnoreCase(C3email.toString())) {
			returnValue = C3email;
		}else if(testdata.equalsIgnoreCase(C3activation.toString())) {
			returnValue = C3activation;
		}else if(testdata.equalsIgnoreCase(C2regoconfirm.toString())) {
			returnValue = C2regoconfirm;
		}else if(testdata.equalsIgnoreCase(indvnewemail.toString())) {
			returnValue = indvnewemail;
		}else if(testdata.equalsIgnoreCase(HRP1Dealer.toString())) {
			returnValue = HRP1Dealer;
		}else if(testdata.equalsIgnoreCase(HRP1Admin1.toString())) {
			returnValue = HRP1Admin1;
		}else if(testdata.equalsIgnoreCase(HRP1Admin2.toString())) {
			returnValue = HRP1Admin2;
		}else if(testdata.equalsIgnoreCase(HRP2Dealer.toString())) {
			returnValue = HRP2Dealer;
		}else if(testdata.equalsIgnoreCase(HRP2Admin1.toString())) {
			returnValue = HRP2Admin1;
		}else if(testdata.equalsIgnoreCase(HRP2Admin2.toString())) {
			returnValue = HRP2Admin2;
		}else if(testdata.equalsIgnoreCase(HRP2Admin3.toString())) {
			returnValue = HRP2Admin3;
		}else if(testdata.equalsIgnoreCase(LRP1Admin1.toString())) {
			returnValue = LRP1Admin1;
		}else if(testdata.equalsIgnoreCase(LRP1Admin2.toString())) {
			returnValue = LRP1Admin2;
		}else if(testdata.equalsIgnoreCase(LRP1Admin3.toString())) {
			returnValue = LRP1Admin3;
		}else if(testdata.equalsIgnoreCase(quickhrp1.toString())) {
			returnValue = quickhrp1;
		}else if(testdata.equalsIgnoreCase(quicklrp1.toString())) {
			returnValue = quicklrp1;
		}else if(testdata.equalsIgnoreCase(acquisitiondate.toString())) {
			returnValue = acquisitiondate;
		}
		else if(testdata.equalsIgnoreCase(rwcissuedate.toString())) {
			returnValue = rwcissuedate;
		}
		else if(testdata.equalsIgnoreCase(rwcreceivedate.toString())) {
			returnValue = rwcreceivedate;
		}else if(testdata.equalsIgnoreCase(svnonescrego.toString())) {
			returnValue = svnonescrego;
		}else if(testdata.equalsIgnoreCase(svnonescvin.toString())) {
			returnValue = svnonescvin;
		}else if(testdata.equalsIgnoreCase(svescrego.toString())) {
			returnValue = svescrego;
		}else if(testdata.equalsIgnoreCase(svescvin.toString())) {
			returnValue = svescvin;
		}else if(testdata.equalsIgnoreCase(mvrego.toString())) {
			returnValue = mvrego;
		}else if(testdata.equalsIgnoreCase(mvvin.toString())) {
			returnValue = mvvin;
		}else if(testdata.equalsIgnoreCase(mvlamsrego.toString())) {
			returnValue = mvlamsrego;
		}else if(testdata.equalsIgnoreCase(mvlamsvin.toString())) {
			returnValue = mvlamsvin;
		}else if(testdata.equalsIgnoreCase(hvrego.toString())) {
			returnValue = hvrego;
		}else if(testdata.equalsIgnoreCase(hvvin.toString())) {
			returnValue = hvvin;
		}else if(testdata.equalsIgnoreCase(hvfirsrego.toString())) {
			returnValue = hvfirsrego;
		}else if(testdata.equalsIgnoreCase(hvfirscheckdigit.toString())) {
			returnValue = hvfirscheckdigit;
		}else if(testdata.equalsIgnoreCase(hvfirsvin.toString())) {
			returnValue = hvfirsvin;
		}else if(testdata.equalsIgnoreCase(htrego.toString())) {
			returnValue = htrego;
		}else if(testdata.equalsIgnoreCase(htvin.toString())) {
			returnValue = htvin;
		}else if(testdata.equalsIgnoreCase(htfirsrego.toString())) {
			returnValue = htfirsrego;
		}else if(testdata.equalsIgnoreCase(htfirsvin.toString())) {
			returnValue = htfirsvin;
		}else if(testdata.equalsIgnoreCase(newemail.toString())) {
			returnValue = newemail;
		}else if(testdata.equalsIgnoreCase(addHRPUser.toString())) {
			returnValue = addHRPUser;
		}else if(testdata.equalsIgnoreCase(addHRPAdmin.toString())) {
			returnValue = addHRPAdmin;
		}else if(testdata.equalsIgnoreCase(addLRPUser.toString())) {
			returnValue = addLRPUser;
		}else if(testdata.equalsIgnoreCase(addLRPAdmin.toString())) {
			returnValue = addLRPAdmin;
		}else if(testdata.equalsIgnoreCase(incidentdate.toString())) {
			returnValue = incidentdate;
		}else if(testdata.equalsIgnoreCase(writeoffdate.toString())) {
			returnValue = writeoffdate;
		}else if(testdata.equalsIgnoreCase(uvpurl.toString())) {
			returnValue = uvpurl;
		}else if(testdata.equalsIgnoreCase(rrurl.toString())) {
			returnValue = rrurl;
		}else if(testdata.equalsIgnoreCase(vreurl.toString())) {
			returnValue = vreurl;
		}else if(testdata.equalsIgnoreCase(loginurl.toString())) {
			returnValue = loginurl;
		}else if(testdata.equalsIgnoreCase(transferurl.toString())) {
			returnValue = transferurl;
		}else if(testdata.equalsIgnoreCase(nvrurl.toString())) {
			returnValue = nvrurl;
		}else if(testdata.equalsIgnoreCase(partnersignupurl.toString())) {
			returnValue = partnersignupurl;
		}else if(testdata.equalsIgnoreCase(uploadurl.toString())) {
			returnValue = uploadurl;
		} else if(testdata.equalsIgnoreCase(uploadurlfordownload.toString())) {
			returnValue = uploadurlfordownload;
		} else if(testdata.equalsIgnoreCase(activationurl1.toString())) {
			returnValue = activationurl1;
		}else if(testdata.equalsIgnoreCase(activationurl2.toString())) {
			returnValue = activationurl2;
		}else if(testdata.equalsIgnoreCase(creditcard.toString())) {
			returnValue = creditcard;
		}else if(testdata.equalsIgnoreCase(bankaccount.toString())) {
			returnValue = bankaccount;
		}else if(testdata.equalsIgnoreCase(nvrstandardurl.toString())) {
			    returnValue = nvrstandardurl; 
	    }else if(testdata.equalsIgnoreCase(nvrmotorcycleurl.toString())) {
		    returnValue = nvrmotorcycleurl;
        }else if(testdata.equalsIgnoreCase(nvrheavyvehicleurl.toString())) {
	        returnValue = nvrheavyvehicleurl;
        }else if(testdata.equalsIgnoreCase(nvrheavytrailerurl.toString())) {
	        returnValue = nvrheavytrailerurl;
        }else if(testdata.equalsIgnoreCase(nvrlighttrailerurl.toString())) {
	        returnValue = nvrlighttrailerurl;
        }else if(testdata.equalsIgnoreCase(partnerdashboard.toString())) {
	        returnValue = partnerdashboard;
	    }else if(testdata.equalsIgnoreCase(individualccurl.toString())) {
	        returnValue = individualccurl;
	    }else if(testdata.equalsIgnoreCase(individualsignupurl.toString())) {
	        returnValue = individualsignupurl;
	    }else if(testdata.equalsIgnoreCase(wovrurl.toString())) {
	        returnValue = wovrurl;
	    }else if(testdata.equalsIgnoreCase(vrourl.toString())) {
	        returnValue = vrourl;
	    }else if(testdata.equalsIgnoreCase(quicklrp1activationaccount.toString())) {
	        returnValue = quicklrp1activationaccount;
	        
	    
    }else if(testdata.equalsIgnoreCase(portalappssearchpartner.toString())) {
        returnValue = portalappssearchpartner;
    }else if(testdata.equalsIgnoreCase(partnerrejection.toString())) {
        returnValue = partnerrejection;
    }else if(testdata.equalsIgnoreCase(partnerinvalidactivationaccount.toString())) {
            returnValue = partnerinvalidactivationaccount;
		    }else if(testdata.equalsIgnoreCase(partnerinvalidactivation.toString())) {
        returnValue = partnerinvalidactivation;
		    }else if(testdata.equalsIgnoreCase(quickhrp1activationaccount.toString())) {
		        returnValue = quickhrp1activationaccount;
		    }else if(testdata.equalsIgnoreCase(LRP1Admin3activation.toString())) {
		        returnValue = LRP1Admin3activation;
		
		    }else if(testdata.equalsIgnoreCase(LRP1Admin1activation.toString())) {
		        returnValue = LRP1Admin1activation;
		
		    }else if(testdata.equalsIgnoreCase(LRP1Admin2activation.toString())) {
		        returnValue = LRP1Admin2activation;
		    }else if(testdata.equalsIgnoreCase(HRP1Dealeractivation.toString())) {
		        returnValue = HRP1Dealeractivation;
		    }else if(testdata.equalsIgnoreCase(HRP1Admin1activation.toString())) {
		        returnValue = HRP1Admin1activation;
		    }else if(testdata.equalsIgnoreCase(HRP1Admin2activation.toString())) {
		        returnValue = HRP1Admin2activation;
		    //}else if(testdata.equalsIgnoreCase(individualsignupurl.toString())) {
		      //  returnValue = individualsignupurl;
		    }else if(testdata.equalsIgnoreCase(eiacustomernum.toString())) {
		        returnValue = eiacustomernum;
		    }else if(testdata.equalsIgnoreCase(eiadob.toString())) {
		        returnValue = eiadob;
		    }else if(testdata.equalsIgnoreCase(eiaemail.toString())) {
		        returnValue = eiaemail;
		    }else if(testdata.equalsIgnoreCase(EIAactivation.toString())) {
		        returnValue = EIAactivation;
		    }else if(testdata.equalsIgnoreCase(coaurl.toString())) {
		        returnValue = coaurl;
		    }else if(testdata.equalsIgnoreCase(indivPSurl.toString())) {
		        returnValue = indivPSurl;
		    }else if(testdata.equalsIgnoreCase(nvrsaveurl.toString())) {
		        returnValue = nvrsaveurl;
		    }else if(testdata.equalsIgnoreCase(COAlastname.toString())) {
		        returnValue = COAlastname;
		    }else if(testdata.equalsIgnoreCase(COAbirthday.toString())) {
		        returnValue = COAbirthday;
		    }else if(testdata.equalsIgnoreCase(COAbirthmonth.toString())) {
		        returnValue = COAbirthmonth;
		    }else if(testdata.equalsIgnoreCase(COAbirthyear.toString())) {
		        returnValue = COAbirthyear;
		    }else if(testdata.equalsIgnoreCase(COAlicencenum.toString())) {
		        returnValue = COAlicencenum;
		    }else if(testdata.equalsIgnoreCase(COAaddress.toString())) {
		        returnValue = COAaddress;
		    }else if(testdata.equalsIgnoreCase(COARaddress.toString())) {
		        returnValue = COARaddress;
		    }else if(testdata.equalsIgnoreCase(COAPaddress.toString())) {
		        returnValue = COAPaddress;
		    }else if(testdata.equalsIgnoreCase(dateregistered.toString())) {
		        returnValue = dateregistered;
		    }else if(testdata.equalsIgnoreCase(paymentpreferenceurl.toString())) {
		        returnValue = paymentpreferenceurl;
		  
			
		    } 
		        
		        
	
		        
		    
		
		
		
		
		return returnValue;
}
		 
}

