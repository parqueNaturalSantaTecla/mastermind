package mastermind.uml;

/** 
@startuml

class Mastermind #gray
class ConsoleView #red
class Logic #blue
class StartController #blue
class ProposalController #blue
class ResumeController #blue
class Game #green
class ProposedCombination #green
class Error #green

	Mastermind *-down-> ConsoleView
	Mastermind *-down-> Logic
	
	ConsoleView .down.> StartController
	ConsoleView .down.> ProposalController
	ConsoleView .down.> ResumeController
		
	Logic *-down-> StartController
	Logic *-down-> ProposalController
	Logic *-down-> ResumeController
	Logic *-down-> Game
	
	StartController -down-> Game
	ResumeController -down-> Game
	ProposalController -down-> Game
	ProposalController .down.> ProposedCombination
	ProposalController .down.> Error
	
	Game *-down-> ProposedCombination
	ProposedCombination .down.> Error
	
@enduml
*/