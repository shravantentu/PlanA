package tasks;


public enum TasksEnum {
	LOGIN ("Login"), 
	CLICK_LINK("ClickLink"),
	CLICK_CHECK_BOX("ClickCheckBox"),
	CLICK_ICON("ClickIcon"),
	CLICK_BUTTON("ClickButton"),
	ENTER_TEXT("EnterText"),
	ENTER_DTEXT("EnterdText"),
	ENTER_CONFIGTEXT("EnterConfigText"),
	CLICK_RADIO("ClickRadio"),
	WAIT("Wait"),
	IS_DISPLAYED("isDisplayed"),
	IS_ENABLED("isEnabled"),
	IS_DISABLED("isDisabled"),
	CLICK_BACK("ClickBack"),
	VERIFY_TEXT ("VerifyText"),
	VERIFY_BUTTON ("VerifyButton"),
	NAVIGATE_URL ("NavigateUrl"),
	APPEND_URL ("AppendUrl"),
	UPLOAD_FILE ("UploadFile"),
	GET_TEXT ("GetText"),
	VERIFY_DROP_DOWN ("VerifyDropDown"),
	VERIFY_TEXT_BOX ("VerifyTextBox"),
    SELECT_DROP_DOWN_VALUE ("SelectDropdownValue"),
	VERIFY_PAGE("VerifyPage"), 
	VERIFY_TEXT_NOT_PRESENT("VerifyTextNotPresent"),
	VERIFY_NO_ELEMENT_PRESENT("VerifyNoElementPresent"),
	TAB ("TAB"),
	CLEAR_TEXT("ClearText"),
	ENTER ("ENTER"),
	IS_POPUP_DISPLAYED ("isPopUpDisplayed"),
	CLOSE_POPUP("closePopup"),
	ACCEPT_POPUP ("acceptPopup"),
	IS_EXPANDED("isExpanded"),
	IS_COLLAPSED("isCollapsed"),
	MOUSE_HOVER("MouseHover"), 
	OPEN_NEW_TAB("OpenNewTab"),
	//CLOSE_NEW_TAB("CloseNewTab"),
    VERIFY_URL("VerifyURL"),
    SET_SCREEN_SIZE("setScreenSize"),
    VERIFY_POSITION("VerifyPosition"),
	LOGOUT("Logout"),
	SELECT_RADIO_BUTTON("SelectRadioButton"),
    DOWNLOAD_DOC("Downloaddoc"),
    MODAL("Modal"),
    READ_FILE("ReadFile"),
    SELECT_CHECKBOX_BUTTON("SelectCheckBox"), 
    Capturescreenprint("capturescreenprint"),
	SLEEP("Sleep"), 
	TEXT_BOX_NUM("EnterNum"),
	CLICK_LINK_Xpath("ClickLinkXpath"),
	Fill_Form("Fillform"), 
	VERIFY_TEXT_FROM_LIST("VerifyTextformlist"),
	VERIFY_Search_Products("VerifyProductcount"),
	SCROLL("scroll"),
	DELETE_fromList("DeleteFromList"),
	ActionON_Nth_Element("ActionOnNthElement"),
	VERIFY_ELEMENT("VerifyElement"),
	Browser_Close("closebrowse"),
	NavigateUrlnTab("NavigateUrlnTab"),
	ClosePopUp("ClosePopUp"),
	SelectSite("SelectSite");
	
	
	//private final String name;
	private final String name;

	public String toString() {
		return name;
	}

	TasksEnum(String name) {
		this.name = name;
	}


	public static TasksEnum getTasksEnum(String task) {
		TasksEnum returnValue = null;
		if (task.equalsIgnoreCase(LOGIN.toString())) {
			returnValue = LOGIN;
		} else if (task.equalsIgnoreCase(CLICK_LINK.toString())) {
			returnValue = CLICK_LINK;
		} else if (task.equalsIgnoreCase(ClosePopUp.toString())) {
			returnValue = ClosePopUp;			
		} else if (task.equalsIgnoreCase(Browser_Close.toString())) {
			returnValue = Browser_Close;
		} else if (task.equalsIgnoreCase(VERIFY_ELEMENT.toString())) {
			returnValue = VERIFY_ELEMENT;
		} else if (task.equalsIgnoreCase(NavigateUrlnTab.toString())) {
			returnValue = NavigateUrlnTab;
		} else if (task.equalsIgnoreCase(CLICK_LINK_Xpath.toString())) {
			returnValue = CLICK_LINK_Xpath;
		} else if (task.equalsIgnoreCase(ActionON_Nth_Element.toString())) {
			returnValue = ActionON_Nth_Element;
		} else if (task.equalsIgnoreCase(VERIFY_Search_Products.toString())) {
			returnValue = VERIFY_Search_Products;			
		} else if (task.equalsIgnoreCase(CLICK_BUTTON.toString())) {
			returnValue = CLICK_BUTTON;
		} else if (task.equalsIgnoreCase(SCROLL.toString())) {
			returnValue = SCROLL;
		} else if (task.equalsIgnoreCase(TEXT_BOX_NUM.toString())) {
			returnValue = TEXT_BOX_NUM;			
		} else if (task.equalsIgnoreCase(DELETE_fromList.toString())) {
			returnValue = DELETE_fromList;
		} else if (task.equalsIgnoreCase(Fill_Form.toString())) {
			returnValue = Fill_Form;			
	    } else if (task.equalsIgnoreCase(ENTER_TEXT.toString())){
			returnValue = ENTER_TEXT;
	    } else if (task.equalsIgnoreCase(Capturescreenprint.toString())){
			returnValue = Capturescreenprint;
	    } else if (task.equalsIgnoreCase(ENTER_DTEXT.toString())){
			returnValue = ENTER_DTEXT;
	    }else if (task.equalsIgnoreCase(ENTER_CONFIGTEXT.toString())){
			returnValue = ENTER_CONFIGTEXT;
	    } else if (task.equalsIgnoreCase(CLICK_ICON.toString())) {
			returnValue = CLICK_ICON;
		}
	    else if (task.equalsIgnoreCase(SELECT_CHECKBOX_BUTTON.toString())) {
            returnValue = SELECT_CHECKBOX_BUTTON;
	    } 
	    else if (task.equalsIgnoreCase(CLICK_RADIO.toString())) {
			returnValue = CLICK_RADIO;
		}
	    else if (task.equalsIgnoreCase(IS_DISPLAYED.toString())) {
			returnValue = IS_DISPLAYED;
		}
	    else if (task.equalsIgnoreCase(IS_ENABLED.toString())) {
			returnValue = IS_ENABLED;
		}
		else if (task.equalsIgnoreCase(IS_DISABLED.toString())) {
			returnValue = IS_DISABLED;
			}
		else if (task.equalsIgnoreCase(CLEAR_TEXT.toString())) {
			returnValue = CLEAR_TEXT;
		}
		else if (task.equalsIgnoreCase(DOWNLOAD_DOC.toString())) {
			returnValue = DOWNLOAD_DOC;
		} 
		else if (task.equalsIgnoreCase(MODAL.toString())) {
			returnValue = MODAL;
		}
		else if (task.equalsIgnoreCase(READ_FILE.toString())) {
			returnValue = READ_FILE;
		}
	    else if (task.equalsIgnoreCase(CLICK_BACK.toString())) {
			returnValue = CLICK_BACK;
		}
	    else if (task.equalsIgnoreCase(VERIFY_PAGE.toString())) {
			returnValue = VERIFY_PAGE;
		} 
	    else if (task.equalsIgnoreCase(TAB.toString())) {
			returnValue = TAB;
		}
	    else if (task.equalsIgnoreCase(ENTER.toString())) {
			returnValue = ENTER;
		}
	    else if (task.equalsIgnoreCase(VERIFY_TEXT_NOT_PRESENT.toString())) {
	 		returnValue = VERIFY_TEXT_NOT_PRESENT;
	    }		
		else if (task.equalsIgnoreCase(VERIFY_TEXT_FROM_LIST.toString())) {
 			returnValue = VERIFY_TEXT_FROM_LIST;
	 	}
	    else if (task.equalsIgnoreCase(VERIFY_NO_ELEMENT_PRESENT.toString())) {
 			returnValue = VERIFY_NO_ELEMENT_PRESENT;
	    }
		 else if (task.equalsIgnoreCase(IS_POPUP_DISPLAYED.toString())) {
			returnValue = IS_POPUP_DISPLAYED;
		 }
		 else if (task.equalsIgnoreCase(CLOSE_POPUP.toString())) {
 			returnValue = CLOSE_POPUP;
		 }
		 else if (task.equalsIgnoreCase(ACCEPT_POPUP.toString())) {
 			returnValue = ACCEPT_POPUP;
 		 }
		 else if (task.equalsIgnoreCase(WAIT.toString())) {
            returnValue = WAIT;
		 }
		 else if (task.equalsIgnoreCase(VERIFY_TEXT.toString())) {
             returnValue = VERIFY_TEXT;
	       }
		 else if (task.equalsIgnoreCase(SelectSite.toString())) {
             returnValue = SelectSite;
	       }
		 else if (task.equalsIgnoreCase(VERIFY_BUTTON.toString())) {
			 returnValue = VERIFY_BUTTON;
		 }
		 else if (task.equalsIgnoreCase(NAVIGATE_URL.toString())) {
             returnValue = NAVIGATE_URL;
		 	}
		 else if (task.equalsIgnoreCase(APPEND_URL.toString())) {
             returnValue = APPEND_URL;
		 	}
		 else if (task.equalsIgnoreCase(UPLOAD_FILE.toString())) {
             returnValue = UPLOAD_FILE;
		 	}
		 else if (task.equalsIgnoreCase(GET_TEXT.toString())) {
             returnValue = GET_TEXT;
		 	}
		 else if (task.equalsIgnoreCase(VERIFY_DROP_DOWN.toString())) {
             returnValue = VERIFY_DROP_DOWN;
		 }
		 else if (task.equalsIgnoreCase(SELECT_DROP_DOWN_VALUE.toString())) {
             returnValue = SELECT_DROP_DOWN_VALUE;
		 }
		 else if (task.equalsIgnoreCase(VERIFY_TEXT_BOX.toString())) {
             returnValue = VERIFY_TEXT_BOX;
		 }
		 else if (task.equalsIgnoreCase(MOUSE_HOVER.toString())) {
			 returnValue = MOUSE_HOVER;				
		 }
		 else if (task.equalsIgnoreCase(IS_EXPANDED.toString())) {
			 returnValue = IS_EXPANDED;
		 }
		 else if (task.equalsIgnoreCase(IS_COLLAPSED.toString())) {
			 returnValue = IS_COLLAPSED;
		 }
		 else if (task.equalsIgnoreCase(OPEN_NEW_TAB.toString())) {
			 returnValue = OPEN_NEW_TAB;
			 }
              
		 else if (task.equalsIgnoreCase(CLICK_CHECK_BOX.toString())) {
			 returnValue = CLICK_CHECK_BOX;
			 }
         else if (task.equalsIgnoreCase(VERIFY_URL.toString())) {
              returnValue = VERIFY_URL;

            }
         else if (task.equalsIgnoreCase(SET_SCREEN_SIZE.toString())) {
              returnValue = SET_SCREEN_SIZE;
            }
        else if (task.equalsIgnoreCase(VERIFY_POSITION.toString())) {
              returnValue = VERIFY_POSITION;
            }

        else if (task.equalsIgnoreCase(SELECT_RADIO_BUTTON.toString())) {
            returnValue = SELECT_RADIO_BUTTON;
  }
        else if (task.equalsIgnoreCase(SLEEP.toString())) {
            returnValue = SLEEP;
  }
		 else if (task.equalsIgnoreCase(LOGOUT.toString())) {
			returnValue = LOGOUT;
		 }
		
		
		

		return returnValue;
}


		 
}

