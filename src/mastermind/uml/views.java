package mastermind.uml;

/** 
@startuml

abstract class WithConsoleView [[java:mastermind.views.WithConsoleView]] {
    ~Console console
	+WithConsoleView()
}
WithConsoleView -right-> Console

enum ColorView [[java:mastermind.views.ColorView]] {
	RED
	BLUE
	YELLOW
	GREEN
	ORANGE
	PURPLE
	initial
	-ColorView(char initial)
	+void write()
	+{static}String allInitials()
	+{static}ColorView getInstance(int code)
	+{static}ColorView getInstance(char character)
	+{static}Error isValid(char character)
}

class SecretCombinationView [[java:mastermind.views.SecretCombinationView]] {
	-{static}String HIDDEN
	+SecretCombinationView()
	+void writeln(int length)
}
WithConsoleView <|-- SecretCombinationView

class ProposedCombinationView [[java:mastermind.views.ProposedCombinationView]] {
	-{static}String TITTLE
	+{static}int ERROR_CODE
	+void write(int[] codes)
	+int[] read()
}
WithConsoleView <|-- ProposedCombinationView
ProposedCombinationView .down.> ColorView

class ResultView [[java:mastermind.views.ResultView]] {
	-{static}String MESSAGES
	+void writeln(int[] results)
}
WithConsoleView <|-- ResultView

class ErrorView [[java:mastermind.views.ErrorView]] {
	-{static}Map<Integer,String> MESSAGES
	+{static}int NO_ERROR
	-{static}int DUPLICATED
	-{static}int WRONG_CHARACTERS
	-{static}int WRONG_LENGTH
	+void write(int error)
}
WithConsoleView <|-- ErrorView
ErrorView .down.> ColorView

class StartView [[java:mastermind.views.StartView]] {
	-{static}String TITTLE
	+void interact(StartController startController)
}
WithConsoleView <|-- StartView
StartView .down.> SecretCombinationView

class ProposalView [[java:mastermind.views.ProposalView]] {
	-{static}String MESSAGES
	+void interact(ProposalController proposalController)
}
WithConsoleView <|-- ProposalView
ProposalView .down.> SecretCombinationView
ProposalView .down.> ProposedCombinationView
ProposalView .down.> ResultView
ProposalView .down.> ErrorView

class ResumeView [[java:mastermind.views.ResumeView]] {
	+void interact(ResumeController resumeController)
}
ResumeView .down.> YesNoDialog



class ConsoleView [[java:mastermind.views.ConsoleView]] {
	+ConsoleView()
	+void interact(Controller controller)
	+void visit(StartController startController)
	+void visit(ProposalController proposalController)
	+void visit(ResumeController continueController)
}
ControllerVisitor <|.. ConsoleView
ConsoleView --> "1" StartView : startView
ConsoleView --> "1" ProposalView : proposalView
ConsoleView --> "1" ResumeView : continueView

@enduml
*/