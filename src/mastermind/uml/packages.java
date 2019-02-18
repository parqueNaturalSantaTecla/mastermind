package mastermind.uml;

/** 
@startuml


	package mastermind {
		class Mastermind
	}
	
	package views {
		class ConsoleView
	}
	package controllers {
		class Logic
		class StartController
		class ProposalController
		class ResumeController
	}
	package models {
		enum Error
		class Game 
		class ProposedCombination
	}
	package utils {
		class ClosedInterval
		class Console 
		class YesNoDialog 
	}
	
	mastermind .down.> views
	mastermind .down.> controllers
	views .down.> controllers
	views .right.> utils
	controllers .down.> models	

@enduml
*/