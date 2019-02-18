package mastermind.uml;

/** 
@startuml

	package mastermind {
	}
	
	package views {
	}
	
	package controllers {
	}
	package models {
	}
	
	package utils {
	}
	
	mastermind .down.> views
	mastermind .down.> controllers
	views .down.> controllers
	views .down.> utils
	controllers .down.> models	

@enduml
*/